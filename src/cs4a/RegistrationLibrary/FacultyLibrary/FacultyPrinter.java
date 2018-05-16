package cs4a.RegistrationLibrary.FacultyLibrary;

import cs4a.RegistrationLibrary.ClassSchedule.ClassSchedule;
import cs4a.RegistrationLibrary.CourseLibrary.CourseSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class prints faculty information to a specified output
 */

public class FacultyPrinter {
    private PrintWriter output;
    private ArrayList<Faculty> faculty;
    private ClassSchedule schedule;

    public FacultyPrinter(PrintWriter output, ArrayList<Faculty> faculty, ClassSchedule schedule) {
        this.output = output;
        this.faculty = faculty;
        this.schedule = schedule;
    }

    public FacultyPrinter(String pathname, ArrayList<Faculty> faculty, ClassSchedule schedule) throws FileNotFoundException {
        this(new PrintWriter(new File(pathname)), faculty, schedule);
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

    public ArrayList<Faculty> getFaculty() {
        return faculty;
    }

    public void setFaculty(ArrayList<Faculty> faculty) {
        this.faculty = faculty;
    }

    public ClassSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(ClassSchedule schedule) {
        this.schedule = schedule;
    }

    /**
     * Print all faculty
     */

    public void printFaculty() {
        for (Faculty f : faculty) {
            output.println(f);
            output.println();

            for (CourseSession session : schedule.getFacultySchedule(f)) {
                output.println(session);
                output.println();
            }

            output.println("-----");
            output.println();
        }
        output.flush();
    }

    /**
     * Return total number of faculty members
     * @return int This is the number of faculty members
     */

    public int getNumFaculty() {
        return faculty.size();
    }
}
