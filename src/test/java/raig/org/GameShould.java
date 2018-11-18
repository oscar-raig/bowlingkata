package raig.org;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

public class GameShould {

  @Test(expected = Game.MaximumFrameReached.class)
  public void addTenFrameAsMaximum() {

    Game game = new Game();

    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
    game.add(new BowlingFrame());
  }

  @Test
  public void returnScoreForASpecificFrame() {

    Game game = new Game();

    game.add(getBowlingFrame(5,4));
    game.add(getBowlingFrame(7,2));


    assertThat(game.getScore(), Is.is(18));
    assertThat(game.getScoresForFrame(1), Is.is(9));
    assertThat(game.getScoresForFrame(2), Is.is(18));

  }

  private BowlingFrame getBowlingFrame(int ...  knockedPins) {
    BowlingFrame bowlingFrame = new BowlingFrame();
    for(int i = 0; i< knockedPins.length; i++) {
      bowlingFrame.add(new BowlingThrow(knockedPins[i]));
    }

    return bowlingFrame;
  }

}
