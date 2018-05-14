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
