/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab01
 * Author: Sumeyye Acar
 * Id: 22103640
*/

import java.util.ArrayList;

public class methods {

    /**
     * This method explains how GCD is calculated and returns the GCD
     * @param x
     * @param y
     * @return Greatest Common Divisor
     */
    public static int GretestCommonDivisor( int x, int y ) {
        System.out.println();
        System.out.println( "We can use the Euclid's algorithm in order to calculate the greatest common divisor\n" +
                            "which will be equal to the the wanted distance (equally spaced and consumed as little as possible)\n" +
                            "If we subtract a smaller number from a larger one (we reduce a larger number),\n" + 
                            "GCD doesnt change. So if we keep subtracting repeatedly the larger of two, we end up with GCD\n" +
                            "(Divisor becomes dividend, remainder becomes divisor and the algorithm stops when we find reaminder 0 and the GCD: divisor)");
        int dividend = 0;
        int divisor = 0;
        int remiander = 1;
        int step = 1;
        
        if( x==y ) {
            return x;
        }
        else if( x > y ) {
            dividend = x;
            divisor = y;
        }
        else {
            dividend = y;
            divisor = x;
        }
        while( remiander != 0 ) {
            if( step == 1 ) {
                remiander = 0;
            }
            System.out.printf( "Step%d:  Dividend: %d  Divisor: %d  Remainder: %d", step, dividend, divisor, dividend%divisor );
            System.out.println();
            remiander = dividend % divisor;
            dividend = divisor;
            divisor = remiander;
            step++;
        }
        return dividend;
    }


    /**
     * This method returns all numbers between a and b which are divisable by x, y and z
     * @param a
     * @param b
     * @param x
     * @param y
     * @param z
     * @return The ArrayList of numbers which are divisable by x, y, z and are between a and b
     */
    public static ArrayList<Integer> numbersInbetween( int a, int b, int x, int y, int z ) {
        System.out.println();
        System.out.println( "In order to find all numbers divisible by x, y and z and are between a and b;\n" +
                            "we need to test all numbers between a and b one by one." );  
        int larger = 0;
        int smaller = 0;
        if( a > b ) {
            larger = a;
            smaller = b;
        }
        else {
            larger = b;
            smaller = a;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for( int i = smaller + 1 ; i < larger; i++ ) {
            if( (i % x == 0) && (i % y == 0) && (i % z == 0) ) {
                System.out.println( i + " is divisible by " + x + ", " + y + " and " + z );
                arr.add(i);
            }
        }
        return arr;
    }


    /**
     * This method explains and calculates how many years are needed in order the "father" to double his "daughetr"s age 
     * @param x
     * @param y
     * @return In how many years "father" will be double his "daughter"s age 
     */
    public static int doubleAge( int x, int y ) {
        System.out.println();
        System.out.println( "In \"?\" years fathers age will be = fathersAge + \"?\". \n" +
                            "In \"?\" years daughters age will be = daughtersAge + \"?\". \n" +
                            "fathersAge + \"?\" = 2 * (daughtersAge + \"?\") \n" +
                            "So we can say: \"?\" = fathersAge - 2*daughtersAge" );
        int father = 0;
        int daughter = 0;
            
        if( x == y) {
            return 0;
        }
        else if ( x > y ) {
            father = x;
            daughter = y;
        }
        else {
            father = y;
            daughter = x; 
        }
        int result = father - (2*daughter);
        System.out.println( father + " - 2*" + daughter + "=" + result );
        return result;
    }

}
