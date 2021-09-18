package homework_4.task_1.Food;

import homework_4.task_1.Dinner.KkalDinner;
import homework_4.task_1.Dinner.SortSalat;
import java.io.FileWriter;
import java.io.IOException;

public class Food {
    public static FileWriter out;

    public static void main(String[] args) throws IOException {

        try {
            out = new FileWriter("out.txt");

            KkalDinner totalkkal_dinner = new KkalDinner();
            totalkkal_dinner.totalkkaldinner();

            SortSalat sort = new SortSalat();
            sort.sortproduct();
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
}