/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: HW3
 * Author: Sumeyye Acar
 * Id: 22103640
*/

import java.util.Scanner;
import cardgame.*;

public class CardGameTest {
    public static void main( String[] args) {
        Scanner scan = new Scanner( System.in);
        System.out.println( "Start of CardGameTest\n");
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        Player     p1;
        Player     p2;
        Player     p3;
        CardGame   game;
        
        // test Card class
        c = new Card( 0);
        System.out.println( c );
        System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c );
        //cards.testOnlyPrint(); remove method after testing!
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        p = new Player( "player1" );
        p1 = new Player( "player2" );
        p2 = new Player( "player3" );
        p3 = new Player( "player4" );
        System.out.println( p.getName() + "\n" );
        
        // test CardGame class too
        game = new CardGame(p, p1, p2, p3);
        game.updateRound();
        game.updateRound();
        game.updateRound();
        System.out.println( "Round No: " + game.getRoundNo() );
        //another way of testing the game class is to playing the game;
        //game.play();
        
        
        System.out.println( "\nEnd of CardGameTest\n" );
        scan.close();
    }
    
}
