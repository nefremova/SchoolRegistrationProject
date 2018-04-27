import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Student> students; // = Read students from student file
		ArrayList<Faculty> faculty;  // = Read faculty from faculty file 
		ArrayList<Course> courses;   // = Read courses from courses file 
		ScheduleParameters parameters; // = Read parameters from paramenter file 

		ScheduleAlgorithm scheduler = ScheduleFactory.createScheduler(parameters);
		Schedule result = scheduler.schedule(students, faculty, courses, parameters);
		result.print();
	}

}
