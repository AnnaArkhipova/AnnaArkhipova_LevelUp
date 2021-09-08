package homework_4.task_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int[] array = new int[100000];

        for (int i = 0; i < array.length; ++i) {
            array[i] = new Random().nextInt();
            list.add(array[i]);
            set.add(array[i]);
        }

        //System.out.println(list);
        //System.out.println(set);

        //System.out.println(list.size());
        //System.out.println(set.size());

        if (list.size() == set.size()) {
            System.out.println("Все элементы в коллекции уникальны");
        } else {
            System.out.println("В коллекции есть повторяющиеся элементы");
        }

        Iterator<Integer> iterator = set.iterator();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        List<Integer> list7 = new ArrayList<>();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            // System.out.println(next);
            if ((next % 2) == 0) {
                list2.add(next);
            } else if ((next % 3) == 0) {
                list3.add(next);
            } else if ((next % 5) == 0) {
                list5.add(next);
            } else if ((next % 7) == 0) {
                list7.add(next);
            }
        }
        /* System.out.println(list2.size());
        System.out.println(list3.size());
        System.out.println(list5.size());
        System.out.println(list7.size());
        */

        Scanner in = new Scanner(System.in);
        System.out.println("Введите делитель:");

        switch (in.nextInt()) {
            case 2:
                System.out.println(list2);
                break;
            case 3:
                System.out.println(list3);
                break;
            case 5:
                System.out.println(list5);
                break;
            case 7:
                System.out.println(list7);
                break;

            default:
                System.out.println("Введен невалидный делитель (2, 3, 5, 7)");
        }
    }
}
