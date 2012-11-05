package com.jooyunghan.arith;

public class Plus extends HorizontalGroup {

	public Plus(Expression e1, Expression e2) {
		super(e1, e2, "+");
	}

	@Override
	public int precedence() {
		return 1;
	}
}
