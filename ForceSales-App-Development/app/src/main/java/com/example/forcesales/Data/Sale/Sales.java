/*
 * 
 * 														Sales Class
 * This object holds a list of sales for a given customer.
 * 
 *  
 * 
 * 
 * 
 * Attributes:
 * salesList - List: An array list which holds sale objects.
 * 
 * 
 * 
 * 
 * Functions:
 * Constructor - Sales() - Default Constructor.
 * void - addSale(Sale) - Add Sale to salesList.
 * void - printSales() - 	Print all sales in list.
 * 
 */
package com.example.forcesales.Data.Sale;

import java.util.ArrayList;

public class Sales {	
	ArrayList<Sale> salesList = new ArrayList<Sale>();

	public void addSale(Sale s) {
		salesList.add(s);
	}
	
	public void printSales() {
		for(Sale s : salesList) {			
			s.printSale();	
		}	
	};
	
	public Sale getSale(int pos) {
		return salesList.get(pos);
	}
}
