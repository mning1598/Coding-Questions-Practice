package crackingthecodinginterview6;

/**
 * checks if two words are similar if rotated enough
 * @author Michael Ning
 *
 */
public class WordRotations {

    public static void main(String[] args) {
        String t = "asdfasdf";
        String t2 = "asdfasdd";
        if(rotateEqual(t,t2)) {
            System.out.println("it is a rotation");
        }
        else {
            System.out.println("no it is not");
        }
    }
    
    public static boolean rotateEqual(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        for(int i = 0; i < a.length();i++) {
            String beg = b.substring(0,i);
            String end = b.substring(i,b.length());
            if(a.equals(beg + end) || a.equals(end+beg)) {
                return true;
            }
        }
        
        
        return false;
    }
}
