package com.company;

public class Dealer {
    private int money;

    Dealer(){
        money = 0;
    }

    public void bargain(){
        System.out.println("Приветсвую герой! Когда-то я тоже путишествовал по миру, а потом мне прострелили колено… ну да ладно, вот ассортимент, выбирай!" +
                "\n1 - Малое зельзе исценения 50g (+ 100 hp)\n2 - Среднее зельзе исценения 200g (+ 400 hp)\n3 - Мощное зельзе исценения 500g (+ 1000 hp)\n4 - Вернуться к приключениям");
    }

    public void addMoney(int money){
        this.money += money;
        System.out.println("Хороший выбор, одобряю!");
    }
}
