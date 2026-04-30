public class Author {
    private String name;
    private String surname;
    private int rating;

    public Author(String name, String surname, int rating) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;

    }

    public boolean matches(String word) {
        if (word == null) {
            return false;
        }
        return name.contains(word) || surname.contains(word);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getRating() {
        return rating;
    }
}


