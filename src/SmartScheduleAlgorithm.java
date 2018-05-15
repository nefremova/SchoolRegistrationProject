import java.util.ArrayList;
import java.util.Comparator;

public class SmartScheduleAlgorithm implements ScheduleAlgorithm {

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
					if (f.getCoursesTaught().contains(courseBase.getCourseId())
                            && f.numCourses < parameters.sessionsPerInstructor) {
						instructor = f;
						break;
					}
				}

				ArrayList<Student> studentsInSession = new ArrayList<>();

				for (Student s : students) {
					if (s.getCoursesWanted().contains(courseBase.getCourseId()) // Student wants to take course
							&& s.numCourses < parameters.getSessionsPerStudent() // Student is able to take course
							&& studentsInSession.size() < courseBase.getMaxStudents())  { // Session is not full
						studentsInSession.add(s);
						s.getCoursesWanted().remove(courseBase.getCourseId());
					}
				}

				int id = idGenerator.nextId();

				courseSessions.add(new CourseSession(courseBase, instructor, studentsInSession, id));
			}
		}

		return new ClassSchedule(courseSessions);
	}

	private int getStudentRank(Student s) {
		return s.getDateEnrolled().getHours() / 1000000 - (int)(s.getGpa() * 10);

	}

	private final Comparator<Student> RankComparator = new Comparator<Student>() {
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

	private void sortStudents(ArrayList<Student> students) {
		students.sort(RankComparator);
	}

}
