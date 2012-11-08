package com.jooyunghan.arith;

public class Term implements Expression {

	private String value;

	public Term(Object value) {
		this.value = value.toString();
	}

	@Override
	public char getChar(int x, int y) {
		return value.charAt(x);
	}

	@Override
	public int height() {
		return 1;
	}

	@Override
	public int baseline() {
		return 0;
	}

	@Override
	public int width() {
		return value.length();
	}

	@Override
	public int precedence() {
		return 3;
	}
}
