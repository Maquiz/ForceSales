

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import Tasks.Employee;
import Tasks.Task;
import Tasks.TaskList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ForceSalesAppTest {

	Employee Arend;
	Employee Thomas;
	Employee Max;
	Calendar test;
	
	public ForceSalesAppTest() {
		
	}
	
	@Before
	public void setUp() {
		Arend = new Employee("Arend");
		Thomas = new Employee("Thomas");
		Max = new Employee("Max");
		test = Calendar.getInstance();
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