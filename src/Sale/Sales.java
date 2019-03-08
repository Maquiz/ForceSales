package Sale;

import java.util.ArrayList;
import java.util.Date;

public class Sales {
	
	ArrayList<Sale> salesList = new ArrayList<Sale>();
	
	//Add Sale to saleList
	public void addSale(Sale s) {
		salesList.add(s);
	}
	
	//Print all sales in list
	public void printSales() {
		for(Sale s : salesList) {			
			s.getTotal();	
		}	
	};
}
