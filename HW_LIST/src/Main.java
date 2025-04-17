import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> todoList = new ArrayList<>();

        while (true) {
            showMenu();
            System.out.println("Ваш выбор: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 0) {
                System.out.println("Выход из программы");
                break;
            } else if (choice == 1) {
                addTask(todoList, scanner);
            } else if (choice == 2) {
                showTasks(todoList);
            } else if (choice == 3) {
                deleteTaskByNumber(todoList, scanner);
            } else if (choice == 4) {
                deleteTaskByName(todoList, scanner);
            } else if (choice == 5) {
                deleteTasksByKeyword(todoList, scanner);
            } else {
                System.out.println("Такого варианта в меню нет. Попробуйте снова");
            }
            if (choice != 0 ) {
                showTasks(todoList);
            }
        }
    }
    private static void showMenu() {
        System.out.println("Выберите операцию:");
        System.out.println("0. Выход из программы");
        System.out.println("1. Добавить дело");
        System.out.println("2. Показать дела");
        System.out.println("3. Удалить дело по номеру");
        System.out.println("4. Удалить дело по названию");
        System.out.println("5. Удалить дела по ключевому слову");
    }

    private static void addTask(List<String> todoList, Scanner scanner) {
        System.out.println("Введите название задачи: ");
        String task = scanner.nextLine();

        if (!todoList.contains(task)) {
            todoList.add(task);
            System.out.println("Добавлено!");
        } else {
            System.out.println("Такое дело уже существует в списке.");
        }
    }

    private static void showTasks(List<String> todoList) {
        if (todoList.isEmpty()) {
            System.out.println("Ваш список дел пуст.");
        } else {
            System.out.println("Ваш список дел:");
            int counter = 1;
            for (String task : todoList) {
                System.out.println(counter++ + ". " + task);
            }
        }
        System.out.println();


    }

    private static void deleteTaskByNumber(List<String> todoList, Scanner scanner) {
        if (todoList.isEmpty()) {
            System.out.println("Нечего удалять.");
            return;
        }

        System.out.print("Введите номер для удаления: ");
        int number = Integer.parseInt(scanner.nextLine());

        if (number < 1 || number > todoList.size()) {
            System.out.println("Нет дела с таким номером.");
        } else {
            todoList.remove(number - 1);
            System.out.println("Удалено!");
        }

    }
    private static void deleteTaskByName(List<String> todoList, Scanner scanner) {
        if (todoList.isEmpty()) {
            System.out.println("Нечего удалять.");
            return;
        }

        System.out.print("Введите задачу для удаления: ");
        String task = scanner.nextLine();

        if (!todoList.contains(task)) {
            System.out.println("Нет дела с таким названием.");
        } else {
            todoList.remove(task);
            System.out.println("Удалено!");
        }
    }

    private static void deleteTasksByKeyword(List<String> todoList, Scanner scanner) {
        if (todoList.isEmpty()) {
            System.out.println("Список дел пуст. Нечего удалять.");
            return;
        }

        System.out.print("Введите ключевое слово для удаления: ");
        String keyword = scanner.nextLine().toLowerCase();

        Iterator<String> iterator = todoList.iterator();
        int removedCount = 0;

        while (iterator.hasNext()) {
            String task = iterator.next();
            if (task.toLowerCase().contains(keyword)) {
                iterator.remove();
                removedCount++;
            }
        }

        if (removedCount > 0) {
            System.out.println("Удалено задач: " + removedCount);
        } else {
            System.out.println("Не найдено задач, содержащих '" + keyword + "'");
        }
    }
}