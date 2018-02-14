package game;

import heroes.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author William Johnson
 * Class that creates a Hero Party
 */
public class HeroParty extends Object implements heroes.Party{
    private List<Hero> heroes;
    private Team team;

    /**
     * Creates the party that three heroes will be a part of.
     * @param team the team that the Hero Party will belong to
     * @param seed the int value that defines the orientation of the heroes in the list of heroes
     */
    public HeroParty(Team team, int seed){
        this.heroes = new ArrayList<Hero>();
        this.team = team;
        if (seed == 0) {
            this.addHero(Hero.create(Heroes.Role.TANK,team,this));
            this.addHero(Hero.create(Heroes.Role.HEALER,team,this));
            this.addHero(Hero.create(Heroes.Role.BERSERKER,team,this));
        }
        else if(seed == 1){
            this.addHero(Hero.create(Heroes.Role.HEALER,team,this));
            this.addHero(Hero.create(Heroes.Role.TANK,team,this));
            this.addHero(Hero.create(Heroes.Role.BERSERKER,team,this));
        }
        else if(seed == 2){
            this.addHero(Hero.create(Heroes.Role.TANK,team,this));
            this.addHero(Hero.create(Heroes.Role.BERSERKER,team,this));
            this.addHero(Hero.create(Heroes.Role.HEALER,team,this));
        }
        else if(seed == 3){
            this.addHero(Hero.create(Heroes.Role.BERSERKER,team,this));
            this.addHero(Hero.create(Heroes.Role.HEALER,team,this));
            this.addHero(Hero.create(Heroes.Role.TANK,team,this));
        }
        else if(seed == 5){
            this.addHero(Hero.create(Heroes.Role.HEALER,team,this));
            this.addHero(Hero.create(Heroes.Role.BERSERKER,team,this));
            this.addHero(Hero.create(Heroes.Role.TANK,team,this));
        }
        else if(seed == 7){
            this.addHero(Hero.create(Heroes.Role.BERSERKER,team,this));
            this.addHero(Hero.create(Heroes.Role.TANK,team,this));
            this.addHero(Hero.create(Heroes.Role.HEALER,team,this));
        }
        else {
            this.addHero(Hero.create(Heroes.Role.TANK,team,this));
            this.addHero(Hero.create(Heroes.Role.HEALER,team,this));
            this.addHero(Hero.create(Heroes.Role.BERSERKER,team,this));
        }
    }

    /**
     * Adds a hero to the list of heroes
     * @param hero the new hero that will be added to the list of heroes
     */
    @Override
    public void addHero(Hero hero) {
        this.getHeroes().add(hero);
    }

    /**
     * Removes the first hero in the heroes list. The hero that is removed from the list will be returned.
     * @return the hero that is removed from the list of heroes
     */
    @Override
    public Hero removeHero() {
        Hero h = this.heroes.get(0);
        this.heroes.remove(0);
        return h;
    }

    /**
     * The number of heroes in the List of heroes
     * @return the number of heroes in the heroes list
     */
    @Override
    public int numHeroes() {
        return this.heroes.size();
    }

    /**
     * Returns the team of the Hero Party
     * @return the team
     */
    @Override
    public Team getTeam() {
        return this.team;
    }

    /**
     * Returns the list of the heros
     * @return list of the heros
     */
    @Override
    public List<Hero> getHeroes() {
        return this.heroes;
    }

    /**
     * Creates and returns a string representation of the Hero Party
     * @return a string representation of the Hero Party
     */
    public String toString(){
        if (this.team == team.DRAGON){
            return "DRAGON";
        }
        else {
            return "LION";
        }
    }
}
