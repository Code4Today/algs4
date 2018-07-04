public class EX01_03_35 {


    public static void main(String[] args) {
        RandomQueue<Card> card_queue = new RandomQueue<Card>();
        String[] suits = {"spade", "heart", "diamond", "club"};
        String[] points = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"};
        for (String point: points) {
            for (String suit :suits) {
                Card card = new Card(suit, point);
                card_queue.enqueue(card);
            }
        }
        for (int i = 1; i <= 4; i++){
            StdOut.println("\nThe card of " + i + "person:");
            for (int k = 0; k < 13; k++) {
                StdOut.print(card_queue.dequeue());
            }
        }



    }
}
