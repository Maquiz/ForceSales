 package Sale;

import java.util.ArrayList;

//A sale which is made up of items
	public class Sale{
		private int saleId;
		private float totalCost;
		private float amountPaid;

		public Sale(int _id){
			saleId = _id;
			totalCost = 0;
			amountPaid = 0;
		}
		
		//Sale List of items sold in transaction
		private ArrayList<Item> saleList =  new ArrayList<Item>();		
		
		//Prints the all items in a sale
		public void getTotal() {
			System.out.println("Sale ID:" + saleId);
			for(Item i :  saleList) {
				totalCost += i.itemTotalCost();
				i.printItem();
				System.out.println();
			}
		
			System.out.println("Total: " + String.format("%.2f", totalCost));
			System.out.println();
		}
			
		//Add item to saleList
		public void addItem(Item i) {
			saleList.add(i);
		}
}
