import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseReader {
    public static ArrayList<Course> readCourses(String pathname)
            throws FileNotFoundException, InputMismatchException {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(pathname));

            while (input.hasNext()) {
                int minStudents = input.nextInt();
                int maxStudents = input.nextInt();
                String department = input.next();
                String code = input.next();
                String newline = input.nextLine();
                String description = input.nextLine();

                if (minStudents < 0 || maxStudents <= 0 || minStudents >= maxStudents) {
                    System.out.println("Invalid Course Parameters. Check Course File.");
                    System.exit(0);
                }

                courses.add(new Course(department, code, description, minStudents, maxStudents));
            }
        }
        catch(FileNotFoundException ex) {
            throw new FileNotFoundException(pathname);
        }
        catch(InputMismatchException ex) {
            throw new InputMismatchException(pathname);
        }

        return courses;
    }
}
