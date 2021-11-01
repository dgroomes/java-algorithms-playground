package dgroomes;

import java.util.Objects;

public class BoggleTile {
	
	private final Character letter;

	private final Point point;

	public Character getLetter() {
		return letter;
	}
	
	public Point getPoint() {
		return point;
	}

	public BoggleTile(Point point, Character letter){
		this.point = point;
		this.letter = letter;
	}
	
	@Override
	public final boolean equals(Object other) {
			if (other == this) {
				return true;
			} else if (other instanceof BoggleTile) {
				BoggleTile that = (BoggleTile) other;
				return Objects.equals(letter, that.letter) &&
					Objects.equals(point, that.point);
			} else {
				return false;
			}
	}
	
	@Override
	public final int hashCode() {
		return Objects.hash(letter, point);
	}
}
