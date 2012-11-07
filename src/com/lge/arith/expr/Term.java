package com.lge.arith.expr;

/**
 * Term represents a number or a variable.
 * 
 * @author jooyung.han
 * 
 */
public class Term extends Expression {
	public Object value;

	public Term(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
