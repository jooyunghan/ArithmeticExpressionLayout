package com.jooyunghan.arith;

public interface Expression {
	char print(int x, int y);
	int height();
	int baseline();
	int width();
	int precedence();
}