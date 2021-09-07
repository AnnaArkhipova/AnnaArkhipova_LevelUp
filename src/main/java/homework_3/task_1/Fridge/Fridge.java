package homework_3.task_1.Fridge;

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

    public Fridge() {
        beef.setKkal(288);
        /*System.out.printf("Калорийность 100г мяса = %.2f \n", beef.getKkal());
         */
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

        beef.setName("Мясо");
        tomato.setName("Помидор");
        cucumber.setName("Огурец");
        salad.setName("Листовой салат");
        potatoes.setName("Картошка");
        cabbage.setName("Капуста");
        carrot.setName("Морковка");
        beet.setName("Свекла");
        onion.setName("Лук");
        water.setName("Вода");
        olive_oil.setName("Оливковое масло");
        salt.setName("Соль");
        pepper.setName("Перец");
    }
}

