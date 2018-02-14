package heroes;

import game.Team;
import heroes.Heroes.Role;

/**
 * @author William Johnson
 * The class that creates a Berserker that and extends the Hero class
 */
public class Berserker extends Hero{
    private static final int BERSERKER_HIT_POINTS = 30;
    private static final int DAMAGE_AMOUNT = 20;

    /**
     * Creates a Berserker for a certain team
     * @param team the team that the Berserker will belong to
     */
    public Berserker(Team team) {
        super(Heroes.getName(team, Role.BERSERKER),BERSERKER_HIT_POINTS);

    }

    /**
     * Returns the role of the Berserker
     * @return the role of the Berserker
     */
    public Role getRole(){
        return Role.BERSERKER;
    }

    /**
     * A hero is attacked and takes damage
     * @param h the hero that will take damage
     */
    @Override
    public void attack(Hero h){
        h.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * Creates a string representation for the Berserker
     * @return a string representation for the Berserker
     */
    @Override
    public String getName() {
        return super.getName();
    }
}
