package dgroomes;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static dgroomes.testing.Assertions.assertThat;

/**
 * This class represents a trail of contiguous Boggle tiles. Imagine when you play Boggle, you're drawing trails of contiguous 
 * Boggle tiles to spell words. This class represents that kind of trail. 
 * Meant to be immutable.
 */
public class BoggleTileTrail {
		
	private final BoggleTile currentTile;

	private final List<BoggleTile> visitedTiles;

	public List<BoggleTile> getVisitedTiles() {
		return visitedTiles;
	}
	
	public BoggleTile getCurrentTile() {
		return currentTile;
	}
	
	public BoggleTileTrail(List<BoggleTile> tiles) {
		if (tiles == null || tiles.size() == 0) {
			throw new IllegalArgumentException("illegal trail");
		} else if (tiles.size() == 1) {
			currentTile = tiles.get(0);
			visitedTiles = new ArrayList<>();
		} else {
			currentTile = tiles.get(tiles.size() - 1);
			visitedTiles = new ArrayList<>(tiles);
			visitedTiles.remove(visitedTiles.size() - 1);
		}
        assertThat(currentTile).isNotNull();
	}
	
	public BoggleTileTrail(BoggleTile tile) {
        assertThat(tile).isNotNull();
		this.currentTile = tile;
		this.visitedTiles = new ArrayList<>();
	}
	
	/**
	 * Extend a trail into a new trail by appending a tile.
	 */
	public BoggleTileTrail extend(BoggleTile extensionTile) {
		List<BoggleTile> trail = new ArrayList<>(visitedTiles);
		trail.add(currentTile);
		trail.add(extensionTile);
		return new BoggleTileTrail(trail);
	}
	
	public boolean haveNotVisited(BoggleTile tile) {
		return !haveVisited(tile);
	}
	
	private boolean haveVisited(BoggleTile tile) {
		System.out.println("#haveVisited: tile=" + tile);
		return visitedTiles.stream().anyMatch(tile::equals);
	}
	
	@Override 
	public String toString() {
		String s = getVisitedTiles().stream()
			.map(BoggleTile::getLetter)
			.map(c -> c.toString())
			.collect(Collectors.joining(""));
		return s + getCurrentTile().getLetter();
	}

}
