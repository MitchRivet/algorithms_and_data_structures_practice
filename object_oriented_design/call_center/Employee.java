package call_center_prob;
import java.util.*;

//lets create an abstract class
public abstract class Employee {
  //properties of employee
  public String title;
  public boolean isAvailable;
  public String name;

  //methods for each employee
  public String getTitle() {
      return title;
  }

  public boolean getAvailability() {
    return isAvailable;
  }

}
