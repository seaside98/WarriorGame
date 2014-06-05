/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cheater;

/**
 *
 * @author seaside98
 */
public class Knight extends Warrior {
    public Knight() {
        name = "Knight";
        speed = 4;
        health = 500;
        color = Cheater.blue;
        dodgeVerb = "dodges";
        
        attacks[0] = "stab";
        attacks[1] = "slam";
        attacks[2] = "chop";
        
        range[0] = 30;
        range[1] = 50;
        
        choosen();
    }
    
    
}