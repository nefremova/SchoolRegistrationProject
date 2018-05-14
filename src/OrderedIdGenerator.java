import java.util.Random;

public class OrderedIdGenerator implements IdGenerator {
	private int currentId;
	
	public OrderedIdGenerator(int min, int max) {
		Random rand = new Random();

		this.currentId = rand.nextInt(max) + min;
	}

	public OrderedIdGenerator(int max) {
		this(0, max);
	}

	public OrderedIdGenerator() {
		this(0, 1000);
	}
	
	@Override
	public int nextId() {
		this.currentId++;
		return this.currentId;
	}

}
