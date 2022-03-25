package com.company;
import java.util.Scanner;
public class Game {

    Game(){}

    public void startGame(){
        System.out.println("Добро пожаловать в этот жестокий, но увлекательный мир Герой! Мы все верим, что ты сможешь его спасти!!!\nКак тебя называть герой?");
        Scanner scanner = new Scanner(System.in);
        Hero hero = new Hero(scanner.nextLine());
        Dealer dealer = new Dealer();
        System.out.println("Поздравляем, вы создали персонажа!" + "\n" + hero);
        outterLoop : while (true){
            System.out.println("Куда вы хотите пойти?\n1. К торговцу\n2. В тёмный лес\n3. На выход");
            int move = scanner.nextInt();
            switch (move){
                case 1:
                    dealer.bargain();
                    System.out.println(String.format("Текущий показатель здоровья %s/%s", hero.getHealth(), hero.getMaxHealth()));
                    while (true){
                        int num = scanner.nextInt();
                        if (num != 1 && num != 2 && num != 3){
                            break;
                        }
                        if (hero.getGold() >= num * 100){
                            hero.minusGold(num * 100);
                            dealer.addMoney(num * 100);
                            hero.addHealth(num * 70);
                            System.out.println(String.format("Здоровье востановлено, текущий показатель %s/%s\nОсталось денег - %s", hero.getHealth(), hero.getMaxHealth(), hero.getGold()));
                        }else {
                            System.out.println("В долг не даю!");
                            continue;
                        }
                    }
                    break;
                case 2:
                    Characters enemy = Math.random() > 0.5 ? new Skeleton("Bob") : new Goblin("Grog");
                    System.out.println(String.format("Вы зашли в темный лес и встретили там\n%s\n1. Вступить в бой\n2. Спасаться бегством", enemy));
                        switch (scanner.nextInt()){
                            case 1:
                                Thread fight = new Battle(hero, enemy);
                                fight.start();
                                try {
                                    fight.join();
                                } catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                                if (hero.getHealth() <= 0){
                                    System.out.println("Ты прошел славный путь на пути к величию! Однако все смертны…");
                                    break outterLoop;
                                }
                                break;
                            default:
                                continue;
                        }
                    break;
                case 3:
                    System.out.println("Ты прошел славный путь на пути к величию! С нетерпением ждем тебя завтра!");
                    break outterLoop;
                default:
                    System.out.println("Твой путь ведет в бездну! Вернись на путь славы!");
            }
        }
    }
}
