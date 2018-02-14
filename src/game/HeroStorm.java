package game;

import heroes.Hero;

/**
 * @author William Johnson
 * Main class that will run the HeroStorm game
 */
public class HeroStorm {
    private HeroParty d;
    private HeroParty l;
    private int count;

    /**
     * Creates the party for the dragon and the party for the lion
     * @param dragonSeed the seed value for the DragonParty
     * @param lionSeed the seed value for the LionParty
     */
    public HeroStorm(int dragonSeed, int lionSeed){
        this.d = new HeroParty(Team.DRAGON, dragonSeed);
        this.l = new HeroParty(Team.LION, lionSeed);
        this.count = 1;

    }

    /**
     * Runs the simulation of the game
     */
    public void play(){
        boolean a = true;
        while (this.d.getHeroes().size() > 0 && this.l.getHeroes().size() > 0) {
            System.out.println("Battle #" + this.count);
            System.out.println("==========");
            System.out.println(this.d.toString() + ":");
            for (int i = 0; i < this.d.getHeroes().size(); i++) {
                System.out.println(this.d.getHeroes().get(i).toString());
            }
            System.out.println();
            System.out.println(this.l.toString() + ":");
            for (int i = 0; i < this.l.getHeroes().size(); i++) {
                System.out.println(this.l.getHeroes().get(i).toString());
            }
            System.out.println();
            if (a) {
                System.out.println("*** " + this.d.getHeroes().get(0).getName() + " vs " + this.l.getHeroes().get(0).getName() + "!\n");
                Hero d_hero = this.d.getHeroes().get(0);
                Hero l_hero = this.l.getHeroes().get(0);
                this.d.removeHero();
                this.l.removeHero();
                d_hero.attack(l_hero);
                if (l_hero.hasFallen() == false){
                    l_hero.attack(d_hero);
                    this.l.addHero(l_hero);
                }
                if (d_hero.hasFallen() == false){
                    this.d.addHero(d_hero);
                }
                a = false;
            }
            else{
                System.out.println("*** " + this.l.getHeroes().get(0).getName() + " vs " + this.d.getHeroes().get(0).getName() + "!\n");
                Hero d_hero = this.d.getHeroes().get(0);
                Hero l_hero = this.l.getHeroes().get(0);
                this.d.removeHero();
                this.l.removeHero();
                l_hero.attack(d_hero);
                if (d_hero.hasFallen() == false){
                    d_hero.attack(l_hero);
                    this.d.addHero(d_hero);
                }
                if (l_hero.hasFallen() == false){
                    l.addHero(l_hero);
                }
                a = true;
            }
            this.count++;
            System.out.println();
        }
        if (this.d.getHeroes().size() == 0){
            System.out.println("Team Lion wins!");
        }
        else {
            System.out.println("Team Dragon wins!");
        }
    }

    /**
     * Main method. Creates the HeroStorm and runs the simulation
     * @param args Array of command line arguments.
     */
    public static void main(String[] args){
        if (args.length == 2) {
            HeroStorm game = new HeroStorm(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            game.play();
        }
        else{
            System.out.println("Invalid number of arguments");
        }
    }
}
