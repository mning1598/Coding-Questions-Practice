package crackingthecodinginterview6;

/**
 * Returns a modified string where spaces are replaced with "%20"
 * @author michael1
 *
 */
public class URLify {

    public static void main(String[] args) {

        String str1 = "Mr John Smith    ";
        int len = 13;
            System.out.println(change(str1, len));
    }
    
    public static String change(String str, int len) {
        
        String res = "";
        boolean space = false;
        for(int i =0; i<len;i++) {
            if(str.charAt(i) != ' ') {
                res+= str.charAt(i);
            }
            else {
                if(str.charAt(i+1) == ' ') {
                    continue;
                }
                else {
                    res+="%20";
                }
            }
        }
        return res;
           
    }
}
