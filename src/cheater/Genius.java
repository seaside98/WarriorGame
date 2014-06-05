/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cheater;

/**
 *
 * @author seaside98
 */
public class Genius extends Warrior {
    public Genius() {
        name = "Genius";
        speed = 1;
        health = 200;
        color = Cheater.green;
        dodgeVerb = "foresees";
        
        attacks[0] = "think";
        attacks[1] = "code";
        attacks[2] = "eat";
        
        range[0] = 100;
        range[1] = 200;
        
        choosen();
    }
}