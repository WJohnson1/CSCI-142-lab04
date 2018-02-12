package game;

import heroes.Hero;

public class HeroStorm {
    public HeroStorm(int dragonSeed, int lionSeed){
        HeroParty d = new HeroParty(Team.DRAGON, dragonSeed);
        HeroParty l = new HeroParty(Team.LION, lionSeed);
        int count = 1;
        boolean a = true;
        while (d.getHeroes().size() > 0 && l.getHeroes().size() > 0) {
            System.out.println(d.getHeroes().size());
            System.out.println(l.getHeroes().size());
            System.out.println("Battle #" + count);
            System.out.println("==========");
            System.out.println(d.toString() + ":");
            for (int i = 0; i < d.getHeroes().size(); i++) {
                System.out.println(d.getHeroes().get(i).toString());
            }
            System.out.println();
            System.out.println(l.toString() + ":");
            for (int i = 0; i < l.getHeroes().size(); i++) {
                System.out.println(l.getHeroes().get(i).toString());
            }
            System.out.println();
            if (a) {
                System.out.println("*** " + d.getHeroes().get(0).getName() + " vs " + l.getHeroes().get(0).getName() + "!");
                d.getHeroes().get(0).attack(l.getHeroes().get(0));
                if (l.getHeroes().get(0).hasFallen() == false){
                    l.getHeroes().get(0).attack(d.getHeroes().get(0));
                    Hero h = l.removeHero();
                    l.addHero(h);
                }
                else {
                    l.removeHero();
                }
                if (d.getHeroes().get(0).hasFallen() == false){
                    Hero h = d.removeHero();
                    d.addHero(h);
                }
                else {
                    d.removeHero();
                }
                a = false;
            }
            else{
                System.out.println("*** " + l.getHeroes().get(0).getName() + " vs " + d.getHeroes().get(0).getName() + "!");
                l.getHeroes().get(0).attack(d.getHeroes().get(0));
                if (d.getHeroes().get(0).hasFallen() == false){
                    d.getHeroes().get(0).attack(l.getHeroes().get(0));
                    Hero h = d.removeHero();
                    d.addHero(h);
                }
                else {
                    d.removeHero();
                }
                if (l.getHeroes().get(0).hasFallen() == false){
                    Hero h = l.removeHero();
                    l.addHero(h);
                }
                else {
                    l.removeHero();
                }
                a = true;
            }
            count++;
            System.out.println();
        }
    }
    public void play(){
        new HeroStorm(0,0);
    }
    public static void main(String[] args){
        new HeroStorm(0,0);
    }
}
