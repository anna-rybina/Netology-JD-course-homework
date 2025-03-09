public class Main {
    public static void main(String[] args) {
        Author author = new Author("Donna", "Tartt", 5);
        Book book = new Book("Secret history", 1992, author, 550);

        System.out.println(book.title);
        System.out.println(book.releaseYear);
        System.out.println(book.author.name + " " + book.author.surname);
        System.out.println(book.pages);

        System.out.println(book.isBig());
        System.out.println(book.matches("Tartt"));
        System.out.println(book.estimatePrice());

    }
}