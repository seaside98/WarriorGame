/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cheater;
import java.util.Random;

/**
 *
 * @author seaside98
 */
public class Warrior {
    
    //Warrior variables
    public String name; //Name of the warrior
    public int speed; //Warrior's speed (0-10)
    public String color; //Color of the warrior's name
    public int health; //Warrior's starting health
    public String dodgeVerb; //Verb to use when the warrior dodges an attack
    
    public Random rand = new Random();
    
    public String black = Cheater.black; //Black color
    
    public String[] attacks = new String[3]; //Attack names
    public int[] range = new int[2]; //Range of damage [0] = low, [1] = high
    
    public String removeHealth(int num, String attackName) {
        if(rand.nextInt(10) >= speed) { //If they are too slow...
            health -= num; //Subtract health
            
            if(health < 0) { //Don't go below 0
                health = 0;
            }
            
            return black + "Your " + attackName + " takes " + num + " health out of " + color + name + black + "! They have " + health + " health left.";
        } else { //or if they are fast!
            return color + name + black + " " + dodgeVerb + " your " + attackName + ".";
        }
    }
    
    public void choosen() { //Called when the character is initialized
        System.out.println( "You have choosen " + color + name + black + "!" );
    }
    
    public int attack(String name) {
        name = name.toLowerCase();
        
        //Random amount damage within the damage range
        int randInt = rand.nextInt(range[1] - range[0]) + range[0];
        
        if ( name.compareTo(attacks[0]) == 0 
                || name.compareTo(attacks[1]) == 0 
                || name.compareTo(attacks[2]) == 0 ) { //valid attack
            return randInt;
        } else {
            return 0; //not a valid attack
        }
    }
}
