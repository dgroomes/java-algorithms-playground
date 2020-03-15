package us.mn.dgtc.unorganized;

import org.junit.Test;
import us.mn.dgtc.Assertions;
import us.mn.dgtc.BoggleBoard;
import us.mn.dgtc.Dictionary;
import us.mn.dgtc.WordFinder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

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