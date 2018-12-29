package crackingthecodinginterview6;
import java.util.HashMap;

/**
 * Checks whether each character in a string is unique.
 * @author Michael Ning
 *
 */
public class isUnique {
    
    public static void main(String[] args) {

        String str = "aaaa";
        if(isunique(str)) {
            System.out.println("pass");
        }
        else {
            System.out.println("error");
        }
    }
    
    public static boolean isunique(String str) {
        HashMap<Character,Integer> characters = new HashMap<Character,Integer>();
        for(int i=0; i<str.length();i++) {
            characters.put(str.charAt(i), characters.getOrDefault(str.charAt(i),0)+1);
            if(characters.get(str.charAt(i)) == 2) {
                return false;
            }
        }
        return true;
    }
}
