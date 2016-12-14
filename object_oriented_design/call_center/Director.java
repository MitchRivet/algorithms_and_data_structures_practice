package call_center_prob;

import java.util.*;

public class Director extends Employee {
  public Director(String newName, boolean available) {
        this.name = newName;
        this.isAvailable = available;
        this.title = "Director";
}
}
