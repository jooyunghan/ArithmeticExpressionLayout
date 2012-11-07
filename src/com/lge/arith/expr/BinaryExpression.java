package com.lge.arith.expr;

/**
 * Superclass for all binary operators.
 * 
 * @author jooyung.han
 * 
 */
public class BinaryExpression extends Expression {
	public Expression e1;
	public Expression e2;
	private char operator;

	public BinaryExpression(Expression e1, Expression e2, char operator) {
		this.e1 = e1;
		this.e2 = e2;
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "(" + e1.toString() + operator + e2.toString() + ")";
	}
}
