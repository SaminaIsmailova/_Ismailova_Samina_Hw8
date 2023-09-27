package kg.geeks.game.players;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int hero = 0; hero < heroes.length; hero++) {
            heroes[hero].setDamage(heroes[hero].getDamage()+ 10 );

        }
    }
}
