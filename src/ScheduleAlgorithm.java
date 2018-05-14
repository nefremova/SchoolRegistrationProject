import java.util.ArrayList;

public interface ScheduleAlgorithm {
	public ClassSchedule schedule(
			ArrayList<Student> students,
			ArrayList<Faculty> faculty,
			ArrayList<Course> courses,
			ScheduleParameters parameters,
			IdGenerator idGenerator);
}
