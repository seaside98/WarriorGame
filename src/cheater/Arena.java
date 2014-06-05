/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cheater;
import java.util.Scanner;

/**
 *
 * @author seaside98
 */
public class Arena {
    
    private Warrior w1; //first warrior
    private Warrior w2; //second warrior
    
    private String nl = "\n"; //new line
    
    private String[] log = new String[5]; //last 5 lines of output
    
    private Scanner scan = Cheater.scan;
    
    public Arena(Warrior w1in, Warrior w2in) { //input the two warriors
        w1 = w1in;
        w2 = w2in;
        
        for( int i = 0; i < log.length; i++ )
            log[i] = nl; //initialize log
        this.updateConsole();
        this.startGame();
    }
    
    private String peat(String c, int num) { //repeat a string x times
        return Cheater.peat(c, num);
    }
    
    public void updateConsole() { //update the console with new values
        System.out.println( peat( nl, 10 ) +
                w1.color + w1.name + "'s health: " + w1.health + peat( " ", 15 ) + 
                w2.color + w2.name + "'s health: " + w2.health + 
                nl + peat( "-", 55 ) ); //names and health left
        for( int i = 0; i < log.length; i++ )
            System.out.print(log[i] + nl); //log of outputs
    }
    
    public void shiftLog(String line) {
        for( int i = 0; i < log.length - 1; i++ )
            log[i] = log[i + 1]; //bump each log[] value up one place
        
        log[log.length - 1] = line + nl; //assign last log[] value
        this.updateConsole();
    }

    public void startGame() {
        doAttack(w1, w2, "goes first."); //first attack
        while(w1.health > 0 && w2.health > 0) { //attack until someone dies
            doAttack(w2, w1, "is up next.");
            if (w1.health > 0) { //make sure first character didn't die
                doAttack(w1, w2, "is up next.");
            }
        }
        this.gameOver();
    }
    
    public void gameOver() {
        String winner;
        if ( w1.health <= 0 ) { //check who won
            winner = w2.color + w2.name + " wins!!!";
        } else {
            winner = w1.color + w1.name + " wins!!!";
        }
        this.shiftLog(winner);
        
        this.shiftLog( "Play again? (yes or no)" );
        if ( scan.next().compareTo("yes") == 0 ) { //play again?
            System.out.println( peat(nl, 10) );
            Cheater.initializeGame();
        } else {
            System.out.println( peat(nl, 10) + winner + peat(nl, 2) + "Thanks for playing!" + nl);
        }
    }
    
    public void doAttack(Warrior war1, Warrior war2, String upNext) {
        this.shiftLog( war1.color + war1.name + " " + upNext + printAttacks(war1) );
        String input = scan.next();
        int damage = war1.attack( input );
        while (damage == 0) { //returns 0 if not a valid attack
            this.shiftLog( war1.color + input + " is not a valid attack." + printAttacks(war1) );
            input = scan.next();
            damage = war1.attack( input ); //try again
        }
        this.shiftLog( war2.removeHealth(damage, input) );
    }
    
    public String printAttacks(Warrior war) { //print out all the attacks
        return " You can either " +
                war.attacks[0] + ", " +
                war.attacks[1] + ", or " +
                war.attacks[2] + ".";
    }
}
