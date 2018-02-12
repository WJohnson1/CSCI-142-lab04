package game;

import heroes.Hero;
import heroes.Heroes;

import java.util.ArrayList;
import java.util.List;

public class HeroParty extends Object implements heroes.Party{
    private List<Hero> heroes;
    private Team team;
    public HeroParty(Team team, int seed){
        this.heroes = new ArrayList<Hero>();
        this.team = team;
        if (seed == 0) {
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.TANK),40));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.HEALER), 35));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.BERSERKER), 30));
        }
        else if(seed == 1){
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.HEALER), 35));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.TANK),40));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.BERSERKER), 30));
        }
        else if(seed == 2){
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.TANK),40));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.BERSERKER), 30));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.HEALER), 35));
        }
        else if(seed == 3){
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.BERSERKER), 30));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.HEALER), 35));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.TANK),40));
        }
        else if(seed == 5){
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.HEALER), 35));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.BERSERKER), 30));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.TANK),40));
        }
        else if(seed == 7){
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.BERSERKER), 30));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.TANK),40));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.HEALER), 35));
        }
        else {
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.TANK),40));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.HEALER), 35));
            this.addHero(new Hero(Heroes.getName(team, Heroes.Role.BERSERKER), 30));
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
