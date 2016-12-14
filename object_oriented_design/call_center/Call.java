package call_center_prob;

public class Call {
  public enum Difficulty { EASY, MEDIUM, HARD };

  public Call(Difficulty difficulty) {
    this.difficulty = difficulty;
    this.handled = false;
  }

  public void handleCall() {
    this.handled = true;
  }

  Difficulty difficulty;
}
