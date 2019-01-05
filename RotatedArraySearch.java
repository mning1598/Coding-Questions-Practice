package crackingthecodinginterview6;

/**
 * Searches for a number in an array that is rotated. (log(n) time)
 * @author Michael Ning
 *
 */
public class RotatedArraySearch {
   
    
    public static void main(String[] args) {
        int[] a = {10,15,20, 0,5};
        int[] b = {50,5,20,30,40};
        
        System.out.println(searchRotated(a,5,0,4));
        System.out.println(searchRotated(b,5,0,4));

    }
    
    public static int searchRotated(int[] a, int num, int start, int end) {
        int mid = (start+end)/2;
        if(num == a[mid]) {
            return mid;
        }
        if(end < start) {
            return -1;
        }
        if(a[start] < a[mid]) {
            if(num >= a[start] && num < a[mid]) {
                return searchRotated(a,num, start, mid-1);
            }
            else {
                return searchRotated(a, num, mid+1, end);
            }
        }
        else if(a[start] > a[mid]) {
            if(num > a[start] || num < a[mid]) {
                return searchRotated(a, num, start, mid-1);
            }
            else {
                return searchRotated(a, num, mid+1, end);
            }
        }
        else {
            if(a[start] != a[mid]) {
                return searchRotated(a, num, start, mid-1);
            }
            else {
                int res = searchRotated(a, num, start, mid-1);
                if(res == -1) {
                    return searchRotated(a, num, mid+1, end);
                }
                else {
                    return res;
                }
            }
        }
        
    }
}
