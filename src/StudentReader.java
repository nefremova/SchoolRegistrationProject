import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class StudentReader {
    private static final int FNAME = 0;
    private static final int LNAME = 1;
    private static final int EMAIL = 2;
    private static final int PHONE = 3;
    private static final int STREET = 4;
    private static final int CITY = 5;
    private static final int STATE = 6;
    private static final int ZIP = 7;
    private static final int DOB = 8;
    private static final int GPA = 9;
    private static final int ENROLLDATE = 10;

    public static ArrayList<Student> readStudents(IdGenerator idGenerator, String pathname)
            throws Exception {
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            Scanner input = new Scanner(new File(pathname));

            while (input.hasNext()) {
                String line = input.nextLine();
                ArrayList<String> items = new ArrayList<String>(Arrays.asList(line.split("\\s*,\\s*")));

                String fName = items.get(FNAME);
                String lName = items.get(LNAME);
                String email = items.get(EMAIL);
                String phoneNum = items.get(PHONE);
                Address address = new Address(items.get(STREET), items.get(CITY), items.get(STATE), items.get(ZIP));
                int id = idGenerator.nextId();
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date dob = df.parse(items.get(DOB));
                double gpa = Double.parseDouble(items.get(GPA));
                Date dateEnrolled = df.parse(items.get(ENROLLDATE));

                ArrayList<String> courseIdList = new ArrayList<String>();

                for (int i = ENROLLDATE; i < items.size(); i++) {
                    courseIdList.add(items.get(i));
                }

                Student student = new Student();

                student.setDob(dob).setGpa(gpa)
                        .setDateEnrolled(dateEnrolled).setCoursesWanted(courseIdList)
                        .setfName(fName).setlName(lName).setEmail(email).setPhoneNum(phoneNum)
                        .setAddress(address)
                        .setIdNum(id);

                students.add(student);
            }
        }
        catch(FileNotFoundException ex) {
            throw new FileNotFoundException(pathname);
        }
        catch(InputMismatchException ex) {
            throw new InputMismatchException(pathname);
        }

        return students;
    }

}
