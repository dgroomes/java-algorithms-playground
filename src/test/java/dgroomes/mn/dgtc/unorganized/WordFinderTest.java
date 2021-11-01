package dgroomes.mn.dgtc.unorganized;

import dgroomes.BoggleBoard;
import dgroomes.Dictionary;
import dgroomes.WordFinder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static dgroomes.testing.Assertions.assertThat;

public class WordFinderTest {

    @Test
    public void doIt() {
        // Arrange
        BoggleBoard board = BoggleBoardTest.makeBoard();
        WordFinder wordFinder = new WordFinder(board, Dictionary.createDictionary());

        // Act
        Set<String> foundWords = wordFinder.findWords();

        // Assert
        assertThat(foundWords).isEqualTo(new HashSet<>(Arrays.asList("it", "is", "its", "zit", "zits", "sit")));
    }
}
