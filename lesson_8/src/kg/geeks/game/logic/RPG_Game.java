package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber = 0;

    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Fatih");
        Warrior warrior1 = new Warrior(50, 15, "Viktor");
        Warrior warrior2 = new Warrior(270, 15, "Juan");
        Medic doc = new Medic(250, 0, 15, "Bakbergen");
        Magic magic = new Magic(260, 20, "Amanjan");
        Berserk berserk = new Berserk(260, 15, "Ainazik");
        Medic assistant = new Medic(300, 0, 5, "Nurdin");
        Witcher witcher = new Witcher(300,0,"Milana");
        Thor emil = new Thor(200, 15, "Emil");
        Reaper sana = new Reaper(300,10,"Sana");
        Bomber bomber = new Bomber(100, 15,"Bomber");
        Lucky lucky = new Lucky(200,5,"Lucky");
        Hero[] heroes = {warrior1, warrior2,  magic, berserk,witcher,emil, sana, bomber, lucky, doc, assistant };

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0
                    && heroes[i].getAbility() != boss.getDefence()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
