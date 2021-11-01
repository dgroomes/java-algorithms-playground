package dgroomes.mn.dgtc.unorganized;

import org.junit.jupiter.api.Test;
import dgroomes.Assertions;
import dgroomes.BoggleBoard;
import dgroomes.Dictionary;
import dgroomes.WordFinder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by David Groomes on 9/15/2015.
 */
public class WordFinderTest {

    @Test
    public void doIt() {
        // Arrange
        BoggleBoard board = BoggleBoardTest.makeBoard();
        WordFinder wordFinder = new WordFinder(board, Dictionary.createDictionary());

        // Act
        Set<String> foundWords = wordFinder.findWords();

        // Assert
        Assertions.assertThat(foundWords).isEqualTo(new HashSet<>(Arrays.asList("it", "is", "its", "zit", "zits", "sit")));
    }
}
