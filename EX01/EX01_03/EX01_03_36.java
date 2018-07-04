public class EX01_03_36 {

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

    }
}
