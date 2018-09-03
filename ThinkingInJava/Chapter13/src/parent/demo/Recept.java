package parent.demo;

import java.util.Formatter;

public class Recept {
    private static final int padding = 5;
    private static final String format1 = "%-" + padding * 3 + "s %" + padding + "s %" + padding * 2 + "s\n";
    private static final String format2 = "%-" + padding * 3 + "s %" + padding + "s %" + padding * 2 + ".2f\n";
    private static final String format3 = "%-" + padding * 3 + ".15s %" + padding + "s %" + padding * 2 + ".2f\n";
    private double total = 0;
    private Formatter formatter = new Formatter(System.out);

    public void printTitle() {
        formatter.format(format1, "Item", "Qty", "Price");
        formatter.format(format1, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        formatter.format(format3, name, qty, price);
        total += price;
    }

    public void printTotal() {
        formatter.format(format2, "Tax", "", total * 0.06);
        formatter.format(format1, "", "", "----");
        formatter.format(format2, "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Recept x = new Recept();
        x.printTitle();
        x.print("Jack's Magic Bean", 4, 4.25);
        x.print("Princess Peas", 3, 5.1);
        x.print("Tree Bears Porridge", 1, 14.29);
        x.printTotal();
    }
}
