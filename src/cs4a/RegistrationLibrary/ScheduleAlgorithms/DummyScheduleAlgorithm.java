package cs4a.RegistrationLibrary.ScheduleAlgorithms;

import cs4a.RegistrationLibrary.ClassSchedule.ClassSchedule;
import cs4a.RegistrationLibrary.CourseLibrary.Course;
import cs4a.RegistrationLibrary.CourseLibrary.CourseSession;
import cs4a.RegistrationLibrary.FacultyLibrary.Faculty;
import cs4a.RegistrationLibrary.Interfaces.IdGenerator;
import cs4a.RegistrationLibrary.Interfaces.ScheduleAlgorithm;
import cs4a.RegistrationLibrary.ParameterLibrary.ScheduleParameters;
import cs4a.RegistrationLibrary.StudentLibrary.Student;

import java.util.ArrayList;

/**
 * Assign faculty to courses on a first come basis
 * Assign students to courses on a first come basis
 * Courses are chosen based on the faculty member's list of courses available to teach
 * and student's wishlist of courses to take
 */
public class DummyScheduleAlgorithm implements ScheduleAlgorithm {
	@Override
	public ClassSchedule schedule(ArrayList<Student> students, ArrayList<Faculty> faculty, ArrayList<Course> courses,
								  ScheduleParameters parameters, IdGenerator idGenerator) {

		ArrayList<CourseSession> courseSessions = new ArrayList<>();

		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < parameters.getSessionsPerCourse(); j++) {
				Course courseBase = courses.get(i);
				Faculty instructor = new Faculty();

				for (Faculty f : faculty) {
					if (f.getCoursesTaught().contains(courseBase) && f.getNumCourses() < parameters.getSessionsPerInstructor()) {
						instructor = f;
						f.addCourse();
						break;
					}
				}

				ArrayList<Student> studentsInSession = new ArrayList<>();

				for (Student s : students) {
					if (s.getCoursesWanted().contains(courseBase) // Student wants to take course
							&& s.getNumCourses() < parameters.getSessionsPerStudent() // Student is able to take course
							&& studentsInSession.size() < courseBase.getMaxStudents())  { // Session is not full
						studentsInSession.add(s);
						s.addCourse();
						s.getCoursesWanted().remove(courseBase);
					}
				}

				int id = idGenerator.nextId();

				courseSessions.add(new CourseSession(courseBase, instructor, studentsInSession, id));
			}
		}

		return new ClassSchedule(courseSessions);
	}
}
