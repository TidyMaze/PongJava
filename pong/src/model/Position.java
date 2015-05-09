package model;

public enum Position {
	LEFT, TOP, RIGHT, BOTTOM;

	static boolean isHorizontal(Position position) {
		return position == TOP || position == BOTTOM;
	}

	static boolean isVertical(Position position) {
		return position == LEFT || position == RIGHT;
	}
}
