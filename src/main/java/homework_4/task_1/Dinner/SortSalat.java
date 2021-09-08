package homework_4.task_1.Dinner;

import homework_4.task_1.Fridge.Fridge;

public class SortSalat extends Fridge{
    public SortSalat() {
        super();

    }

    public void sortproduct() {
       double[] kkalprod = new double[4];
       String [] nameprod = new String[4];
       int out, in, i;
       double dummy_kkal;
       String dummy_name;

        kkalprod[0] = tomato.getKkal();
        kkalprod[1] = cucumber.getKkal();
        kkalprod[2] = olive_oil.getKkal();
        kkalprod[3] = salad.getKkal();

        nameprod[0] = tomato.getName();
        nameprod[1] = cucumber.getName();
        nameprod[2] = olive_oil.getName();
        nameprod[3] = salad.getName();

        /*for (i=0; i<=3; i++) {
            System.out.printf("%.2f \n", kkalprod[i]);
        }
        */

        for (out = 3; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (kkalprod[in] > kkalprod[in + 1]) {
                    dummy_kkal = kkalprod[in];
                    kkalprod[in] = kkalprod[in + 1];
                    kkalprod[in + 1] = dummy_kkal;

                    dummy_name = nameprod[in];
                    nameprod[in] = nameprod[in + 1];
                    nameprod[in + 1] = dummy_name;
                }
            }
        }
        System.out.println("КАЛОРИЙНОСТЬ ПРОДУКТОВ В САЛАТЕ ПО ВОЗРАСТАНИЮ:");
        for (i=0; i<=3; i++) {
            System.out.println(nameprod[i]);
            System.out.printf(" %.2f \n", kkalprod[i]);
        }
    }
}
