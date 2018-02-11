package heroes;

import game.Team;
import heroes.Heroes.Role;

public class Healer extends Hero{
    protected static final int DAMAGE_AMOUNT = 10;
    protected static final int HEAL_AMOUNT = 10;
    protected static final int HEALER_HIT_POINTS = 35;
    private static Team team;
    protected Healer(Team team) {
        super(Heroes.getName(team,Role.HEALER),HEALER_HIT_POINTS);
        this.team = team;
    }
    public Heroes.Role getRole(){
        return Role.HEALER;
    }
    public void attack(Hero h){
        this.heal(HEAL_AMOUNT);

        h.takeDamage(this.DAMAGE_AMOUNT);
    }

    @Override
    public String getName() {
        return super.getName();
    }
    public void attack(){

    }
}
