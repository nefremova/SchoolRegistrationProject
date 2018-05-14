import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Student extends Person {
    private Date dob;
    private double gpa;
    private Date dateEnrolled;
    private ArrayList<String> coursesWanted;

    public Student(String fName, String lName, String email, String phoneNum, Address address, int idNum,
                   Date dob, double gpa, Date dateEnrolled, ArrayList<String> coursesWanted) {
        super(fName, lName, email, phoneNum, address, idNum);
        this.dob = dob;
        this.gpa = gpa;
        this.dateEnrolled = dateEnrolled;
        this.coursesWanted = coursesWanted;
    }

    public Student(String fName, String lName, String email, String phoneNum,
                   String streetAddress, String city, String state, String zipcode, int idNum,
                   int yearBorn, int monthBorn, int dayBorn, double gpa,
                   int yearEnrolled, int monthEnrolled, int dayEnrolled, String ... coursesWanted) {

        this(fName, lName, email, phoneNum, new Address(streetAddress, city, state, zipcode),
                idNum, new Date(yearBorn, monthBorn, dayBorn), gpa,
                new Date(yearEnrolled, monthEnrolled, dayEnrolled),
                new ArrayList<String>(Arrays.asList(coursesWanted)));

    }

    public Student() {
        this("", "", "", "", new Address(), 0, new Date(), 0.0, new Date(), new ArrayList<>());
    }

    public Date getDob() {
        return dob;
    }

    public Student setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public double getGpa() {
        return gpa;
    }

    public Student setGpa(double gpa) {
        this.gpa = gpa;
        return this;
    }

    public Date getDateEnrolled() {
        return dateEnrolled;
    }

    public Student setDateEnrolled(Date dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
        return this;
    }

    public ArrayList<String> getCoursesWanted() {
        return coursesWanted;
    }

    public Student setCoursesWanted(ArrayList<String> coursesWanted) {
        this.coursesWanted = coursesWanted;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder studentString = new StringBuilder();
        studentString.append(super.toString());
        studentString.append("\nDOB: " + dob);
        studentString.append("\nGPA: " + gpa);
        studentString.append("\nDate Enrolled: " + dateEnrolled);

        return studentString.toString();
    }
}
