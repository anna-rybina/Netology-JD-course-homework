import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Список возможных товаров для покупки");
        System.out.println("1. Молоко 50 руб/шт");
        System.out.println("2. Хлеб 14 руб/шт");
        System.out.println("3. Гречневая крупа 80 руб/шт");

        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        int[] prices = {50, 14, 80};
        int sumProducts = 0;
        List<String> purchases = new ArrayList<>();

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int numberOfProducts = Integer.parseInt(parts[1]);

            int currentPrice = prices[productNumber];


            String purchaseString = products[productNumber]
                    + " "
                    + numberOfProducts
                    + " шт "
                    + currentPrice
                    + " руб/шт "
                    + currentPrice * numberOfProducts
                    + " руб в сумме ";

            purchases.add(purchaseString);
            sumProducts = sumProducts + (currentPrice * numberOfProducts);


        }
        System.out.println("Ваша корзина: ");
        for (String purchaseString : purchases) {
            System.out.println(purchaseString);
        }
        System.out.println("Итого: " + sumProducts);
    }
}