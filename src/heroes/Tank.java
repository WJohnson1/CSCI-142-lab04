package heroes;

import game.Team;

public class Tank extends Hero{
    protected static final int DAMAGE_AMOUNT = 15;
    protected static final double SHIELD_DMG_MULTIPLIER = 0.9;
    protected static final int TANK_HIT_POINTS = 40;
    public Tank(Team team) {
        super(Heroes.getName(team, Heroes.Role.TANK),TANK_HIT_POINTS);
    }
    public Heroes.Role getRole(){
        return Heroes.Role.TANK;
    }
    public void attack(Hero h){
        h.takeDamage(this.DAMAGE_AMOUNT);
    }
    @Override
    public void takeDamage(int i){
        super.takeDamage((int)(i*SHIELD_DMG_MULTIPLIER));
    }

}
