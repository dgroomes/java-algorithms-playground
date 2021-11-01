package dgroomes.mn.dgtc.unorganized;

import org.junit.Test;
import dgroomes.BoggleBoard;
import dgroomes.BoggleTile;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Groomes on 9/15/2015.
 */
public class BoggleBoardTest {

    @Test
    public void testIterator() throws Exception {
        // Arrange
        BoggleBoard boggleBoard = makeBoard();

        // Act
        Iterator<BoggleTile> iterator = boggleBoard.iterator();

        // Assert
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('i');
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('t');
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('s');
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isTrue();
        BoggleTileAssert.assertThat(iterator.next()).hasLetter('z');
        assertThat(iterator.hasNext()).isFalse();
    }

    //<editor-fold desc="Test helpers">
    public static BoggleBoard makeBoard() {
        List<Character> row1 = Arrays.asList('i', 't', 'z');
        List<Character> row2 = Arrays.asList('z', 's', 'z');
        List<Character> row3 = Arrays.asList('z', 'z', 'z');
        return BoggleBoard.buildBoggleBoard(Arrays.asList(row1, row2, row3));
    }
    //</editor-fold>
}
