# Basic  #

## Part 1 ##
I have implemented the classes Character and Team, following the coursework specification.
I have added an additional member variable Team to the Character class.
Additional methods are added to Character class - void setName(String name), void setLevel(Integer level), Integer getLevel().
Additional methods are added to Team class - void setMembers(ArrayList<Character> members), ArrayList<Character> getMembersArray(), void removeMember(Character member),
abstract void printInformation().

## Part 2 ##
I have implemented the classes Student, AIStudent, CSStudent,  CyberStudent, and SEStudent, following the coursework specification.
I have added additional methods to Student class - Integer getMaxKP(), Integer getCurrentKP(), void setCurrentKP(Integer currentKP).

## Part 3 ##
I have implemented the classes Minion and Boss, following the coursework specification.
I have implemented the interface Monster, following the coursework specification.

## Part 4 ##
I have implemented the classes StudentTeam, MonsterTeam, and Guild, following the coursework specification.
I changed the Team class to be an abstract one, following the coursework specification.
I added the printInformation() method to both StudentTeam and MonsterTeam classes, overriding it from their parent class - Team.
Additional methods are added to StudentTeam class - boolean hasEnoughKP(), Character lowestDefenceEnemy(Team enemyTeam), Character highestAttackFriend(),
void attackEnemy(Character member, Team enemyTeam, Character lowestDefenceEnemy, Character highestAttackFriend), void heal(Character member).
Additional methods are added to MonsterTeam class - Character getBestFighter(ArrayList<Character> members, Character enemy, StudentTeam chosenTeam), boolean isGuildDead().
Additional methods are added to Guild class - Integer beatenCategories(Character member, int enemyHitPoints, int enemyAttack, int enemyDefence, int enemySpeed), 
boolean isGuildDead(), Integer getMaxCategoriesBeaten(ArrayList<Integer> statsByMember), Character getBestFighter(ArrayList<Character> members, Character enemy, StudentTeam chosenTeam).

I choose the team by comparing students by the number of the opponent's categories they beat: hit points, attack, defence, and speed.
When choosing a member to add to the team, the students will be compared by hit points, if there are two or more members that beat the opponent by the same number of categories.
If they have the same number of hit points, then the first one will be returned.

The strategy for the move method is as folllows.
1. If the currently attacking student has very low HP, then it should recharge. Depending on the type of student, it will use its own special ability to heal.
2. Else, if the HP is high, the student will attack and will use his/her special ability. 
3. If there are not enough KP for special abilities, students use the selfStudy() method for recharging and the javaProgramming() method for attacking.

## Part 5 ##
I have implemented the class Battle, following the coursework specification.
Additional methods are added to Battle class - boolean areMonstersDead(), boolean areStudentsDead(), ArrayList<Character> sortMembersDescending(ArrayList<Character> members).

Strategy: 
In each round:
1. All members both from the student and the monster team are added in a list and sorted by their speeds. (after each round because some members might have been removed because they died)
2. The next member makes a move. (attacks)
3. Printing information for the current round.
4. All dead students and monsters are spotted.
5. All dead members are removed.

## Part 6 ##
I have implemented the class TowerOfMonsters, following the coursework specification.
Additional methods are added to TowerOfMonsters class - void initStudents(), Guild getGuild().

Strategy: 
For each new team of monsters(new line from file):
1. A TowerOfMonsters object is created and in it's constructor the guild is initialized with 8 students, following the coursework specification.
2. Getting the components from the given file and creating monster objects (minions or bosses).
3. The fight starts.
4. If monsters win, the student guild tries again with a newly formed team. If there are no alive students left, the game stops and the monsters officially win. 
5. Printing the winner.

# Extension #
I have implement the following extension: Including the students with their special abilities from ECS programmes - the ELEC side.

I added six new classes, representing other programmes. The new students I inclduded in the fight in the TowerOfMonsters class. They are initialized in the guild,
along with the old types of students. The guild starts with 10 players, since the old programmes are four and the newly added are six.

The following classes are added AeroEEStudent, BioEStudent, EEEStudent, ElectricalEStudent, ELectronicEStudent, and MechatronicStudent.
Class AeroEEStudent extends Student.
Class BioEStudent extends Student.
Class EEEStudent extends Student.
Class ElectricalEStudent extends Student.
Class ELectronicEStudent extends Student.
Class MechatronicStudent extends Student.

The special abililities for AeroEEStudent are: 
1. void parachuteAttack(Team enemyTeam):
- The parachute attack ability is available for aerospace electronic engineering students only.
- The student reduces the hit points of each of all bosses by 1.
- The student's EP gets increased by 4 and their KP becomes 0. If a minion dies, the students gets 4 more EP.
The special abililities for BioEStudent are: 
1. void poison(Team enemyTeam):
- The poison ability is available for biomedical electronic engineering students only.
- The student reduces the hit points of each of all minions by 1.
- The student's EP gets increased by 4 and their KP becomes 0. If a minion dies, the students gets 4 more EP.
2. void techCure():
- The tech cure ability is available for biomedical electronic engineering students only.
- Each alive member of the student's team increases his/her HP by half of his/her attack points.
- The student's EP gets increased by 4 and their KP becomes 0.
The special abililities for EEEStudent are: 
1. void smartHit(Team enemyTeam):
- The smart hit ability is available for electronic and electrical students only.
- The student reduces the hit points of each of the alive enemies in the enemy team by 2.
- The student's EP gets increased by 4 and their KP becomes 0. If an enemy dies, the students gets 4 more EP.
2. void helpTwoFriends(Character friend, Character secondFriend):
- The ability to help two friends is available for electronic and electrical students only.
- Two friends are healed with the amount of their defence, divided by 2.
- The student's EP gets increased by 4 and their KP becomes 0.
The special abililities for ElectricalEStudent are: 
1. void electrocute(Character enemy):
- The ability to electrocute an enemy is available to the electrical students only.
- The enemy loses half of his HP. The student also sets his/her KP to 0 and receives 4 EP.
- If the enemy dies, the electrical student receives additional 4 EP.
The special abililities for ELectronicEStudent are: 
1. void stopCurrent(Character enemy): 
- The stop current ability is available to the electronic students only.
- The enemy loses 3 of his HP. The student also sets his/her KP to 0 and receives 4 EP.
- If the enemy dies, the electronic student receives additional 4 EP.
The special abililities for MechatronicStudent are:
1. void help(Character friend, Character secondFriend):
- The help ability is available for mechatronic students only. By using it, they heal two friends with the amount of their defence. 
- The mechatronic's EP gets increased by 4 and their KP becomes 0.
2. void mechanicalAttack(Character enemy): 
- The ability to attack mechanically is available to the mechatronic students only.
- The enemy loses HP, determined by the value of the attack of the student, divided by two.
- The student also sets his/her KP to 0 and receives 4 EP.
- If the enemy dies, the mechatronic student receives additional 4 EP.

To run the program with the extension, please use the following command:
java TowerOfMonsters

