package cs4a.RegistrationLibrary.IdAlgorithms;

import cs4a.RegistrationLibrary.Interfaces.IdGenerator;
import cs4a.RegistrationLibrary.ParameterLibrary.IdGenerationParameters;

/**
 * Choose an algorithm / class to use for generating unique ids
 */

public class IdFactory {
    private IdFactory(){ } // Prevent instantiation

    /**
     * User can easily add additional algorithm options by
     * adding a data field to the IdGenerationParameters / IdParameterReader classes
     * and writing an additional condition into this function
     * @see IdGenerationParameters
     * @see cs4a.RegistrationLibrary.ParameterLibrary.IdParameterReader
     * @param parameters This object contains boolean data fields that determine which algorithm to use
     * @return IdGenerator This returns an interface which implements the method nextId()
     * @see IdGenerator
     */

    public static IdGenerator createIdGenerator(IdGenerationParameters parameters) {
        if (parameters.useOrdered) {
            return new OrderedIdGenerator(parameters.getMin(), parameters.getMax());
        }

        return new RandomIdGenerator(parameters.getMin(), parameters.getMax());
    }

}
