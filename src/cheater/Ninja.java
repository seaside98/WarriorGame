/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cheater;

/**
 *
 * @author seaside98
 */
public class Ninja extends Warrior {
    public Ninja() {
        name = "Ninja";
        speed = 5;
        health = 400;
        color = Cheater.red;
        dodgeVerb = "outruns";
        
        attacks[0] = "kick";
        attacks[1] = "slice";
        attacks[2] = "fly";
        
        range[0] = 40;
        range[1] = 70;
        
        choosen();
    }
}
