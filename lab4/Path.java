/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab04
 * Author: Sumeyye Acar
 * Id: 22103640
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Path {
    //Attributes
    private String[] path = new String[100];  // the Path array
    Scanner readFromFile;   // Scanner
    String fileName;
    
    // The Constructure creates an array for each instruction
    public Path( String filename ) throws FileNotFoundException {
        fileName = filename;
        readFromFile = new Scanner( new File( filename), "UTF-8" );
        for( int i = 0; readFromFile.hasNextLine(); i++ ) {
            path[i] = readFromFile.nextLine();
        }
        // trim the array
        int indexOfNull = Arrays.asList(path).indexOf(null);
        path = Arrays.copyOfRange(path, 0, indexOfNull);
    }

    public char[][] getPath() { // the instructions as two dimensional array
        char[][] pathInstructions = new char[path.length][3];
        for( int i = 0; i < path.length; i++ ) {
            pathInstructions[i][0] = path[i].charAt(0);
            pathInstructions[i][1] = path[i].charAt(2);
            pathInstructions[i][2] = '.';
            if( path[i].length() > 3 ) {
                pathInstructions[i][2] =  path[i].charAt(3);
            }
        }
        return pathInstructions;
    }

    public String toString() {
        String output = "";
        for( int i = 0; i < getPath().length; i++ ) {
            output += getPath()[i][0] + " --> " + getPath()[i][1];
            if( getPath()[i][2] != 0 ) {
                output += getPath()[i][2] + "\n";
            }
            else {
                output +=  "\n";
            }
        }
        return output;
    }
}// end of the Path class