import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentReader {
    public static ArrayList<Student> readStudents(IdGenerator idGenerator) throws Exception {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner input = new Scanner(new File("Students.txt"));

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
            int yearBorn = input.nextInt();
            int monthBorn = input.nextInt();
            int dayBorn = input.nextInt();
            double gpa = input.nextDouble();
            int yearEnrolled = input.nextInt();
            int monthEnrolled = input.nextInt();
            int dayEnrolled = input.nextInt();

            ArrayList<String> courseIdList = new ArrayList<>();
            String courseId = input.nextLine();

            while (!courseId.contains(";")) {
                courseIdList.add(courseId);
                courseId = input.nextLine();
            }

            Student student = new Student();

            student.setDob(new Date(yearBorn, monthBorn, dayBorn)).setGpa(gpa)
                    .setDateEnrolled(new Date(yearEnrolled, monthEnrolled, dayEnrolled)).setCoursesWanted(courseIdList)
                    .setfName(fName).setlName(lName).setEmail(email).setPhoneNum(phoneNum)
                    .setAddress(new Address(streetAddress, city, state, zipcode))
                    .setIdNum(id);

            students.add(student);
        }

        return students;
    }

}
