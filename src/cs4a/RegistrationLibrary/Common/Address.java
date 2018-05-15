package cs4a.RegistrationLibrary.Common;

/**
 * This class holds information for an Address (Street address, city, state, and zipcode)
 */
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

    /**
     * Return address as a string
     * @return
     */
    @Override
    public String toString() {
        return streetAddress + " " + city + ", " + state + " " + zipcode;
    }
}
