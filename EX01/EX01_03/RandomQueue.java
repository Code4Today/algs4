import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item>{
    private Item[] q;
    private int N;
    private int first;
    private int last;

    public RandomQueue() {
        q = (Item[]) new Object[2];
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
        for (int i = 0; i <  N; i++) {
            temp[max/4 + i] = q[first + i];
        }
        q = temp;
        first = max/4;
        last = max/4 + N;
//        StdOut.println("Resize the array to " + max);
    }

    public void enqueue(Item item) {
        // last number is the end of array, resize the array
        if (first == 0) {
            resize(2*q.length);
        }
        q[--first] = item;
        N++;
//        StdOut.println("Memory: " + q.length + " first: " + first + " last: " + last);
    }

//    public void pushRight(Item item) {
//        // last number is the end of array, resize the array
//        if (last == q.length) {
//            resize(2*q.length);
//        }
//        q[last++] = item;
//        N++;
////        StdOut.println("Memory: " + q.length + " first: " + first + " last: " + last);
//    }

//    public Item popLeft() {
//        if (0 == N) {
//            throw new NoSuchElementException("Queue out of bound!");
//        } else {
//            Item item = q[first];
//            q[first++] = null;
//            N--;
//            // 1/2 empty place in array
//            if ((N == q.length/4) && N > 0) {
//                resize(q.length/2);
//            }
////            StdOut.println("Memory: " + q.length + " first: " + first + " last: " + last);
//            return item;
//        }
//    }

    public Item dequeue() {
        if (0 == N) {
            throw new NoSuchElementException("Queue out of bound!");
        } else {
            int exchange = StdRandom.uniform(first, last);
            Item temp = q[exchange];
            q[exchange] = q[last - 1];
            q[last - 1] = temp;
            Item item = q[last - 1];
            q[--last] = null;
            N--;
            // 1/2 empty place in array
            if ((N == q.length/4) && N > 0) {
                resize(q.length/2);
            }
//            StdOut.println("Memory: " + q.length + " first: " + first + " last: " + last);
            return item;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();

//        for (int i = 0; i < N; i++) {
//            s.append(q[first + i]);
//            s.append(' ');
//        }
//        return s.toString();
    }

    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private int current;
        private int[] mix_num = new int[N];

        public ListIterator() {
            for (int i = 0; i < N; i++) {
                mix_num[i] = first + i;
            }
            StdRandom.shuffle(mix_num);
            current = 0;
        }

        public boolean hasNext()  {
            return current < N;
        }

        public void remove()      {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return q[mix_num[current++]];
        }
    }

    public static void main(String[] args) {
        RandomQueue<Integer> ll = new RandomQueue<Integer>();
        ll.enqueue(543);
        StdOut.println(ll);
        ll.dequeue();
        StdOut.println(ll);
        ll.enqueue(78);
        StdOut.println(ll);
        ll.dequeue();
        StdOut.println(ll);
        ll.enqueue(78);
        StdOut.println(ll);
        ll.enqueue(983);
        StdOut.println(ll);
        ll.enqueue(65);
        StdOut.println(ll);
        ll.enqueue(78);
        StdOut.println(ll);
        ll.enqueue(19);
        StdOut.println(ll);
        ll.enqueue(195);
        StdOut.println(ll);
        ll.enqueue(78);
        StdOut.println(ll);
        for (int i: ll) {
            StdOut.print(i + " ");
        }
        ll.dequeue();
        StdOut.println(ll);
        ll.dequeue();
        ll.dequeue();
        ll.dequeue();
        ll.dequeue();
        StdOut.println(ll);
        ll.dequeue();
        StdOut.println(ll);
        ll.dequeue();
        StdOut.println(ll);
        StdOut.println(ll.size());
    }
}