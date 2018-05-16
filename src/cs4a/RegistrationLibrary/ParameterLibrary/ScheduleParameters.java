package cs4a.RegistrationLibrary.ParameterLibrary;

/**
 * This class contains information about schedule parameters
 * such as which algorithm to use, number of sessions per course, sessions per student
 * and sessions per instructor
 */

public class ScheduleParameters {
	public boolean useSmartScheduler;
	private int sessionsPerStudent;
	private int sessionsPerCourse;
	private int sessionsPerInstructor;

	public ScheduleParameters(boolean useSmartScheduler, int sessionsPerCourse, int sessionsPerStudent, int sessionsPerInstructor) {
		this.useSmartScheduler = useSmartScheduler;
		this.sessionsPerCourse = sessionsPerCourse;
		this.sessionsPerStudent = sessionsPerStudent;
		this.sessionsPerInstructor = sessionsPerInstructor;
	}

	public ScheduleParameters() {
		this(false, 0, 0, 0);
	}

	public int getSessionsPerStudent() {
		return sessionsPerStudent;
	}

	public void setSessionsPerStudent(int sessionsPerStudent) {
		this.sessionsPerStudent = sessionsPerStudent;
	}

	public int getSessionsPerCourse() {
		return sessionsPerCourse;
	}

	public void setSessionsPerCourse(int sessionsPerCourse) {
		this.sessionsPerCourse = sessionsPerCourse;
	}

	public int getSessionsPerInstructor() {
		return sessionsPerInstructor;
	}

	public void setSessionsPerInstructor(int sessionsPerInstructor) {
		this.sessionsPerInstructor = sessionsPerInstructor;
	}
}
