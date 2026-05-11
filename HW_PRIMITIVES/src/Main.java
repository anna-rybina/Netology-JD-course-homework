import java.util.Scanner;

public class Main {
    private static final int RATE_INCOME = 6;
    private static final int RATE_INCOME_MINUS_EXPENSES = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("""
                    Выберите операцию и введите её номер:
                    1. Добавить новый доход
                    2. Добавить новый расход
                    3. Выбрать систему налогообложения
                    Для выхода введите end""");

            String input = scanner.nextLine();
            if ("end".equalsIgnoreCase(input)) {
                break;
            }

            int operation;

            try {
                operation = Integer.parseInt(input);
            } catch (NumberFormatException  e) {
                System.out.println("Введите 1, 2, 3 или end");
                continue;
            }

            switch (operation) {
                case 1:
                    while (true) {
                        System.out.println("Введите сумму дохода:");
                        String earningsInput = scanner.nextLine();
                        int earnedMoney;
                        try {
                            earnedMoney = Integer.parseInt(earningsInput);
                            if (earnedMoney < 0) {
                                System.out.println("Сумма не может быть отрицательной");
                                continue;
                            }
                            earnings += earnedMoney;
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Введите число - сумму дохода");
                        }

                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("Введите сумму расхода:");
                        String spendingsInput = scanner.nextLine();
                        int spentMoney;
                        try {
                            spentMoney = Integer.parseInt(spendingsInput);
                            if (spentMoney < 0) {
                                System.out.println("Сумма не может быть отрицательной");
                                continue;
                            }
                            spendings += spentMoney;
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Введите число - сумму расхода");
                        }
                    }
                    break;
                case 3:
                    int earningsTax = taxEarnings(earnings);
                    int spendingsTax = taxEarningsMinusSpendings(earnings, spendings);
                    showTaxComparison(earningsTax, spendingsTax);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }

        System.out.println("Программа завершена!");

    }

    public static void showTaxComparison(int earningsTax, int spendingsTax) {
        if (earningsTax > spendingsTax) {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + spendingsTax + " рублей");
            System.out.println("Налог на другой системе: " + earningsTax + " рублей");
            System.out.println("Экономия: " + (earningsTax - spendingsTax) + " рублей");
        } else if (earningsTax < spendingsTax) {
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + earningsTax + " рублей");
            System.out.println("Налог на другой системе: " + spendingsTax + " рублей");
            System.out.println("Экономия: " + (spendingsTax - earningsTax) + " рублей");
        } else if (earningsTax == spendingsTax) {
            System.out.println("Можете выбрать любую систему налогообложения");
            System.out.println("Налог на обеих системах: " + earningsTax + " рублей" );
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * RATE_INCOME_MINUS_EXPENSES / 100;
        return (tax>=0) ? tax : 0;
    }

    public static int taxEarnings (int earnings) {
        int tax = earnings * RATE_INCOME / 100;
        return (tax>=0) ? tax : 0;
    }
}
