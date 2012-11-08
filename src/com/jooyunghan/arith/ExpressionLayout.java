package com.jooyunghan.arith;

import java.io.IOException;

public class ExpressionLayout {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test("1");
		test("2*1");
		test("3-2-1");
		test("3*(2+1)");
		test("3-(2-1)");
		test("1/x");
		test("23/xyz");
		test("xy/(1-x)");
		test("1/x/y");
		test("3-2/(1/x)");
		test("z*(y/x-z/(1-x)/(y/x))");		
	}

	private static void test(String string) {
		System.out.println("===============");
		System.out.println(string + " => ");
		try {
			print(Parser.parse(string));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void print(Expression e) {
		for (int y = 0; y < e.height(); y++) {
			for (int x = 0; x < e.width(); x++) {
				System.out.print(e.print(x, y));
			}
			System.out.println();
		}
	}

}
