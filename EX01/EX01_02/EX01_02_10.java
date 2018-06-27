import edu.princeton.cs.algs4.*;

public class EX01_02_10 {
    
    public static void main(String[] args) {
        VisualCounter vc = new VisualCounter(10, 3);
        for (int i = 0; i < 5; i++) {
            vc.increment();
            vc.increment();
            vc.increment();
            vc.increment();
            vc.decrement();
            vc.decrement();
            vc.decrement();
            vc.decrement();
            vc.decrement();
            vc.decrement();
            vc.decrement();
        }
    }
}
