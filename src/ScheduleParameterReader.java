import java.io.File;
import java.util.Scanner;

public class ScheduleParameterReader {
    public static ScheduleParameters readParameters(String pathname) throws Exception {
        Scanner input = new Scanner(new File(pathname));

        int sessionsPerCourse = input.nextInt();
        int sessionsPerStudent = input.nextInt();
        int sessionsPerInstructor = input.nextInt();
        boolean useSmartAlgorithm = input.nextBoolean();

        if (sessionsPerCourse <= 0 || sessionsPerStudent <= 0 || sessionsPerInstructor <= 0) {
            System.out.println("Session Parameter error. Check input file.");
            System.exit(0);
        }

        return new ScheduleParameters(useSmartAlgorithm, sessionsPerCourse, sessionsPerStudent, sessionsPerInstructor);
    }

}
