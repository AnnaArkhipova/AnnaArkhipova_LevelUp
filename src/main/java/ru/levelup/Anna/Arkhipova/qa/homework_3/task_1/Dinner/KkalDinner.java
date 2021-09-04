package ru.levelup.Anna.Arkhipova.qa.homework_3.task_1.Dinner;

import ru.levelup.Anna.Arkhipova.qa.homework_3.task_1.Food.Fridge;

public class KkalDinner extends Fridge {
    public double totalkkal_salat;
    public double totalkkal_borsch;
    public double totalkkal_dinner;

    public double totalkkal_beef;
    public double totalkkal_tomato;
    public double totalkkal_cucumber;
    public double totalkkal_salad;
    public double totalkkal_potatoes;
    public double totalkkal_cabbage;
    public double totalkkal_carrot;
    public double totalkkal_beet;
    public double totalkkal_onion;
    public double totalkkal_water;
    public double totalkkal_olive_oil;
    public double totalkkal_salt;
    public double totalkkal_pepper;

    public void totalkkaldinner() {
        beef.setWeight(1);

        tomato.setWeight(200);
        cucumber.setWeight(200);
        salad.setWeight(100);
        potatoes.setWeight(500);
        cabbage.setWeight(200);
        carrot.setWeight(200);
        beet.setWeight(200);
        onion.setWeight(100);

        water.setWeight(3);
        olive_oil.setWeight(50);

        salt.setWeight(0.05);
        pepper.setKkal(0.03);

        totalkkal_beef = beef.getKkal() * beef.getWeight();
        totalkkal_tomato = tomato.getKkal() * tomato.getWeight();
        totalkkal_cucumber = cucumber.getKkal() * cucumber.getWeight();
        totalkkal_salad = salad.getKkal() * salad.getWeight();
        totalkkal_potatoes = potatoes.getKkal() * potatoes.getWeight();
        totalkkal_cabbage = cabbage.getKkal() * cabbage.getWeight();
        totalkkal_carrot = carrot.getKkal() * carrot.getWeight();
        totalkkal_beet = beet.getKkal() * beet.getWeight();
        totalkkal_onion = onion.getKkal() * onion.getWeight();
        totalkkal_water = water.getKkal() * water.getWeight();
        totalkkal_olive_oil = olive_oil.getKkal() * olive_oil.getWeight();
        totalkkal_salt = salt.getKkal() * salt.getWeight();
        totalkkal_pepper = pepper.getKkal() * pepper.getWeight();

        totalkkal_salat = totalkkal_tomato + totalkkal_cucumber + totalkkal_salad + totalkkal_olive_oil;
        totalkkal_borsch =
            totalkkal_beef + totalkkal_potatoes + totalkkal_cabbage + totalkkal_carrot + totalkkal_beet
                + totalkkal_onion + totalkkal_water + totalkkal_salt + totalkkal_pepper;
        totalkkal_dinner = totalkkal_salat + totalkkal_borsch;

        System.out.printf("Калорийность салата = %d \n", totalkkal_salat);
        System.out.printf("Калорийность борща = %d \n", totalkkal_borsch);
        System.out.printf("Калорийность обеда = %d \n", totalkkal_dinner);
    }
}
