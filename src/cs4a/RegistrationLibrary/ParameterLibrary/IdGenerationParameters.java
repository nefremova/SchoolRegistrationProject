package cs4a.RegistrationLibrary.ParameterLibrary;

/**
 * This class contains information about the id generation parameters
 * such as which algorithm to use, and min and max values
 */

public class IdGenerationParameters {
    public boolean useOrdered;
    private int max;
    private int min;

    public IdGenerationParameters(boolean useOrdered, int min, int max) {
        this.useOrdered = useOrdered;
        this.min = min;
        this.max = max;
    }

    public IdGenerationParameters() {
        this(false, 0, 0);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
