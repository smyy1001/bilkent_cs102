/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab06
 * Author: Sumeyye Acar
 * Id: 22103640
*/

import java.io.FileNotFoundException;
class test {
    public static void main(String[] args) throws FileNotFoundException {
        Facility facility = new Facility();
        facility.importFacility("sample_input");
        System.out.println("The list of all rooms: " +facility.roomsConnectedRooms + "\n");
        System.out.println("The list of the connected rooms of the 8th room: "+facility.roomsConnectedRooms.get(7).connectedRooms + "\n");
        System.out.println("The brached rooms when attacked \"nwwo\" with the attack level 7: ");
        facility.securityAttack("nwwo", 7);
        facility.simulateAttacks(4);
        System.out.println("\n"+"The list of all rooms after the simulation: " +facility.simulRoomsConnectedRooms + "\n");
    }
}
