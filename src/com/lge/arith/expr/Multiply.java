package com.lge.arith.expr;


/**
 * Multiple : e1 * e2
 */
public class Multiply extends BinaryExpression {
	public Multiply(Expression e1, Expression e2) {
		super(e1, e2, '*');
	}
}
