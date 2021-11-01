package dgroomes.boggle;

import dgroomes.coordinates.Point;

public record BoggleTile(
        Point point,
        Character letter) {
}
