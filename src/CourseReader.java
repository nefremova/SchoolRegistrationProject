import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseReader {
    public static ArrayList<Course> readCourses() throws Exception {
        Scanner input = new Scanner(new File("Courses.txt"));
        ArrayList<Course> courses = new ArrayList<>();

        while (input.hasNext()) {
            String department = input.nextLine();
            String code = input.nextLine();
            String description = input.nextLine();
            int minStudents = input.nextInt();
            int maxStudents = input.nextInt();

            if (minStudents < 0 || maxStudents <= 0 || minStudents >= maxStudents) {
                System.out.println("Invalid Course Parameters. Check Course File.");
                System.exit(0);
            }

            courses.add(new Course(department, code, description, minStudents, maxStudents));
        }

        return courses;
    }
}
