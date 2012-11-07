package com.lge.arith;

import java.io.IOException;

import com.lge.arith.expr.Expression;

public class Main {
	public static void main(String[] args) {
		String[] testCases = new String[] { "1", "2*1", "3+2*1", "3-2-1",
				"3*(2+1)", "3-(2-1)", "1/x", "1/xyz", "12/xyz", "1/x/y",
				"xy/(1-x)", "3-2/(1/x)", "z*(y/x-z/(1-x)/(y/x))"

		};
		for (String testCase : testCases) {
			test(testCase);
		}
	}

	private static void test(String string) {
		System.out.println("===============");
		System.out.println(string + " => ");
		try {
			Expression e = Parser.parse(string);

			// print as String for testing purpose.
			// you may delete this after print(e) does the job.
			System.out.println(e.toString());

			// for now, prints nothing ('cos height == 0)
			print(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Print expression using height(), width(), getChar() methods of Expression
	 * 
	 * @param e
	 *            expression to be printed
	 */
	private static void print(Expression e) {
		for (int y = 0; y < e.height(); y++) {
			for (int x = 0; x < e.width(); x++) {
				System.out.print(e.getChar(x, y));
			}
			System.out.println();
		}
	}
}
