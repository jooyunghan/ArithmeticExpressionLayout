package com.lge.arith.expr;


/**
 * Minus : e1 - e2
 */
public class Minus extends BinaryExpression {
	public Minus(Expression e1, Expression e2) {
		super(e1, e2, '-');
	}
}
