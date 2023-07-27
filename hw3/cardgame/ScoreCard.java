package cardgame;
// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:Sümeyye Acar
// date: 14/10/22
public class ScoreCard {
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers ) {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++) { 
            scores[i] = 0; 
        } 
    }
    
    // methods
    public int getScore( int playerNo) { 
        return scores[ playerNo ];
    }
    
    public void update( int playerNo, int amount) { 
        scores[playerNo] += amount; 
    }
    
    public String toString() {
        String s;
        s = "\n" + "_____________\n" + "\nPlayer\tScore\n" + "_____________\n";
        for ( int playerNo = 0; playerNo < scores.length; playerNo++) {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        s += "_____________\n";
        return s;
    }
    
    public int[] getWinners() {
        int[] winners = new int[1];
        int max = scores[0];
        int winnerPlayerNo = 0;
        for( int i = 1; i < scores.length; i++ ) {
            if( scores[i] > max ) {
                max = scores[i];
                winnerPlayerNo = i;
            }
        }
        winners[0] = winnerPlayerNo;
        return winners;
    }
}
