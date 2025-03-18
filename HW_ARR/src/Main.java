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
        int[] productsAmount = new int[products.length];
        int sumProducts = 0;

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int numberOfProducts = Integer.parseInt(parts[1]);

            productsAmount[productNumber] = productsAmount[productNumber] + numberOfProducts;

            int currentPrice = prices[productNumber]; 
            sumProducts = sumProducts + (currentPrice * numberOfProducts); 
        }
        for (int productIndex = 0; productIndex < products.length; productIndex++) {
            if (productsAmount[productIndex] == 0) {
                continue;
            }
            System.out.println(products[productIndex]
                    + " "
                    + productsAmount[productIndex]
                    + " шт "
                    + prices[productIndex]
                    + " руб/шт "
                    + prices[productIndex] * productsAmount[productIndex]
                    + " руб в сумме ");
        }
        System.out.println("Итого: " + sumProducts);
    }
}
