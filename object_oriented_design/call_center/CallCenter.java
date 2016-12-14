package call_center_prob;
import java.util.*;

public class CallCenter {

public ArrayList<Responder> responders;
public ArrayList<Manager> managers;
public ArrayList<Director> directors;

//use a filter to determine if the different types of employees are available
public boolean responderAvailable(final ArrayList<Responder> res) {
        return res.stream().filter(o -> o.getAvailability() == true).findFirst().isPresent();
}

public boolean managerAvailable(final ArrayList<Manager> manager) {
        return manager.stream().filter(o -> o.getAvailability() == true).findFirst().isPresent();
}

public boolean directorAvailable(final ArrayList<Director> dir) {
        return dir.stream().filter(o -> o.getAvailability() == true).findFirst().isPresent();
}

//constructor
public CallCenter(ArrayList<Responder> responders, ArrayList<Manager> managers,
                  ArrayList<Director> directors) {
        this.responders = responders;
        this.managers = managers;
        this.directors = directors;
}

//method for handling a call
public String dispatchCall(Call incomingCall) {

        //findAny returns an Optional, which will model a potentially missing value without null
        Optional<Responder> nextResponder = this.responders.stream().filter(r -> r.getAvailability() == true).findAny();
        Optional<Manager> nextManager = this.managers.stream().filter(m -> m.getAvailability() == true).findAny();
        Optional<Director> nextDirector = this.directors.stream().filter(d -> d.getAvailability() == true).findAny();

        //TODO: don't assume that the first avilable, qualified emplyee will be able to handle the call
        //roll to see if the call is a success and pass the call up if it is not
        if (incomingCall.difficulty == Call.Difficulty.EASY) {
                if (responderAvailable(this.responders)) {
                        //optionals require get() to access the properties of the original element
                        return "Responder, " + nextResponder.get().name + ", will be with you shortly";
                } else if (managerAvailable(this.managers)) {
                        return "Manager, " + nextManager.get().name + ", will be with you shortly";
                } else if (directorAvailable(this.directors)) {
                        return "Director, " + nextDirector.get().name + ", will be with you shortly";
                } else {
                        return "We are currently busy, please hold";
                }

        } else if (incomingCall.difficulty == Call.Difficulty.MEDIUM) {
                if (managerAvailable(this.managers)) {
                        return "Manager, " + nextManager.get().name + ", will be with you shortly";
                } else if (directorAvailable(this.directors)) {
                        return "Director, " + nextDirector.get().name + ", will be with you shortly";
                } else {
                        return "We are currently busy, please hold";
                }
        } else if (incomingCall.difficulty == Call.Difficulty.HARD) {
                if (directorAvailable(this.directors)) {
                        return "Director, " + nextDirector.get().name + ", will be with you shortly";
                } else {
                        return "We are currently busy, please hold";
                }
        } else {
                return "Currently waiting for a valid call";
        }
}
}
