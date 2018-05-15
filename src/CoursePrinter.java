import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CoursePrinter {
    private PrintWriter output;
    private ArrayList<Course> courses;
    private ClassSchedule schedule;

    public CoursePrinter(PrintWriter output, ArrayList<Course> courses, ClassSchedule schedule) {
        this.output = output;
        this.courses = courses;
        this.schedule = schedule;
    }

    public CoursePrinter(String pathname, ArrayList<Course> courses, ClassSchedule schedule) throws FileNotFoundException {
        this(new PrintWriter(new File(pathname)), courses, schedule);
    }

    public PrintWriter getOutput() {
        return output;
    }

    public void setOutput(PrintWriter output) {
        this.output = output;
    }

    public void setOutput(String pathname) throws FileNotFoundException {
        this.output = new PrintWriter(new File(pathname));
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ClassSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(ClassSchedule schedule) {
        this.schedule = schedule;
    }

    public void printScheduledCourses() {
        for (Course course : courses) {
            if (!schedule.isUnscheduled(course))  {
                output.println(course);
                output.println();

                for (CourseSession session : schedule.getScheduledSessionsForCourse(course)) {
                    output.println(session);
                    output.println();
                }
                output.flush();
            }
            output.println();
            output.println();
        }
        output.flush();
    }

    public void printUnscheduledCourses() {
        for (Course course : courses) {
            if (schedule.isUnscheduled(course)) {
                output.println(course.getCourseId() + "\nMin Students: " + course.getMinStudents());
                output.println();
                output.println();
            }
        }
        output.flush();
    }
}
