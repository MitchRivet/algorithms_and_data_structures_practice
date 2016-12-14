package call_center_prob;
import java.util.*;

public class Problem {
  public static String[] responderNames = {"Joe", "Janice", "Jake"};
  public String[] managerNames = {"Mike", "Donna"};
  public String[] directorNames = {"Amy"};

  public static ArrayList<Responder> createResponders() {
    ArrayList<Responder> responders = new ArrayList<Responder>(3);

    for (int i = 0; i < responderNames.length; i++) {
      responders.add(new Responder(responderNames[i]));
    }
    return responders;
  }

  public static void main(String[] args) {
    //create a call center

    ArrayList<Responder> currentResponders = createResponders();
    //CallCenter newCallCenter = new CallCenter(8, 3, 1, 0, 2, 0);
    //Call firstCall = new Call(Call.Difficulty.MEDIUM);

    //newCallCenter.dispatchCall(firstCall)
    for (Responder res : currentResponders) System.out.println(res.name);


  }
}
