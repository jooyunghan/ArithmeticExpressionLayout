package com.lge.arith.expr;


/**
 * Plus : e1 + e2
 */
public class Plus extends BinaryExpression {
	public Plus(Expression e1, Expression e2) {
		super(e1, e2, '+');
	}
}
