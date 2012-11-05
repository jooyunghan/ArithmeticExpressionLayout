package com.jooyunghan.arith;

public class Divide implements Expression {

	private Expression e1;
	private Expression e2;
	private int w;
	private int h;

	public Divide(Expression e1, Expression e2) {
		this.e1 = e1;
		this.e2 = e2;
		this.w = Math.max(e1.width(), e2.width()) + 2; // padding 1 for both ends
		this.h = e1.height() + e2.height() + 1;
	}

	@Override
	public char print(int x, int y) {
		if (y < e1.height()) {
			return dispatch(e1, x, y);
		} else if (y == e1.height()) {
			return '-';
		} else {
			return dispatch(e2, x, y-e1.height()-1);
		}
	}

	private char dispatch(Expression e, int x, int y) {
		int ew = e.width();
		int pad = (w - ew) / 2;
		if (x < pad || x >= ew + pad) {
			return ' ';
		} else {
			return e.print(x-pad, y);
		}
	}

	@Override
	public int height() {
		return h;
	}

	@Override
	public int width() {
		return w;
	}

	@Override
	public int precedence() {
		return 2;
	}
}
