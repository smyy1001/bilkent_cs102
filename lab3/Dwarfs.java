/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab03
 * Author: Sumeyye Acar
 * Id: 22103640
*/

public class Dwarfs extends character implements Fighter, Mage{

    public Dwarfs(int race, int classs) {
        super(race, classs);
    }

    public void rest() {
        updateCurrentHp(20.0);
        updateCurrentMp((-1.0)*7.0);
    }

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
        else {
            System.out.println( "This ability can't be used!" );
        }
        return true;
    }
    
}