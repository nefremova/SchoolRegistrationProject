import java.util.ArrayList;

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
					if (f.getCoursesTaught().contains(courseBase) && f.numCourses < parameters.sessionsPerInstructor) {
						instructor = f;
						break;
					}
				}

				ArrayList<Student> studentsInSession = new ArrayList<>();

				for (Student s : students) {
					if (s.getCoursesWanted().contains(courseBase) // Student wants to take course
							&& s.numCourses < parameters.getSessionsPerStudent() // Student is able to take course
							&& studentsInSession.size() < courseBase.getMaxStudents())  { // Session is not full
						studentsInSession.add(s);
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
