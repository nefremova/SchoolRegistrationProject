import java.util.ArrayList;

public class Schedule {
	private final ArrayList<StudentSchedule> studentSchedule;
	private final ArrayList<FacultySchedule> facultySchedule;
	private final ArrayList<CourseSession> courseSessions;
	
	public Schedule(
			ArrayList<StudentSchedule> studentSchedule,
			ArrayList<FacultySchedule> facultySchedule,
			ArrayList<CourseSession> courseSessions) {
		this.studentSchedule = studentSchedule;
		this.facultySchedule = facultySchedule;
		this.courseSessions = courseSessions;
	}

	public ArrayList<StudentSchedule> getStudentSchedule() {
		return studentSchedule;
	}

	public ArrayList<FacultySchedule> getFacultySchedule() {
		return facultySchedule;
	}

	public ArrayList<CourseSession> getCourseSessions() {
		return courseSessions;
	}
	
	public void print() {
		// Print the thing
	}
}
