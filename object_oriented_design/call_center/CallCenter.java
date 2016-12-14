package call_center_prob;
import java.util.*;

public class CallCenter {

public ArrayList<Responder> responders;
public ArrayList<Manager> managers;
public ArrayList<Director> directors;

public boolean responderAvailable(final ArrayList<Responder> res) {
        return res.stream().filter(o -> o.getAvailability() == true).findFirst().isPresent();
}

public boolean managerAvailable(final ArrayList<Manager> manager) {
        return manager.stream().filter(o -> o.getAvailability() == true).findFirst().isPresent();
}

public boolean directorAvailable(final ArrayList<Director> dir) {
        return dir.stream().filter(o -> o.getAvailability() == true).findFirst().isPresent();
}

public CallCenter(ArrayList<Responder> responders, ArrayList<Manager> managers,
                  ArrayList<Director> directors) {
        this.responders = responders;
        this.managers = managers;
        this.directors = directors;
}

public String dispatchCall(Call incomingCall) {

        Optional<Responder> nextResponder = this.responders.stream().filter(r -> r.getAvailability() == true).findAny();
        Optional<Manager> nextManager = this.managers.stream().filter(m -> m.getAvailability() == true).findAny();
        Optional<Director> nextDirector = this.directors.stream().filter(d -> d.getAvailability() == true).findAny();

        if (incomingCall.difficulty == Call.Difficulty.EASY) {
                if (responderAvailable(this.responders)) {
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
