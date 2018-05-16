package cs4a.RegistrationLibrary.ParameterLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class reads in schedule parameters from a file
 */

public class ScheduleParameterReader {
    /**
     * Read schedule parameters from a file
     * @param pathname Pathname of file to read from
     * @return ScheduleParameters This object contains all parameters needed to generate a schedule
     * @throws FileNotFoundException This contains a message with the pathname of the file
     * @throws InputMismatchException This contains a message with the pathname of the file
     */

    public static ScheduleParameters readParameters(String pathname)
            throws FileNotFoundException, InputMismatchException {

        ScheduleParameters sParameters;

        try {
            Scanner input = new Scanner(new File(pathname));

            int sessionsPerCourse = input.nextInt();
            int sessionsPerStudent = input.nextInt();
            int sessionsPerInstructor = input.nextInt();
            boolean useSmartAlgorithm = input.nextBoolean();

            if (sessionsPerCourse <= 0 || sessionsPerStudent <= 0 || sessionsPerInstructor <= 0) { // Check for invalid input
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
