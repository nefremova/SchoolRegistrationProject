package cs4a.RegistrationLibrary.ParameterLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class reads in id parameters from a file
 */
public class IdParameterReader {
    public static IdGenerationParameters readParameters(String pathname)
            throws FileNotFoundException, InputMismatchException {
        IdGenerationParameters idParameters;
        try {
            Scanner input = new Scanner(new File(pathname));

            boolean useOrdered = input.nextBoolean();
            int min = input.nextInt();
            int max = input.nextInt();

            if (min < 0 || max <= 0 || min >= max) {
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
