package com.jooyunghan.arith;

public class Term implements Expression {

	private String value;

	public Term(Object value) {
		this.value = value.toString();
	}

	@Override
	public char print(int x, int y) {
		if (x < value.length())
			return value.charAt(x);
		return 'X';
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
		return value.toString().length();
	}

	@Override
	public int precedence() {
		return 3;
	}
}
