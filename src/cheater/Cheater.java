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
public class Cheater {
    
    public static final char nl = '\n'; //new line
    public static Scanner scan = new Scanner(System.in);
    private static Warrior[] wAry = new Warrior[2]; //the two warriors
    
    public static final String red = "\u001B[31m"; //red color
    public static final String blue = "\u001B[34m"; //blue color
    public static final String green = "\u001B[32m"; //green color
    public static final String black = "\u001B[30m"; //black color
    
    public static final String ninja = red + "Ninja" + nl; //colored names
    public static final String knight = blue + "Knight" + nl;
    public static final String genius = green + "Genius" + nl;
    
    public static String[] characters = new String[3]; //list of character names
    
    public static String peat(String c, int num) { //repeat a string x times
        if(num == 1)
            return c;
        else 
            return c + peat(c, num - 1);
    }
    
    private static void chooseFirst() { //Choose the first character
        
        System.out.println( black + peat( "-", 35 ) );
        
        //Print out the characters
        System.out.println( "Please choose your first character:" );
            for ( int i = 0; i < characters.length; i++ ) {
                System.out.print( characters[i] );
            }
        System.out.println( black + peat( "-", 35 ) );
        
        //Get the user input
        String input = scan.next();
        input = input.toLowerCase();
        
        //See which character it was
        if ( input.compareTo( "ninja" ) == 0 ) {
            //Ninja
            makeCharacter(input, 0);
            characters[0] = "";
            chooseSecond( "knight", "genius" );
        } else if ( input.compareTo( "knight" ) == 0 ) {
            //Knight
            makeCharacter(input, 0);
            characters[1] = "";
            chooseSecond( "ninja", "genius" );
        } else if ( input.compareTo( "genius" ) == 0 ) {
            //Genius
            makeCharacter(input, 0);
            characters[2] = "";
            chooseSecond( "ninja", "knight" );
        } else {
            //Invalid
            System.out.println( "Character not found." );
            chooseFirst();
        }
    }
    
    private static void chooseSecond(String first, String second) { //Choose the second character
        
        System.out.println( black + peat( "-", 35 ) );
        
        //Print out the last two characters
        System.out.println( "Please choose your second character:" );
            for ( int i = 0; i < characters.length; i++ ) {
                System.out.print( characters[i] );
            }
        System.out.println( black + peat( "-", 35 ) );
        
        //Get the user input
        String input = scan.next();
        input = input.toLowerCase();
        
        //See which character it was
        if ( input.compareTo( first ) == 0 ) {
            //First
            makeCharacter(input, 1);
            startGame();
        } else if ( input.compareTo( second ) == 0 ) {
            //Second
            makeCharacter(input, 1);
            startGame();
        } else {
            //Invalid
            System.out.println( "Character not found." );
            chooseSecond(first, second);
        }
    }
    
    public static void startGame() {
        Arena game = new Arena(wAry[0], wAry[1]); //make a new arena
    }
    
    private static void makeCharacter(String name, int index) {
        switch (name) { //figure out which character and create it
            case "ninja": 
                wAry[index] = new Ninja();
                break;
            case "knight": 
                wAry[index] = new Knight();
                break;
            case "genius": 
                wAry[index] = new Genius();
                break;
        }
    }
    
    public static void initializeGame() {
        
        //Put the characters into an array
        characters[0] = ninja;
        characters[1] = knight;
        characters[2] = genius;
        
        //Welcome message
        System.out.println( "Welcome to the battle arena!" );
        
        chooseFirst();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initializeGame();
    }
}
