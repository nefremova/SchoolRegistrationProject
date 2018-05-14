import java.util.ArrayList;

public class ClassSchedule {

	private ArrayList<CourseSession> courseSessions;

	public ClassSchedule(ArrayList<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}

	public ArrayList<CourseSession> getStudentSchedule(Student student) {
		ArrayList<CourseSession> studentSchedule = new ArrayList<>();

		for (CourseSession session : courseSessions) {
			for (Student s : session.students) {
				if (s.equals(student)) {
					studentSchedule.add(session);
					break;
				}
			}
		}

		return studentSchedule;
	}

	public ArrayList<CourseSession> getFacultySchedule(Faculty faculty) {
		ArrayList<CourseSession> facultySchedule = new ArrayList<>();

		for (CourseSession session : courseSessions) {
			if (session.instructor.equals(faculty)) {
				facultySchedule.add(session);
			}
		}

		return facultySchedule;
	}

	public ArrayList<CourseSession> getSessionsForCourse(Course course) {
		ArrayList<CourseSession> courseSessions = new ArrayList<>();

		for (CourseSession session : courseSessions) {
			if (session.courseBase.equals(course)) {
				courseSessions.add(session);
			}
		}

		return courseSessions;
	}

}
