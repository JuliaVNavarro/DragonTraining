/** FireDragon.java - subclass of superclass Dragon.java where the FireDragon
 * is a dragon that can attack causing damage within a range of 5 - 9 HP points */
public class FireDragon extends Dragon{
  /** Amount of fire shots */
  private int fireShots;

  /** FireDragon constructor 
   * @param String n name of FireDragon 
   * @param int mhp maximum hit points */
  public FireDragon(String n, int mHp){
    super(n, mHp); // calls superclass constructor from Dragon.java
    fireShots = 2; //initialize amount of fire shots the FireDragon will begin with
  }

  /** Random number is generated between 5-9 if a shot is fired from the FireDragon. 
   * The FireDragon's fireShots are decremented after each shot.
   * @return int rand, random number generated between 5-9*/
  public int fireShot(){
    int rand = 0;
    if (fireShots >= 1){
      rand = (int)((Math.random() * 5) + 5);
      fireShots --;
    }
    else{
      rand = 0;
    }
    return rand;
  }

  /** String representation of the FireDragon's name, hp points out of their original max hp points, and their total Fire Shots remaining.
   * @return String representation of FireDragon's name, hp points out of their original max hp points, and their total Fire Shots remaining */
  @Override
  public String toString(){
     return super.toString() + "\n   Fire Shots remaining: " + fireShots; // calls superclass toString method along with total fire shots remaining
  }
}