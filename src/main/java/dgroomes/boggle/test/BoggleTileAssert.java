package dgroomes.boggle.test;

import dgroomes.boggle.BoggleTile;
import dgroomes.testing.Assertable;

import java.util.Objects;

class BoggleTileAssert extends Assertable<BoggleTile> {
  protected BoggleTileAssert(BoggleTile actual) {
    super(actual);
  }

  public void hasLetter(char c) {
    isNotNull();

    if (!Objects.equals(c, actual.letter())) {
      fail("Expected boggle tile to have letter '%s' but was '%s'".formatted(c, actual.letter()));
    }
  }

  public static BoggleTileAssert assertThat(BoggleTile actual) {
    return new BoggleTileAssert(actual);
  }
}
