/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab04
 * Author: Sumeyye Acar
 * Id: 22103640
*/


import java.io.FileNotFoundException;
import java.io.IOException;
class RunMe {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        /*
         * the Constructors make us of readFromFolder() method -which uses
         * the createPath(String filename) method to create Paths- in order to generate a Path array 
         * holding all given Paths
         * Additionally, one can create random Paths with the createPath method
         */
        Map givenMap = new Map( "Map.txt" ); 
        Map randomMap = new Map( 50,100 );

        // display the Maps by using readMap()
        System.out.println( "-----GIVEN MAP-----" );
        givenMap.readMap();
        System.out.println( "-----RANDOM MAP-----" );
        randomMap.readMap();

        // creating random paths with creatPath() method 
        // and testing wheteher it is leading to a treasure or not
        Path randomPath = givenMap.createPath();
        System.out.print( "A random generated path is created and it leads to a treasure in the given map: " );
        System.out.print(givenMap.isPathToTreasure(randomPath.getPath()));
        System.out.println();

        // paths that reach Treasure for both Maps
        System.out.println( "\n\n-----PATHS WHICH LEAD TO TREASURE FOR THE GIVEN MAP-----" );
        givenMap.processAllPaths();
        System.out.println( "\n\n-----PATHS WHICH LEAD TO TREASURE FOR THE RANDOM MAP-----" );
        randomMap.processAllPaths();

        // testin the checkPathCombination(Path a, Path b) method for the givenMap
        Path a = new Path( "Sample Paths\\path-0.txt" );
        Path b = new Path( "Sample Paths\\path-1.txt" );
        Path c = new Path( "Sample Paths\\path-2.txt" );
        System.out.println( "\n\na + b leads to a treasure in the given map: " + givenMap.checkPathCombination(a, b) );
        System.out.println( "a + c leads to a treasure in the given map: " + givenMap.checkPathCombination(a, c) );

        // display the possible path combinations by using processPathCombinations()
        // the processPathCombinations() method makes use of checkPathCombination() method
        // the checkPathCombination() method makes use of isPathToTreasure() method
        // the isPathToTreasure() method makes use of isMovePossible() method
        System.out.println( "\n\n-----COMBINATIONS WHICH LEAD TO TREASURE FOR THE GIVEN MAP-----" );
        givenMap.processPathCombinations();
        System.out.println( "\n\n-----COMBINATIONS WHICH LEAD TO TREASURE FOR THE RANDOM MAP-----" );
        randomMap.processPathCombinations();
    }// main method
}// class
