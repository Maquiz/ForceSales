package Sale;

public class Main {

	static Sales s  = new Sales ();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create Sale
		Sale s1 = new Sale(1);
		Sale s2 = new Sale(2);
		
		//Add Sale to sales list
		s.addSale(s1);
		s.addSale(s2);
		
		//Need to force precision to 2 decimals
		Item ik = new Item("A's Hat",29.99f,3);
		Item shoe = new Item("Large Shoe", 45.00f, 10);
		Item overwatch = new Item("Overwatch", 49.99f,1);
		
		
		s1.addItem(ik);
		s1.addItem(shoe);
		s1.addItem(overwatch);
		
		s2.addItem(ik);
		s2.addItem(shoe);
		
		//print All Sales
		s.printSales();
		
	}

}
