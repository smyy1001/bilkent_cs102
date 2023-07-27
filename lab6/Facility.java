/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab06
 * Author: Sumeyye Acar
 * Id: 22103640
*/


import java.util.*;
import java.io.*;
public class Facility {
    // Attributes
    int roomCount;
    ArrayList<room> roomsConnectedRooms = new ArrayList<>();
    ArrayList<room> simulRoomsConnectedRooms = new ArrayList<>();
    room justARoom;
    ArrayList<room> deadRoom = new ArrayList<>();

    // Constructor
    public Facility() {}
    
    /**
     * importing the rooms to the facility
     * @param filename
     * @throws FileNotFoundException
     */
    public void importFacility(String filename) throws FileNotFoundException {
        int lineNum = 0;
        String line;
        Scanner in = new Scanner(new File(filename + ".txt"), "UTF-8");
        line = in.nextLine();
        lineNum++;
        this.roomCount = Integer.parseInt(line.trim());
        while (lineNum >= 1 && lineNum-1 < roomCount) {
            line = in.nextLine();
            justARoom = new room(line.substring(0, line.indexOf(" ") + 1).trim(),
                    Integer.parseInt(line.substring(line.indexOf(" "), line.length()).trim()));
            roomsConnectedRooms.add(justARoom);
            lineNum++;
        }
        while (in.hasNextLine()) {
            line = in.nextLine();
            for(int a = 0; a < roomsConnectedRooms.size(); a++) {
                if(roomsConnectedRooms.get(a).nameOfTheRoom.trim().equals(line.substring(0, line.indexOf("-")).trim())) {
                    for(int b = 0; b < roomsConnectedRooms.size(); b++) {
                        if(line.substring(line.indexOf("-") + 1, line.length()).trim()
                                .equals(roomsConnectedRooms.get(b).nameOfTheRoom.trim())) {
                            roomsConnectedRooms.get(a).connectedRooms.add(roomsConnectedRooms.get(b));
                            roomsConnectedRooms.get(b).connectedRooms.add(roomsConnectedRooms.get(a));
                        }
                    }
                }
            }
        }
    }

    // Real World Methods
    /**
     * The attack which performs the attack to the aimed room
     * @param name
     * @param attackLevel
     */
    public void securityAttack(String name, int attackLevel) {
        for (int a = 0; a < roomsConnectedRooms.size(); a++) {
            if (roomsConnectedRooms.get(a).nameOfTheRoom.equals(name)) {
                if (roomsConnectedRooms.get(a).securityLevel < attackLevel) {
                    deadRoom.add(roomsConnectedRooms.get(a));
                    attackSpread(a, attackLevel);
                }
            }
        }
    }
    /**
     * The method checking the connected rooms
     * @param index
     * @param attack
     */
    public void attackSpread(int index, int attack) {
        for (int a = 0; a < roomsConnectedRooms.get(index).connectedRooms.size(); a++) {
            if (roomsConnectedRooms.get(index).connectedRooms.get(a).securityLevel < attack) {
                deadRoom.add(roomsConnectedRooms.get(index).connectedRooms.get(a));
            }
        }
        announceTheLoser();
    }
    /**
     * The method printing the breached rooms and setting back the security (breached = false / security level += 1)
     */
    public void announceTheLoser() {
        System.out.println("The breached rooms:");
        for (int i = 0; i < deadRoom.size(); i++) {
            System.out.println("-" + deadRoom.get(i).nameOfTheRoom + " is breached.");
            deadRoom.get(i).setBackSecurity();
        }
    }


    // Simulation Methods
    /**
     * The attack which performs the attack to the aimed room (in a parallel universe like a simulation)
     * @param name
     * @param attackLevel
     */
    public void simulSecurityAttack(String name, int attackLevel) {
        for (int a = 0; a < simulRoomsConnectedRooms.size(); a++) {
            if (simulRoomsConnectedRooms.get(a).nameOfTheRoom.equals(name)) {
                if (simulRoomsConnectedRooms.get(a).securityLevel < attackLevel) {
                    simulRoomsConnectedRooms.get(a).setBackSecurity();
                    simulAttackSpread(a, attackLevel);
                }
            }
        }
    }
    /**
     * The method checking the connected rooms (in a parallel universe like a simulation)
     * @param index
     * @param attack
     */
    public void simulAttackSpread(int index, int attack) {
        for (int a = 0; a < simulRoomsConnectedRooms.get(index).connectedRooms.size(); a++) {
            if (simulRoomsConnectedRooms.get(index).connectedRooms.get(a).securityLevel < attack) {
                simulRoomsConnectedRooms.get(index).connectedRooms.get(a).setBackSecurity();
            }
        }
    }
    /**
     * where the simulation happens 
     * @param tries
     */
    public void  simulateAttacks(int  tries) {
        Random rand = new Random();
        int random = rand.nextInt(roomCount);
        simulRoomsConnectedRooms.addAll(roomsConnectedRooms);
        for( int i = 1; i < tries+1; i++ ) {
            simulSecurityAttack(simulRoomsConnectedRooms.get(random).nameOfTheRoom, i+5);
            random = rand.nextInt(roomCount);
        }
    }
}
