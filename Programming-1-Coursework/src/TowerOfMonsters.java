import java.io.*;

//The class where a file is handled and the game is started.
public class TowerOfMonsters {
  private final Guild guild;

  public TowerOfMonsters() {
    guild = new Guild();
    initStudents();
  }

  public Guild getGuild() {
    return guild;
  }

  public static void main(String[] args) {
    TowerOfMonsters towerOfMonsters = new TowerOfMonsters();
    //If you want to run the "medium.txt" file, this should be changed to "args[1]"
    File file = new File(args[0]);
    BufferedReader reader;
    String line;
    String[] monsters;
    String[] components = new String[3];
    MonsterTeam monsterTeam = new MonsterTeam("Monsters");

    try {
      reader = new BufferedReader(new FileReader(file));
      line = reader.readLine();
      while (line != null) {

        monsters = line.split(";");

        //Getting the components from a given file and creating monster objects (minions or bosses).
        for (String monster : monsters) {
          components[0] = monster.split("\\(")[0];
          components[1] = (monster.split("\\(")[1]).split(",")[0];
          components[2] = (monster.split("\\(")[1]).split(",")[1].split("\\)")[0];

          if (components[1].equals("Minion")) {
            Minion minion = new Minion(components[0]);
            minion.setLevel(Integer.parseInt(components[2]));
            monsterTeam.addMember(minion);
          } else if (components[1].equals("Boss")) {
            Boss boss = new Boss(components[0]);
            boss.setLevel(Integer.parseInt(components[2]));
            monsterTeam.addMember(boss);
          } else {
            throw new Exception("Wrong input! There's not such a monster!");
          }
        }

        //The fight starts.
        StudentTeam studentTeam = (StudentTeam) towerOfMonsters.getGuild().getTeam(monsterTeam);
        Battle battle = new Battle(studentTeam, monsterTeam);
        Team team = battle.fight();

        //If monsters won, the student should try again with a new team.
        if (team instanceof MonsterTeam) {
          System.out.println("FIGHTING AGAIN WITH A NEW TEAM");
          studentTeam = (StudentTeam) towerOfMonsters.getGuild().getTeam(monsterTeam);
          if (studentTeam != null) {
            System.out.println("TRYING WITH A NEW TEAM");
            battle = new Battle(studentTeam, monsterTeam);
            team = battle.fight();
          } else {
            System.out.println("NO STUDENTS LEFT! END OF THE GAME!!!");
            System.out.println("MONSTERS WON THE GAME");
            return;
          }
        }

        //Printing the winner.
        if (team instanceof StudentTeam) {
          System.out.println("STUDENTS WON THIS ROUND");
        } else if (team instanceof MonsterTeam) {
          System.out.println("MONSTERS WON THE GAME");
          return;
        } else {
          System.out.println("DRAW");
        }
        System.out.println();
        line = reader.readLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Eight students are initialized in the guild, following the coursework specifications.
   */
  public void initStudents() {
    for (int i = 0; i < 2; i++) {
      try {
        this.guild.addMember(new AIStudent("AIStudent" + i));
        this.guild.addMember(new CSStudent("CSStudent" + i));
        this.guild.addMember(new SEStudent("SEStudent" + i));
        this.guild.addMember(new CyberStudent("CyberStudent" + i));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}