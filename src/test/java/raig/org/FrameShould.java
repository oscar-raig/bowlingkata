package raig.org;


import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class FrameShould {

  BowlingFrame bowlingframe;

  @Before
  public void setUp() {
    bowlingframe = new BowlingFrame();
  }

  @Test
  public void returnCalculatedScore() {

    assertThat(bowlingframe.getScore(), Is.is(0));
  }

  @Test
  public void returnNumberOfThrows() {

    assertThat(bowlingframe.getThowNumber(), Is.is(0));
  }

  @Test
  public void addThrow() {

    bowlingframe.add(new BowlingThrow(1));
    assertThat(bowlingframe.getThowNumber(), Is.is(1));
  }

  @Test(expected = BowlingFrame.MaximNumberOfThrowsReached.class)
  public void throwExceptionIfThereAreMoreThanThreeThrows() {

    bowlingframe.add(new BowlingThrow(1));
    bowlingframe.add(new BowlingThrow(1));
    bowlingframe.add(new BowlingThrow(1));
    bowlingframe.add(new BowlingThrow(1));
  }

  @Test
  public void sumThrowsInScore() {

    bowlingframe.add(new BowlingThrow(6));
    bowlingframe.add(new BowlingThrow(3));

    assertThat(bowlingframe.getScore(), Is.is(9));
  }
}
