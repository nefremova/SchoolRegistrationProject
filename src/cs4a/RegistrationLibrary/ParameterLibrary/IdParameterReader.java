package cs4a.RegistrationLibrary.ParameterLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class reads in id parameters from a file
 */

public class IdParameterReader {
    /**
     * Read id parameters from a file
     * @param pathname Pathname of file to read from
     * @return IdGenerationParameters This object contains all parameters needed to generate a unique ID
     * @throws FileNotFoundException This contains a message with the pathname of the file
     * @throws InputMismatchException This contains a message with the pathname of the file
     */

    public static IdGenerationParameters readParameters(String pathname)
            throws FileNotFoundException, InputMismatchException {

        IdGenerationParameters idParameters;

        try {
            Scanner input = new Scanner(new File(pathname));

            boolean useOrdered = input.nextBoolean();
            int min = input.nextInt();
            int max = input.nextInt();

            if (min < 0 || max <= 0 || min >= max) { // Check for invalid input
                System.out.println("ID Parameter error. Check input file.");
                System.exit(0);
            }

            idParameters = new IdGenerationParameters(useOrdered, min, max);
        }

        catch(FileNotFoundException ex) {
            throw new FileNotFoundException(pathname);
        }
        catch(InputMismatchException ex) {
            throw new InputMismatchException(pathname);
        }

        return idParameters;
    }
}
