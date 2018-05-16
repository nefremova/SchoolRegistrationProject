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
import java.util.Comparator;

/**
 * Rank students by seniority and gpa
 * then implement dummy sorting algorithm
 */

public class SmartScheduleAlgorithm implements ScheduleAlgorithm {
	/**
	 * Sort students by rank, then sort them into classes
	 * based on their wishlist. Sort faculty in order based
	 * on classes available to teach.
	 *
	 * @param students ArrayList of Student objects
	 * @param faculty ArrayList of Faculty objects
	 * @param courses ArrayList of Course objects
	 * @param parameters ScheduleParameters object
	 * @param idGenerator idGenerator interface which implements nextId()
	 * @return ClassSchedule schedule
	 */

	@Override
	public ClassSchedule schedule(ArrayList<Student> students, ArrayList<Faculty> faculty, ArrayList<Course> courses,
								  ScheduleParameters parameters, IdGenerator idGenerator) {

		ArrayList<CourseSession> courseSessions = new ArrayList<>();
		sortStudents(students);

		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < parameters.getSessionsPerCourse(); j++) {
				Course courseBase = courses.get(i);
				Faculty instructor = new Faculty();

				for (Faculty f : faculty) {
					if (f.getCoursesTaught().contains(courseBase.getCourseId()) // instructor is able to teach course
                            && f.getNumCourses() < parameters.getSessionsPerInstructor()) { // instructor has room in schedule
						f.addCourse();
						instructor = f;
						break;
					}
				}

				ArrayList<Student> studentsInSession = new ArrayList<>();

				for (Student s : students) {
					if (s.getCoursesWanted().contains(courseBase.getCourseId()) // Student wants to take course
							&& s.getNumCourses() < parameters.getSessionsPerStudent() // Student has room in schedule
							&& studentsInSession.size() < courseBase.getMaxStudents())  { // Session is not full

						studentsInSession.add(s);
						s.addCourse();
						s.getCoursesWanted().remove(courseBase.getCourseId());
					}
				}

				int id = idGenerator.nextId();

				courseSessions.add(new CourseSession(courseBase, instructor, studentsInSession, id));
			}
		}

		return new ClassSchedule(courseSessions);
	}

	/**
	 * Generate a rank for a student based on their seniority and GPA
	 * @param s Student object
	 * @return int This returns a student's rank
	 */

	private int getStudentRank(Student s) {
		return s.getDateEnrolled().getHours() / 1000000 - (int)(s.getGpa() * 10);

	}


	private final Comparator<Student> RankComparator = new Comparator<Student>() {
		/**
		 * Compare two student objects
		 * @param s1 First student
		 * @param s2 Second student
		 * @return int This returns 1 if s1 > s2, 0 if s1 == s2, and -1 if s2 > s1.
		 */

		@Override
		public int compare(Student s1, Student s2) {
			if (getStudentRank(s1) > getStudentRank(s2)) {
				return 1;
			}
			else if (getStudentRank(s1) == getStudentRank(s2)) {
				return 0;
			}
			else {
				return -1;
			}
		}
	};

	/**
	 * Sort students in ArrayList by ranking
	 * @param students ArrayList of Student objects
	 */

	private void sortStudents(ArrayList<Student> students) {
		students.sort(RankComparator);
	}

}
