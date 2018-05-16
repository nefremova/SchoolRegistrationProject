package cs4a.RegistrationLibrary.FacultyLibrary;

import cs4a.RegistrationLibrary.Common.Address;
import cs4a.RegistrationLibrary.Interfaces.IdGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class reads faculty information from a file
 */

public class FacultyReader {
    private static final int FNAME = 0;
    private static final int LNAME = 1;
    private static final int EMAIL = 2;
    private static final int PHONE = 3;
    private static final int STREET = 4;
    private static final int CITY = 5;
    private static final int STATE = 6;
    private static final int ZIP = 7;
    private static final int HIREDATE = 8;
    private static final int ISTENURED = 9;

    /**
     * Read faculty information one line at a time.
     * Parse each line into an Arraylist of strings separated by commas.
     * Use constants to assign each element of the Arraylist to a data field in faculty
     *
     * @param idGenerator Interface for generating a unique id
     * @param pathname Pathname to file to read data from
     * @return ArrayList<Faculty> This returns all faculty as an ArrayList
     * @throws Exception FileNotFoundException, InputMismatchException both handled with pathname as message
     */

    public static ArrayList<Faculty> readFaculty(IdGenerator idGenerator, String pathname)
            throws Exception {

        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();

        try {
            Scanner input = new Scanner(new File(pathname));

            while (input.hasNext()) {
                // Read line
                String line = input.nextLine();

                // Separate line into ArrayList<String> by commas surrounded by whitespace
                ArrayList<String> items = new ArrayList<String>(Arrays.asList(line.split("\\s*,\\s*")));

                String fName = items.get(FNAME);
                String lName = items.get(LNAME);
                String email = items.get(EMAIL);
                String phoneNum = items.get(PHONE);
                Address address = new Address(items.get(STREET), items.get(CITY), items.get(STATE), items.get(ZIP));

                int id = idGenerator.nextId(); // Generate id

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date dateHired = df.parse(items.get(HIREDATE));

                boolean isTenured = Boolean.parseBoolean(items.get(ISTENURED));

                ArrayList<String> coursesTaught = new ArrayList<String>();

                for (int i = ISTENURED; i < items.size(); i++) {  // Input a variable number of courses taught
                    coursesTaught.add(items.get(i));
                }

                Faculty faculty = new Faculty();
                faculty.setDateHired(dateHired).setTenured(isTenured)
                        .setCoursesTaught(coursesTaught).setfName(fName).setlName(lName)
                        .setEmail(email).setPhoneNum(phoneNum).setAddress(address)
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

