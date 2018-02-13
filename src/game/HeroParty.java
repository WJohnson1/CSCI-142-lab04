package game;

import heroes.*;

import java.util.ArrayList;
import java.util.List;

public class HeroParty extends Object implements heroes.Party{
    private List<Hero> heroes;
    private Team team;
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


    @Override
    public void addHero(Hero hero) {
        this.getHeroes().add(hero);
    }

    @Override
    public Hero removeHero() {
        Hero h = this.heroes.get(0);
        this.heroes.remove(0);
        return h;
    }

    @Override
    public int numHeroes() {
        return this.heroes.size();
    }

    @Override
    public Team getTeam() {
        return this.team;
    }

    @Override
    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public String toString(){
        if (this.team == team.DRAGON){
            return "DRAGON";
        }
        else {
            return "LION";
        }
    }
}
