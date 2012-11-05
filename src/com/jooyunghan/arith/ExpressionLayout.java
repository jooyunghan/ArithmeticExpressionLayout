package com.jooyunghan.arith;

public class ExpressionLayout {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print(new Plus(new Term(1), new Multiply(new Term(1), new Term(1))));
		print(new Divide(new Term(1), new Plus(new Term(1), new Term(1))));
		print(new Minus(new Term(1), new Minus(new Term(1), new Term(1))));
		print(new Minus(new Term(1), new Plus(new Term(1), new Term(1))));
		print(new Minus(new Minus(new Term(1), new Term("x")), new Term(1)));
	}

	private static void print(Expression e) {
		for (int y=0; y<e.height(); y++) {
			for (int x=0; x<e.width(); x++) {
				System.out.print(e.print(x, y));
			}
			System.out.println();
		}
	}

}
