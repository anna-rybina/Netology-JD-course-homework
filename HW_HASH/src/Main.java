import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();
        HashSet<String> uniqueCountries = new HashSet<>();

        costPerAddress.put(new Address("Россия", "Воркута"), 250);
        costPerAddress.put(new Address("Россия", "Киров"), 200);
        costPerAddress.put(new Address("Беларусь", "Минск"), 350);
        costPerAddress.put(new Address("Китай", "Пекин"), 700);

        Scanner scanner = new Scanner(System.in);
        int totalCost = 0;

        while (true) {
            System.out.println("\nЗаполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();

            if (country.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите город: ");
            String city = scanner.nextLine();

            if (city.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите вес (кг): ");
            int weight = 0;
            String weightStr = scanner.nextLine();
            try {
                weight = Integer.parseInt(weightStr);
            } catch (NumberFormatException e) {
                if (weightStr.equalsIgnoreCase("end")) {
                    break;
                }
            }


            Address address = new Address(country, city);

            if (costPerAddress.containsKey(address)) {
                int cost = costPerAddress.get(address) * weight;
                uniqueCountries.add(country.toLowerCase());
                totalCost += cost;
                System.out.println("Стоимость доставки составит: " + cost + " руб.");
                System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
                System.out.println("Уникальных стран доставки: " + uniqueCountries.size());
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
        }
        System.out.println("\nИтоговая информация:");
        System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
        System.out.println("Всего уникальных стран доставки: " + uniqueCountries.size());
        System.out.println("Список стран: " + String.join(", ", uniqueCountries));

        scanner.close();
    }
}