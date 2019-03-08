package Tasks;
/*
 * 						Fake Employee Class (for testing purposes)
 */


public class Employee {
	
	private String name;

	public Employee(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
