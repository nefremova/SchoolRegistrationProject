package cs4a.RegistrationLibrary.ScheduleAlgorithms;

import cs4a.RegistrationLibrary.Interfaces.ScheduleAlgorithm;
import cs4a.RegistrationLibrary.ParameterLibrary.ScheduleParameters;

/**
 * Determine which algorithm to use to schedule
 * students and faculty based on parameters
 */

public class ScheduleFactory {
	private ScheduleFactory() {} // Prevent instantiation

	/**
	 * User can easily add additional algorithm options by
	 * adding a data field to the ScheduleParameters / ScheduleParameterReader classes
	 * and writing an additional condition into this function
	 * @see ScheduleParameters
	 * @see cs4a.RegistrationLibrary.ParameterLibrary.ScheduleParameterReader
	 * @param parameters This object contains boolean data fields that determine which algorithm to use
	 * @return ScheduleAlgorithm This returns an interface which implements the method
	 * schedule(ArrayList<Student> students, ArrayList<Faculty> faculty, ArrayList<Course> courses,
	 * ScheduleParameters parameters, IdGenerator idGenerator)
	 * @see ScheduleAlgorithm
	 */

	public static ScheduleAlgorithm createScheduler(ScheduleParameters parameters) {
		if (parameters.useSmartScheduler) {
			return new SmartScheduleAlgorithm();
		}
		return new DummyScheduleAlgorithm();
	}
}
