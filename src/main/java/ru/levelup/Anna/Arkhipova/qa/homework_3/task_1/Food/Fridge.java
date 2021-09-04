package ru.levelup.Anna.Arkhipova.qa.homework_3.task_1.Food;

import ru.levelup.Anna.Arkhipova.qa.homework_3.task_1.Dinner.KkalDinner;

public class Fridge {
    public Meat beef = new Meat();

    public Vegetables tomato = new Vegetables();
    public Vegetables cucumber = new Vegetables();
    public Vegetables salad = new Vegetables();
    public Vegetables potatoes = new Vegetables();
    public Vegetables cabbage = new Vegetables();
    public Vegetables carrot = new Vegetables();
    public Vegetables beet = new Vegetables();
    public Vegetables onion = new Vegetables();

    public Liquid water = new Liquid();
    public Liquid olive_oil = new Liquid();

    public Spice salt = new Spice();
    public Spice pepper = new Spice();

    public KkalDinner totalkkal_dinner = new KkalDinner();

    public void main(String[] args) {

        beef.setKkal(288);

        tomato.setKkal(20);
        cucumber.setKkal(15);
        salad.setKkal(12);
        potatoes.setKkal(76);
        cabbage.setKkal(27);
        carrot.setKkal(32);
        beet.setKkal(49);
        onion.setKkal(47);

        water.setKkal(0);
        olive_oil.setKkal(898);

        salt.setKkal(0);
        pepper.setKkal(251);

        totalkkal_dinner.totalkkaldinner();
    }
}

