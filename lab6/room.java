/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab06
 * Author: Sumeyye Acar
 * Id: 22103640
*/

import java.util.ArrayList;

public class room {
    // Attributes
    String nameOfTheRoom;
    ArrayList<room> connectedRooms = new ArrayList<>();
    int connectedRoomNum;
    int securityLevel;

    // Constructor
    public room( String roomName, int securityLevel ) {
        nameOfTheRoom = roomName;
        this.securityLevel = securityLevel;
    }

    // Method
    public void setBackSecurity() {
        securityLevel++;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public String toString() {
        return nameOfTheRoom + "-->" + securityLevel;
    }
}