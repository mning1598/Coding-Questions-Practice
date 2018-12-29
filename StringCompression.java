package crackingthecodinginterview6;

/**
 * Compresses the string into a different format
 * @author Michael Ning
 *
 */
public class StringCompression {
    public static void main(String[] args) {
        
        String str = "aaaaffbbbbccccddd";
        
        System.out.println(compress(str));
    }
    
    public static String compress(String s1) {
        String res = "" + s1.charAt(0);
        int count = 1;
        
        for(int i = 1; i < s1.length(); i++) {
            if((s1.charAt(i) !=s1.charAt(i-1))) {
                res+= String.valueOf(count);
                res+=s1.charAt(i);
                count=1;
            }
            else {
                count++;
                continue;
            }
        }
        res+=String.valueOf(count);
        return res;
        
    }

}
