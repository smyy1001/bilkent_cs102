/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab04
 * Author: Sumeyye Acar
 * Id: 22103640
*/


// for reading from a file and printing to a file
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
// for Random.nextInt() method and the usage of ArrayList
import java.util.ArrayList;
import java.util.Random;


class Map {
    // Attributes
    char[][] TreasureMap;
    Path[] paths;
    String[] pathNames;
    char[] cells = new char[4];     // Possible Cells
    Scanner scan;    // Scanner(from file)
    Random rand = new Random();
    // Current Position
    int y;  // [0-200]
    int currenty;
    int x;  
    int currentx;  // [0-200]


    // the constructor which uses the sample Map
    public Map(String filename) throws FileNotFoundException {
        readFromFolder(new File("Sample Paths"));
        ArrayList<String> temp = new ArrayList<>();
        scan = new Scanner( new File(filename), "UTF-8" );
        while( scan.hasNextLine() ) {
            temp.add(scan.nextLine());
        }
        TreasureMap = new char[temp.size()][temp.get(0).length()];
        for( int v = 0; v < temp.size(); v++ ) {
            for( int w = 0; w < temp.get(0).length(); w++ ) {
                TreasureMap[v][w] = temp.get(v).charAt(w);
            }
        }
        // Setting the location (start point)
        for( int i = 0; i < TreasureMap.length; i++ ) {
            for( int j = 0; j < TreasureMap[i].length; j++ ) {
                if( TreasureMap[i][j] == 'S' ) { this.y = i; this.x = j; }
            }
        }
        setCurrents();
    }


    // the Constructor which creates and represents a new random Map
    public Map(int i, int u) throws IOException {
        readFromFolder(new File("Sample Paths"));
        // possible cells
        cells[0] = 'B';// block (-)
        cells[1] = '.';// empty(+)
        cells[2] = 'X';// treasure(+)
        cells[3] = 'S';// starting point(+)
        //generate the Treasure Map 2D Array
        TreasureMap = new char[i][u];
        int randomX;
        int randomY;
        randomX = rand.nextInt(u);
        randomY = rand.nextInt(i);
        for( int a = 0; a < i ; a++ ) {
            for( int b = 0; b < u; b++ ) {
                if( a == 0 || b == 0 || a == i-1 || b == u-1 ) {    // The Frame
                    TreasureMap[a][b] = cells[0];// B
                }
                else {
                    if( b < (u+2)/10 ) {
                        TreasureMap[a][b] = cells[0];   //B
                    }
                    else if( b < ((u+2)/10) + ((u+2)/15) ) {
                        TreasureMap[a][b] = cells[2];   //X
                    }
                    else {
                        TreasureMap[a][b] = cells[1];   //.
                    }
                }
            }
            for( int p = 1; p < u-1; p++ ) {
                int randomIndex = rand.nextInt( u-2 )+1;
                char tempChar = TreasureMap[a][randomIndex];
                TreasureMap[a][randomIndex] = TreasureMap[a][p];
                TreasureMap[a][p] = tempChar;
            }
        }
        TreasureMap[randomY][randomX] = cells[3];   //S
        // Setting the location (start point)
        this.x = randomX;
        this.y = randomY;
    
        // the exporting part of this project is been taken from my own previous Lab Assignment (Lab 1)! 
        scan = new Scanner( System.in );
        System.out.print( "What should be name be of your maps .txt file? (dont include .txt)" );
        String name = scan.next();
        name = name.trim();
        name = name + ".txt";
        //creating the file
        File maps = new File(name);
        //making sure the creation process succeeded
        if( maps.createNewFile() ) {
            System.out.println("File created: " + maps.getName());
        } 
        else {
            System.out.println("File already exists.");
        }
        //Obejct from the PrintStream Class
        PrintStream newStream = new PrintStream( maps );
        //notifying the user about the result. THIS PART IS STILL BEING PRINTED TO THE TERMINAL 
        System.out.println("You can see your Map in the " + maps.getAbsolutePath() + " named file!");
        System.setOut( newStream );
        //Everything will be in the new generated .txt file from now on
        for( int t = 0; t < TreasureMap.length; t++ ) {
            for( int j = 0; j < TreasureMap[t].length; j++ ) {
                System.out.print(TreasureMap[t][j]);
            }
            System.out.println();
        }
        //setting System.out back to the terminal
        System.setOut( new PrintStream(new FileOutputStream(FileDescriptor.out)) );
        System.out.println();
        setCurrents();
    }// end of the second constuctor 


    void setCurrents() {
        currentx = x;
        currenty = y;
    }


    public Path createPath(String filename) throws FileNotFoundException {
        Path path = new Path(filename);
        return path;
    }// End of the createPath method

    
    public Path createPath() throws IOException {
        
        // generate a random path
        int randomNumOfInstructions = rand.nextInt(10) + 1;
        char[][] rpath = new char[randomNumOfInstructions][3];
        int randomDirection;
        int randomNumToMove;
        for( int a = 0; a < rpath.length; a++ ) {
            randomDirection = rand.nextInt(4);
            randomNumToMove = rand.nextInt(25) + 1;
            if( randomDirection == 0 ){ 
                rpath[a][0] = 'E';
            }
            else if( randomDirection == 1 ){ 
                rpath[a][0] = 'W';
            }
            else if( randomDirection == 2 ){ 
                rpath[a][0] = 'N';
            }
            else if( randomDirection == 3 ){ 
                rpath[a][0] = 'S';
            }

            if( randomNumToMove > 9 ) {
                rpath[a][1] = (char) (randomNumToMove/10 + '0');
                rpath[a][2] = (char) (randomNumToMove%10 + '0');
            }
            else if( randomNumToMove < 10 ) {
                rpath[a][1] = (char) (randomNumToMove + '0');
                rpath[a][2] = '.';
            }
        }

        // the exporting part of this project is been taken from my own previous Lab Assignment (Lab 1)! 
        scan = new Scanner( System.in );
        System.out.print( "What should be the name be of your path .txt file? (dont include .txt)" );
        String name = scan.next();
        name = name.trim();
        name = name + ".txt";
        //creating the file
        File paths = new File(name);
        //making sure the creation process succeeded
        if( paths.createNewFile() ) {
            System.out.println("File created: " + paths.getName());
        } 
        else {
            System.out.println("File already exists.");
        }
        //Obejct from the PrintStream Class
        PrintStream newStream = new PrintStream( paths );
        //notifying the user about the result. THIS PART IS STILL BEING PRINTED TO THE TERMINAL 
        System.out.print("You can see your Path in the " + paths.getAbsolutePath() + " named file!");
        System.setOut( newStream );
        //Everything will be in the new generated .txt file from now on

        for( int i = 0; i < rpath.length; i++ ) {
            System.out.print( rpath[i][0] + " " + rpath[i][1] );
            if( rpath[i][2] != '.' ) { System.out.print( rpath[i][2] ); }
            System.out.println();
        }

        //setting System.out back to the terminal
        System.setOut( new PrintStream(new FileOutputStream(FileDescriptor.out)) );
        System.out.println();
        
        Path path = createPath(name);
        return path;
    }


    public void readMap() throws FileNotFoundException {
        for( int i = 0 ; i < TreasureMap.length; i++ ) {
            for( int j = 0; j < TreasureMap[i].length; j++ ) {
                System.out.print( TreasureMap[i][j] );
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }// End of the readMap method



    public boolean isPathToTreasure(char[][] charr) throws FileNotFoundException { 
        setCurrents();
        boolean isPathToTreasure = true;
        for( int i = 0; i < charr.length; i ++) {
            isMovePossible(charr, i);
        }
        if( TreasureMap[currenty][currentx] != 'X' && TreasureMap[currenty][currentx] != 'T' ) {isPathToTreasure = false;}
        return isPathToTreasure;
    }// End of the isPathToTreasure method



    public boolean isMovePossible( char[][] charr, int i ) throws FileNotFoundException{
        boolean possible = true;
        int value = Character.getNumericValue(charr[i][1]);
        if( charr[i][2] != '.' ) {
            value = ((value*10) + Character.getNumericValue(charr[i][2]));
        }
        if( charr[i][0] == 'S' ) {    // south
            for( int a = 1; (a < value + 1) && possible; a++ ) {
                if( currenty+a < TreasureMap.length && (TreasureMap[currenty+a][currentx] == 'B') ) { possible = false;}
                if( currenty+a >= TreasureMap.length ) { possible = false; }
            }
            if( possible ) { currenty += value; }
        }
        else if( charr[i][0] == 'N' ) {    // nourth
            for( int a = 1; (a < value + 1) && possible; a++ ) {
                if( currenty-a < TreasureMap.length && (TreasureMap[currenty-a][currentx] == 'B') ) { possible = false;}
                if( currenty-a < 0 ) { possible = false; }
            }
            if( possible ) { currenty -= value; }
        }
        else if( charr[i][0] == 'E' ) {    // east
            for( int a = 1; (a < value + 1) && possible; a++ ) {
                if( currentx+a < TreasureMap.length && (TreasureMap[currenty][currentx+a] == 'B') ) { possible = false;}
                if( currentx+a >= TreasureMap[0].length ) { possible = false; }
            }
            if( possible ) { currentx += value; }
        }
        else if( charr[i][0] == 'W' ) {    // west
            for( int a = 1; (a < value + 1) && possible; a++ ) {
                if( currentx-a < TreasureMap.length && (TreasureMap[currenty][currentx-a] == 'B') ) { possible = false;}
                if( currentx-a < 0 ) { possible = false; }
            }
            if( possible ) { currentx -= value; }
        }
        return possible;

    }// End of the isMovePossible method 



    public void readFromFolder(File folderName) throws FileNotFoundException {
        File[] files = folderName.listFiles();
        pathNames = new String[files.length];
        for( int a = 0; a < files.length; a++) {
            pathNames[a] = files[a].getAbsolutePath();
        }
        paths = new Path[pathNames.length];
        for( int j = 0; j < paths.length; j++ ) {
            paths[j] = createPath(pathNames[j]);
        }
    }// End of the readFromFolder method



    public boolean checkPathCombination(Path a, Path b) throws FileNotFoundException {
        char[][] combinedPath = new char[a.getPath().length + b.getPath().length][3];
        for( int i = 0; i < combinedPath.length; i++ ) {
            if( i < a.getPath().length ) {
                combinedPath[i][0] = a.getPath()[i][0];
                combinedPath[i][1] = a.getPath()[i][1];
                combinedPath[i][2] = a.getPath()[i][2];
            }
            else {
                combinedPath[i][0] = b.getPath()[i-a.getPath().length][0];
                combinedPath[i][1] = b.getPath()[i-a.getPath().length][1];
                combinedPath[i][2] = b.getPath()[i-a.getPath().length][2];
            }
        }
        return isPathToTreasure(combinedPath);
    }// End of the checkPathCombination method



    public void processPathCombinations() throws FileNotFoundException {
        System.out.println( "The combinations that reach a tresure:" );
        for( int i = 0; i < 81; i++ ) {
            for( int j = 0; j < 81; j++ ) {
                if( checkPathCombination(paths[i], paths[j]) ) { 
                    System.out.println( paths[i].fileName + " + " + paths[j].fileName );
                }
            }
        }
    }// End of the processPathCombinations method

    public void processAllPaths() throws FileNotFoundException {
        System.out.println( "The paths which reach a tresure:" );
        for( int i = 0; i < 81; i++ ) {
            if( isPathToTreasure(paths[i].getPath()) ) { 
                System.out.println( paths[i].fileName );
            }
        }
    }

}// end of the Map class