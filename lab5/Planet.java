/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab05
 * Author: Sumeyye Acar
 * Id: 22103640
*/


import java.awt.*;
import javax.swing.*;
public class Planet extends JPanel{
    /**
     * CS102 Lab Assignment 5
     * @author Sümeyye Acar 21.11.2022
     */
    
    // Attributes
    Color[] planetColor = {Color.white, Color.blue, Color.green, Color.red, Color.pink, 
                            Color.gray, Color.yellow,Color.orange,Color.black};// 9 colors
    double angle;
    int xCoord;
    int yCoord;
    int radius;
    int smallR;
    int largerR;
    double currentAngle;
    Color clr;

    /**
     * The Constructor
     * @param radius (radius of the planet)
     * @param r (diameter of the orbit (y-axis))
     * @param R (diameter of the orbit (x-axis))
     * @param color
     * @param angle (the angle which is needed in order to calculate the starting point of the planet)
     */
    public Planet( int radius, int r, int R, int color, double angle ){
        clr = planetColor[color];
        this.radius = radius;
        this.angle = angle;
        currentAngle = angle;
        smallR = r;
        largerR = R;
        setPosition(angle);
    }

    /**
     * The method to set the coordinates relative to the angle
     * @param angle 
     */
    public void setPosition(double angle) {
        xCoord = (int) ((largerR/2)*Math.cos(Math.toRadians(angle)));
        yCoord = (int) ((smallR/2)*Math.sin(Math.toRadians(angle)));
    }

    public void setPosition(boolean b, double speed) {
        currentAngle = (double) (currentAngle + speed);
    }

    /**
     * The method to draw the orbit and planet according to the user's choices
     * @param g
     */
    public void draw(Graphics g) {
        super.paintComponent(g);
        g.setColor(clr);
        // Orbit
        g.drawOval((1000-largerR)/2,(400-smallR)/2, largerR, smallR);
        // Planet
        g.fillOval((500-radius/2)+(xCoord), (200-radius/2)+(yCoord), radius, radius);
    }
}