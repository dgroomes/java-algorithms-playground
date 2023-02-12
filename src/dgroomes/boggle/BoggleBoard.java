package dgroomes.boggle;

import dgroomes.coordinates.Point;

import java.util.*;
import java.util.stream.Collectors;

import static dgroomes.testing.Assertions.assertThat;

/**
 * You know the game Boggle? This Class represent the Boggle tile board. Tiles on the table are zero-indexed. E.g. a tile's coordinates
 * may be (0,0), (0,4), (1,0) etc. The properties "width" and "height" have nothing to do with zero-indexing. E.g. if the board is of size
 * 4x4, then the width is 4 and the height is 4--not 3 and 3.
 */
public record BoggleBoard(
        Map<Point, BoggleTile> mapOfBoard,
        int width,
        int height) implements Iterable<BoggleTile> {

    public static BoggleBoard buildBoggleBoard(List<List<Character>> characterMatrix) {
        Map<Point, BoggleTile> mapOfBoard = new HashMap<>();
        if (characterMatrix == null || characterMatrix.size() == 0 || characterMatrix.get(0).size() == 0) {
            throw new IllegalArgumentException("illegal boggle board");
        }
        int rows = characterMatrix.size();
        int columns = characterMatrix.get(0).size();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Point point = new Point(column, row);
                mapOfBoard.put(point, new BoggleTile(point, characterMatrix.get(row).get(column)));
            }
        }
        return new BoggleBoard(mapOfBoard, columns, rows);
    }

    public Iterator<BoggleTile> iterator() {
        return new Iterator<>() {

            private BoggleTile currentTile;

            public BoggleTile next() {
                if (currentTile == null) {
                    currentTile = mapOfBoard.get(new Point(0, 0));
                } else if (currentTile.point().x() < width - 1) {
                    currentTile = mapOfBoard.get(Point.AdjacentPositionFinders.RIGHT.from(currentTile.point()));
                } else {
                    currentTile = mapOfBoard.get(Point.getPointAtNewLineFrom(currentTile.point()));
                }
                return currentTile;
            }

            public boolean hasNext() {
                if (currentTile == null) {
                    return true;
                } else {
                    return !(currentTile.point().x() == width - 1 && currentTile.point().y() == height - 1);
                }
            }
        };
    }

    public Set<BoggleTile> getAdjacentTilesOf(BoggleTile tile) {
        assertThat(tile).isNotNull();
        Point point = tile.point();
        Set<BoggleTile> adjacentTiles = Arrays.stream(Point.AdjacentPositionFinders.values())
                .map(finder -> finder.from(point))
                .filter(this::inBounds)
                .map(mapOfBoard::get)
                .collect(Collectors.toSet());

        System.out.println("Boggleboard#getAdjacentTilesOf: adjacentTiles.size()=" + adjacentTiles.size());
        return adjacentTiles;
    }

    private boolean inBounds(Point point) {
        return point.x() >= 0 && point.y() >= 0 && point.x() < width && point.y() < height;
    }
}
