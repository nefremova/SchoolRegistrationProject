
public class RandomIdGenerator implements PeopleIdGenerator {

	@Override
	public int nextId() {
		return (int)(Math.random() * Integer.MAX_VALUE);
	}

}
