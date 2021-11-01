package dgroomes.mn.dgtc.unorganized;

import org.assertj.core.api.AbstractAssert;
import dgroomes.BoggleTile;

import java.util.Objects;

/**
 * Created by David Groomes on 9/15/2015.
 */
class BoggleTileAssert extends AbstractAssert<BoggleTileAssert, BoggleTile> {
    protected BoggleTileAssert(BoggleTile actual) {
        super(actual, BoggleTileAssert.class);
    }

    public void hasLetter(char c) {
        isNotNull();

        if (!Objects.equals(c, actual.getLetter())) {
            failWithMessage("Expected boggle tile to have letter <%s> but was <%s>", c, actual.getLetter());
        }
    }

    public static BoggleTileAssert assertThat(BoggleTile actual) {
        return new BoggleTileAssert(actual);
    }

}
