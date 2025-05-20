// Deck.java
import java.util.*;

public class Deck {
    private String subject;
    private List<Flashcard> cards;

    public Deck(String subject) {
        this.subject = subject;
        this.cards = new ArrayList<>();
    }

    public void addCard(Flashcard card) {
        cards.add(card);
    }

    public List<Flashcard> getCards() {
        return cards;
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public String getSubject() {
        return subject;
    }
}