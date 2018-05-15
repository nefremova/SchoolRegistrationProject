import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {

		try {
			IdGenerationParameters PersonIdParameters = IdParameterReader.readParameters("PersonIdParameters.txt");
			IdGenerator personIdGenerator = IdFactory.createIdGenerator(PersonIdParameters);

			IdGenerationParameters SessionIdParameters = IdParameterReader.readParameters("SessionIdParameters.txt"); // Read ID Parameters from file
			IdGenerator sessionIdGenerator = IdFactory.createIdGenerator(SessionIdParameters);

			ArrayList<Student> students = StudentReader.readStudents(personIdGenerator, "Students.txt");
			ArrayList<Faculty> faculty = FacultyReader.readFaculty(personIdGenerator, "Faculty.txt");

			ArrayList<Course> courses = CourseReader.readCourses("Courses.txt");
			ScheduleParameters sParameters = ScheduleParameterReader.readParameters("ScheduleParameters.txt");

			ScheduleAlgorithm scheduler = ScheduleFactory.createScheduler(sParameters);
			ClassSchedule result = scheduler.schedule(students, faculty, courses, sParameters, sessionIdGenerator);

			CoursePrinter cPrinter = new CoursePrinter("ScheduledStudents.txt", courses, result);
			cPrinter.printScheduledCourses();

			cPrinter.setOutput("UnscheduledStudents.txt");
			cPrinter.printUnscheduledCourses();

			FacultyPrinter fPrinter = new FacultyPrinter("FacultySchedule.txt", faculty, result);
			fPrinter.printFaculty();

			StudentPrinter sPrinter = new StudentPrinter("ScheduledStudents.txt", students, result);
			sPrinter.printScheduledStudents();

			sPrinter.setOutput("UnscheduledStudents.txt");
			sPrinter.printUnscheduledStudents();
		}

		catch(FileNotFoundException ex) {
			System.out.println("File " + ex.getMessage() + " not found.");
		}
		catch(InputMismatchException ex) {
			System.out.println("File " + ex.getMessage() +  " contains invalid format.");
		}
		catch(Exception ex) {
			System.out.println("Exception occured: " + ex);
		}
	}
}
