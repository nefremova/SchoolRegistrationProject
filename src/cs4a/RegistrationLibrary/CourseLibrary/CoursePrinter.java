package cs4a.RegistrationLibrary.CourseLibrary;

import cs4a.RegistrationLibrary.ClassSchedule.ClassSchedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class prints course information to a specified output source
 */

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

    /**
     * Print scheduled courses
     */

    public void printScheduledCourses() {
        for (Course course : courses) {
            if (schedule.hasScheduled(course))  {
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

    /**
     * Print unscheduled courses
     */

    public void printUnscheduledCourses() {
        for (Course course : courses) {
            if (!schedule.hasScheduled(course)) {
                output.println(course.getCourseId() + "\nMin Students: " + course.getMinStudents());
                output.println();
                output.println();
            }
        }
        output.flush();
    }

    /**
     * Return total number of courses
     * @return int This returns number of courses
     */

    public int getNumCourses() {
        return courses.size();
    }

    /**
     * Return total number of sessions
     * @return int This returns number of sessions
     */

    public int getNumScheduledSessions() {
        int count = 0;
        for (CourseSession session : schedule.getCourseSessions()) {
            if (session.isScheduled()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Return total number of scheduled courses
     * @return int This returns number of unscheduled courses
     */

    public int getNumScheduledCourses() {
        int count = 0;

        for (Course course : courses) {
            if (schedule.hasScheduled(course)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Return total number of unscheduled courses
     * @return int This returns number of scheduled courses
     */

    public int getNumUnscheduledCourses() {
        int count = 0;

        for (Course course : courses) {
            if (!schedule.hasScheduled(course)) {
                count++;
            }
        }

        return count;
    }
}
