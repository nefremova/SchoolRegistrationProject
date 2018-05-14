public class IdFactory {
    private IdFactory(){ }

    public static IdGenerator createIdGenerator(IdGenerationParameters parameters) {
        if (parameters.useOrdered) {
            return new OrderedIdGenerator(parameters.min, parameters.max);
        }

        return new RandomIdGenerator(parameters.min, parameters.max);
    }

}
