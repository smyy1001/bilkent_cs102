/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab01
 * Author: Sumeyye Acar
 * Id: 22103640
*/

import java.util.Scanner;//Scanner
import java.util.ArrayList;//Array of the types
import java.util.Random;//random values for random questions

//generating new file and changing the current PrintStream
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CS102_Sec1_Asgn1_Acar_Sümeyye {

    public static void main(String[] args) throws IOException {

        //scanner
        Scanner sc = new Scanner( System.in );
        
        //menu
        String menu = "What would you like to do?\n" +
                    "1- FlowerBed Question (Greatest Common Divisor Question)\n" +
                    "2- Finding the numbers in an interval which are divisible by some numbers\n" +
                    "3- father-Daughter Question (Age Problem)\n" +
                    "4- Solving Random 5 Questions\n" +
                    "5- Exit";
        System.out.println( menu );
        int choice = sc.nextInt();

        //START
        while ( choice != 5 ) {
            if( choice == 1 ) {
                System.out.println();

                //question
                System.out.println( "Around a rectangular flowerbed with dimensions X meters \n" +
                                    "and Y meters are to be planted roses equally spaced \n" +
                                    "so that the roses are found in every corner of the flowerbed \n" +
                                    "and are consumed as little as possible. At what distance are planted roses?" );

                //getting the variables 
                System.out.println( "Enter the \"X\": ");
                int x = sc.nextInt();
                System.out.println( "Enter the \"Y\": ");
                int y = sc.nextInt();

                //displaying the result
                System.out.println( "Minimum distance between roses: " + methods.GretestCommonDivisor(x, y) );
                System.out.println();

                //back to menu
                System.out.println( menu );
                choice = sc.nextInt();
            }
            else if( choice == 2 ) {
                System.out.println();

                //question
                System.out.println( "What are the numbers between A and B " +
                                    "that are divisible by X, Y and Z?" );

                //getting the variables
                System.out.println( "Enter the \"A\": ");
                int a = sc.nextInt();
                System.out.println( "Enter the \"B\": ");
                int b = sc.nextInt();
                System.out.println( "Enter the \"X\": ");
                int x = sc.nextInt();
                System.out.println( "Enter the \"Y\": ");
                int y = sc.nextInt();
                System.out.println( "Enter the \"Z\": ");
                int z = sc.nextInt();

                //displaying the result
                System.out.println( "Numbers in the interval (a, b) which divisible by x, y, z: \n" +
                                    methods.numbersInbetween(a, b, x, y, z) );
                System.out.println();

                //back to menu
                System.out.println( menu );
                choice = sc.nextInt();
            }
            else if( choice == 3 ) {
                System.out.println();

                //quesiton
                System.out.println( "Louis is X years old. His daughter is Y years old. \n" +
                                    "In how many years will Louis be double his daughter's age?" );

                //getting the variables
                System.out.println( "Enter the \"X\": ");
                int x = sc.nextInt();
                System.out.println( "Enter the \"Y\": ");
                int y = sc.nextInt();

                //displaying the result
                System.out.println( "Needed years: " + methods.doubleAge(x, y) );
                System.out.println();

                //back to menu
                System.out.println( menu );
                choice = sc.nextInt();
            }
            else if( choice == 4 ) {
                System.out.println();

                //asking the user for the types of questions 
                System.out.println( "Enter what type of questions you'd like to have in the right order.\n" +
                                    "Such as: 1,1,2,3,2 (1 => Greatest Common Divisor Question, 2 => Finding the numbers Question, 3 => Age Problem)" );
                
                //getting the types
                String types = sc.next();

                //creating an ArrayList out of the types in the correct order
                ArrayList<Integer> typesArr = new ArrayList<Integer>();
                for( int i = 0; i < types.length(); i++ ) {
                    if( Character.isDigit(types.charAt(i)) ) {
                        typesArr.add( Character.getNumericValue( types.charAt(i) ) );
                    }
                }

                //displaying the result
                //Results shouldn't be shown on the terminal, print them to a .txt file (EXPORTING)

                //getting the name from the user and creating the .txt file
                System.out.println( "What should be name be of your results .txt file?" );
                String name = sc.next();
                name = name.trim();
                name = name + ".txt";
                
                //creating the file
                File randQuest = new File(name);
                
                //making sure the creation process succeeded
                if( randQuest.createNewFile() ) {
                    System.out.println("File created: " + randQuest.getName());
                } 
                else {
                    System.out.println("File already exists.");
                }

                //Obejct from the PrintStream Class
                PrintStream newStream = new PrintStream( randQuest );

                //notifying the user about the result. THIS PART IS STILL BEING PRINTED TO THE TERMINAL 
                System.out.println("You can see your random generated questions and the answers in the " +
                                    randQuest.getAbsolutePath() + " named file!");
                
                System.setOut( newStream );
                //Everything will be in the randQuest file after this line

                //generating the questions and the solutions
                for( int j = 0; j < 5; j++ ) {
                    Random random = new Random();
                    if( typesArr.get(j) == 1 ) {
                        int X = random.nextInt(201);
                        int Y = random.nextInt(201);
                        System.out.print("X: " + X + " Y: " + Y + "\n" );
                        System.out.println( methods.GretestCommonDivisor( X, Y) );
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                    else if( typesArr.get(j) == 2 ) {
                        int a = random.nextInt(101);
                        int b = random.nextInt(101);
                        int x = random.nextInt(20)+1;
                        int y = random.nextInt(20)+1;
                        int z = random.nextInt(20)+1;
                        System.out.printf( "A:%d B:%d X:%d Y:%d Z:%d%n", a,b,x,y,z );
                        System.out.println( methods.numbersInbetween(a, b, x, y, z) );
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                    else if( typesArr.get(j) == 3 ) {
                        int x = random.nextInt(41) + 50;//father
                        int y = random.nextInt(26);//daughter
                        System.out.printf( "X:%d Y:%d%n" , x,y);
                        System.out.println( methods.doubleAge(x, y) );
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                }

                //setting System.out back to the terminal
                System.setOut( new PrintStream(new FileOutputStream(FileDescriptor.out)) );
                System.out.println();

                //back to menu
                System.out.println( menu );
                choice = sc.nextInt();
            }
        }
        if( choice == 5 ) {
            //Exiting...
            System.out.println( "\n\nExiting...\n\n" );
        }

        //closing the Scanner
        sc.close();
    }
}