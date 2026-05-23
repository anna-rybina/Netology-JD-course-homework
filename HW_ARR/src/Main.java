import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] basket = new int[products.length];

        showFoodMenu(products, prices);
        fillBasket(basket);
        showFullBasket(products, prices, basket);

    }

    private static void showFullBasket(String[] products, int[] prices, int[] basket) {
        System.out.println("Ваша корзина:");
        int total = 0;
        for (int i = 0; i < products.length; i++) {
            if (basket[i] > 0) {
                int currentPrice = basket[i] * prices[i];
                total += currentPrice;

                System.out.printf("%s %d шт %d руб/шт %d руб в сумме\n",
                        products[i],
                        basket[i],
                        prices[i],
                        currentPrice);
            }
        }
        System.out.printf("Итого %d руб\n", total);
    }


    public static void fillBasket (int[] basket) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер товара и количество или введите `end`");
            String stringInput = scanner.nextLine(); // 2 10

            if (stringInput.equalsIgnoreCase("end")) {
                break;
            }

            String[] parts = stringInput.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int amountOfFood = Integer.parseInt(parts[1]);
            basket[productNumber] += amountOfFood;

        }
    }

    public static void showFoodMenu(String[] products, int[] prices) {
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s %d руб/шт\n", i+1,  products[i], prices[i]);
        }
    }
}
