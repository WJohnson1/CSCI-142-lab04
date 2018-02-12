package heroes;

import game.HeroParty;
import game.Team;
import heroes.Heroes.Role;

public class Healer extends Hero{
    protected static final int DAMAGE_AMOUNT = 10;
    protected static final int HEAL_AMOUNT = 10;
    protected static final int HEALER_HIT_POINTS = 35;
    private static Team team;
    private static Party party;
    protected Healer(Team team, Party p) {
        super(Heroes.getName(team,Role.HEALER),HEALER_HIT_POINTS);
        this.team = team;
        this.party = p;
    }
    public Heroes.Role getRole(){
        return Role.HEALER;
    }
    @Override
    public void attack(Hero h){
        for (int i = 0; i<this.party.getHeroes().size();i++){
            this.party.getHeroes().get(i).heal(HEAL_AMOUNT);
        }
        h.takeDamage(DAMAGE_AMOUNT);
    }
}
