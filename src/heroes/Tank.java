package heroes;

import game.Team;

/**
 * @author William Johnson
 * The class that creates a Tank that and extends the Hero class
 */
public class Tank extends Hero{
    protected static final int DAMAGE_AMOUNT = 15;
    protected static final double SHIELD_DMG_MULTIPLIER = 0.9;
    protected static final int TANK_HIT_POINTS = 40;

    /**
     * Creates a Tank for a certain team
     * @param team the team that the Tank will belong to
     */
    public Tank(Team team) {
        super(Heroes.getName(team, Heroes.Role.TANK),TANK_HIT_POINTS);
    }

    /**
     * Returns the role of the Tank
     * @return the role of the Tank
     */
    public Heroes.Role getRole(){
        return Heroes.Role.TANK;
    }

    /**
     * The Tank takes only 90 percent of the initial damage given
     * @param i the initial damage for the Tank
     */
    @Override
    public void takeDamage(int i){
        super.takeDamage((int)(i*SHIELD_DMG_MULTIPLIER));
    }

}
