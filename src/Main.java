import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Create student/faculty ID generator class
		
		ArrayList<Student> students; // = Read students from student file (using ID generator)
		ArrayList<Faculty> faculty;  // = Read faculty from faculty file 
		ArrayList<Course> courses;   // = Read courses from courses file 
		ScheduleParameters parameters; // = Read parameters from paramenter file 

		ScheduleAlgorithm scheduler = ScheduleFactory.createScheduler(parameters);
		Schedule result = scheduler.schedule(students, faculty, courses, parameters);
		result.print();
	}

}
