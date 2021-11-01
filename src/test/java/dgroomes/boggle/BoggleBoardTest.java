package dgroomes.boggle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dgroomes.boggle.BoggleTileAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class BoggleBoardTest {

    @Test
    public void testIterator() throws Exception {
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
