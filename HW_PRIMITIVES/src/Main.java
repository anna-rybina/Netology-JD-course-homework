import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax1 = (earnings - spendings) * 15 / 100;
        if (tax1 >= 0) {
            return tax1;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax2 = earnings * 6 / 100;
        if (tax2 >= 0) {
            return tax2;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr1 = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int money1 = Integer.parseInt(moneyStr1);
                    earnings = earnings + money1;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStr2 = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int money2 = Integer.parseInt(moneyStr2);
                    spendings = spendings + money2;
                    break;
                case 3:
                    int taxSystem1 = taxEarningsMinusSpendings(earnings, spendings);
                    int taxSystem2 = taxEarnings(earnings);
                    int economy1 = taxSystem1 - taxSystem2;
                    int economy2 = taxSystem2 - taxSystem1;
                    if (taxSystem1 > taxSystem2) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxSystem2);
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Налог на другой системе: " + taxSystem1);
                        System.out.println("Экономия: " + economy1);
                    } else if (taxSystem2 > taxSystem1) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxSystem1);
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Налог на другой системе: " + taxSystem2 );
                        System.out.println("Экономия: " + economy2);

                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}