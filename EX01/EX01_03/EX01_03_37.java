public class EX01_03_37 {


    public static void main(String[] args) {
        Queue<Integer> people = new Queue<Integer>();
        int N = Integer.parseInt(args[0]);  // number of people
        int M = Integer.parseInt(args[1]);  // number of count
        for (int i = 0; i < N; i++) {
            people.enqueue(i);
        }
        while (!people.isEmpty()) {
            for (int i = 0; i < M - 1; i++) {
                people.enqueue(people.dequeue());
            }
            StdOut.print(people.dequeue() + " ");
        }

    }
}
