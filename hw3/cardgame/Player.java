/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: HW3
 * Author: Sumeyye Acar
 * Id: 22103640
*/

package cardgame;
// Player - Simple card game player with name and hand of cards

// date:14/10/22
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    public Player( String name) {
        this.name = name;
        hand = new Cards(false);
    }
    
    // methods
    public String getName() {
        return name;
    }

    public Cards getHand() {
        return hand;
    }
    
    public void add( Card c) {
        hand.addTopCard( c );
    }
    
    public Card playCard() {
        return hand.getTopCard();
    }

    public String toString() {
        return this.name;
    }
    
}
