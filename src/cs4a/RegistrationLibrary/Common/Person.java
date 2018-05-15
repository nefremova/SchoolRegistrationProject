package cs4a.RegistrationLibrary.Common;

/**
 * This class is a base class for students and faculty
 *
 */

public class Person implements Comparable{
    protected String fName;
    protected String lName;
    protected String email;
    protected String phoneNum;
    protected Address address;
    protected int idNum;
    protected int numCourses = 0;

    /**
     * Constructor taking in first name, last name, email, phone number, address, and id
     * @param fName
     * @param lName
     * @param email
     * @param phoneNum
     * @param address
     * @param idNum
     */

    public Person(String fName, String lName, String email, String phoneNum,
                  Address address, int idNum)  {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.idNum = idNum;

    }

    /** Constructor taking in first name, last name, email, phone number, address by parts, and id
     *
     * @param fName
     * @param lName
     * @param email
     * @param phoneNum
     * @param streetAddress
     * @param city
     * @param state
     * @param zipcode
     * @param idNum
     */
    public Person(String fName, String lName, String email, String phoneNum,
                  String streetAddress, String city, String state, String zipcode, int idNum) {
        this(fName, lName, email, phoneNum, new Address(streetAddress, city, state, zipcode), idNum);
    }

    /**
     * Default constructor
     */

    public Person() {
        this("", "", "", "", new Address(), 0);
    }

    public String getfName() {
        return fName;
    }

    public Person setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public String getlName() {
        return lName;
    }

    public Person setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Person setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Person setAddress(Address address) {
        this.address = address;
        return this;
    }

    public int getIdNum() {
        return idNum;
    }

    public Person setIdNum(int idNum) {
        this.idNum = idNum;
        return this;
    }

    public void addCourse() {
        numCourses++;
    }

    public int getNumCourses() {
        return numCourses;
    }

    /**
     * Override the equals method to return true if id numbers match
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Person person = (Person) o;
        return idNum == person.idNum;
    }

    /**
     * Return Person as a string
     * @return
     */
    @Override
    public String toString() {
        StringBuilder personString = new StringBuilder();
        personString.append("Name: " + fName + " " + lName);
        personString.append("\nEmail: " + email);
        personString.append("\nTelephone: " + phoneNum);
        personString.append("\nAddress: " + address);
        personString.append("\nID: " + idNum);

        return personString.toString();
    }


    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        String thisFullName = this.fName + this.lName;
        String thatFullName = person.fName + person.lName;

        return thisFullName.compareTo(thatFullName);
    }

}
