package heroes;

import game.Team;
import heroes.Heroes.Role;

public class Berserker extends Hero{
    protected static final int BERSERKER_HIT_POINTS = 30;
    protected static final int DAMAGE_AMOUNT = 20;
    protected Berserker(Team team) {
        super(Heroes.getName(team, Role.BERSERKER),BERSERKER_HIT_POINTS);
    }
    public Role getRole(){
        return Role.BERSERKER;
    }
    public void attack(Hero h){
        h.takeDamage(this.DAMAGE_AMOUNT);
    }
}
