package Sale;

import java.util.Date;

//Items that make up a sale
 public class Item{
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