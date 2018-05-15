import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FacultyReader {
    public static ArrayList<Faculty> readFaculty(IdGenerator idGenerator, String pathname)
            throws FileNotFoundException, InputMismatchException {
        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
        try {
            Scanner input = new Scanner(new File(pathname));

            while (input.hasNext()) {
                String fName = input.nextLine();
                String lName = input.nextLine();
                String email = input.nextLine();
                String phoneNum = input.nextLine();
                String streetAddress = input.nextLine();
                String city = input.nextLine();
                String state = input.nextLine();
                String zipcode = input.nextLine();
                int id = idGenerator.nextId();
                int yearHired = input.nextInt();
                int monthHired = input.nextInt();
                int dayHired = input.nextInt();
                boolean isTenured = input.nextBoolean();

                ArrayList<String> courseIdList = new ArrayList<>();
                String newline = input.nextLine();
                String courseId = input.nextLine();

                while (!courseId.contains(";")) {
                    courseIdList.add(courseId);
                    courseId = input.nextLine();
                }

                Faculty faculty = new Faculty();

                faculty.setDateHired(new Date(yearHired, monthHired, dayHired)).setTenured(isTenured)
                        .setCoursesTaught(courseIdList).setfName(fName).setlName(lName)
                        .setEmail(email).setPhoneNum(phoneNum).setAddress(new Address(streetAddress, city, state, zipcode))
                        .setIdNum(id);

                facultyList.add(faculty);
            }
        }
        catch(FileNotFoundException ex) {
            throw new FileNotFoundException(pathname);
        }
        catch(InputMismatchException ex) {
            throw new InputMismatchException(pathname);
        }
        return facultyList;
    }

}

