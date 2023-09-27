package kg.geeks.game.players;

import java.util.Random;

public class Lucky extends Hero{

    public Lucky(int health, int damage, String name) {
        super(health, damage, SuperAbility.LUCKY, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        boolean boo = random.nextBoolean();
        if (boo){
            this.setHealth(this.getHealth()*2);
        }
    }
}
