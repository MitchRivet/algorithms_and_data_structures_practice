import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Path {

    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Path cd(String newPath) {
      //split up the current path and the new one
      String[] newP = newPath.split("/");
      String[] oldP= path.split("/");

      int lnCount=0;
      //count out how many times we go back
       for(String str:newP){
        if(str.equals("..")){
         lnCount++;
        }
       }

     //how many items in the old path array
     int len = oldP.length;

     //to return
     String strOut = "";

     //only grab up to the things that we want
     for (int i=0; i < len-lnCount; i++){
      strOut = strOut + oldP[i] + "/";
     }

     //overwrite len
     len = newP.length;

     for (int i=0; i<len ; i++) {
      if(!newP[i].equals("..")) {
       strOut=strOut+newP[i]+"/";
      }
     }

     path = strOut.substring(0, strOut.length()-1);

     if (path.indexOf("/") < 0) {
      throw new UnsupportedOperationException("Directory not found");
     }

     return this;
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        System.out.println(path.cd("../x").getPath());
    }
}
