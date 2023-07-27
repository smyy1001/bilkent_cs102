/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab03
 * Author: Sumeyye Acar
 * Id: 22103640
*/

public class Halflings extends character implements Fighter, Rogue, Mage {

    public Halflings(int race,int classs) {
        super(race,classs);
    }

    public void secondBreakfast() {
        updateCurrentHp(5);
        updateCurrentMp(5);
    }

    public void mimic(character chr, int ability) {

        // Human
        if(chr.race == 0) {

            // Fighter
            if( chr.classs == 0 ) {
                if( ability == 0 ) {// Attack
                    attack(chr);
                }
                if( ability == 1 ) {// Defend
                    defend();
                }
                if( ability == 2 ) {// Slash
                    slash(chr);
                }
                if( ability == 3 ) {// Brust
                    brust(chr);
                }
                if( ability == 4 ) {// Struggle
                    if( currentHP > 10 ) {
                        chr.updateCurrentHp( -((0.25) * HP) );
                        updateCurrentHp(-10);
                    }
                }
            } 

            // Rogue
            else if(chr.classs == 1) {
                if( ability == 0 ) {// Attack
                    attack(chr);;
                }
                if( ability == 1 ) {// Defend
                    defend();                }
                if( ability == 2 ) {// Quick Attack
                    quickAttack(chr);
                }
                if( ability == 3 ) {// Shoot Arrows
                    shootArrows(chr);
                }
                if( ability == 4 ) {// Struggle
                    if( currentHP > 10 ) {
                        chr.updateCurrentHp( -((0.25) * HP) );
                        updateCurrentHp(-10);
                    }
                }
            }

            // Mage
            else {
                if( ability == 0 ) {// Attack
                    attack(chr);
                }
                if( ability == 1 ) {// Defend
                    defend();                }
                if( ability == 2 ) {// Fire
                    fire(chr);
                }
                if( ability == 3 ) {// Thunder
                    thunder(chr);
                }
                if( ability == 4 ) {// Blizzer
                    blizzard(chr);
                }
                if( ability == 5 ) {// Struggle
                    if( currentHP > 10 ) {
                        chr.updateCurrentHp( -((0.25) * HP) );
                        updateCurrentHp(-10);
                    }
                }
            }
        }


        // Elves
        else if( chr.race == 1 ) {

            // Rogue
            if( chr.classs == 1 ) {
                if( ability == 0 ){// Attack
                    attack(chr);
                }
                else if( ability == 1 ){// Defend
                    defend();                }
                else if( ability == 2 ){// Quick Attack
                    quickAttack(chr);
                }
                else if( ability == 3 ){// Shoot Arrows
                    shootArrows(chr);
                }
                else if( ability == 4 ){// Mana Restore
                    updateCurrentMp(level*2);
                    updateCurrentHp(-2);
                }
            }

            // Mage
            else {
                if( ability == 0 ){// Attack
                    attack(chr);
                }
                else if( ability == 1 ){// Defend
                    defend();
                }
                else if( ability == 2 ){// Fire 
                    fire(chr);
                }
                else if( ability == 3 ){// Thunder
                    thunder(chr);
                }
                else if( ability == 4 ){// Blizzer
                    blizzard(chr);
                }
                else if( ability == 5 ){// Mana Restore
                    updateCurrentMp(level*2);
                    updateCurrentHp(-2);
                }
            }
        }


        // Dwarfs
        else if( chr.race == 2 ) {

            // Fighter
            if(chr.classs == 0) {
                if( ability == 0 ){// Attack
                    attack(chr);
                }
                else if( ability == 1 ){// Defend
                    defend();
                }
                else if( ability == 2 ){// Slash
                    slash(chr);
                }
                else if( ability == 3 ){// Brust
                    brust(chr);
                }
                else if( ability == 4 ){// Rest
                    updateCurrentHp(20);
                    updateCurrentMp(-7);
                }
            }

            // Mage
            else {
                if( ability == 0 ){// Attack
                    attack(chr);
                }
                else if( ability == 1 ){// Defend
                    defend();
                }
                else if( ability == 2 ){// Fire
                    fire(chr);
                }
                else if( ability == 3 ){// Thunder
                    thunder(chr);
                }
                else if( ability == 4 ){// Blizzer
                    blizzard(chr);
                }
                else if( ability == 5 ){// Rest
                    updateCurrentHp(20);
                    updateCurrentMp(-7);
                }
            }
        }


        // Halflings
        else {

            // Fighter
            if( chr.classs == 0 ) {
                if( ability == 0 ){// Attack
                    attack(chr);                }
                else if( ability == 1 ){// Defend
                    defend();
                }
                else if( ability == 2 ){// Slash
                    slash(chr);
                }
                else if( ability == 3 ){// Brust
                    brust(chr);
                }
                else if( ability == 4 ){// Second Breakfast
                    updateCurrentHp(5);
                    updateCurrentMp(5);
                }
            }

            // Rogue
            else {
                if( ability == 0 ){// Attack
                    attack(chr);                }
                else if( ability == 1 ){// Defend
                    defend();
                }
                else if( ability == 2 ){// Quick Attack
                    quickAttack(chr);
                }
                else if( ability == 3 ){// Shoot Arrows
                    shootArrows(chr);
                }
                else if( ability == 4 ){// Second Breakfast
                    updateCurrentHp(5);
                    updateCurrentMp(5);
                }
            }
        }

    }// end of the method mimic

    // FIGHTER Methods
    @Override 
    public boolean slash(character chr) {
        if( MP > 5 ) {
            chr.updateCurrentHp((-1.0)*(baseAttack*2.0));
            updateCurrentMp((-1.0)*5.0);
        }
        else {
            System.out.println( "This ability can't be used!" );
        }
        return true;
    }
    @Override
    public boolean brust(character chr) {
        chr.updateCurrentHp((-1.0)*(currentMP*3.0));
        updateCurrentMp((-1.0)*currentMP);
        return true;
    }

    // ROGUE Methods
    @Override 
    public boolean quickAttack(character chr) {
        if( classs == 1 ) {
            if( chr.classs == 1 ) {
                if( chr.speed > speed ) { updateCurrentHp((-1.0)*chr.baseAttack); }
                else { chr.updateCurrentHp((-1.0)*baseAttack); }
            }
            chr.updateCurrentHp((-1.0)*baseAttack);
            updateCurrentMp(-2.0);
            return true;
        }
        else{ return false; }
    }
    @Override
    public boolean shootArrows(character chr) {
        chr.updateCurrentHp((-1.0)*(2.0+baseAttack+(double)speed));
        if( chr.currentHP > 0 ) { updateCurrentHp(-3.0); }
        return true;
    }

    // MAGE Methods
    @Override 
    public boolean fire( character chr ) {
        if( currentHP > 3 || MP >= 2) {
            double maxSpeed;
            if( chr.speed > speed ) { maxSpeed = chr.speed; }
            else { maxSpeed = speed; }
            chr.updateCurrentHp((-1.0)*(maxSpeed*3.0) );
            if( MP >= 2 ) { updateCurrentMp(-2.0); }
            else if( MP<2 && chr.currentHP > 0 ) { updateCurrentHp(-3.0); }
        }
        else {
            System.out.println( "This ability can't be used!" );
        }
        return true;
    }
    @Override
    public boolean thunder(character chr) {
        chr.updateCurrentHp((-1.0)*(baseMagic*2.0));
        updateCurrentMp((-1.0)*8.0);
        return true;
    }
    @Override
    public boolean blizzard(character chr) {
        chr.updateCurrentHp(-12.0);
        updateCurrentMp(-12.0);
        if( currentMP < 0 ) {
            updateCurrentHp(currentMP);
            updateCurrentMp((-1.0)*(currentMP));
        }
        return true;
    }

}// end of the class