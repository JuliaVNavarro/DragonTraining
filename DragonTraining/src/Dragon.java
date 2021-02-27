
/** Dragon.java - is a dragon that can attack
 * causing damage within a range of 3 - 7 HP points*/
public class Dragon{
  /* Name of the dragon */
  private String name;
  /* Dragon's hit points */
  private int hp;
  /* Dragon's maximum hit points */
  private int maxHp;

  /** Dragon constructor
   * @param String n the Dragon's name
   * @param int mHp the maximum amount of hit points*/
  public Dragon ( String n, int mHp){
    name = n;
    maxHp = mHp;
    hp = mHp;
  }

  /** Retrieves the dragon's name 
   * @return the dragon's name*/
  public String getName(){
    return name;
  }

  /** Retrieves the dragon's hit points 
   * @return dragon's hit points */
  public int getHp(){
    return hp;
  }

  /** Creates a random amount of damage in the range of 3-7 hp points from an attack.
   * @return damage amount from the attack */
  public int attack(){
    int damage = (int)((Math.random() * 5) + 3);
    return damage;
  }

  /** Damage is calculated by subtracting the amount of damage done from the dragon's hp points 
   * @param amount of damage */
  public void takeDamage(int d){
    hp -= d;
    if (hp < 0){
      hp = 0;
    }  
  }

  /** String representation of the dragon's name and the dragon's hp points out of their original max hp points 
   * @return String representation of dragon's name & hp points out of original max hp points */
  @Override
  public String toString(){
    return name + ": " + hp + "/" + maxHp;
  }
}
