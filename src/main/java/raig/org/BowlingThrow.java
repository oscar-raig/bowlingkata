package raig.org;

public class BowlingThrow {

  private final int knockedPins;

  public BowlingThrow(int knockedPins) {
    if ((knockedPins < 0) || (knockedPins > 12)) {
      throw new InvalidKnockedPin();
    }
    this.knockedPins = knockedPins;
  }

  public int getKnockedPins() {
    return knockedPins;
  }

  public class InvalidKnockedPin extends RuntimeException {
    public InvalidKnockedPin() {
      super();
    }
  }
}
