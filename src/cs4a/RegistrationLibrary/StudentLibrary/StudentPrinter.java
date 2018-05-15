package cs4a.RegistrationLibrary.StudentLibrary;

import cs4a.RegistrationLibrary.ClassSchedule.ClassSchedule;
import cs4a.RegistrationLibrary.CourseLibrary.CourseSession;
import cs4a.RegistrationLibrary.StudentLibrary.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Print information about students to given output
 */
public class StudentPrinter {
    private PrintWriter output;
    private ArrayList<Student> students;
    private ClassSchedule schedule;

    public StudentPrinter(PrintWriter output, ArrayList<Student> students, ClassSchedule schedule) {
        this.output = output;
        this.students = students;
        this.schedule = schedule;
    }

    public StudentPrinter(String pathname, ArrayList<Student> students, ClassSchedule schedule)
            throws FileNotFoundException {
        this(new PrintWriter(new File(pathname)), students, schedule);
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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ClassSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(ClassSchedule schedule) {
        this.schedule = schedule;
    }

    /**
     * Print all students that are scheduled
     */
    public void printScheduledStudents() {
        for (Student student : students) {
            if (schedule.getStudentSchedule(student).size() > 0) {
                output.println(student);
                output.println();

                for (CourseSession session : schedule.getStudentSchedule(student)) {
                    output.println("Session ID: " + session.getSessionId()
                            + " Course ID: " + session.getCourseBase().getCourseId()
                            + "\n" + session.getCourseBase().getDescription());
                    output.println();
                }
                output.println("-----");
                output.println();
            }
        }
        output.flush();
    }

    /**
     * Print all students that are not scheduled
     */
    public void printUnscheduledStudents() {
        for (Student student : students) {
            if (schedule.getStudentSchedule(student).size() == 0) {
                output.println(student);
                output.println("-----");
                output.println();
            }
        }

        output.flush();
    }

    /**
     * Return total number of students
     * @return
     */
    public int getNumStudents() {
        return students.size();
    }

    /**
     * Return total number of scheduled students
     * @return
     */
    public int getNumScheduledStudents() {
        int count = 0;

        for (Student s : students) {
            if (schedule.getStudentSchedule(s).size() > 0) {
                count++;
            }
        }

        return count;
    }

    /**
     * Return total number of unscheduled students
     * @return
     */
    public int getNumUnscheduledStudents() {
        int count = 0;

        for (Student s : students) {
            if (schedule.getStudentSchedule(s).size() == 0) {
                count++;
            }
        }

        return count;
    }

}

