package call_center_prob;

//will create for the entire group of employees/office
public class CallCenter {
  public int numberOfResponders;
  public int numberOfManagers;
  public int numberOfDirectors;
  public int availableResponders;
  public int availableManagers;
  public int availableDirectors;

  public CallCenter(int numberOfResponders, int numberOfMangers, int numberofDirectors,
  int availableResponders, int availableManagers, int availableDirectors) {
    this.numberOfResponders = numberOfResponders;
    this.numberOfManagers = numberOfMangers;
    this.numberOfDirectors = numberOfDirectors;
    this.availableResponders = availableResponders;
    this.availableManagers = availableManagers;
    this.availableDirectors = availableDirectors;
  }

  public String dispatchCall(Call incomingCall) {
    if (incomingCall.difficulty == Call.Difficulty.EASY && this.availableResponders > 0) {
      return "A Responder will take your call";
    }

    if ((incomingCall.difficulty == Call.Difficulty.MEDIUM ||
      incomingCall.difficulty == Call.Difficulty.EASY)
      && this.availableManagers > 0) {
      return "A Manager will take your call";
    }

    if ((incomingCall.difficulty == Call.Difficulty.HARD ||
      incomingCall.difficulty == Call.Difficulty.MEDIUM ||
      incomingCall.difficulty == Call.Difficulty.EASY)
      && this.availableDirectors > 0) {
      return "The Director will take your call";
    } else {
      return "No one is available, please hold";
    }
  }
}
