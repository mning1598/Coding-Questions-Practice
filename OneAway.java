package crackingthecodinginterview6;

/**
 * checks if the two strings are exactly one edit away. An edit can include a replace, a delete, or an insert.
 * @author Michael Ning
 *
 */
public class OneAway {
    public static void main(String[] args) {
        
        String str = "abd";
        String str2 = "abcd";
        if(checkOne(str,str2)) {
            System.out.println("pass");
        }
        else {
            System.out.println("error");
        }
    }
    
    public static boolean checkOne(String s1, String s2) {
        
        if(s1.length() == s2.length()) {
            //replacing a letter
            int diff = 0;
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    diff++;
                }
            }
            return (diff == 1);

        }
        else if(s1.length() == s2.length() + 1) {
            //delete a letter abcd  acd
            int index1 = 0;
            int index2 = 0;
            while(index1 < s1.length() && index2 < s2.length()) {
                if(s1.charAt(index1) != s2.charAt(index2)) {
                    if(index1 != index2) {
                        return false;
                    }
                    index1++;
                }
                else {
                    index1++;
                    index2++;
                }
                
            }
            return true;
        }
        else if(s2.length() == s1.length() +1) {
            //insert a letter
            int index1 = 0;
            int index2 = 0;
            while(index1 < s1.length() && index2 < s2.length()) {
                if(s1.charAt(index1) != s2.charAt(index2)) {
                    if(index1 != index2) {
                        return false;
                    }
                    index2++;
                }
                else {
                    index1++;
                    index2++;
                }
            }
            return true;
        }
        
        return false;
           
    }
}
