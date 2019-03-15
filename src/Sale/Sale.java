/*
 * 
 * 														Sale Class
 * This object is a single Sale which is made up of Items, Can see if the sale is completed or how much is left?
 * 
 *  
 * 
 * 
 * 
 * Attributes:
 * saleId - int: The unique ID for a single sale.
 * totalCost - float: The total cost of all of the items for this sale.
 * amountPaid - float: The amount the customer has paid for this sale.
 * saleList - List: An array list which holds item objects sold in a single transaction.
 * 
 * 
 * 
 * 
 * 
 * Functions:
 * Constructor - Sale(int) - Int _id is a unique sale identifier, totalCost and amountPaid are initialized to 0;
 * void - addIem(Item) - Add Item to saleList.
 * void - printSale() - Print Sale Id, All Items sold and total for all Sales in  saleList.
 * 
 */
package Sale;

import java.util.ArrayList;

	public class Sale{
		private int saleId;
		private float totalCost;
		private float amountPaid;
		private ArrayList<Item> saleList =  new ArrayList<Item>();	

		public Sale(int _id){
			saleId = _id;
			totalCost = 0;
			amountPaid = 0;
		}
		
		public void addItem(Item i) {
			saleList.add(i);
		}
		
		public void addPayment(float payAmount) {
			amountPaid += payAmount;
			
		}
		
		public void printSale() {
			System.out.println("Sale ID:" + saleId);
			for(Item i :  saleList) {
				totalCost += i.itemTotalCost();
				i.printItem();
				System.out.println();
			}
		
			System.out.println("Total: " + String.format("%.2f", totalCost));
			System.out.println("Amount Paid: "  +  String.format("%.2f", amountPaid));
			System.out.println();
		}
			
}
