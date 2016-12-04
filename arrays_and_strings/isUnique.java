import java.io.*;
import java.util.*;

//write an algorithm to check if a string contains all unqiue characters
public class isUnique {

  public static boolean checkUnique ( String str ) {
    char letterArray[] = new char[str.length()];
    boolean check = true;

    for (int i = 0; i < str.length(); i++){
      char c = str.charAt(i);

      if (!(new String(letterArray).indexOf(c) == -1)) {
        check = false;
      } else {
        letterArray[i] = c;
      }
    }

    if (check == true) {
      System.out.println("The string has all unique characters!");
    } else {
      System.out.println("The string does not have all unqiue characters");
    }

    return check;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String stringToCheck = sc.next();
    System.out.println("the string to check: " + stringToCheck);
    checkUnique(stringToCheck);

  }

}
