import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScheduleParameterReader {
    public static ScheduleParameters readParameters(String pathname)
            throws FileNotFoundException, InputMismatchException {
        ScheduleParameters sParameters;
        try {
            Scanner input = new Scanner(new File(pathname));

            int sessionsPerCourse = input.nextInt();
            int sessionsPerStudent = input.nextInt();
            int sessionsPerInstructor = input.nextInt();
            boolean useSmartAlgorithm = input.nextBoolean();

            if (sessionsPerCourse <= 0 || sessionsPerStudent <= 0 || sessionsPerInstructor <= 0) {
                System.out.println("Session Parameter error. Check input file.");
                System.exit(0);
            }

            sParameters = new ScheduleParameters(useSmartAlgorithm, sessionsPerCourse, sessionsPerStudent, sessionsPerInstructor);
        }

        catch(FileNotFoundException ex) {
            throw new FileNotFoundException(pathname);
        }
        catch(InputMismatchException ex) {
            throw new InputMismatchException(pathname);
        }

        return sParameters;
    }

}
