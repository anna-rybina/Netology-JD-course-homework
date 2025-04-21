public class Address {
    private final String country;
    private final String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Address address = (Address) obj;
        return country.equalsIgnoreCase(address.country)
                && city.equalsIgnoreCase(address.city);
    }

    @Override
    public int hashCode() {
        return 31 * country.toLowerCase().hashCode()
                + city.toLowerCase().hashCode();
    }
}
