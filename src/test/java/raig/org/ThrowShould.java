package raig.org;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class ThrowShould {

  @Test
  public void acceptValidKnockedPins() {

    BowlingThrow bowlingThrow = new BowlingThrow(5);
    assertThat(bowlingThrow.getKnockedPins(), Is.is(5));
  }

  @Test(expected = BowlingThrow.InvalidKnockedPin.class)
  public void notAcceptInvalidKniockedPins() {
    new BowlingThrow(14);
  }

}
