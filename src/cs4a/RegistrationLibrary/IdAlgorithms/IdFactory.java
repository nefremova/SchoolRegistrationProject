package cs4a.RegistrationLibrary.IdAlgorithms;

import cs4a.RegistrationLibrary.Interfaces.IdGenerator;
import cs4a.RegistrationLibrary.ParameterLibrary.IdGenerationParameters;

/**
 * Choose an algorithm / class to use for generating unique ids based on parameters
 */
public class IdFactory {
    private IdFactory(){ }

    public static IdGenerator createIdGenerator(IdGenerationParameters parameters) {
        if (parameters.useOrdered) {
            return new OrderedIdGenerator(parameters.min, parameters.max);
        }

        return new RandomIdGenerator(parameters.min, parameters.max);
    }

}
