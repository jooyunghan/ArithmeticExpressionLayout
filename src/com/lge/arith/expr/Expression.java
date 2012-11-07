package com.lge.arith.expr;

/**
 * Expression to be printed. Each 'pixel' can be retrieved by getChar().
 * <code>new Minus(new Term(3), new Term("x"))</code> means "3 - x". The same
 * expression objects may be constructed by Parser.parse("3-x").
 * 
 * @author jooyung.han
 * 
 */
public class Expression {

	/**
	 * Returns 'pixel' character of relative position(x,y).
	 * 
	 * @param x
	 *            x-coordinate relative to its own origin(0, 0). 0 <= x < width
	 * @param y
	 *            y-coordinate relative to its own origin(0, 0). 0 <= y < height
	 * @return character to be printed (x, y)
	 */
	public char getChar(int x, int y) {
		return ' ';
	}

	/**
	 * 'Pixel' height for this expression
	 * 
	 * @return height for this expression
	 */
	public int height() {
		return 0;
	}

	/**
	 * 'Pixel' width for this expression
	 * 
	 * @return width for this expression
	 */
	public int width() {
		return 0;
	}
}
