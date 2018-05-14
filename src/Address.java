public class Address {
    String streetAddress;
    String city;
    String state;
    String zipcode;

    public Address(String streetAddress, String city, String state, String zipcode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Address() {
        this("", "", "", "");
    }

    @Override
    public String toString() {
        return streetAddress + " " + city + ", " + state + " " + zipcode;
    }
}
