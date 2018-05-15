package cs4a.RegistrationLibrary.ParameterLibrary;

/**
 * This class contains information about the id generation parameters
 * such as which algorithm to use, and min and max values
 */
public class IdGenerationParameters {
    public boolean useOrdered;
    public int max;
    public int min;

    public IdGenerationParameters(boolean useOrdered, int min, int max) {
        this.useOrdered = useOrdered;
        this.min = min;
        this.max = max;
    }

    public IdGenerationParameters() {
        this(false, 0, 0);
    }
}
