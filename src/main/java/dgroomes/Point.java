package dgroomes;

import java.util.Objects;

public class Point {
	
	private final int x;
	
	private final int y;

	public int getX() { 
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public final boolean equals(Object other) {
		if (other == this) {
			return true;
		} else if (other instanceof Point) {
			Point that = (Point) other;
			return Objects.equals(x, that.getX()) &&
			    Objects.equals(y, that.getY());			
		} else {
			return false;
		}
	}	
	
	@Override
	public String toString() {
		return "us.mn.dgtc.Point: x=" + x + " y=" + y;
	}
	
	@Override
	public final int hashCode() {
		return Objects.hash(x, y);
	}
	
	enum AdjacentPositionFinders {
		TOP(0, -1),
		TOP_RIGHT(1, -1),
		RIGHT(1, 0),
		BOTTOM_RIGHT(1, 1),
		BOTTOM(0, 1),
		BOTTOM_LEFT(-1, 1),
		LEFT(-1, 0),
		TOP_LEFT(-1, -1);
		
		private int xOffset;
		private int yOffset;
		
		AdjacentPositionFinders(int xOffset, int yOffset) {
			this.xOffset = xOffset;
			this.yOffset = yOffset;
		}		
		
		public Point from(Point point) {
			Point computedPoint = new Point(point.getX() + xOffset, point.getY() + yOffset);
			System.out.println("AdjacentPositionFinders#from: computedPoint=" + computedPoint);
			return computedPoint;
		}
	}
	
	public static Point getPointAtNewLineFrom(Point point) {
		return new Point(0, point.getY() + 1);
	}
}
