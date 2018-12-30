package crackingthecodinginterview6;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Creates a stack that also tracks the minimum value in the stack with a separate stack.
 * @author Michael Ning
 *
 */
public class StackMin extends Stack<Integer>{
    
    private int capacity;
    private int[] vals;
    private int size;
    Stack<Integer> s2;
   
    public static void main(String[] args) throws Exception {
        StackMin s = new StackMin(5);
        s.push(4);
        s.push(5);
        s.push(2);
        s.push(1);
        
        System.out.println("---");
        System.out.println(s.min());
        System.out.println(s.pop());
        System.out.println("---");
        System.out.println(s.min());
        System.out.println(s.pop());
        System.out.println("---");
        System.out.println(s.min());
        System.out.println(s.pop());
        System.out.println("---");
        System.out.println(s.min());
        System.out.println(s.pop());
        }
    
    
    public StackMin(int cap) {
        size = 0;
        capacity = cap-1;
        vals = new int[cap];
        s2 = new Stack<Integer>();
    }
    
    public int min() {
        if(s2.isEmpty()) {
            return 999999999;
        }
        return s2.peek();
        
    }
    public void push(int x) throws Exception {
        if(isFull()) {
            throw new Exception();
        }
        if(x <= min()) {
            s2.push(x);
        }
        vals[size] = x;
        size++;
        
    }
    
    public Integer pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        int res = vals[size];
        if(res <= min()) {
            s2.pop();
        }
        vals[size] = 0;
        size--;
        
        return res;
    }
    
    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==capacity;
    }
}
