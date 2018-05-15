package cs4a.RegistrationLibrary.CourseLibrary;

/**
 * This class contains all information pertaining to a course
 */

public class Course {
    private String department;
    private String code;
    private String description;
    private int minStudents;
    private int maxStudents;

    public Course(String department, String code, String description, int minStudents, int maxStudents) {
        this.department = department;
        this.code = code;
        this.description = description;
        this.minStudents = minStudents;
        this.maxStudents = maxStudents;
    }

    public Course(String department, String code, String description) {
        this(department, code, description, 10, 30);
    }

    public Course() {
        this("", "", "", 0, 0);
    }

    public String getDepartment() {
        return department;
    }

    public Course setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Course setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getMinStudents() {
        return minStudents;
    }

    public Course setMinStudents(int minStudents) {
        this.minStudents = minStudents;
        return this;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public Course setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
        return this;
    }

    public String getCourseId() {
        return department + code;
    }

    /**
     * Return course as a string
     * @return
     */

    @Override
    public String toString() {
        return department + code + "\n" + description;
    }

    /**
     * Override the equals method to return true if courses have identical id numbers
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Course course = (Course) o;
        return getCourseId().equals(course.getCourseId());
    }
}
