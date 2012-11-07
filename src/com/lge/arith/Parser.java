package com.lge.arith;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

import com.lge.arith.expr.Divide;
import com.lge.arith.expr.Expression;
import com.lge.arith.expr.Minus;
import com.lge.arith.expr.Multiply;
import com.lge.arith.expr.Plus;
import com.lge.arith.expr.Term;

/**
 * Parser parses the arithmetic expression according to the following grammar.
 * 
 * <pre>
 * expression = sum
 * sum = product (('+'|'-') product)*
 * product = term (('*'|'/') term)*
 * term =  value | '(' expression ')'
 * </pre>
 */
public class Parser {
	private StreamTokenizer st;

	/**
	 * @param string expression to be parsed
	 * @return Expression object, which is a parse tree.
	 * @throws IOException 
	 */
	public static Expression parse(String string) throws IOException {
		return new Parser(string).expression();
	}
	
	private Parser(String string) {
		st = new StreamTokenizer(new StringReader(string));
		st.ordinaryChar('/');
		st.ordinaryChar('-');
	}

	// expression = sum
	private Expression expression() throws IOException {
		return sum();
	}

	// sum = product (('+'|'-') product)*
	private Expression sum() throws IOException {
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
	private Expression product() throws IOException {
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

	// term = value | '(' expression ')'
	private Expression term() throws IOException {
		int ttype = st.nextToken();
		if (ttype == StreamTokenizer.TT_NUMBER) {
			return new Term((int) st.nval);
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