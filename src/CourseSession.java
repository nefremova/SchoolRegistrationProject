import java.util.ArrayList;

public class CourseSession extends Course {
    public int sessionId;
    public ArrayList<Student> students;
    public Faculty instructor;
    public Course courseBase;

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

    public boolean isScheduled() {
        return students.size() >= courseBase.getMinStudents();
    }

    public boolean isFull() {
        return students.size() == courseBase.getMaxStudents();
    }

    public void addStudent(Student s) {
        if (!isFull()) {
            students.add(s);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        CourseSession courseSession = (CourseSession) o;

        return sessionId == courseSession.sessionId;
    }

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
