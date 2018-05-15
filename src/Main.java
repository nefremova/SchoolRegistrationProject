import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

			PrintWriter output = new PrintWriter(new File("ScheduledCourses.txt"));

			printScheduledCourses(result, output);
		}

		catch(FileNotFoundException ex) {
			System.out.println("File " + ex.getMessage() + " not found.");
		}
		catch(InputMismatchException ex) {
			System.out.println("File " + ex.getMessage() +  " contains invalid format.");
		}
	}

	public static void printScheduledCourses(ClassSchedule schedule, PrintWriter output) {
		for (CourseSession session : schedule.getCourseSessions()) {
			if (session.isScheduled()) {
				output.println(session.toString());
				output.println();
				output.println();
			}
		}

		output.flush();
	}

}
