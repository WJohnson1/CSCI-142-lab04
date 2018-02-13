package heroes;
import game.Team;
import heroes.Heroes.Role;
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

    public void attack(Hero h){
        h.takeDamage(this.max_dmg);
    }
    public String getName(){
        return this.name;
    }
    public void heal(int health){
        this.health= this.health+health;
        if (this.health>this.max_health){
            this.health = this.max_health;
        }
        System.out.println(this.getName() + " heals " + health + " points");

    }
    public void takeDamage(int damage){
        this.health = this.health - damage;
        System.out.println(this.getName() + " takes " + damage + " damage");
        if (this.health<0){
            this.health = 0;
        }
    }
    public boolean hasFallen(){
        if (this.health<=0){
            System.out.println(this.getName() + " has fallen!");
            return true;
        }
        else{
            return false;
        }
    }

    public int getMax_health(){
        return this.max_health;
    }
    @Override
    public String toString(){
        return this.getName() +", " + this.getRole() + ", " + this.gethealth() + "/" + this.getMax_health();
    }
    public int gethealth() {
        return this.health;
    }

    public Party getParty() {
        return party;
    }
}
