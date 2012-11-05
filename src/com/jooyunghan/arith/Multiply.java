package com.jooyunghan.arith;

public class Multiply extends HorizontalGroup {

	public Multiply(Expression e1, Expression e2) {
		super(e1, e2, "*");
	}
	
	@Override
	public int precedence() {
		return 2;
	}
}
