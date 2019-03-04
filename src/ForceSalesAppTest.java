

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.Date;

class ForceSalesAppTest {

	Employee Arend;
	Employee Thomas;
	Employee Max;
	Date test;
	
	public ForceSalesAppTest() {
		
	}
	
	@Before
	public void setUp() {
		Arend = new Employee("Arend");
		Thomas = new Employee("Thomas");
		Max = new Employee("Max");
		test = new Date();
	}
	
	@Test
	public void listAddTest() {
		TaskList list = new TaskList();
		
		Task job1 = new Task("Sales report", Arend, test);
		Task job2 = new Task("Profit Report", Thomas, test);
		Task job3 = new Task("Growth report", Max, test);
		
		list.addTask(job1);
		list.addTask(job2);
		list.addTask(job3);
		
		assertEquals(3, list.getSize());
	}
	

}
