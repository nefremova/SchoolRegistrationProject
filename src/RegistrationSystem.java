import cs4a.RegistrationLibrary.ClassSchedule.*;
import cs4a.RegistrationLibrary.CourseLibrary.*;
import cs4a.RegistrationLibrary.FacultyLibrary.*;
import cs4a.RegistrationLibrary.IdAlgorithms.IdFactory;
import cs4a.RegistrationLibrary.Interfaces.*;
import cs4a.RegistrationLibrary.ParameterLibrary.*;
import cs4a.RegistrationLibrary.ScheduleAlgorithms.ScheduleFactory;
import cs4a.RegistrationLibrary.StudentLibrary.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * <h1>School Registration System</h1>
 * This program generates text files for registration and scheduling
 * of students, faculty, and courses
 * based on text file input.
 *
 * <p>
 * <b>Note:</b> The scheduling and id generating algorithms are
 * flexible through the use of factories
 *
 * @author  Natalia Efremova
 * @version 3.2
 * @since   2018-5-2
 */

public class RegistrationSystem {
	/**
	 * This is the main method of the program
	 * @param args Unused
	 * @return Nothing
	 * @exception FileNotFoundException
	 * @exception InputMismatchException
	 * @exception Exception
	 * @see Throwable
	 */
	public static void main(String[] args) {

		try {
			// Read parameters for Person ID from file and generate Person ID algorithm
			IdGenerationParameters PersonIdParameters = IdParameterReader.readParameters("PersonIdParameters.txt");
			IdGenerator personIdGenerator = IdFactory.createIdGenerator(PersonIdParameters);

			// Read parameters fro Session ID from file and generate Session ID algorithm
			IdGenerationParameters SessionIdParameters = IdParameterReader.readParameters("SessionIdParameters.txt"); // Read ID Parameters from file
			IdGenerator sessionIdGenerator = IdFactory.createIdGenerator(SessionIdParameters);

			// Read Students, Faculty, and Courses from text files
			ArrayList<Student> students = StudentReader.readStudents(personIdGenerator, "Students.txt");
			ArrayList<Faculty> faculty = FacultyReader.readFaculty(personIdGenerator, "Faculty.txt");
			ArrayList<Course> courses = CourseReader.readCourses("Courses.txt");

			// Read schedule parameters from text file and generate scheduling algorithm
			ScheduleParameters sParameters = ScheduleParameterReader.readParameters("ScheduleParameters.txt");
			ScheduleAlgorithm scheduler = ScheduleFactory.createScheduler(sParameters);

			// Sort students, faculty, and courses into a comprehensive schedule
			ClassSchedule result = scheduler.schedule(students, faculty, courses, sParameters, sessionIdGenerator);

			// Print Scheduled Courses
			CoursePrinter cPrinter = new CoursePrinter("ScheduledCourses.txt", courses, result);
			cPrinter.printScheduledCourses();

			// Print Unscheduled Courses
			cPrinter.setOutput("UnscheduledCourses.txt");
			cPrinter.printUnscheduledCourses();

			// Print Faculty Schedules
			FacultyPrinter fPrinter = new FacultyPrinter("FacultySchedule.txt", faculty, result);
			fPrinter.printFaculty();

			// Print Scheduled Students
			StudentPrinter sPrinter = new StudentPrinter("ScheduledStudents.txt", students, result);
			sPrinter.printScheduledStudents();

			// Print Unscheduled Students
			sPrinter.setOutput("UnscheduledStudents.txt");
			sPrinter.printUnscheduledStudents();

			// Print stats of program
			printStats(sPrinter.getNumStudents(), fPrinter.getNumFaculty(), cPrinter.getNumCourses(),
					cPrinter.getNumSessions(), cPrinter.getNumUnscheduledCourses(), sPrinter.getNumUnscheduledStudents());
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

	/**
	 * This method is used to print the stats of the whole program to the consol
	 * @param numStudents Total number of students
	 * @param numFaculty Total number of faculty
	 * @param numCourses Total number of courses
	 * @param numSessions Total number of sessions
	 * @param numUnscheduledCourses Total number of unscheduled courses
	 * @param numUnscheduledStudents Total number of unscheduled students
	 * @return Nothing
	 */
	public static void printStats(int numStudents, int numFaculty, int numCourses,
								  int numSessions, int numUnscheduledCourses, int numUnscheduledStudents) {

		System.out.println("Total Students: " + numStudents);
		System.out.println("Total Faculty: " + numFaculty);
		System.out.println("Total Courses: " + numCourses);
		System.out.println("Total Scheduled Sessions: "+ numSessions);
		System.out.println("Total Unscheduled Courses: " + numUnscheduledCourses);
		System.out.println("Total Unscheduled Students: " + numUnscheduledStudents);

	}
}
