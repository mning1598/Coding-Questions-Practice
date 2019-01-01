package crackingthecodinginterview6;

/**
 * Given a positive integer, print the next smallest and the next 
 * largest number that have the same number of 1 bits in their 
 * binary representation.
 * @author Michael Ning
 *
 */
public class NextNumber {

    public static void main(String[] args) {
        int a = 21;
        findNext(a);
    }
    
    public static void findNext(int n) {
        int oneCount = 0;
        int len = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                oneCount++;
            }
            len = len + 1;
            n = n >> 1;
        }
        
        //max
        int x = 0;
        int tempL = len;
        int tempC = oneCount;
        while(tempL >0) {
            x = x << 1;
            if(tempC > 0) {
                x++;
                tempC--;
            }
            tempL--;
        }
        System.out.println("The largest representation with these ones is: " + x);
        int m = 0;
        while(oneCount > 0) {
            m = m << 1;
            m++;
            oneCount--;
        }
        System.out.println("The smallest representation with these ones is: " + m);
    }
}
