package raig.org;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {


  private List<BowlingFrame> frameList = new ArrayList<>();
  private int fa;

  public void add(BowlingFrame bowlingFrame) {
    if ( frameList.size() >= 10 ) {
      throw new MaximumFrameReached();
    }
    this.frameList.add(bowlingFrame);
  }

  public int getScore() {
    return frameList.stream()
            .map(frame -> frame.getScore())
            .collect(Collectors.summingInt(Integer::intValue));
  }

  public int getScoresForFrame(int frameNumber) {

    return frameList.subList(0 , frameNumber)
            .stream().map(frame -> frame.getScore())
            .collect(Collectors.summingInt(Integer::intValue));
  //  return frameList.get(frameNumber-1).getScore();
  }

  public class MaximumFrameReached extends RuntimeException {
    public MaximumFrameReached() {
      super();
    }
  }
}
