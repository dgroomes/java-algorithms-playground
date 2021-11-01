package dgroomes;

public record Point(int x, int y) {

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
            Point computedPoint = new Point(point.x() + xOffset, point.y() + yOffset);
            System.out.println("AdjacentPositionFinders#from: computedPoint=" + computedPoint);
            return computedPoint;
        }
    }

    public static Point getPointAtNewLineFrom(Point point) {
        return new Point(0, point.y() + 1);
    }
}
