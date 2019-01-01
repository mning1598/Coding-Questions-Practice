package crackingthecodinginterview6;

/**
 * Given a double n (between 0 and 1 non-inclusive), return the binary representation of n.
 * @author Michael Ning
 *
 */
public class DecimalBinaryConversion {
    
    public static void main(String[] args) {
        String a = convertDecimal(0.125);
        System.out.println(a);
        String b = convertDecimal(.00000000000001);
        System.out.println(b);

        
    }
    
    public static String convertDecimal(double n) {
        if(n <=0 || n >=1) {
            return "ERROR";
        }
        StringBuilder res = new StringBuilder();
        res.append(".");
        while(n > 0) {
            if(res.length() > 32) {
                return "ERROR";
            }
            n = n*2;
            if(n >=1) {
                n = n- 1;
                res.append("1");
            }
            else {
                res.append("0");
            }
        }
        return res.toString();
        
    }
}
