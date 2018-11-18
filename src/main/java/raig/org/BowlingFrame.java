package raig.org;

import java.util.ArrayList;
import java.util.List;

public class BowlingFrame {

  private int score;
  private List<BowlingThrow> throwlist = new ArrayList<>();

  public int getScore() {
    return score;
  }

  public int getThowNumber() {
    return throwlist.size();
  }

  public void add(BowlingThrow bowlingThrow) {
    if(throwlist.size()>= 3) {
      throw new MaximNumberOfThrowsReached();
    }
    throwlist.add(bowlingThrow);
  }

  public class MaximNumberOfThrowsReached extends RuntimeException {
    public MaximNumberOfThrowsReached() {
      super();
    }
  }
}
