public class Book {
    private String title;
    private Author author;
    private int releaseYear;
    private int pages;

    public Book(String title, Author author, int releaseYear, int pages) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.pages = pages;
    }

    public boolean isBig() {
        return pages > 500;
    }

    public boolean matches(String word) {
       if (word == null) {
           return false;
       }
       return title.contains(word) || author.matches(word);
    }

    public int estimatePrice() {
        int rawPrice = (int) (pages * 3 * Math.sqrt(author.getRating()));
        return Math.max(rawPrice, 250);
    }
}
