package call_center_prob;
import java.util.*;

//will create for the entire group of employees/office
public class CallCenter {
  // public int numberOfResponders;
  // public int numberOfManagers;
  // public int numberOfDirectors;
  // public int availableResponders;
  // public int availableManagers;
  // public int availableDirectors;

  public ArrayList<Responder> responders;
  public ArrayList<Manager> managers;
  public ArrayList<Director> directors;

//   public boolean responderAvailable(final ArrayList<Responder> res) {
//     return res.stream().filter(o -> o.getAvailability().equals(true)).findFirst().isPresent();
// }

  public CallCenter(ArrayList<Responder> responders, ArrayList<Manager> managers,
    ArrayList<Director> directors) {

    this.responders = responders;
    this.managers = managers;
    this.directors = directors;
  }

  public String dispatchCall(Call incomingCall) {
    return "nothing yet";
    // if (incomingCall.difficulty == Call.Difficulty.EASY && this.availableResponders > 0) {
    //   return "A Responder will take your call";
    // }
    //
    // if ((incomingCall.difficulty == Call.Difficulty.MEDIUM ||
    //   incomingCall.difficulty == Call.Difficulty.EASY)
    //   && this.availableManagers > 0) {
    //   return "A Manager will take your call";
    // }
    //
    // if ((incomingCall.difficulty == Call.Difficulty.HARD ||
    //   incomingCall.difficulty == Call.Difficulty.MEDIUM ||
    //   incomingCall.difficulty == Call.Difficulty.EASY)
    //   && this.availableDirectors > 0) {
    //   return "The Director will take your call";
    // } else {
    //   return "No one is available, please hold";
    // }
  }
}
