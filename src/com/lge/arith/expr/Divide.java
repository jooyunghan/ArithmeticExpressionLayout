package com.lge.arith.expr;


/**
 * Divide : e1/e2
 */
public class Divide extends BinaryExpression {
	public Divide(Expression e1, Expression e2) {
		super(e1, e2, '/');
	}
}
