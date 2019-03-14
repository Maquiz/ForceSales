/*
 * 
 * 														Item Class
 * This object is a single item within a Sale which is made up of Items, Contains detailed information about a single item.
 * 
 *  
 * 
 * 
 * 
 * Attributes:
 * itemDescription - String: The unique description of an Item.
 * itemCost - float: Cost of a Single Item.
 * itemQuantity - int: The amount of this item sold.
 * saleList - List: An array list which holds item objects sold in a single transaction.
 * dateSold - Date: The date that the item was sold to customer.
 * 
 * 
 * 
 * 
 * 
 * Functions:
 * Constructor - Item(String,float, int) - Description of Item, Cost of a Single Item and Quantity of that item being sold.
 * void - changQuantity(int) - Add or remove Item Quantity using positive or negative ints respectivily.
 * float - itemTotalCost:  Calculates the total cost of items * quantity
 * void - printItem() - Print Date Sold, item description, cost, quantity and total cost.
 * 
 */
package Sale;

import java.util.Date;

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
	
	
	public void changeQuantity(int _quantity) {
		itemQuantity += _quantity;
	}
	
	public float itemTotalCost() {
		return  itemCost * itemQuantity;
	}
	
	public void printItem() {
		System.out.println(dateSold);
		System.out.println(itemDescription + " " + String.format("%.2f", itemCost) + " "+ itemQuantity + " " + String.format("%.2f", itemTotalCost()));
		
	}
	
	public String toString() {
		return itemDescription + " " + String.format("%.2f", itemCost) + " "+ itemQuantity + " " + String.format("%.2f", itemTotalCost());	
	}
}