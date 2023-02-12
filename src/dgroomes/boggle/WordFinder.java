package dgroomes.boggle;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static dgroomes.testing.Assertions.assertThat;

public class WordFinder {

    private final BoggleBoard board;
    private final Dictionary dictionary;
    private final Set<String> foundWords = new HashSet<>();

    public WordFinder(BoggleBoard board, Dictionary dictionary) {
        this.board = board;
        this.dictionary = dictionary;
    }

    private boolean ran = false;

    public Set<String> findWords() {
        if (ran) {
            throw new IllegalStateException("this us.mn.dgtc.WordFinder has already found words");
        }
        ran = true;
        board.forEach(this::findWordsFromTile);
        return foundWords;
    }

    private void findWordsFromTile(final BoggleTile tile) {
        assertThat(tile).isNotNull();
        BoggleTileTrail trail = new BoggleTileTrail(tile);
        findWordsOfTrail(trail);
    }

    private void findWordsOfTrail(BoggleTileTrail trail) {
        Set<BoggleTileTrail> extendedTrails = board.getAdjacentTilesOf(trail.getCurrentTile())
                .stream()
                .filter(trail::haveNotVisited)
                .map(trail::extend)
                .collect(Collectors.toSet());
        Set<String> foundWordsInTrail = extendedTrails.stream()
                .map(BoggleTileTrail::toString)
                .filter(dictionary::isWord)
                .collect(Collectors.toSet());
        foundWords.addAll(foundWordsInTrail);
        extendedTrails.stream()
                .filter(extendedTrail -> dictionary.isPartialOfWordBeginning(extendedTrail.toString()))
                .forEach(this::findWordsOfTrail);
    }
}
