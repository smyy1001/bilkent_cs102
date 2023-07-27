/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab05
 * Author: Sumeyye Acar
 * Id: 22103640
*/

import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

public class the_space extends JPanel{
    /**
     * CS102 Lab Assignment 5
     * @author Sümeyye Acar 21.11.2022
     */

    //
    public static ArrayList<Planet> planets = new ArrayList<Planet>();
    Timer timerStart;
    Timer timerStart2;
    Timer timerStop;
    Timer timerRewind;
    JButton addPlanet;
    JButton start;
    JButton stop;
    JButton rewind;
    int pos = 0;

    /**
     * Constructor with no parameter
     * The Panel containing the Planets
     */
    public the_space() {
        ActionListener button2 = new ButtonListener2();
        ActionListener button3 = new ButtonListener3();
        ActionListener button4 = new ButtonListener4();
        timerStart = new Timer(10, button2);
        timerStart2 = new Timer(10, button4);
        setBackground(Color.blue.darker().darker().darker().darker().darker().darker());
        addPlanet = new JButton("ADD PLANET!");
        start = new JButton("START");
        stop = new JButton("STOP");
        rewind = new JButton("REWIND");
        addPlanet.setBackground(Color.cyan.darker().darker());
        start.setBackground(Color.cyan.darker().darker());
        stop.setBackground(Color.cyan.darker().darker());
        rewind.setBackground(Color.cyan.darker().darker());
        addPlanet.setForeground(Color.white);
        start.setForeground(Color.white);
        stop.setForeground(Color.white);
        rewind.setForeground(Color.white);
        addPlanet.addActionListener(new ButtonListener1());
        start.addActionListener(button2);
        stop.addActionListener(button3);
        rewind.addActionListener(button4);
        add(addPlanet);
        add(start);
        add(stop);
        add(rewind);
        setVisible(true);
    }

    /**
     *  displaying the Sun and 4 Planets in the beginning
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < planets.size(); i++) {
            planets.get(i).draw(g);
        }
        // Sun
        g.setColor(Color.yellow.brighter().brighter());
        g.fillOval(450, 150, 100, 100);
    }

    /**
     * @param event (clicking the button)
     * @return the custom planet
     */
    private class ButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Scanner scan = new Scanner(System.in);
            int r,R,radius, color;
            double a;
            System.out.println("Enter the radius of the planet: ");
            radius = scan.nextInt();
            System.out.println("Enter the Smaller Radius of the orbit: ");
            r = scan.nextInt();
            System.out.println("Enter the Larger Radius of the orbit: ");
            R = scan.nextInt();
            System.out.println("Enter the Color Number (0-8): ");
            color = scan.nextInt();
            System.out.println("Enter the angle for the starting point: ");
            a = scan.nextDouble();
            Planet myPlanet = new Planet(radius, r, R, color, a);
            planets.add(myPlanet); 
            for( int i = 0; i < planets.size(); i++ ) {
                planets.get(i).draw(getGraphics());
            }
            scan.close();
        }
    }

    private class ButtonListener2 implements ActionListener { //start button
        @Override
        public void actionPerformed(ActionEvent event) {
            if(timerStart2.isRunning()) {timerStart2.stop();}
            timerStart.start();
            for( int i = 0; i < planets.size(); i++ ) {
                planets.get(i).setPosition(true, (5*i) + 7.75);
                planets.get(i).setPosition(planets.get(i).currentAngle);
            }
            repaint();
        }
    }
    private class ButtonListener4 implements ActionListener { //rewind button
        @Override
        public void actionPerformed(ActionEvent event) {
            if(timerStart.isRunning()) {timerStart.stop();}
            timerStart2.start();
            for( int i = 0; i < planets.size(); i++ ) {
                planets.get(i).setPosition(true, -(5*i+7.75));
                planets.get(i).setPosition(planets.get(i).currentAngle);
            }
            repaint();
        }
    }
    private class ButtonListener3 implements ActionListener { //stop button
        @Override
        public void actionPerformed(ActionEvent event) {
            if(timerStart.isRunning()) { timerStart.stop();}
            if(timerStart2.isRunning()) { timerStart2.stop();}
        }
    }


}