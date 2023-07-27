/*
 * Course: CS-102
 * Semester: Fall 2022
 * Assignment: Lab03
 * Author: Sumeyye Acar
 * Id: 22103640
*/

// in order to use the ArrayLists;
import java.util.ArrayList;

// The Interfaces (Classes)
interface Fighter {
    boolean slash(character chr);
    boolean brust(character chr);
}
interface Rogue {
    boolean quickAttack(character chr);
    boolean shootArrows(character chr);
}
interface Mage {
    boolean fire(character chr);
    boolean thunder(character chr);
    boolean blizzard(character chr);
}

// The character
class character {
    // Attributes
    int level;
    int race;
    int classs;
    double HP;
    double MP;
    double speed;
    double baseMagic;
    double baseAttack;
    double currentHP;
    double currentMP;

    public character( int race, int classs ) {
        level = 1;
        this.race = race;
        this.classs = classs;
        setHP(); 
        setCurrentHP(); 
        setMP();
        setCurrentMP();
        setSpeed();
        setBaseAttack();
        setBaseMAgic();
    }

    public boolean updateLevel() {
        level+=1; 
        setHP();
        setMP();
        setBaseAttack();
        setBaseMAgic();
        setSpeed();
        return true; 
    }

    public void setLevel(int i) {
        level = i;
    }

    public void setHP() {
        if( race == 0 ) {
            this.HP = 35 +(3*level);
        }
        else if( race == 2 ) {
            this.HP = level + 40;
        }
        else{ this.HP = 20 + (4*level); }
    }

    public void setCurrentHP() {
        this.currentHP = HP;
    }

    public void setCurrentHP(double i) {
        currentHP = i;
    }

    public void setMP() {
        if( race == 1 ) {
            this.MP = this.HP -10;
        }
        else if( race == 2 ) {
            this.MP = level + 10;
        }
        else{ this.MP =((double) HP / 2.0); }
    }

    public void setCurrentMP() {
        this.currentMP = MP;
    }

    public void setCurrentMP(double i) {
        currentMP = i;
    }

    public void setSpeed() {
        if( race == 1 ) {
            this.speed = level + 4;
        }
        else if( race == 2 ) {
            this.speed = ((double)level/2.0) + 1;
        }
        else{ this.speed = level; }
    }
    
    public void setBaseMAgic() {
        this.baseMagic =((double) MP / 5.0) + 2;
    }

    public void setBaseMAgic(double i) {
        baseMagic = i;
    }
    
    public void setBaseAttack() {
        this.baseAttack =((double) HP / 10.0) + 1;
    }

    public void setBaseAttack(double i) {
        baseAttack = i;
    }

    public String getRace() {
        String[] races = new String[4];
        races[0] = "Human";
        races[1] = "Elves";
        races[2] = "Dwarfs";
        races[3] = "Halflings";
        return races[ this.race ];
    }

    public String getClasss() {
        String[] classes = new String[3];
        classes[0] = "Fighter";
        classes[1] = "Rogue";
        classes[2] = "Mage";
        return classes[ this.classs ];
    }

    public void updateCurrentHp( double i ) {
        currentHP += i;
    }

    public void updateCurrentMp( double i ) {
        currentMP += i;
    }

    public String[] Abilities() {
        ArrayList<String> fighter = new ArrayList<>();
        fighter.add("Slash");
        fighter.add("Brust");
        ArrayList<String> rogue = new ArrayList<>();
        rogue.add( "Quick Attack");
        rogue.add( "Shoot Arrows");
        ArrayList<String> mage = new ArrayList<>();
        mage.add("Fire");
        mage.add("Thunder");
        mage.add("Blizzer");
        ArrayList<String> commonAbilities = new ArrayList<>();
        commonAbilities.add("Attack");
        commonAbilities.add("Defend");

        // Human
        if( race == 0 ) {
            if( classs == 0 ) {
                String[] abilities = new String[5];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 2; j++ ) {
                    abilities[j+2] = j+3+"-"+fighter.get(j);
                }
                abilities[4] = "5-Struggle";
                return abilities;
            }
            else if( classs == 1 ) {
                String[] abilities = new String[5];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 2; j++ ) {
                    abilities[j+2] = j+3+"-"+rogue.get(j);
                }
                abilities[4] = "5-Struggle";
                return abilities;
            }
            else {
                String[] abilities = new String[6];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 3; j++ ) {
                    abilities[j+2] = j+3+"-"+mage.get(j);
                }
                abilities[5] = "6-Struggle";
                return abilities;
            }
        }

        // Elves
        else if( race == 1 ) {
            if( classs == 1 ) {
                String[] abilities = new String[5];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 2; j++ ) {
                    abilities[j+2] = j+3+"-"+rogue.get(j);
                }
                abilities[4] = "5-Mana Restore";
                return abilities;
            }
            else {
                String[] abilities = new String[6];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 3; j++ ) {
                    abilities[j+2] = j+3+"-"+mage.get(j);
                }
                abilities[5] = "6-Mana Restore";
                return abilities;
            }
        }

        // Dwarfs
        else if( race == 2 ) {
            if( classs == 0 ) {
                String[] abilities = new String[5];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 2; j++ ) {
                    abilities[j+2] = j+3+"-"+fighter.get(j);
                }
                abilities[4] = "5-Rest";
                return abilities;
            }
            else {
                String[] abilities = new String[6];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 3; j++ ) {
                    abilities[j+2] = j+3+"-"+mage.get(j);
                }
                abilities[5] = "6-Rest";
                return abilities;
            }
        }

        // Halflings
        else {
            if( classs == 0 ) {
                String[] abilities = new String[6];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 2; j++ ) {
                    abilities[j+2] = j+3+"-"+fighter.get(j);
                }
                abilities[4] = "5-Second Breakfast";
                abilities[5] = "6-Mimic";
                return abilities;
            }
            else {
                String[] abilities = new String[6];
                for( int i = 0; i < 2; i++ ) {
                    abilities[i] = i+1+"-"+commonAbilities.get(i);
                }
                for( int j = 0; j < 2; j++ ) {
                    abilities[j+2] = j+3+"-"+rogue.get(j);
                }
                abilities[4] = "5-Second Breakfast";
                abilities[5] = "6-Mimic";
                return abilities;
            }
        }
    }

    // Attack Ability
    public void attack(character chr) {
        if( classs == 2 ) { 
            chr.updateCurrentHp((-1.0)*((double)baseMagic)); 
        }
        else { 
            chr.updateCurrentHp((-1.0)*((double)baseAttack)); 
        }
    }

    // Defend Ability
    public void defend() {
        updateCurrentHp( ((double)HP)/10.0 );
    }
    
    // toString()
    @Override
    public String toString() {
        String character = "\nRace: " + getRace() + "   Class: " + getClasss() + "   Level: " + level +
                           "\nCurrent HP: " + currentHP + "   Current MP: " + currentMP + 
                           "\nBase Magic: " + baseMagic + "   Base Attack: " + baseAttack;
        return character;
    }

    protected Object clone( int classss) {
        character myClone = new character(race, classss);
        myClone.setBaseAttack(baseAttack);
        myClone.setBaseMAgic(baseMagic);
        myClone.setCurrentHP(currentHP);
        myClone.setCurrentMP(currentMP);
        myClone.setLevel(level);
        return myClone;
    }

}