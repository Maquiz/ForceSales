package com.example.forcesales.Data.util;


import java.util.ArrayList;

import com.example.forcesales.Data.client.Client;
import com.example.forcesales.Data.client.ClientArray;

/*
 * AbstractArrayListComparsion is a an abstract class that extends from ArrayList.
 * This class provides two protected methods that are used to help with generating
 * a specialized ArrayList.
 * 
 * Note that the abstractContains is intended to be wrapped onto another method.
 * 
 * Public:
 * 	-> (Constructor) Initalizes ArrayList.
 * 
 * Protected:
 * 	-> createEmptyArrayList - An abstract function that return a newly created Object.
 * 		It is not intended for the actual implementation to return a new ArrayList, 
 * 		instead, you should return a new instance of the inheriated class.
 * 
 * 	-> abstractContains - Takes a value and CompareTwoObjects. This code is responsible,
 * 		for returning a specialized ArrayList based on what the CompareTwoObjects method
 * 		is comparing. If the CompareTwoObjects method returns true, the item is added to
 * 		the new list.
 * 		Note that the public function that calls this method should cast the returned object
 * 		to the inheriated class
 */

@SuppressWarnings("serial")
public abstract class AbstractArrayListComparsion <A> extends ArrayList<A> {
	public AbstractArrayListComparsion() {
		super();
	}
	
	abstract protected ArrayList<A> createEmptyArrayList();
	
	protected <V> ArrayList<A> abstractContains(V v, CompareTwoObjects<A,V> comparsion) {
		ArrayList<A> result = createEmptyArrayList();
		
		for(A i: this) {
			if (comparsion.compare(i, v))
				result.add(i);
		}
		
		return result;
	}
}
