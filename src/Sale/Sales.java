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
	
	//A sale which is made up of items
	static public class Sale{
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

		//Items that make up a sale
		 static public class Item{
			private String itemDescription;
			private float itemCost;
			private int itemQuantity;	
			private Date dateSold;
			
			//Item constructor
			public Item(String _desc, float _cost, int _quantity) {
				itemDescription = _desc;
				itemCost = _cost;
				itemQuantity = _quantity;
				//This currently prints the current date
				dateSold = new Date();
			};		
			
			//Add or remove Item Quantity
			public void changeQuantity(int _quantity) {
				itemQuantity += _quantity;
			}
			
			//Total cost of this type of item 
			public float itemTotalCost() {
				return  itemCost * itemQuantity;
			}
			
			//Prints item description, cost, quantity and total cost
			public void printItem() {
				System.out.println(dateSold);
				System.out.println(itemDescription + " " + String.format("%.2f", itemCost) + " "+ itemQuantity + " " + String.format("%.2f", itemTotalCost()));
				
			}
		}
	}	
}
