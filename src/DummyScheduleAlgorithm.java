import java.util.ArrayList;

public class DummyScheduleAlgorithm implements ScheduleAlgorithm {
	@Override
	public Schedule schedule(
			ArrayList<Student> students,
			ArrayList<Faculty> faculty,
			ArrayList<Course> courses,
			ScheduleParameters parameters) {
		// TODO Write scheduling algorithm here
		return new Schedule(null, null, null);
	}
}
