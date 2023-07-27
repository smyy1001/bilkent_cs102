/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab03
 * Author: Sumeyye Acar
 * Id: 22103640
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// The Battle Area
public class BattleArea {


    // For this task I have a characcter class which contains the common methods of the races
    // The classes Humans, Elves, Dwarfs and Halflings extend the character class (Inheritence)
    // Fighter-Rogue-Mage are interfaces (on top of the ccahracter class, outside the class)
    // Humans class implement Fighter-Rogue-Mage
    // Elves class implement Rogue-Mage
    // Dwarfs class implement Fighter-Mage
    // Halflings class implement Fighter-Rogue
    // The race classes contain their unique abilities as well as the
    //     abilities coming with the interfaces they implement

    public static void main(String[] args) throws CloneNotSupportedException{

        // Attributes
        Scanner takeInput = new Scanner( System.in );
        int RaceSelection;
        int ClassSelection;
        int abilitySelection;
        boolean otoPlay = false;

        // Characters
        character player = new character(0, 0);
        character opponent = new character(0, 0);
        
        // Ther Race-Class Table
        String[][] tableOfCharacters = new String[4][5];
        tableOfCharacters[0][0] = "Class/Race";
        tableOfCharacters[0][1] = "1- Human";
        tableOfCharacters[0][2] = "2- Elf";
        tableOfCharacters[0][3] = "3- Dwarf";
        tableOfCharacters[0][4] = "4- Halfling";
        tableOfCharacters[1][0] = "1- Fighter";
        tableOfCharacters[1][1] = "  yes";
        tableOfCharacters[1][2] = "  no";
        tableOfCharacters[1][3] = "  yes";
        tableOfCharacters[1][4] = "  yes";
        tableOfCharacters[2][0] = "2- Rogue";
        tableOfCharacters[2][1] = "  yes";
        tableOfCharacters[2][2] = "  yes";
        tableOfCharacters[2][3] = "  no";
        tableOfCharacters[2][4] = "  yes";
        tableOfCharacters[3][0] = "3- Mage";
        tableOfCharacters[3][1] = "  yes";
        tableOfCharacters[3][2] = "  yes";
        tableOfCharacters[3][3] = "  yes";
        tableOfCharacters[3][4] = "  no";

        // printing the table and getting the class and race form the user
        for( int i = 0; i < 4; i++) {
            for( int j = 0; j < 5; j++ ) {
                System.out.printf( "%-13s", tableOfCharacters[i][j] );
            }
            System.out.println();
        }

        // setting the characters race and class
        System.out.print( "\nPlease enter the number of the race you want to play: (be aware that you can only choose according to the table!)" );
        RaceSelection = takeInput.nextInt();
        System.out.print( "Please enter the number of the class you want to play: " );
        ClassSelection = takeInput.nextInt();
        
        if( RaceSelection < 5 && RaceSelection > -1 ) {
            if( RaceSelection == 1 ) {// Human
                player = new Humans( RaceSelection-1, ClassSelection-1 );
            }
            else if( RaceSelection == 2 ) {// Elves
                while( ClassSelection == 1 ) {
                    System.out.println("\nPlease enter the number of the class you want to play: (be aware that you can only choose according to the table!)"); 
                    ClassSelection = takeInput.nextInt();
                }
                player = new Elves(RaceSelection-1, ClassSelection-1);
            }
            else if( RaceSelection == 3 ) {// Dwarfs
                while( ClassSelection == 2 ) {
                    System.out.println("\nPlease enter the number of the class you want to play: (be aware that you can only choose according to the table!)"); 
                    ClassSelection = takeInput.nextInt();
                }
                player = new Dwarfs(RaceSelection-1, ClassSelection-1);
            }
            else {// Halflings
                while( ClassSelection == 3 ) {
                    System.out.println("\nPlease enter the number of the class you want to play: (be aware that you can only choose according to the table!)"); 
                    ClassSelection = takeInput.nextInt();
                }
                player = new Halflings(RaceSelection-1, ClassSelection-1);
            }
        }


        // Start the battle
        boolean playTheGame = true;
        while( playTheGame ) {
            while( player.currentHP > 0 ) {

                // creating a random opponent character according the rules
                Random random = new Random();
                int randomRace = random.nextInt(4);
                if( randomRace == 0 ) {// Human
                    int randomClass = random.nextInt(3);
                    opponent = new Humans( 0, randomClass );
                }
                else if( randomRace == 1 ) {// Elves
                    int randomClass = random.nextInt(3);
                    while( randomClass == 0 ) { randomClass = random.nextInt(3); }// cant be fighter
                    opponent = new Elves( 1, randomClass );
                }
                else if( randomRace == 2 ) {// Dwarfs
                    int randomClass = random.nextInt(3);
                    while( randomClass == 1 ) { randomClass = random.nextInt(3); }// cant be rogue
                    opponent = new Dwarfs( 2, randomClass );
                }
                else if( randomRace == 3 ) {// Halflings
                    int randomClass = random.nextInt(3);
                    while( randomClass == 2 ) { randomClass = random.nextInt(3); }// cant be mage
                    opponent = new Halflings( 3, randomClass );
                }
                // setting the opponents level
                if( player.level != 1 ) {
                    int randomLevel = random.nextInt(2);
                    if( randomLevel == 0 ) {
                        opponent.setLevel(player.level);
                        opponent.updateLevel();
                        opponent.setLevel(opponent.level-1);
                    }
                    else {
                        opponent.setLevel(player.level-1);
                        opponent.updateLevel();
                        opponent.setLevel(opponent.level-1);
                    }
                }
                System.out.println( "\n\nCurrent states:\nPlayer" + player.toString() + 
                                    "\n\nOpponent" + opponent.toString() + "\n" );
                
                System.out.print( "\nWould you like to turn on the Oto-Play? Enter Y for yes, N for no--> " );
                String oto = takeInput.next();
                if( oto.equalsIgnoreCase("y") ) { otoPlay = true; }

                for( int i = 0; i < 100000 && (player.currentHP > 0) && (opponent.currentHP > 0); i++ ) {// end when one of them looses
                    if( i % 2 == 0 ) {// Players turn
                        System.out.print( "\n\n"+Arrays.toString(player.Abilities()) + "\nPlayers turn -- > Enter which ability you want to use: " );
                        // Human
                        if( player.race == 0 ) {
                            if( player.classs == 0 ) {// Fighter (5 ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(5) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { player.defend(); }
                                else if( abilitySelection == 3 ) { ((Humans)player).slash(opponent); }
                                else if( abilitySelection == 4 ) { ((Humans)player).brust(opponent); }   
                                else { ((Humans) player).struggle(opponent); }
                            }
                            else if( player.classs == 1 ) {// Rogue (5 Ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(5) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { player.defend(); }
                                else if( abilitySelection == 3 ) { ((Humans)player).quickAttack(opponent); }
                                else if( abilitySelection == 4 ) { ((Humans)player).shootArrows(opponent); }   
                                else { ((Humans) player).struggle(opponent); }
                            }   
                            else {// Mage (6 Ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(6) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { ((Humans)player).defend(); }
                                else if( abilitySelection == 3 ) { ((Humans)player).fire(opponent); }
                                else if( abilitySelection == 4 ) { ((Humans)player).thunder(opponent); }   
                                else if( abilitySelection == 5 ) { ((Humans)player).blizzard(opponent); }   
                                else { ((Humans) player).struggle(opponent); }
                            }
                        }

                        // ELves
                        else if( player.race == 1 ) {
                            if( player.classs == 1 ) {// Rogue (5 Ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(5) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { player.defend(); }
                                else if( abilitySelection == 3 ) { ((Elves)player).quickAttack(opponent); }
                                else if( abilitySelection == 4 ) { ((Elves)player).shootArrows(opponent); }   
                                else { ((Elves) player).manaRestore(); }
                            }  
                            else {// Mage (6 Ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(6) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { player.defend(); }
                                else if( abilitySelection == 3 ) { ((Elves)player).fire(opponent); }
                                else if( abilitySelection == 4 ) { ((Elves)player).thunder(opponent); }   
                                else if( abilitySelection == 5 ) { ((Elves)player).blizzard(opponent); }   
                                else { ((Elves) player).manaRestore(); }
                            }
                        }

                        // Dwarfs
                        else if( player.race == 2 ) {
                            if( player.classs == 0 ) {// Fighter (5 ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(5) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { player.defend(); }
                                else if( abilitySelection == 3 ) { ((Dwarfs)player).slash(opponent); }
                                else if( abilitySelection == 4 ) { ((Dwarfs)player).brust(opponent); }   
                                else { ((Dwarfs) player).rest(); }
                            }
                            else {// Mage (6 Ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(6) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { player.defend(); }
                                else if( abilitySelection == 3 ) { ((Dwarfs)player).fire(opponent); }
                                else if( abilitySelection == 4 ) { ((Dwarfs)player).thunder(opponent); }   
                                else if( abilitySelection == 5 ) { ((Dwarfs)player).blizzard(opponent); }   
                                else { ((Dwarfs) player).rest(); }
                            }
                        }

                        // Halflings
                        else {
                            if( player.classs == 0 ) {// Fighter (5 ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(5) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { player.defend(); }
                                else if( abilitySelection == 3 ) { ((Halflings)player).slash(opponent); }
                                else if( abilitySelection == 4 ) { ((Halflings)player).brust(opponent); }   
                                else if( abilitySelection == 5 ) { ((Halflings) player).secondBreakfast(); }
                                else { 
                                    System.out.print( Arrays.toString(opponent.Abilities()) );
                                    System.out.print( "\nEnter which ability you want to mimic: " );
                                    int ability = takeInput.nextInt();
                                    ((Halflings) player).mimic(opponent, ability); 
                                }
                            }
                            if( player.classs == 1 ) {// Rogue (5 Ability)
                                if( !otoPlay ) {
                                    abilitySelection = takeInput.nextInt();
                                }
                                else {
                                    abilitySelection = takeInput.nextInt(5) + 1;
                                }
                                if( abilitySelection == 1 ) { player.attack(opponent); }
                                else if( abilitySelection == 2 ) { player.defend(); }
                                else if( abilitySelection == 3 ) { ((Halflings)player).quickAttack(opponent); }
                                else if( abilitySelection == 4 ) { ((Halflings)player).shootArrows(opponent); }  
                                else if( abilitySelection == 5 ) { ((Halflings)player).secondBreakfast(); } 
                                else { 
                                    System.out.print( Arrays.toString(opponent.Abilities()) );
                                    System.out.print( "\nEnter which ability you want to mimic: " );
                                    int ability = takeInput.nextInt();
                                    ((Halflings) player).mimic(opponent, ability); 
                                }
                            }
                        }
                        player.updateLevel();
                    }

                    else {// Opponents turn
                        System.out.print( Arrays.toString(opponent.Abilities()) + "\n\nOpponents turn\n" );
                        // Human
                        if( opponent.race == 0 ) {
                            if( opponent.classs == 0 ) {// Fighter (5 ability)
                                abilitySelection = random.nextInt(5);
                                if( abilitySelection == 1 ) { opponent.attack(player); }
                                else if( abilitySelection == 2 ) { opponent.defend(); }
                                else if( abilitySelection == 3 ) { ((Humans)opponent).slash(player); }
                                else if( abilitySelection == 4 ) { ((Humans)opponent).brust(player); }   
                                else { ((Humans) opponent).struggle(player); }
                                System.out.println( "Played ability: " + opponent.Abilities()[abilitySelection] );
                            }
                            else if( opponent.classs == 1 ) {// Rogue (5 Ability)
                                abilitySelection = random.nextInt(5);
                                if( abilitySelection == 1 ) { opponent.attack(player); }
                                else if( abilitySelection == 2 ) { opponent.defend(); }
                                else if( abilitySelection == 3 ) { ((Humans)opponent).quickAttack(player); }
                                else if( abilitySelection == 4 ) { ((Humans)opponent).shootArrows(player); }   
                                else { ((Humans) opponent).struggle(player); }
                                System.out.println( "Played ability: " + opponent.Abilities()[abilitySelection] );
                            }   
                            else {// Mage (6 Ability)
                                abilitySelection = random.nextInt(6);
                                if( abilitySelection == 1 ) { opponent.attack(player); }
                                else if( abilitySelection == 2 ) { opponent.defend(); }
                                else if( abilitySelection == 3 ) { ((Humans)opponent).fire(player); }
                                else if( abilitySelection == 4 ) { ((Humans)opponent).thunder(player); }   
                                else if( abilitySelection == 5 ) { ((Humans)opponent).blizzard(player); }   
                                else { ((Humans) opponent).struggle(player); }
                                System.out.println( "Played ability: " + opponent.Abilities()[abilitySelection] );
                            }
                        }

                        // ELves
                        else if( opponent.race == 1 ) {
                            if( opponent.classs == 1 ) {// Rogue (5 Ability)
                                abilitySelection = random.nextInt(5);
                                if( abilitySelection == 1 ) { opponent.attack(player); }
                                else if( abilitySelection == 2 ) { opponent.defend(); }
                                else if( abilitySelection == 3 ) { ((Elves)opponent).quickAttack(player); }
                                else if( abilitySelection == 4 ) { ((Elves)opponent).shootArrows(player); }   
                                else { ((Elves) opponent).manaRestore(); }
                                System.out.println( "Played ability: " + opponent.Abilities()[abilitySelection] );
                            }  
                            else {// Mage (6 Ability)
                                abilitySelection = random.nextInt(6);
                                if( abilitySelection == 1 ) { opponent.attack(player); }
                                else if( abilitySelection == 2 ) { opponent.defend(); }
                                else if( abilitySelection == 3 ) { ((Elves)opponent).fire(player); }
                                else if( abilitySelection == 4 ) { ((Elves)opponent).thunder(player); }   
                                else if( abilitySelection == 5 ) { ((Elves)opponent).blizzard(player); }   
                                else { ((Elves) opponent).manaRestore(); }
                                System.out.println( "Played ability: " + opponent.Abilities()[abilitySelection] );
                            }
                        }

                        // Dwarfs
                        else if( opponent.race == 2 ) {
                            if( opponent.classs == 0 ) {// Fighter (5 ability)
                                abilitySelection = random.nextInt(5);
                                if( abilitySelection == 1 ) { opponent.attack(player); }
                                else if( abilitySelection == 2 ) { opponent.defend(); }
                                else if( abilitySelection == 3 ) { ((Dwarfs)opponent).slash(player); }
                                else if( abilitySelection == 4 ) { ((Dwarfs)opponent).brust(player); }   
                                else { ((Dwarfs) opponent).rest(); }
                                System.out.println( "Played ability: " + opponent.Abilities()[abilitySelection] );
                            }
                            else {// Mage (6 Ability)
                                abilitySelection = random.nextInt(6);
                                if( abilitySelection == 1 ) { opponent.attack(player); }
                                else if( abilitySelection == 2 ) { opponent.defend(); }
                                else if( abilitySelection == 3 ) { ((Dwarfs)opponent).fire(player); }
                                else if( abilitySelection == 4 ) { ((Dwarfs)opponent).thunder(player); }   
                                else if( abilitySelection == 5 ) { ((Dwarfs)opponent).blizzard(player); }   
                                else { ((Dwarfs) opponent).rest(); }
                                System.out.println( "Played ability: " + opponent.Abilities()[abilitySelection] );
                            }
                        }

                        // Halflings
                        else {
                            if( opponent.classs == 0 ) {// Fighter (6 ability)
                                abilitySelection = random.nextInt(6);
                                if( abilitySelection == 1 ) { 
                                    opponent.attack(player); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                }
                                else if( abilitySelection == 2 ) { 
                                    opponent.defend();
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] ); 
                                }
                                else if( abilitySelection == 3 ) { 
                                    ((Halflings)opponent).slash(player); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                }
                                else if( abilitySelection == 4 ) { 
                                    ((Halflings)opponent).brust(player); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                }   
                                else if( abilitySelection == 5 ) { 
                                    ((Halflings) opponent).secondBreakfast(); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                }
                                else { 
                                    System.out.print( Arrays.toString(player.Abilities()) );
                                    int ability = takeInput.nextInt();
                                    System.out.print( "The played ability: " + player.Abilities()[ability] );
                                    ((Halflings) opponent).mimic(player, ability); 
                                }
                            }
                            else {// Rogue (6 Ability)
                                abilitySelection = random.nextInt(6);
                                if( abilitySelection == 1 ) { 
                                    opponent.attack(player); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                }
                                else if( abilitySelection == 2 ) { 
                                    opponent.defend(); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                }
                                else if( abilitySelection == 3 ) { 
                                    ((Halflings)opponent).quickAttack(player); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                }
                                else if( abilitySelection == 4 ) { 
                                    ((Halflings)opponent).shootArrows(player); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                }  
                                else if( abilitySelection == 5 ) { 
                                    ((Halflings) opponent).secondBreakfast(); 
                                    System.out.print( "The played ability: " + opponent.Abilities()[abilitySelection] );
                                } 
                                else { 
                                    System.out.print( Arrays.toString(player.Abilities()) );
                                    int ability = takeInput.nextInt();
                                    System.out.print( "The played ability: " + player.Abilities()[ability] );
                                    ((Halflings) opponent).mimic(player, ability);
                                }
                            }
                        }
                        opponent.updateLevel();
                    }
                    // next players turn
                    System.out.println( "\n\nCurrent states:\nPlayer" + player.toString() + 
                                        "\n\nOpponent" + opponent.toString() + "\n" );
                }

                //one is defeated
                if( opponent.currentHP < 1 ) { 
                    System.out.println("\n\n---|You won!!! Your next enemy will be " +
                                        "created for your next battle.|---\n\nEnter 0 if you want to keep playing, -1 if you want to quit!"); 
                    int i = takeInput.nextInt();
                    if( i == -1 ) { playTheGame = false; break; }
                    System.out.print( "Would you like to change your class? Enter Y if yes, N if no--> " );
                    String answeer = takeInput.next();
                    if( answeer.equalsIgnoreCase("y") ) {
                        if( player.race == 0 ) {// Humans
                            if( player.classs == 0 ) {
                                System.out.print( "\nWhich one will you be? 2-Rogue 3-Mage--> " );
                                int switchClass = takeInput.nextInt();
                                player = (character) player.clone(switchClass-1);
                            }
                            else if( player.classs == 1 ) {
                                System.out.print( "\nWhich one will you be? 1-Fighter 3-Mage--> " );
                                int switchClass = takeInput.nextInt();
                                player = (character) player.clone(switchClass-1);
                            }
                            else if( player.classs == 2 ) {
                                System.out.print( "\nWhich one will you be? 1-Fighter 2-Rogue--> " );
                                int switchClass = takeInput.nextInt();
                                player = (character) player.clone(switchClass-1);
                            }
                        }
                        else if( player.race == 1 ) {// Elves
                            if( player.classs == 1 ) { player = (character)player.clone(2); }
                            else if( player.classs == 2 ) { player = (character)player.clone(1); }
                        }
                        else if( player.race == 2 ) {// Dwrafs
                            if( player.classs == 2 ) { player = (character)player.clone(0); }
                            else if( player.classs == 0 ) { player = (character)player.clone(2); }
                        }
                        if( player.race == 3 ) {// Halflings
                            if( player.classs == 1 ) { player = (character)player.clone(0); }
                            else if( player.classs == 0 ) { player = (character)player.clone(1); }
                        }
                    }
                }
                else { 
                    System.out.println("\n\n---|You have lost! Maybe next time...|---\n");
                    playTheGame = false;
                }
            }
            playTheGame = false;
        }
        System.out.println( "The Battle ended!\n\n" );
        // close the Scanner
        takeInput.close();
    }
}// end of the class
