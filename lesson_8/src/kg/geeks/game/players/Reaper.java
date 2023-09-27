package kg.geeks.game.players;

public class Reaper extends Hero{
    private int persentage1 = (this.getHealth()/100)*30;
    private int persentage2 = (this.getHealth()/100)*15;
    public Reaper(int health, int damage, String name) {
        super(health, damage, SuperAbility.RAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() == persentage1){
            this.setDamage(this.getDamage()*2);
            System.out.println(this.getName()+ "увеличил урон в два раза");
        }else if (this.getHealth() == persentage2){
            this.setDamage(this.getDamage()*3);
            System.out.println(this.getName()+ "увеличил урон в три раза");
        }

    }
}
