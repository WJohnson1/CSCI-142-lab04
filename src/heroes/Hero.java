package heroes;
import game.Team;
import heroes.Heroes.Role;

/**
 *@author William Johnson
 * The abstract class that will create a Hero
 */
public abstract class Hero{
    private String name;
    private int health;
    private int max_health;
    private Party party;
    private Team team;
    private int max_dmg;
    public Hero(String name, int max_health){
        this.name = name;
        this.health = max_health;
        this.max_health = max_health;
    }

    /**
     * Creates a Hero with a certain role, that belongs to a certain team, and a certain party. This hero will be
     * returned
     * @param r the role of the Hero
     * @param t the team of the Hero
     * @param p the party of the Hero
     * @return the Hero that was created
     */
    public static Hero create(Role r, Team t, Party p){
        Hero h;
        if (r == Role.BERSERKER){
            h = new Berserker(t);
            h.max_dmg = 20;
        }
        else if (r == Role.HEALER){
            h = new Healer(t);
            h.max_dmg = 10;
        }
        else{
            h = new Tank(t);
            h.max_dmg = 15;
        }
        h.party = p;
        h.team = t;
        return h;
    }

    /**
     * Returns the role of the Hero
     * @return the role of the Hero
     */
    public Role getRole(){
        if (this.name.equals("Simba") || this.name.equals("Trogdor")){
            return Role.BERSERKER;
        }
        else if(this.name.equals("Spyro") || this.name.equals("Elsa")){
            return Role.HEALER;
        }
        else{
            return Role.TANK;
        }
    }

    /**
     * The hero attacks another hero
     * @param h the hero that will be attacked
     */
    public void attack(Hero h){
        h.takeDamage(this.max_dmg);
    }

    /**
     * Returns the name of the Hero
     * @return the name of the Hero
     */
    public String getName(){
        return this.name;
    }

    /**
     * Heals the Hero
     * @param health the amount that the Hero will heal
     */
    public void heal(int health){
        this.health= this.health+health;
        if (this.health>this.max_health){
            this.health = this.max_health;
        }
        System.out.println(this.getName() + " heals " + health + " points");

    }

    /**
     * The Hero will take a certain amount of damage
     * @param damage the amount of damage that the Hero takes
     */
    public void takeDamage(int damage){
        this.health = this.health - damage;
        System.out.println(this.getName() + " takes " + damage + " damage");
        if (this.health<0){
            this.health = 0;
        }
    }

    /**
     * Returns false if the Hero is alive and true if the Hero is not alive
     * @return true or false
     */
    public boolean hasFallen(){
        if (this.health<=0){
            System.out.println(this.getName() + " has fallen!");
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns the maximum health of the Hero
     * @return the maximum health
     */
    public int getMax_health(){
        return this.max_health;
    }

    /**
     * Returns the string representation of the Hero
     * @return the string representation of the Hero
     */
    @Override
    public String toString(){
        return this.getName() +", " + this.getRole() + ", " + this.gethealth() + "/" + this.getMax_health();
    }

    /**
     * Returns the health of the Hero
     * @return the health of the Hero
     */
    public int gethealth() {
        return this.health;
    }

    /**
     * Returns the party of the Hero
     * @return the party of the Hero
     */
    public Party getParty() {
        return party;
    }
}
