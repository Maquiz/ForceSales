package com.example.forcesales.Data.util;


import java.util.ArrayList;

/**
 * AbstractArrayListComparsion is a an abstract class that extends from ArrayList.
 * This class provides two protected methods that are used to help with generating
 * a specialized ArrayList (ex: Return a list of people that match the last name).
 *
 *
 * Note:
 * 	For the second template argument, you must provide the subclass itself:
 * 		"AccountArray extends AbstractArrayListComparsion<Account,AccountArray>"
 * 
 * Public:
 * 	-> (Constructor) Initializes ArrayList.
 * 
 * Protected:
 * 	-> createEmptyArrayList - An abstract function that return a newly created Object.
 * 		If you set the template parameters correctly, the return type is your subClass.
 * 		For example:
 *
 * 			protected AccountArray createEmptyArrayList() {
 * 				return new AccountArray();
 *        	}
 *
 *
 * 	-> abstractContains - Takes a value and CompareTwoObjects. This code is responsible,
 * 		for returning a specialized ArrayList based on what the CompareTwoObjects method
 * 		is comparing. If the CompareTwoObjects method returns true, the item is added to
 * 		the new list.
 * 		For example:
 *
 * 			public AccountArray compareOpportunityName(String value) {
 * 				return abstractContains(value, compare_oportunity_name);
 *        	}
 */

public abstract class AbstractArrayListComparsion <A,B extends AbstractArrayListComparsion<A,B>> extends ArrayList<A> {
	public AbstractArrayListComparsion() {
		super();
	}

	abstract protected B createEmptyArrayList();
//	protected B createEmptyArrayList() {
//		return new B();
//	}

	protected <V> B abstractContains(V v, CompareTwoObjects<A,V> comparsion) {
		B result = createEmptyArrayList();

		for(A i: this) {
			if (comparsion.compare(i, v))
				result.add(i);
		}

		return result;
	}
}
