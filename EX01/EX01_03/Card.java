public class Card {
    private final String suits;
    private final String points;
    public Card(String suits, String points) {
        this.suits = suits;
        this.points = points;
    }

    public String toString() {
        return suits + ":" + points + " ";
    }
}