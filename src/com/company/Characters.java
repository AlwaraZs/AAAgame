package com.company;

import java.util.Random;

public abstract class Characters {
    private String name;
    private String race;
    private int health;
    private int maxHealth;
    private int gold;
    private int dexterity;
    private int strength;
    private int experience;
    private int level;

    Characters(String name, String race, int level){
        this.name = name;
        this.race = race;
        this.level = level;
        experience = 0;
        strength = level * 3;
        dexterity = level * 6;
        gold = level * 100;
        health = level * 6;
        maxHealth = health;
    }

    @Override
    public String toString(){
        return String.format("%s (%s)\nХарктеристики :\n\tУровень - %s%s\n\tЗолото - %s\n\tЗдоровье - %s/%s\n\tСила - %s\n\tЛовкость - %s",
                name, race, level, race.equals("Human") ? String.format(" (опыт %s/%s)", experience, level * 100) : "", gold, health, maxHealth, strength, dexterity);
    }
    protected int attack(){
        int crit = getDexterity() * getStrength() > new Random().nextInt(100) ? 2 : 1;
        if (getDexterity() * 3 > new Random().nextInt(100)) return getStrength() * crit;
        else return  0;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    private void addMaxHealth() {
        this.maxHealth = level * 6;
    }

    public int getHealth() {
        return health;
    }

    public void minusHealth(int health) {
        this.health -= health;
    }

    public void addHealth(int health) {
        this.health = Math.min(health + this.health, maxHealth);
    }

    public int getGold() {
        return gold;
    }

    public void minusGold(int gold) {
        this.gold -= gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    private void addDexterity() {
        this.dexterity = level * 6;
    }

    public int getStrength() {
        return strength;
    }

    private void addStrength() {
        this.strength = level * 3;
    }

    public int getExperience(){
        return experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        if (race.equals("Human")) upLevle();
    }

    public int getLevel() {
        return level;
    }

    private void upLevle(){
        int expToNextLevle = level * 100;
        if (experience >= expToNextLevle) {
            while (experience >= expToNextLevle) {
                level++;
                experience -= expToNextLevle;
                expToNextLevle = level * 100;
                System.out.println(String.format("\nВы получили уровень %s! Здоровье полностью востановлено!", level));
            }
            System.out.println(String.format("До следующего уровня %s опыта.\n", expToNextLevle - level));
            addDexterity();
            addStrength();
            addMaxHealth();
            health = maxHealth;
        }
    }
}
