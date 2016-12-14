package call_center_prob;
import java.util.*;

//employee is an abstract class since responders, directors, and managers are all employees
public abstract class Employee {
//properties of every employee
public String title;
public boolean isAvailable;
public String name;

//methods generic to all employee types
public String getTitle() {
        return title;
}

public boolean getAvailability() {
        return isAvailable;
}

}
