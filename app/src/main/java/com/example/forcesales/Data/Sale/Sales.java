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

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Sales implements Parcelable {

	ArrayList<Sale> salesList;

	public Sales(){
		salesList = new ArrayList<Sale>();
	}


	public void addSale(Sale s) {
		salesList.add(s);
	}
	
	public void printSales() {
		for(Sale s : salesList) {			
			s.printSale();	
		}	
	};

	public ArrayList<Sale> getSalesList(){
		return salesList;
	}
	
	public Sale getSale(int pos) {
		return salesList.get(pos);
	}

	//parcelable methods
	@Override
	public int describeContents(){
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeList(salesList);
	}

	//creator
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Sales createFromParcel(Parcel in){
			return new Sales(in);
		}

		public Sales[] newArray(int size){
			return new Sales[size];
		}
	};

	//de-parecel object
	private Sales(Parcel in) {
		salesList = new ArrayList<Sale>();
		in.readList(salesList, Sale.class.getClassLoader());
	}
}
