import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{

    private Node<Item> first;    // beginning of deque
    private Node<Item> last;     // end of deque
    private int n;               // number of elements on deque

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }


    public Deque() {
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        return first.item;
    }

    public void pushRight(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        n++;
    }

    public void pushLeft(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        if (last == null)
            last = first;
        n++;
    }

    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = first.item;

        if (n == 1) {
            first = null;
            last = null;
        } else {
            Node<Item> past = first;
            Node<Item> itr = first;
            while (itr.next != null){
                past = itr;
                itr = itr.next;
            }
            item = itr.item;
            past.next = null;
            last = past;
        }
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  {
            return current != null;
        }

        public void remove()      {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> ll = new Deque<Integer>();
        ll.pushLeft(543);
        StdOut.println(ll);
        ll.popRight();
        StdOut.println(ll);
        ll.pushRight(78);
        StdOut.println(ll);
        ll.popLeft();
        StdOut.println(ll);
        ll.pushLeft(78);
        StdOut.println(ll);
        ll.pushLeft(983);
        StdOut.println(ll);
        ll.pushRight(65);
        StdOut.println(ll);
        ll.pushRight(78);
        StdOut.println(ll);
        ll.pushLeft(19);
        StdOut.println(ll);
        ll.pushRight(78);
        StdOut.println(ll);
        ll.popRight();
        StdOut.println(ll);
        ll.popLeft();
        StdOut.println(ll);
        StdOut.println(ll.size());
    }
}


