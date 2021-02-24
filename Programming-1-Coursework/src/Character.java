//Simulation of a character in the game where it will be fighter.
public class Character {
  private String name;
  private final Integer baseHP;
  private final Integer baseAtk;
  private final Integer baseDef;
  private final Integer baseSpd;
  private Integer level;
  private Integer currentHP;
  private Integer currentEP;
  private Team team;

  public Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
    this.name = name;
    this.baseHP = baseHP;
    this.baseAtk = baseAtk;
    this.baseDef = baseDef;
    this.baseSpd = baseSpd;
    this.level = 1;
    this.currentHP = getMaxHP();
    this.currentEP = 0;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getMaxHP() {
    return Math.round((float) baseHP * (float) (Math.pow(level, 1.2)));
  }

  public Integer getAttack() {
    return Math.round((float) baseAtk * (float) (Math.pow(level, 1.2)));
  }

  public Integer getDefence() {
    return Math.round((float) baseDef * (float) (Math.pow(level, 1.2)));
  }

  public Integer getSpeed() {
    return Math.round((float) baseSpd * (float) (Math.pow(level, 1.2)));
  }

  public Integer getTargetEP() {
    return Math.round(10f * (float) (Math.pow(level, 1.5)));
  }

  public Integer getHP() {
    return currentHP;
  }

  public Integer getEP() {
    return currentEP;
  }

  public Integer getLevel() {
    return level;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  /**
   * Increasing the HP of a character by given amount.
   *
   * @param amount the amount by which the character's HP will be increased.
   */
  public void increaseHP(int amount) {
    if (currentHP + amount >= 0) {
      if (currentHP + amount >= getMaxHP()) {
        currentHP = getMaxHP();
      } else {
        currentHP += amount;
      }
    }
  }

  /**
   * Decreasing the HP of a character by given amount.
   *
   * @param amount the amount by which the character's HP will be decreased.
   */
  public void decreaseHP(int amount) {
    if (currentHP - amount < 0) {
      currentHP = 0;
    }
    if (currentHP - amount >= 0) {
      currentHP -= amount;
    }
  }

  /**
   * Increasing the EP of a character by given amount. The character levels up when it reaches its target EP.
   *
   * @param amount the amount by which the character's EP will be increased.
   */
  public void increaseEP(int amount) {
    currentEP += amount;
    if (currentEP >= getTargetEP()) {
      level++;
      currentEP = 0;
      if (currentHP != 0) {
        currentHP = getMaxHP();
      }
    }
  }
}
