package call_center_prob;
import java.util.*;

public class Problem {

public static String[] responderNames = {"Joe", "Janice", "Jake", "Anna", "Gizele", "Oscar"};
public static String[] managerNames = {"Mike", "Donna", "Homer", "Neil", "Brad", "Dan", "Charlie", "Samantha"};
public static String[] directorNames = {"Amy", "Scarlett", "Bridgette", "Johnson"};
public static Random r = new Random();

public static ArrayList<Responder> createResponders() {
        int numResponders = r.nextInt(responderNames.length);
        ArrayList<Responder> responders = new ArrayList<Responder>(numResponders);

        for (int i = 0; i < numResponders; i++) {
                responders.add(new Responder(responderNames[i], r.nextBoolean()));
        }

        return responders;
}

public static ArrayList<Manager> createManagers() {
        int numManagers = r.nextInt(managerNames.length);
        ArrayList<Manager> managers = new ArrayList<Manager>(managerNames.length);
        for (int i = 0; i < numManagers; i++) {
                managers.add(new Manager(managerNames[i], r.nextBoolean()));
        }
        return managers;
}

public static ArrayList<Director> createDirectors() {
        int numDirectors = r.nextInt(directorNames.length);
        ArrayList<Director> directors = new ArrayList<Director>(directorNames.length);
        for (int i = 0; i < numDirectors; i++) {
                directors.add(new Director(directorNames[i], r.nextBoolean()));
        }
        return directors;
}

public static void main(String[] args) {
        ArrayList<Responder> currentResponders = createResponders();
        ArrayList<Manager> currentManagers = createManagers();
        ArrayList<Director> currentDirectors = createDirectors();

        CallCenter newCallCenter = new CallCenter(currentResponders, currentManagers, currentDirectors);

        int difficultyRoll = r.nextInt(2) + 1;
        Call.Difficulty diff;

        switch (difficultyRoll) {
        case 1:
                diff = Call.Difficulty.EASY;
                break;
        case 2:
                diff = Call.Difficulty.MEDIUM;
                break;
        case 3:
                diff = Call.Difficulty.HARD;
                break;
        default:
                diff = Call.Difficulty.EASY;
                break;
        }

        Call firstCall = new Call(diff);

        System.out.println(newCallCenter.dispatchCall(firstCall));
        // for (Director res : newCallCenter.directors) System.out.println(res.name);

}
}
