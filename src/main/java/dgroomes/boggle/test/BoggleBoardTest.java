package dgroomes.boggle.test;

import dgroomes.boggle.BoggleBoard;

import java.util.List;

import static dgroomes.TerminalUtil.bold;
import static dgroomes.TerminalUtil.reset;
import static dgroomes.boggle.test.BoggleTileAssert.assertThat;
import static dgroomes.testing.Assertions.assertThat;
import static java.lang.System.out;

public class BoggleBoardTest {

    public static void main(String[] args) {
        bold(); out.println("BoggleBoardTest"); reset();

        testIterator();

        out.println("\n");
    }

    public static void testIterator() {
        // Arrange
        var boggleBoard = makeBoard();

        // Act
        var iterator = boggleBoard.iterator();

        // Assert
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('i');
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('t');
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('s');
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isFalse();
    }

    public static BoggleBoard makeBoard() {
        var row1 = List.of('i', 't', 'z');
        var row2 = List.of('z', 's', 'z');
        var row3 = List.of('z', 'z', 'z');
        return BoggleBoard.buildBoggleBoard(List.of(row1, row2, row3));
    }
}
