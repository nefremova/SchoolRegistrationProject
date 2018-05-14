import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		try {
			IdGenerationParameters PersonIdParameters = IdParameterReader.readParameters("PersonIdParameters.txt");
			IdGenerator personIdGenerator = IdFactory.createIdGenerator(PersonIdParameters);

			IdGenerationParameters SessionIdParameters = IdParameterReader.readParameters("SessionIdParameters.txt"); // Read ID Parameters from file
			IdGenerator sessionIdGenerator = IdFactory.createIdGenerator(SessionIdParameters);

			ArrayList<Student> students = StudentReader.readStudents(personIdGenerator);
			ArrayList<Faculty> faculty = FacultyReader.readFaculty(personIdGenerator);
			ArrayList<Course> courses = CourseReader.readCourses();
			ScheduleParameters sParameters = ScheduleParameterReader.readParameters("ScheduleParameters.txt");

			ScheduleAlgorithm scheduler = ScheduleFactory.createScheduler(sParameters);
			ClassSchedule result = scheduler.schedule(students, faculty, courses, sParameters, sessionIdGenerator);

		}
		catch (Exception ex){
			System.out.println("Error: File Not Found.");
		}


	}

}
