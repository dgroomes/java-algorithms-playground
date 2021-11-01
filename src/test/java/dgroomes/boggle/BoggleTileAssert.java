package dgroomes.boggle;

import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

class BoggleTileAssert extends AbstractAssert<BoggleTileAssert, BoggleTile> {
    protected BoggleTileAssert(BoggleTile actual) {
        super(actual, BoggleTileAssert.class);
    }

    public void hasLetter(char c) {
        isNotNull();

        if (!Objects.equals(c, actual.letter())) {
            failWithMessage("Expected boggle tile to have letter <%s> but was <%s>", c, actual.letter());
        }
    }

    public static BoggleTileAssert assertThat(BoggleTile actual) {
        return new BoggleTileAssert(actual);
    }

}