import java.util.ArrayList;

public interface ScheduleAlgorithm {
	public Schedule schedule(
			ArrayList<Student> students,
			ArrayList<Faculty> faculty,
			ArrayList<Course> courses,
			ScheduleParameters parameters);
}
