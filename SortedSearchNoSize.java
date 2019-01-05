package crackingthecodinginterview6;

/**
 * Searches through a sorted array not knowing the size of the array.
 * @author Michael Ning
 *
 */
public class SortedSearchNoSize {

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,12, 18,27,33, 53,92, 112};
        System.out.println(search(a,112));
        
    }
    
    public static int search(int[] a, int num) {
        
        int end = 1;
        while(elementAt(a,end) != -1 && num > elementAt(a, end)) {
            end *= 2;
        }
        return binarySearch(a, num, end/2, end);
    }
    
    public static int binarySearch(int[] a, int num, int start, int end) {
        int mid = (start+end)/2;
        if(start<= end) {
            if(num == elementAt(a,mid)) {
                return mid;
            }
            else if(num < elementAt(a,mid) || elementAt(a, mid) == -1) {
                return binarySearch(a, num, start, mid-1);
            }
            else if(num > elementAt(a, mid)) {
                return binarySearch(a, num, mid+1, end);
            }
        }
        return -1;
    }
    
    public static int elementAt(int[] a, int index) {
        if(index >= a.length) {
            return -1;
        }
        return a[index];
    }
}
