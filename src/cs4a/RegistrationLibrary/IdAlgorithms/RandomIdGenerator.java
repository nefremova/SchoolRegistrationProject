package cs4a.RegistrationLibrary.IdAlgorithms;

import cs4a.RegistrationLibrary.Interfaces.IdGenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generate a random, unique id (adjustable min/max)
 */

public class RandomIdGenerator implements IdGenerator {
	private ArrayList<Integer> usedIds = new ArrayList<Integer>();
	int max, min;

	public RandomIdGenerator(int min, int max) {
		this.max = max;
		this.min = min;
	}

	public RandomIdGenerator(int max) {
		this(0, max);
	}

	public RandomIdGenerator() {
		this(0, Integer.MAX_VALUE);
	}

	/**
	 * Implement nextId() method in IdGenerator interface
	 * by generating a random int, comparing it to a list
	 * of used Ids, and finally adding the unique id to the list
	 * @return int This returns a unique id
	 */

	@Override
	public int nextId() {
		Random rand = new Random();

		int id = rand.nextInt(max) + min;

		while(usedIds.contains(id)) {
			id = rand.nextInt(max) + min;
		}

		usedIds.add(id);
		return id;
	}

}
