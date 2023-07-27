/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab05
 * Author: Sumeyye Acar
 * Id: 22103640
*/

import java.awt.*;
import javax.swing.*;
class the_gui extends JFrame {
    /**
     * CS102 Lab Assignment 5
     * @author Sümeyye Acar 21.11.2022
     */

    JPanel solarPanel;
    JPanel solarPanel2;
    JLabel heading;
    final int width;
    final int height;

    /**
     * The Frame containing all Components
     * @param height (of the frame)
     * @param width (of the frame)
     */
    public the_gui( int height, int width ) {
        // Title 
        setTitle("Lab Assignment 5 - Sümeyye Acar");

        // Size
        this.width = width;
        this.height = height;
        setSize(this.height, this.width);

        // Panels
        solarPanel = new JPanel();
        solarPanel2 = new JPanel();
        solarPanel.setLayout(new BoxLayout(solarPanel, BoxLayout.Y_AXIS));
        solarPanel2.setLayout(new GridBagLayout());
        solarPanel.setBackground(Color.blue.darker().darker().darker().darker().darker().darker());
        solarPanel2.setBackground(Color.blue.darker().darker().darker().darker().darker().darker());
        solarPanel2.add(solarPanel);
        
        // Label
        heading = new JLabel("The Solar System\n");
        heading.setForeground(Color.white);
        heading.setFont(new Font("Serif", Font.PLAIN, 25));
        solarPanel.add(heading);
        
        add(solarPanel2, BorderLayout.NORTH);
    }

}