package model;

import java.awt.geom.Rectangle2D.Double;

public class MyDoubleRectangle2D extends Double {
	public MyDoubleRectangle2D(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	public MyDoubleRectangle2D() {
		super();
	}

	@Override
	public String toString() {
		return "Rectangle : x=" + getX() + ", y=" + getY() + ", width =" + getWidth() + ", height="
				+ getHeight();
	}
}
