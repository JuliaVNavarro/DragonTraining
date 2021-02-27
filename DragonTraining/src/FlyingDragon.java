/** FlyingDragon.java - subclass of superclass Dragon.java where the FlyingDragon
 * is a dragon that can attack causing damage within a range of 5 - 10 HP points */
public class FlyingDragon extends Dragon{
  /* Amount of swoop attacks */
  private int swoops;

  public FlyingDragon(String n, int mHp){
    super(n, mHp); // calls superclass constructor from Dragon.java
    swoops = 2; // initialize amount of swoop attacks the FlyingDragon will begin with
  }

  /** Random number is generated between 5-10 if the FlyingDragon does a swoop attack, . 
   * The FlyingDragon's swoops are decremented after each attack.
   * @return int rand, random number generated between 5-10*/
  public int swoopAttack(){
    int rand = 0;
    if (swoops >= 1){
      rand = (int)((Math.random() * 6) + 5);
      swoops --;
    }
    else{
      rand = 0;
    }
    return rand;
  }

  /** String representation of the FlyingDragon's name, hp points out of their original max hp points, and their total Swoop attacks remaining.
   * @return String representation of FlyingDragon's name, hp points out of their original max hp points, and their total Swoop attacks remaining */
  @Override
  public String toString(){
    return super.toString() + "\n   Swoop Attacks remaining: " + swoops; // calls superclass toString method along with total swoop attacks remaining
  }
}