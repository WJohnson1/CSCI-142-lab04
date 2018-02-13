package heroes;

import game.Team;
import heroes.Heroes.Role;

public class Healer extends Hero{
    private static final int DAMAGE_AMOUNT = 10;
    private static final int HEAL_AMOUNT = 10;
    private static final int HEALER_HIT_POINTS = 35;
    public Healer(Team team) {
        super(Heroes.getName(team,Role.HEALER),HEALER_HIT_POINTS);
    }
    public Heroes.Role getRole(){
        return Role.HEALER;
    }
    @Override
    public void attack(Hero h){
        //this.heal(HEAL_AMOUNT);
        for (Hero q: this.getParty().getHeroes()){
            q.heal(HEAL_AMOUNT);
        }
        h.takeDamage(DAMAGE_AMOUNT);
    }
}
