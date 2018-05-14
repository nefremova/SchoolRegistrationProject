public class ScheduleParameters {
	public boolean useSmartScheduler;
	int sessionsPerStudent;
	int sessionsPerCourse;
	int sessionsPerInstructor;

	public ScheduleParameters(boolean useSmartScheduler, int sessionsPerCourse, int sessionsPerStudent, int sessionsPerInstructor) {
		this.useSmartScheduler = useSmartScheduler;
		this.sessionsPerCourse = sessionsPerCourse;
		this.sessionsPerStudent = sessionsPerStudent;
		this.sessionsPerInstructor = sessionsPerInstructor;
	}

	public ScheduleParameters() {
		this(false, 0, 0, 0);
	}

	public boolean isUseSmartScheduler() {
		return useSmartScheduler;
	}

	public void setUseSmartScheduler(boolean useSmartScheduler) {
		this.useSmartScheduler = useSmartScheduler;
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
