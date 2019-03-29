package com.example.forcesales.Data.consoleKit;

/*
 * A container that holds a value
 */

public final class Holder<A> {
	private A in;
	
	public Holder() {
		this.in = null;
	}
	
	public Holder(A in) {
		this.in = in;
	}
	
	public A get() {
		return this.in;
	}
	
	public void set(A in) {
		this.in = in;
	}
}
