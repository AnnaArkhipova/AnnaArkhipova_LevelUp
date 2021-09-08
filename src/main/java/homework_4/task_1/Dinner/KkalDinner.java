package homework_4.task_1.Dinner;

import static homework_4.task_1.Food.Food.out;

import homework_4.task_1.Fridge.Fridge;
import java.io.IOException;
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

    public int min_kkal, max_kkal;

    public int kkal_borch, kkal_salat;
    public int amount;

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

    public void totalkkaldinner() throws IOException {
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

        System.out.printf("ОБЕД ГОТОВ! Калорийность обеда = %.2f \n", totalkkal_dinner);
        String str = "ОБЕД ГОТОВ! Калорийность обеда = " + String.valueOf(totalkkal_dinner) + "\n";
        out.write(str);

        System.out.printf("Калорийность салата = %.2f \n", totalkkal_salat);
        str = "Калорийность салата = " + String.valueOf(totalkkal_salat) + "\n";
        out.write(str);

        System.out.printf("Калорийность 5 л борща = %.2f \n", totalkkal_borsch);
        str = "Калорийность 5 л борща = " + String.valueOf(totalkkal_borsch) + "\n";
        out.write(str);

        System.out.println("Введите минимальное количество калорий продукта в борще:");
        Scanner in1 = new Scanner(System.in);
        try {
            min_kkal = Integer.parseInt(in1.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Введено неверное число");
            return;
        }

        System.out.println("Введите максимальное количество калорий продукта в борще:");
        Scanner in2 = new Scanner(System.in);
        try {
            max_kkal = Integer.parseInt(in2.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Введено неверное число");
            return;
        }

        if(totalkkal_beef > min_kkal & totalkkal_beef < max_kkal){
            System.out.printf("Калорийность мяса в борще = %.2f \n", totalkkal_beef);
            str = "Калорийность мяса в борще = " + String.valueOf(totalkkal_beef) + "\n";
            out.write(str);
        } else if (totalkkal_potatoes > min_kkal & totalkkal_potatoes < max_kkal) {
            System.out.printf("Калорийность картошки в борще = %.2f \n", totalkkal_potatoes);
            str = "Калорийность картошки в борще = " + String.valueOf(totalkkal_potatoes) + "\n";
            out.write(str);
        } else if (totalkkal_cabbage > min_kkal & totalkkal_cabbage < max_kkal) {
            System.out.printf("Калорийность капусты в борще = %.2f \n", totalkkal_cabbage);
            str = "Калорийность капусты в борще = " + String.valueOf(totalkkal_cabbage) + "\n";
            out.write(str);
        } else if (totalkkal_carrot > min_kkal & totalkkal_carrot < max_kkal) {
            System.out.printf("Калорийность морковки в борще = %.2f \n", totalkkal_carrot);
            str = "Калорийность морковки в борще = " + String.valueOf(totalkkal_carrot) + "\n";
            out.write(str);
        } else if (totalkkal_beet > min_kkal & totalkkal_beet < max_kkal) {
            System.out.printf("Калорийность свеклы в борще = %.2f \n", totalkkal_beet);
            str = "Калорийность свеклы в борще = " + String.valueOf(totalkkal_beet) + "\n";
            out.write(str);
        } else if (totalkkal_onion > min_kkal & totalkkal_onion < max_kkal) {
            System.out.printf("Калорийность лука в борще = %.2f \n", totalkkal_onion);
            str = "Калорийность лука в борще = " + String.valueOf(totalkkal_onion) + "\n";
            out.write(str);
        } else if (totalkkal_water > min_kkal & totalkkal_water < max_kkal) {
            System.out.printf("Калорийность воды в борще = %.2f \n", totalkkal_water);
            str = "Калорийность воды в борще = " + String.valueOf(totalkkal_water) + "\n";
            out.write(str);
        } else if (totalkkal_salt > min_kkal & totalkkal_salt < max_kkal) {
            System.out.printf("Калорийность соли в борще = %.2f \n", totalkkal_salt);
            str = "Калорийность соли в борще = " + String.valueOf(totalkkal_salt) + "\n";
            out.write(str);
        } else if (totalkkal_pepper > min_kkal & totalkkal_pepper < max_kkal) {
            System.out.printf("Калорийность перца в борще = %.2f \n", totalkkal_pepper);
            str = "Калорийность перца в борще = " + String.valueOf(totalkkal_pepper) + "\n";
            out.write(str);
        } else {
            System.out.println("Продукт с заданным диапазоном калорий в борще не найден. \n");
            out.write("Продукт с заданным диапазоном калорий в борще не найден. \n");
        }

        System.out.println("ПЕРЕСЧЕТ НА ОДНУ ПОРЦИЮ.");
        out.write("ПЕРЕСЧЕТ НА ОДНУ ПОРЦИЮ. \n");

        System.out.println("На сколько порций делить обед?:");
                Scanner in3 = new Scanner(System.in);
        try {
            amount = Integer.parseInt(in3.nextLine());
            System.out.printf("Количество порций = %d \n", amount);
            str = "Количество порций = " + String.valueOf(amount) + "\n";
            out.write(str);
        } catch (NumberFormatException e) {
            System.err.println("Введено неверное число");
            return;
        }
        try {
            kkal_borch = (int)totalkkal_borsch / amount;
            kkal_salat = (int)totalkkal_salat / amount;
        } catch (Exception ex){
            System.out.println(ex.toString());
            return;
        }
        System.out.printf("Калорийность борща на порцию = %d \n", kkal_borch);
        str = "Калорийность борща на порцию = " + String.valueOf(kkal_borch) + "\n";
        out.write(str);

        System.out.printf("Калорийность салата на порцию = %d \n", kkal_salat);
        str = "Калорийность салата на порцию = " + String.valueOf(kkal_salat) + "\n";
        out.write(str);
    }
}
