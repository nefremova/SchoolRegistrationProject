package cs4a.RegistrationLibrary.CourseLibrary;

import cs4a.RegistrationLibrary.FacultyLibrary.Faculty;
import cs4a.RegistrationLibrary.StudentLibrary.Student;

import java.util.ArrayList;

/**
 * This class contains information about a session of a course
 */

public class CourseSession {
    private int sessionId;
    private ArrayList<Student> students;
    private Faculty instructor;
    private Course courseBase;

    public CourseSession(Course courseBase, Faculty instructor, ArrayList<Student> students, int sessionId) {
        this.courseBase = courseBase;
        this.instructor = instructor;
        this.students = students;
        this.sessionId = sessionId;
    }

    public CourseSession() {
        this(new Course(), new Faculty(), new ArrayList<Student>(), 0);
    }

    public int getSessionId() {
        return sessionId;
    }

    public CourseSession setSessionId(int sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public CourseSession setStudents(ArrayList<Student> students) {
        this.students = students;
        return this;
    }

    public Faculty getInstructor() {
        return instructor;
    }

    public CourseSession setInstructor(Faculty instructor) {
        this.instructor = instructor;
        return this;
    }

    public Course getCourseBase() {
        return courseBase;
    }

    public CourseSession setCourseBase(Course courseBase) {
        this.courseBase = courseBase;
        return this;
    }

    /**
     * Check if session is scheduled
     * @return boolean This returns true if the size of the student array is greater or equal to the minimum students required
     */

    public boolean isScheduled() {
        return students.size() >= courseBase.getMinStudents() && instructor.getIdNum() != 0;
    }

    /**
     * Check if course is full
     * @return boolean This returns true if the size of the student array equals the max students allowed
     */

    public boolean isFull() {
        return students.size() == courseBase.getMaxStudents();
    }

    /**
     * Add a student if the session is not full
     * @param s Student object
     */

    public void addStudent(Student s) {
        if (!isFull()) {
            students.add(s);
        }
    }

    /**
     * Remove a student
     * @param s Student object
     */

    public void removeStudent(Student s) {
      students.remove(s);
    }

    /**
     * Check if two CourseSession objects are equal
     * @param o Object comparable to CourseSession
     * @return boolean This returns true if the course session id matches the session id of o
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        CourseSession courseSession = (CourseSession) o;

        return sessionId == courseSession.sessionId;
    }

    /**
     * Return session as a string
     * @return String This is formatted with each data field on a new line
     */
    @Override
    public String toString() {
        StringBuilder cSession = new StringBuilder();

        cSession.append(courseBase.toString());
        
        cSession.append("\nSession id: " + sessionId);
        cSession.append("\nInstructor: " + instructor.getfName() + " "
                + instructor.getlName() + " " + instructor.getIdNum());
        cSession.append("\nStudents: " + students.size());

        for (Student s : students) {
            cSession.append("\n" + s.getfName() + " " + s.getlName() + " " + s.getIdNum());
        }

        return cSession.toString();
    }
}
