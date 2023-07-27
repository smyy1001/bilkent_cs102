/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab05
 * Author: Sumeyye Acar
 * Id: 22103640
*/


import javax.swing.*;
public class test extends JFrame{
    /**
     * CS102 Lab Assignment 5
     * @author Sümeyye Acar 21.11.2022
     */

    public static void main(String[] args) {
        the_gui solar = new the_gui(1000,500);
        solar.setDefaultCloseOperation(EXIT_ON_CLOSE);
        solar.setLocationRelativeTo(null);

        the_space space = new the_space();
        solar.add(space);
        // Planets
        Planet pl = new Planet(30, 300, 500, 2, 180);
        Planet p2 = new Planet(50, 175, 600, 1, 267);
        Planet p3 = new Planet(80, 200, 300, 3, 12);
        Planet p4 = new Planet(16, 370, 200, 4, 135);
        the_space.planets.add(pl);
        the_space.planets.add(p2);
        the_space.planets.add(p3);
        the_space.planets.add(p4);

        solar.setVisible(true);
    }
}
