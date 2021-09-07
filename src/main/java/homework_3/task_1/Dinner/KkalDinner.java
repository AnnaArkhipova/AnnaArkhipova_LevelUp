package homework_3.task_1.Dinner;

import homework_3.task_1.Fridge.Fridge;
import java.util.Scanner;

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

    public double min_kkal, max_kkal;

    public KkalDinner() {
        super();

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
    }

    public void totalkkaldinner() {
        totalkkal_beef = beef.getKkal() * beef.getWeight();
        /*System.out.printf("Калорийность 100г мяса = %.2f \n", beef.getKkal());
        System.out.printf("Вес мяса = %.2f \n", beef.getWeight());
        System.out.printf("Калорийность мяса = %.2f \n", totalkkal_beef);
        */
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

        System.out.printf("ОБЕД ГОТОВ! Калорийность обеда = %.2f \n", totalkkal_dinner);
        System.out.printf("Калорийность салата = %.2f \n", totalkkal_salat);
        System.out.printf("Калорийность борща = %.2f \n", totalkkal_borsch);


        Scanner in = new Scanner(System.in);

        System.out.println("Введите минимальное количество калорий продукта в борще:");
        min_kkal = in.nextDouble();
        System.out.println("Введите максимальное количество калорий продукта в борще:");
        max_kkal = in.nextDouble();

        if(totalkkal_beef > min_kkal & totalkkal_beef < max_kkal){
            System.out.printf("Калорийность мяса в борще = %.2f \n", totalkkal_beef);
        } else if(totalkkal_potatoes > min_kkal & totalkkal_potatoes < max_kkal){
            System.out.printf("Калорийность картошки в борще = %.2f \n", totalkkal_potatoes);
        } else if(totalkkal_cabbage > min_kkal & totalkkal_cabbage < max_kkal){
            System.out.printf("Калорийность капусты в борще = %.2f \n", totalkkal_cabbage);
        } else if(totalkkal_carrot > min_kkal & totalkkal_carrot < max_kkal){
            System.out.printf("Калорийность морковки в борще = %.2f \n", totalkkal_carrot);
        } else if(totalkkal_beet > min_kkal & totalkkal_beet < max_kkal){
            System.out.printf("Калорийность свеклы в борще = %.2f \n", totalkkal_beet);
        } else if(totalkkal_onion > min_kkal & totalkkal_onion < max_kkal){
            System.out.printf("Калорийность лука в борще = %.2f \n", totalkkal_onion);
        } else if(totalkkal_water > min_kkal & totalkkal_water < max_kkal){
            System.out.printf("Калорийность воды в борще = %.2f \n", totalkkal_water);
        } else if(totalkkal_salt > min_kkal & totalkkal_salt < max_kkal){
            System.out.printf("Калорийность соли в борще = %.2f \n", totalkkal_salt);
        } else if(totalkkal_pepper > min_kkal & totalkkal_pepper < max_kkal){
            System.out.printf("Калорийность перца в борще = %.2f \n", totalkkal_pepper);
        } else {
            System.out.println("Продукт с заданным диапазоном калорий в борще не найден. \n");
        }

    }
}
