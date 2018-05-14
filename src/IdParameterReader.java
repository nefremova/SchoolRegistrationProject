import java.io.File;
import java.util.Scanner;

public class IdParameterReader {
    public static IdGenerationParameters readParameters(String pathname) throws Exception{
        Scanner input = new Scanner(new File(pathname));

        boolean useOrdered = input.nextBoolean();
        int min = input.nextInt();
        int max = input.nextInt();

        if (min < 0 || max <= 0 || min >= max) {
            System.out.println("ID Parameter error. Check input file.");
            System.exit(0);
        }

        return new IdGenerationParameters(useOrdered, min, max);
    }
}
