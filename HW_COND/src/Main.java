import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (true) {
            System.out.println("Введите год в формате yyyy:");
            int year = scanner.nextInt();
            System.out.println("Введите количество дней:");
            int days = scanner.nextInt();
            if (days == countDays(year)) {
                counter++;
            }
            if (countDays(year) != days) {
                System.out.println("Неправильно! В этом году " + countDays(year) + " дней");
                System.out.println("Набрано очков: " + counter);
                break;
            }
        }
    }

    public static int countDays(int year) {
        if (year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))) {
            return 366;
        } else {
            return 365;
        }
    }
}
