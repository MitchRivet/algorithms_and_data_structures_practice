package call_center_prob;
import java.util.*;

public class Problem {

//these arrarys are collections of all the possible different employees
public static String[] responderNames = {"Joe", "Janice", "Jake", "Anna", "Gizele", "Oscar"};
public static String[] managerNames = {"Mike", "Donna", "Homer", "Neil", "Brad", "Dan", "Charlie", "Samantha"};
public static String[] directorNames = {"Amy", "Scarlett", "Bridgette", "Johnson"};
public static Random r = new Random();

public static ArrayList<Responder> createResponders() {
        //randomize the number of responders with the upperbound being the number of names we have
        int numResponders = r.nextInt(responderNames.length);
        ArrayList<Responder> responders = new ArrayList<Responder>(numResponders);

        //add too the arrayList with new responder objects
        for (int i = 0; i < numResponders; i++) {
                //randomize names and also randomize the availability of the employee
                responders.add(new Responder(responderNames[i], r.nextBoolean()));
        }

        return responders;
}

//same creation as responders
public static ArrayList<Manager> createManagers() {
        int numManagers = r.nextInt(managerNames.length);
        ArrayList<Manager> managers = new ArrayList<Manager>(managerNames.length);
        for (int i = 0; i < numManagers; i++) {
                managers.add(new Manager(managerNames[i], r.nextBoolean()));
        }
        return managers;
}

//same creation as responders
public static ArrayList<Director> createDirectors() {
        int numDirectors = r.nextInt(directorNames.length);
        ArrayList<Director> directors = new ArrayList<Director>(directorNames.length);
        for (int i = 0; i < numDirectors; i++) {
                directors.add(new Director(directorNames[i], r.nextBoolean()));
        }
        return directors;
}

public static void main(String[] args) {
        //get our current arrays of availble employees by title
        ArrayList<Responder> currentResponders = createResponders();
        ArrayList<Manager> currentManagers = createManagers();
        ArrayList<Director> currentDirectors = createDirectors();

        //pass these employees into the call center
        CallCenter newCallCenter = new CallCenter(currentResponders, currentManagers, currentDirectors);

        int difficultyRoll = r.nextInt(2) + 1;
        Call.Difficulty diff;

        //randomly choose the difficulty of the call
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

        //printing a string with the title and name of the available employee
        System.out.println(newCallCenter.dispatchCall(firstCall));

}
}
