package call_center_prob;

//will create for the entire group of employees/office
public class CallCenter {
  public int numberOfResponders;
  public int numberOfManagers;
  public int numberOfDirectors;

  public CallCenter(int numberOfResponders, int numberOfMangers, int numberofDirectors) {
    this.numberOfResponders = numberOfResponders;
    this.numberOfManagers = numberOfMangers;
    this.numberOfDirectors = numberOfDirectors;
  }

  public String dispatchCall(Call incomingCall) {
    return "call has been dispatched";
  }
}
