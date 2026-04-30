public class Main {
    public static void main(String[] args) {
        Author author = new Author("Kathy", "Sierra", 10);
        Book book = new Book("Head First Java, 3rd Edition", author, 2022, 688);

        System.out.println(book.isBig());
        System.out.println(book.matches("Java"));
        System.out.println(book.matches("Python"));
        System.out.println(book.matches("Sierra"));
        System.out.println(book.estimatePrice());
    }
}
