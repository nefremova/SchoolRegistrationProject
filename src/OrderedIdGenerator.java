
public class OrderedIdGenerator implements PeopleIdGenerator {
	private int currentId;
	
	public OrderedIdGenerator() {
		this.currentId = (int)(Math.random() * 1000) + 1000;
	}
	
	@Override
	public int nextId() {
		this.currentId++;
		return this.currentId;
	}

}
