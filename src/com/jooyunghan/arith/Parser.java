package com.jooyunghan.arith;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/*
 exression = sum
 sum = product (('+'|'-') product)*
 product = term (('*'|'/') term)*
 term =  number | '(' expression ')'
 */
public class Parser {
	private StreamTokenizer st;

	public Parser(String string) {
		st = new StreamTokenizer(new StringReader(string));
		st.ordinaryChar('/');
		st.ordinaryChar('-');
	}
	
	public static Expression parse(String string) throws IOException {
		return new Parser(string).expression();
	}

	// expression = sum
	public Expression expression() throws IOException {
		return sum();
	}

	// sum = product (('+'|'-') product)*
	Expression sum() throws IOException {
		Expression result = product();
		while (true) {
			st.nextToken();
			if (st.ttype == '+') {
				result = new Plus(result, product());
			} else if (st.ttype == '-') {
				result = new Minus(result, product());
			} else {
				st.pushBack();
				break;
			}
		}
		return result;
	}

	// product = term (('*'|'/') term)*
	Expression product() throws IOException {
		Expression result = term();
		while (true) {
			st.nextToken();
			if (st.ttype == '*') {
				result = new Multiply(result, term());
			} else if (st.ttype == '/') {
				result = new Divide(result, term());
			} else {
				st.pushBack();
				break;
			}
		}
		return result;
	}

	// term = number | '(' expression ')'
	Expression term() throws IOException {
		int ttype = st.nextToken();
		if (ttype == StreamTokenizer.TT_NUMBER) {
			return new Term((int)st.nval);
		} else if (ttype == StreamTokenizer.TT_WORD) {
			return new Term(st.sval);
		} else if (ttype == '(') {
			Expression result = expression();
			st.nextToken();
			return result;
		} else {
			throw new RuntimeException("Number or ( expected");
		}
	}
}