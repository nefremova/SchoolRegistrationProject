
public class ScheduleFactory {
	// Prevent instantiation
	private ScheduleFactory() {}
	
	public static ScheduleAlgorithm createScheduler(ScheduleParameters parameters) {
		/*
		 * For example: if we want to add another scheduler algorithm, and use it 
		 * based on another parameter flag
		if (parameters.usePetersScheduler) {
			 return new PeterSchedulingAlgorithm
		}
		*/
		if (parameters.useSmartScheduler) {
			return new SmartScheduleAlgorithm();
		}
		return new DummyScheduleAlgorithm();
	}
}
