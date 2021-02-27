import java.util.*;
/**CECS 227 Sec 02: Object Oriented Application Development
 * Lab 06: Dragon Trainer
 * Group: 05
 * Julia Navarro & Dhruv Savla
 * Thursday, February 25, 2021

 * Main.java is a game wher ethe user must try to defeat 3 dragons before dying. The game will end once the user is defeated by the
 * dragons or deafeats all 3 dragons. This class gathers information from Dragon.java, FireDragon.java, and FlyingDragon.java to create 
 * dragons needed for this game. */
class Main {
  public static void main(String[] args) {

    Dragon d = new Dragon("Night Fury", 50); //create a basic Dragon
    FireDragon fd = new FireDragon("Hobgobler", 50); //create a FireDragon
    FlyingDragon flyd = new FlyingDragon("Thornridge", 50); //create a FlyingDragon
    int userHp = 150; //initialize user's starting HP 
    System.out.println("What is your name, challenger?");
    String userName = CheckInput.getString(); //prompt the user to enter their name 
    System.out.println("\nWelcome to dragon training, " + userName + "! 1\nYou must defeat 3 dragons."); //the game begins
    
    
    do {
      int ad = attackDragon(userName, userHp, d, fd, flyd, d.getHp(), fd.getHp(), flyd.getHp()); //prompt user to choose a dragon to attack
      int a = Arrow(); //get damage amount from Arrow
      int s = Sword(); //get damage amount from Sword
      int w = weapons(a, s); //prompt user to select a weapon
      
      /* If the user chooses the Arrow, then the damage will be done to the dragon that they had also chosen */
      if (w == 1){
          if(ad == 1){
            d.takeDamage(a);
          }
          else if(ad == 2){
            fd.takeDamage(a);
          }
          else if(ad == 3){
            flyd.takeDamage(a);
          }
        }
        /* If the user chooses the Arrow, then the damage will be done to the dragon that they had also chosen */
        else if (w == 2){
          if(ad == 1){
            d.takeDamage(s);
          }
          else if(ad == 2){
            fd.takeDamage(s);
          }
          else if(ad == 3){
            flyd.takeDamage(s);
          }
        }

      if((d.getHp() + fd.getHp() + flyd.getHp()) == 0) { //check to see if all dragons have be slayed. If so, the do/while loop is broken
    	  break;
      }

      int rd = randomDragon(); //randomly select a dragon
      int au = 0; //initialize damage amount to attack user to 0
      int specialAttack = (int) (Math.random() * 2) + 1; //randomly select a special attack in case a FireDragon or FlyingDragon is selected. 1 = basic attack & 2 = special attack
      /* If the basic dragon is chosen and.... */
      if(rd == 1){
        /* it is still alive, then basic dragon will attack */
        if(d.getHp() > 0){
          System.out.println("\n" + d.getName() + " smashes you with its tail.");
          au = d.attack(); //set damage amount = to amount of damage from that dragon's attack
        }
        /* it is dead, but the FireDragon is alive then the FireDragon will do a basic attack */
        else if(d.getHp() == 0 && fd.getHp() > 0){
          System.out.println("\n" + fd.getName() + " smashes you with its tail.");
          au = fd.attack();
        }
        /* it and the FireDragon are both dead, then the FlyingDragon will do a basic attack */
        else if(d.getHp() == 0 && fd.getHp() == 0){
          System.out.println("\n" + flyd.getName() + " smashes you with its tail.");
          au = flyd.attack();
        }
      }
      /* If the FireDragon & basic attack is chosen and... */
      else if (rd == 2 && specialAttack == 1){
        /* it is still alive, the FireDragon will do a basic attack... */
        if(fd.getHp() > 0){
          System.out.println("\n" + fd.getName() + " smashes you with its tail.");
          au = fd.attack();
        }
        /* it is dead, but the FlyingDragon is alive, then the FlyingDragon will do a basic attack */
        else if(fd.getHp() == 0 && flyd.getHp() > 0){
          System.out.println("\n" + flyd.getName() + " smashes you with its tail.");
          au = flyd.attack();
        }
        /* it and the FlyingDragon are both dead, then the basic dragon will do a basic attack */
        else if(fd.getHp() == 0 && flyd.getHp() == 0){
          System.out.println("\n" + d.getName() + " smashes you with its tail.");
          au = d.attack();
        }
      }
      /* If the FireDragon & special attack are chosen and... */
      else if(rd == 2 && specialAttack == 2){
        /* it is still alive, the FireDragon will use a fire shot */
        if(fd.getHp() > 0){
          System.out.println("\n" + fd.getName() + " spews fire at you.");
          au = fd.fireShot();
        }
        /* if is dead, but the FlyingDragon is alive, then the FlyingDragon will use a swoop attack */
        else if(fd.getHp() == 0 && flyd.getHp() > 0){
          System.out.println("\n" + flyd.getName() + " swoops down and knocks you over.");
          au = flyd.swoopAttack();
        }
        /* it and the FlyingDragon are both dead then the basic dragon will do a basic attack */
        else if(fd.getHp() == 0 && flyd.getHp() == 0){
          System.out.println("\n" + d.getName() + " smashes you with its tail.");
          au = d.attack();
        }
      }
      /* If the FlyingDragon & basic attack are chosen and ... */
      else if(rd == 3 && specialAttack == 1){
        /* it is still alive then the FlyingDragon will do a basic attack */
        if(flyd.getHp() > 0){
          System.out.println("\n" + flyd.getName() + " smashes you with its tail.");
          au = flyd.attack();
        }
        /* it is dead but the FireDragon is still alive, then the FireDragon will do a basic attack */
        else if(flyd.getHp() == 0 && fd.getHp() > 0){
          System.out.println("\n" + fd.getName() + " smashes you with its tail.");
          au = fd.attack();
        }
        /* it and the FlyingDragon are dead, the the basic dragon will do a basic attack */
        else if(flyd.getHp() == 0 && fd.getHp() == 0){
          System.out.println("\n" + d.getName() + " smashes you with its tail.");
          au = d.attack();
        }
      }
      /* If the FlyingDragon & special attack are chosen and... */
      else if(rd == 3 && specialAttack == 2){
        /* it is still alive, the FlyingDragon will use a swoop attack */
        if (flyd.getHp() > 0){
          System.out.println("\n" + flyd.getName() + " swoops down and knocks you over.");
          au = flyd.swoopAttack();
        }
        /* it is dead but the FireDragon is still alive, thent he FireDragon will use a fire shot */
        else if(flyd.getHp() == 0 && fd.getHp() > 0){
          System.out.println("\n" + fd.getName() + " spews fire at you.");
          au = fd.fireShot();
        }
        /* it and the FireDragon are both dead then the basic dragon will do a basic attack */
        else if(flyd.getHp() == 0 && fd.getHp() == 0){
          System.out.println("\n" + d.getName() + " smashes you with its tail.");
          au = d.attack();
        }
      }

      userHp -= au; //decrement the user's HP from the damage done by the dragons
      
    }while(userHp > 0); //loop will continue to run until broken or the user dies

    if((d.getHp() + fd.getHp() + flyd.getHp()) > 0){ //if the user dies
      System.out.println("\nYou have been defeated.");
    }
    else if((d.getHp() + fd.getHp() + flyd.getHp()) == 0){ //if the user wins
      System.out.println("\nCongatulations " + userName + "! \nYou defeated all three dragons! \nYou win!");
    }
    
  }

  /** Returns the random number of damage to be caused by the arrow.
   * @return int arrowDamage random number of damage to be caused by the arrow */  
  public static int Arrow(){
    int arrowDamage = (int) (Math.random() * 12) + 1;
    return arrowDamage;
  }

  /** Returns the random number of damage to be caused by the sword.
   * @return int swordDamage random number of damage to be caused by the sword */ 
  public static int Sword(){
    int swordDamage = ((int)(Math.random() * 6)+ 1) + ((int)(Math.random() * 6)+ 1);
    return swordDamage;
  }
   
  /** Returns a randomly chosen dragon that will attack the user.
   * @return int chosen random number indicating a dragon chosen to attack the user */
  public static int randomDragon(){
    int chosen = (int) (Math.random() * 3) + 1;
    return chosen;
  }

  /** Prompts the user to choose a live dragon to attack.
   * @param String u - user's name
   * @param int uHp - user's hp
   * @param Dragon d1 - dragon from Dragon class 
   * @param FireDragon d2 - dragon from FireDragon class
   * @param FlyingDragon d3 - dragon from FlyingDragon class
   * @param int d1Hp - basic Dragon's HP value
   * @param int d2Hp - FireDragon's HP value
   * @param int d3Hp - FlyingDragon's HP value 
   * @return int userChoice - the user's choice of dragon to attack */
  public static int attackDragon(String u, int uHp, Dragon d1, FireDragon d2, FlyingDragon d3, int d1Hp, int d2Hp, int d3Hp){
    /* print out menu with the dragons that are still alive for the user to choose from */
    System.out.println("\n" + u + " HP: " + uHp);
    if (d1Hp > 0 ){
      System.out.println("1. Attack " + d1);
    }
    if (d2Hp > 0 ){
      System.out.println("2. Attack " + d2);
    }
    if (d3Hp > 0 ){
      System.out.println("3. Attack " + d3);
    }
    /* Prompt the user to select a dragon that is still alive */
    Scanner input = new Scanner(System.in);
    int userChoice = 0;
    boolean valid = false;
    while(!valid){
      if(input.hasNextInt()){
        userChoice = input.nextInt();
        /* if the user chooses a dead dragon, that dragon's name & HP value will be shown and the user will be notified to select again */
        if(d1Hp == 0 && userChoice == 1){
          System.out.println("\n" + d1 + "\nThis Dragon is dead. Please choose a living dragon to attack.");
        }
        else if(d2Hp == 0 && userChoice == 2){
          System.out.println("\n" + d2 + "\nThis Dragon is dead. Please choose a living dragon to attack.");
        }
        else if(d3Hp == 0 && userChoice == 3){
          System.out.println("\n" + d3 + "\nThis Dragon is dead. Please choose a living dragon to attack.");
        }
        else{
          valid = true;
        }
      }else {
				input.next(); //clear invalid string
				System.out.println( "Invalid Input." );
      }
    }
    return userChoice;
  }

  /** Prompts user to select a weapon to attack a dragon with.
   * @param int arrow - amount of damage that will be done with the arrow
   * @param int sword - amount of damage that will be done with the sword 
   * @return int weaponChoice - return the weapon that is chosen by the user. 1 = Arrow & 2 = sword */ 
  public static int weapons(int arrow, int sword){
    System.out.println("\nAttack with: \n1. Arrow (1 D" + arrow + ") \n2. Sword (2 D" + sword + ")"); //print out weapons menu
    /* Prompt user to choose a number from 1-2 and notify them what their choice does */
    int weaponChoice = CheckInput.getIntRange(1, 2); 
    if(weaponChoice == 1){
      System.out.println("\nYou hit the dragon with an arrow.");
    }
    else if(weaponChoice == 2){
      System.out.println("\nYou slash the dragon with your sword.");
    }
    return weaponChoice;
  }
}