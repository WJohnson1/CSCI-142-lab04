package heroes;
import game.Team;
import heroes.Heroes.Role;
public class Hero{
    private String name;
    private int health;
    public Hero(String name, int max_health){
        this.name = name;
        this.health = max_health;
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
        else if(this.name.equals("Spyro") || this.name.equals("Else")){
            return Role.HEALER;
        }
        else{
            return Role.TANK;
        }
    }
    public void attack(Hero h){
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

    }
    public void takeDamage(int damage){

    }
    public boolean hasFallen(){
        if (this.health<=0){
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public String toString(){
        return "";
    }
    public int gethealth() {
        return this.health;
    }
}
