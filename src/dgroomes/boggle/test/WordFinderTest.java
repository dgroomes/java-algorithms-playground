package dgroomes.boggle.test;

import dgroomes.boggle.Dictionary;
import dgroomes.boggle.WordFinder;

import java.util.Set;

import static dgroomes.TerminalUtil.bold;
import static dgroomes.TerminalUtil.reset;
import static dgroomes.testing.Assertions.assertThat;
import static java.lang.System.out;

public class WordFinderTest {

  public static void main(String[] args) {
    bold();
    out.println("WordFinderTest");
    reset();
    test();

    out.println("\n");
  }

  public static void test() {
    // Arrange
    var board = BoggleBoardTest.makeBoard();
    var wordFinder = new WordFinder(board, Dictionary.createDictionary());

    // Act
    var foundWords = wordFinder.findWords();

    // Assert
    assertThat(foundWords).isEqualTo(Set.of("it", "is", "its", "zit", "zits", "sit"));
  }
}
