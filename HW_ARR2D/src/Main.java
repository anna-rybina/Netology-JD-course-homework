import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Оригинальная матрица");
        int[][] matrix = createMatrix(8, 8);
        printMatrix(matrix);

        int[][] result = rotateMatrix(matrix);

        System.out.println("\nПеревернутая матрица");
        printMatrix(result);
    }

    private static int[][] rotateMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[size - 1 - j][i];
            }
        }
        return result;
    }

    private static int[][] createMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(256);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}