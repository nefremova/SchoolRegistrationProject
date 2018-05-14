import java.util.ArrayList;
import java.util.Random;

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
