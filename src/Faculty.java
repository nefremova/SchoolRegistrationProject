import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Faculty extends Person {
    private Date dateHired;
    private boolean isTenured;
    ArrayList<String> coursesTaught;

    public Faculty(String fName, String lName, String email, String phoneNum, Address address,
                   int idNum, Date dateHired, boolean isTenured, ArrayList<String> coursesTaught) {

        super(fName, lName, email, phoneNum, address, idNum);
        this.dateHired = dateHired;
        this.isTenured = isTenured;
        this.coursesTaught = coursesTaught;
    }

    public Faculty(String fName, String lName, String email, String phoneNum, String streetAddress, String city,
                   String state, String zipcode, int idNum, Date dateHired, boolean isTenured, String ... coursesTaught) {
        this(fName, lName, email, phoneNum, new Address(streetAddress, city, state, zipcode),
                idNum, dateHired, isTenured, new ArrayList<String>(Arrays.asList(coursesTaught)));
    }

    public Faculty() {
        this("", "", "", "", new Address(), 0, new Date(), false, new ArrayList<String>());
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Faculty setDateHired(Date dateHired) {
        this.dateHired = dateHired;
        return this;
    }

    public boolean isTenured() {
        return isTenured;
    }

    public Faculty setTenured(boolean tenured) {
        isTenured = tenured;
        return this;
    }

    public ArrayList<String> getCoursesTaught() {
        return coursesTaught;
    }

    public Faculty setCoursesTaught(ArrayList<String> coursesTaught) {
        this.coursesTaught = coursesTaught;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder facultyString = new StringBuilder();
        SimpleDateFormat mdyFormat = new SimpleDateFormat("MM/dd/yyyy");

        facultyString.append(super.toString());
        facultyString.append("\nDate Hired: " + mdyFormat.format(dateHired));
        facultyString.append("\nTenured?: " + isTenured);

        return facultyString.toString();
    }
}
