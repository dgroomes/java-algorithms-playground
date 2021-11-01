package dgroomes.boggle;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static dgroomes.testing.Assertions.assertThat;

public class WordFinderTest {

    @Test
    public void doIt() {
        // Arrange
        var board = BoggleBoardTest.makeBoard();
        var wordFinder = new WordFinder(board, Dictionary.createDictionary());

        // Act
        var foundWords = wordFinder.findWords();

        // Assert
        assertThat(foundWords).isEqualTo(Set.of("it", "is", "its", "zit", "zits", "sit"));
    }
}
