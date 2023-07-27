/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: HW3
 * Author: Sumeyye Acar
 * Id: 22103640
*/

package cardgame;

import java.util.Random;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
//
// date:14/10/22
public class Cards {
    final int NOOFCARDSINFULLPACK = 52;
    
    //properties
    Card[] cards;
    int    valid;
    
    //constructors
    public Cards( boolean fullPack) {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        if ( fullPack) { 
            createFullPackOfCards();  
        }
    }
    
    //methods
    public Card getTopCard() {
        Card tmp;
        if ( valid <= 0) { 
            return null; 
        }
        else {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    public boolean addTopCard( Card c ) {
        Card card = new Card( c.getCardNo() );
        if ( valid < cards.length) {
            cards[valid] = card;
            valid++;
            return true;
        }
        return false;
    }
    
    private void createFullPackOfCards() {
        for( int i = 0; i < 52; i++ ) {
            addTopCard( new Card(i) );
        }
        valid = 52;
    }
    
    public void shuffle() {
        int index;
        Card temp;
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
			index = random.nextInt(52);
			temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}
    }
    
    /* For testing purposes only
    public void testOnlyPrint() {
        for ( int i =0; i < valid; i++) {
            System.out.println( cards[i] );
        }
    }*/
}
