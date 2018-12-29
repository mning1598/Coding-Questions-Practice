package crackingthecodinginterview6;
import java.util.HashMap;

/**
 * Checks whether two strings are permutations of each other.
 * @author Michael Ning
 *
 */
public class CheckStringPerms {
        
    public static void main(String[] args) {

        String str1 = "fa2ds";
        String str2 = "asdf2";
        if(strPerm(str1, str2)) {
            System.out.println("pass");
        }
        else {
            System.out.println("error");
        }
    }
    
    public static boolean strPerm(String str1, String str2) {
        if(str1.length() != str2.length() || str1 == null || str2 == null) {
            return false;
        }
        HashMap<Character,Integer> c1 = new HashMap<Character,Integer>();

        for(int i=0; i<str1.length();i++) {
            c1.put(str1.charAt(i), c1.getOrDefault(str1.charAt(i),0)+1);
        }
        for(int i=0; i<str2.length();i++) {
            if(c1.get(str2.charAt(i)) != 1) {
                return false;
            }
            c1.put(str2.charAt(i), c1.get(str2.charAt(i))-1);
        }
        
        return true;
    }
    

}
