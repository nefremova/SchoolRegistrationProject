import java.io.PrintWriter;
import java.util.ArrayList;

public class ClassSchedule {

	private ArrayList<CourseSession> courseSessions;

	public ClassSchedule(ArrayList<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}

	public ArrayList<CourseSession> getCourseSessions() {
		return courseSessions;
	}

	public void setCourseSessions(ArrayList<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}

	public ArrayList<CourseSession> getStudentSchedule(Student student) {
		ArrayList<CourseSession> studentSchedule = new ArrayList<>();

		for (CourseSession session : courseSessions) {
			for (Student s : session.getStudents()) {
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
			if (session.getInstructor().equals(faculty)) {
				facultySchedule.add(session);
			}
		}

		return facultySchedule;
	}

	public ArrayList<CourseSession> getScheduledSessionsForCourse(Course course) {
		ArrayList<CourseSession> cSessions = new ArrayList<>();

		for (CourseSession session : courseSessions) {
			if (course.equals(session.getCourseBase()) && session.isScheduled()) {
				cSessions.add(session);
			}
		}

		return cSessions;
	}

	public boolean isUnscheduled(Course course) {
		for (CourseSession session : courseSessions) {
			if (session.isScheduled() && session.getCourseBase().equals(course)) {
				return false;
			}
		}
		return true;
	}
}
