package heroes;

import game.Team;
import heroes.Heroes.Role;

/**
 * @author William Johnson
 * The class that creates a Healer that and extends the Hero class
 */
public class Healer extends Hero{
    private static final int DAMAGE_AMOUNT = 10;
    private static final int HEAL_AMOUNT = 10;
    private static final int HEALER_HIT_POINTS = 35;

    /**
     * Creates a Healer that belongs to a certain team
     * @param team
     */
    public Healer(Team team) {
        super(Heroes.getName(team,Role.HEALER),HEALER_HIT_POINTS);
    }

    /**
     * Returns the role of the Healer
     * @return the role of the Healer
     */
    public Heroes.Role getRole(){
        return Role.HEALER;
    }

    /**
     * The healer heals itself before healing the rest of the members of it's party. Then the healer inflicts damage on
     * another Hero
     * @param h the hero that the healer attacks
     */
    @Override
    public void attack(Hero h){
        this.heal(HEAL_AMOUNT);
        for (Hero q: this.getParty().getHeroes()){
            q.heal(HEAL_AMOUNT);
        }
        h.takeDamage(DAMAGE_AMOUNT);
    }
}
