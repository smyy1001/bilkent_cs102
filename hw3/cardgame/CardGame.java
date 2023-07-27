/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: HW3
 * Author: Sumeyye Acar
 * Id: 22103640
*/

package cardgame;
import java.util.ArrayList;
import java.util.Scanner;

// Cardgame

// date:14/10/22
public class CardGame {
    // properties
    Cards             fullPack;
    ArrayList<Player> players; 
    ScoreCard         scoreCard; 
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4) {
        // fill the Players[]
        players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);

        // full pack at the beginning to distrubute to the players 
        fullPack = new Cards( true );
        fullPack.shuffle();
        for( int a = 0; a < 4; a++ ) {
            for( int b = 0; b < 13; b++ ) {
                players.get(a).add( fullPack.getTopCard() );
            }
        }

        //create a scoreCard to hold the score of each player
        scoreCard = new ScoreCard( 4 );

        //create an Cards(Deste) array to hold each Cards of the players on the table 
        cardsOnTable = new Cards[4];
        for( int j = 0; j < 4; j++ ) {
            cardsOnTable[j] = new Cards(false);
        }

        //initialize the number of played rounds to zero
        roundNo = 1;
    }

    // methods
    public void play() {
    // menu
    String menu ="Enter what you want to do:\n"+
    "1-Play\n" +
    "2-Display Score Card\n"+
    "3-Quit Game";
    
    Scanner in = new Scanner( System.in );
    System.out.println( menu );
    int choice = in.nextInt();
    while( choice != 3 && roundNo != 14 ) {
        if( choice == 1 ) {
            for( int i = 0; i < 4; i++ ) {
                System.out.println( "whose turn is it?" );
                int a = in.nextInt();
                setTurnOfPlayer(a); 
                isTurnOf( players.get(turnOfPlayer) );
            }
            roundNo++;
            //back to menu
            System.out.println(menu);
            choice = in.nextInt();
        }
        else if( choice == 2 ) {
            System.out.println( showScoreCard() );
            //back to menu
            System.out.println(menu);
            choice = in.nextInt();
        }
    }
    if( choice == 3 ) {
        isGameOver();
    }
    in.close();
    }

    public void updateRound() {
        roundNo++;
    }


    public boolean playTurn( Player p, Card c) {
        int index = -1;
        for( int i = 0; i < 4; i++ ) {
            if( p.getName().equalsIgnoreCase( players.get(i).getName() ) ) {
                index = i;
            }
        }
        cardsOnTable[index].addTopCard(c);
        scoreCard.update( index , c.cardNo );
        return true;
    }
    
    public boolean isTurnOf( Player p) {
        playTurn(p, p.playCard());
        return true;
    }

    public void setTurnOfPlayer( int x ) {
        turnOfPlayer = x;
    }

    public boolean isGameOver() {
        System.out.print( "The Winner: " );
        for( int i = 0; i < getWinners().length; i++ ) {
            System.out.print( getWinners()[i].toString() );
        }
        return true;
    }
    
    public int getScore( int playerNumber ) {
        return scoreCard.getScore( playerNumber );
    }
    
    public String getName( int playerNumber ) {
        return players.get( playerNumber ).getName();
    }
    
    public int getRoundNo() {
        return roundNo;
    }
    
    public int getTurnOfPlayerNo() {
        return turnOfPlayer;
    }
    
    public Player[] getWinners() {
        Player[] Winners = new Player[ scoreCard.getWinners().length ];
        for( int i = 0; i < Winners.length; i++ ) {
            Winners[i] = players.get(scoreCard.getWinners()[i]);
        }
        return Winners;
    }
    
    public String showScoreCard() {
        return scoreCard.toString();
    }
    
}