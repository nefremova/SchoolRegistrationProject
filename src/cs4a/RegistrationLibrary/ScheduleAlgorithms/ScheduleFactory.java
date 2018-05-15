package cs4a.RegistrationLibrary.ScheduleAlgorithms;

import cs4a.RegistrationLibrary.Interfaces.ScheduleAlgorithm;
import cs4a.RegistrationLibrary.ParameterLibrary.ScheduleParameters;
import cs4a.RegistrationLibrary.ScheduleAlgorithms.DummyScheduleAlgorithm;

/**
 * Determine which algorithm to use to schedule
 * students and faculty based on parameters
 */
public class ScheduleFactory {
	// Prevent instantiation
	private ScheduleFactory() {}
	
	public static ScheduleAlgorithm createScheduler(ScheduleParameters parameters) {
		if (parameters.useSmartScheduler) {
			return new SmartScheduleAlgorithm();
		}
		return new DummyScheduleAlgorithm();
	}
}
