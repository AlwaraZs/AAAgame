package com.company;

public class Battle extends Thread{
    private Characters player; // player
    private Characters monster;

    Battle(Characters player, Characters monster){
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void run(){
        synchronized (player){
            System.out.println(String.format("%s\n\nvs\n\n%s", player, monster));
            boolean beatPlayer = true;
            while (true) {
                if (player.getHealth() <= 0 || monster.getHealth() <= 0) {
                    if (player.getHealth() > 0) {
                        player.addGold(monster.getGold());
                        player.addExperience(monster.getExperience());
                        System.out.println(String.format("\nПоздравляю вы победили!\nПолучено опыта: %s, Получено золота: %s\n%s\n", monster.getExperience(), monster.getGold(), player));
                        break;
                    }
                    System.out.println(String.format("\nВы проиграли. Достигнутый уровень %s.\n", player.getLevel()));
                    break;
                }
                Characters attacking = beatPlayer ? player : monster;
                Characters enemy = beatPlayer ? monster : player;
                System.out.println(String.format("\n%s(%s) атакует", attacking.getName(), attacking.getRace()));
                int damage = attacking.attack();
                enemy.minusHealth(damage);
                System.out.println(damage == 0 ? String.format("%s(%s) промахивается!", attacking.getName(), attacking.getRace()) : String.format("%s%s(%s) насовит %s урона!",  attacking.getStrength() < damage ? "Кртический удар!!! " : "", attacking.getName(), attacking.getRace(), damage));
                System.out.println(String.format("%s(%s/%s) - %s(%s/%s)", attacking.getRace(), attacking.getHealth(), attacking.getMaxHealth(), enemy.getRace(), enemy.getHealth(), enemy.getMaxHealth()));
                beatPlayer = !beatPlayer;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
