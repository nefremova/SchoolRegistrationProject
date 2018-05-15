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
	 * Generate an arraylist of course sessions related to a student
	 * @param student
	 * @return
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
	 * Generate an arraylist of course sessions related to a faculty member
	 * @param faculty
	 * @return
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
	 * @param course
	 * @return
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
	 * Return true if a course is unscheduled (not even one session scheduled)
	 * @param course
	 * @return
	 */
	public boolean isUnscheduled(Course course) {
		for (CourseSession session : courseSessions) {
			if (session.isScheduled() && session.getCourseBase().equals(course)) {
				return false;
			}
		}
		return true;
	}
}
