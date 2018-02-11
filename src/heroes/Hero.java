package heroes;
import game.Team;
import heroes.Heroes.Role;
public class Hero{
    private String name;
    private int health;
    private int max_health;
    public Hero(String name, int max_health){
        this.name = name;
        this.health = max_health;
        this.max_health = max_health;
    }
    public static Hero create(Role r, Team t, Party p){
        int health = 0;
        if (r == Role.BERSERKER){
            health = Berserker.BERSERKER_HIT_POINTS;
        }
        else if (r == Role.HEALER){
            health = Healer.HEALER_HIT_POINTS;
        }
        else{
            health = Tank.TANK_HIT_POINTS;
        }
        Hero h = new Hero(Heroes.getName(t,r),health);
        p.addHero(h);
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
        if (this.getRole() == Role.BERSERKER) {
            h.takeDamage(Berserker.DAMAGE_AMOUNT);
        }
        else if (this.getRole() == Role.HEALER) {
            h.takeDamage(Healer.DAMAGE_AMOUNT);
        }
        else {
            h.takeDamage(Tank.DAMAGE_AMOUNT);
        }
    }
    public String getName(){
        return this.name;
    }
    public void heal(int health){
        this.health= this.health+health;
        if (this.getRole() == Role.BERSERKER){
            if (this.health>Berserker.BERSERKER_HIT_POINTS){
                this.health = Berserker.BERSERKER_HIT_POINTS;
            }
        }
        else if (this.getRole() == Role.HEALER){
            if (this.health>Healer.HEALER_HIT_POINTS){
                this.health = Healer.HEALER_HIT_POINTS;
            }
        }
        else if (this.getRole() == Role.TANK){
            if (this.health>Tank.TANK_HIT_POINTS){
                this.health = Tank.TANK_HIT_POINTS;
            }
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
}
