package com.jooyunghan.arith;

import java.util.ArrayList;
import java.util.List;

public abstract class HorizontalGroup implements Expression {

	protected List<Expression> es = new ArrayList<Expression>();
	protected int w = -1;
	protected int h = -1;
	private int baseline;

	public HorizontalGroup(Expression e1, Expression e2, String op) {
		add(e1, precedence() > e1.precedence());
		es.add(new Term(" " + op + " ")); // Term is used as a static text in
											// this case.
		add(e2, precedence() >= e2.precedence()); // left-to-right, therefore,
													// if right hand operand has
													// equal precedence we need
													// to put additional
													// parentheses. In 1+(1+1)
													// case, removing the
													// unnecessary parentheses
													// requires transforming the
													// parse tree, which is
													// beyond the job of
													// parsing-and-layout.

		w = Util.sum(es, "width");
		h = Util.max(es, "height");
		baseline = Util.max(es, "baseline");
	}

	private void add(Expression e, boolean needsParen) {
		if (needsParen) {
			es.add(new Term("("));
		}
		es.add(e);
		if (needsParen) {
			es.add(new Term(")"));
		}
	}

	@Override
	public char getChar(int x, int y) {
		for (Expression e : es) {
			if (x < e.width()) {
				return dispatch(e, x, y);
			}
			x -= e.width();
		}
		return 'X';
	}

	private char dispatch(Expression e, int x, int y) {
		int pad = baseline - e.baseline();
		if (y < pad || y >= pad + e.height()) {
			return ' ';
		} else {
			return e.getChar(x, y - pad);
		}
	}

	@Override
	public int height() {
		return h;
	}

	@Override
	public int baseline() {
		return baseline;
	}

	@Override
	public int width() {
		return w;
	}

}