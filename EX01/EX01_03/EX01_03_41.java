public class EX01_03_41 {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(9);
        q.enqueue(10);
        Queue<Integer> p = new Queue<Integer>(q);
        StdOut.println("p: " + p);
        StdOut.println("q: " + q);
        q.dequeue();
        StdOut.println("p: " + p);
        StdOut.println("q: " + q);
    }

}
