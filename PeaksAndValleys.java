package crackingthecodinginterview6;

import java.util.Arrays;

/**
 * Given an array, sort it in a sequence of "peaks" and "valleys."
 * Peaks are when the adjacent elements in an array are less than that element.
 * Valleys are when the adjacent elements in an an array are greater than that element.
 * @author michael1
 *
 */
public class PeaksAndValleys {

    
    public static void main(String[] args) {
        int[] a = {1,5,2,4,9,8,3,7};
        a = makeArr(a);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    public static int[] makeArr(int[] a) {
        Arrays.sort(a);
        for(int i=1; i < a.length; i= i+2) {
            int temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }
        return a;
    }
}
