//Создать класс Notebook с полями (price(double), ram(int))
//1. Сгенерировать список объектов типа Notebook с разными значениям price и ram
//2. Релизовать 3 сортировки: 1 - по цене, 2 - по памяти, 3 - сначала по памяти, потом по цене
//3. Отсортировать тремя способами стандартными средствами (Collections#sort или List#sort)

package lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Notebook {

    private double price;
    private int ram;

    public Notebook(double price, int ram) {
        this.price = price;
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public String printNotebook() {
        System.out.println("Notebook price: " + price + ", RAM: " + ram);
        return null;
    }

    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook(70000, 16));
        notebooks.add(new Notebook(25000, 8));
        notebooks.add(new Notebook(110000, 8));
        notebooks.add(new Notebook(40000, 16));
        notebooks.add(new Notebook(130000, 32));
        notebooks.add(new Notebook(90000, 32));
        notebooks.add(new Notebook(60000, 8));



        System.out.println("1. Сортировка по цене:");
        Collections.sort(notebooks, Comparator.comparingDouble(Notebook::getPrice));
        for (Notebook notebook: notebooks) {
            notebook.printNotebook();
        }
        

        System.out.println("2. Сортировка по памяти:");
        Collections.sort(notebooks, Comparator.comparingInt(Notebook::getRam));
        for (Notebook notebook: notebooks) {
            notebook.printNotebook();
        }

        System.out.println("3. Сортировка сначала по памяти, потом по цене:");
        Collections.sort(notebooks, Comparator.comparingInt(Notebook::getRam).thenComparing(Notebook::getPrice));;
        for (Notebook notebook : notebooks) {
            notebook.printNotebook();
        }

    }
    
}
