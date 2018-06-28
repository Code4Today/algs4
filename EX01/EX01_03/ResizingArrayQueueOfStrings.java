import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings<Item> {
    private Item[] q;
    private int N;
    private int first;
    private int last;
    
    public ResizingArrayQueueOfStrings() {
        q = (Item[]) new Object[1];
        N = 0;
        first = 0;
        last = 0;
    }
    
    public boolean isEmpty() {  
        return N == 0;
    }
    
    public int size() {
        return N;
    }
    
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = q[first + i];
        }
        q = temp;
        first = 0;
        last = N;
    }
    
    public void enqueue(Item item) {
        // last number is the end of array, resize the array
        if (last == q.length) {
            resize(2*q.length);
        }
        q[last++] = item;
        N++;
        StdOut.println("Memory: " + q.length + " first: " + first + " last: " + last);
    }
    
    public Item dequeue() {
        if (0 == N) {
            throw new NoSuchElementException("Queue out of bound!");
        } else {
            Item item = q[first];
            q[first++] = null;
            N--;
            // 1/2 empty place in array
            if ((N == q.length/4) && N > 0) {
                resize(q.length/2);
            }
            StdOut.println("Memory: " + q.length + " first: " + first + " last: " + last);
            return item;
        }
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < N; i++) {
            s += q[first + i] + "-";
        }
        return s;
    }
    
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings<String> rq = new ResizingArrayQueueOfStrings<String>();
        rq.enqueue("43");
        StdOut.println(rq);
        rq.enqueue("5345");
        StdOut.println(rq);
        for (int i = 0; i < 10; i++) {
            rq.enqueue("954");
            StdOut.println(rq);
            rq.enqueue("134");
            StdOut.println(rq);
            rq.dequeue();
            StdOut.println(rq);
        }
        for (int i = 0; i < 10; i++) {
            rq.dequeue();
            StdOut.println(rq);
            rq.dequeue();
            StdOut.println(rq);
            rq.dequeue();
            StdOut.println(rq);
        }
    }
}