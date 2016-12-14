package call_center_prob;
import java.util.*;

public class Problem {
  public static String[] responderNames = {"Joe", "Janice", "Jake"};
  public static String[] managerNames = {"Mike", "Donna"};
  public static String[] directorNames = {"Amy"};

  public static ArrayList<Responder> createResponders() {
    ArrayList<Responder> responders = new ArrayList<Responder>(responderNames.length);

    for (int i = 0; i < responderNames.length; i++) {
      responders.add(new Responder(responderNames[i]));
    }
    return responders;
  }

  public static ArrayList<Manager> createManagers() {
    ArrayList<Manager> managers = new ArrayList<Manager>(managerNames.length);

    for (int i = 0; i < managerNames.length; i++) {
      managers.add(new Manager(managerNames[i]));
    }
    return managers;
  }
  public static ArrayList<Director> createDirectors() {
    ArrayList<Director> directors = new ArrayList<Director>(directorNames.length);

    for (int i = 0; i < directorNames.length; i++) {
      directors.add(new Director(directorNames[i]));
    }
    return directors;
  }

  public static void main(String[] args) {


    ArrayList<Responder> currentResponders = createResponders();
    ArrayList<Manager> currentManagers = createManagers();
    ArrayList<Director> currentDirectors = createDirectors();

    CallCenter newCallCenter = new CallCenter(currentResponders, currentManagers, currentDirectors);
    Call firstCall = new Call(Call.Difficulty.MEDIUM);

    //newCallCenter.dispatchCall(firstCall)
    for (Responder res : newCallCenter.responders) System.out.println(res.name);


  }
}
