package cs4a.RegistrationLibrary.ClassSchedule;

import cs4a.RegistrationLibrary.CourseLibrary.Course;
import cs4a.RegistrationLibrary.CourseLibrary.CourseSession;
import cs4a.RegistrationLibrary.FacultyLibrary.Faculty;
import cs4a.RegistrationLibrary.StudentLibrary.Student;

import java.util.ArrayList;

/**
 * This class holds an ArrayList of course sessions
 * and contains methods that give information about the schedule
 */

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

	/**
	 * Generate an ArrayList of course sessions related to a student
	 * @param student Student object
	 * @return ArrayList<CourseSession> This return's the student's schedule
	 */

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

	/**
	 * Generate an ArrayList of course sessions related to a faculty member
	 * @param faculty Faculty object
	 * @return ArrayList<CourseSession> This return's the faculty member's schedule.
	 */

	public ArrayList<CourseSession> getFacultySchedule(Faculty faculty) {
		ArrayList<CourseSession> facultySchedule = new ArrayList<>();

		for (CourseSession session : courseSessions) {
			if (session.getInstructor().equals(faculty)) {
				facultySchedule.add(session);
			}
		}

		return facultySchedule;
	}

	/**
	 * Generate an arraylist of course sessions related to a course
	 * @param course Course object
	 * @return ArrayList<CourseSession> This returns all scheduled sessions for the course
	 */
	public ArrayList<CourseSession> getScheduledSessionsForCourse(Course course) {
		ArrayList<CourseSession> cSessions = new ArrayList<>();

		for (CourseSession session : courseSessions) {
			if (course.equals(session.getCourseBase()) && session.isScheduled()) {
				cSessions.add(session);
			}
		}

		return cSessions;
	}

	/**
	 * Check if a schedule contains a course that is scheduled.
	 * @param course Course object
	 * @return boolean This returns true if a course has at least one scheduled session.
	 */

	public boolean hasScheduled(Course course) {
		for (CourseSession session : courseSessions) {
			if (session.isScheduled() && session.getCourseBase().equals(course)) {
				return true;
			}
		}
		return false;
	}
}
