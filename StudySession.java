// StudySession.java
import java.util.*;

public class StudySession {
    private Deck deck;
    private int currentIndex;
    private int dailyGoal;

    public StudySession(Deck deck, int dailyGoal) {
        this.deck = deck;
        this.dailyGoal = dailyGoal;
        this.currentIndex = 0;
        deck.shuffleDeck();
    }

    public Flashcard nextCard() {
        if (currentIndex < deck.getCards().size()) {
            return deck.getCards().get(currentIndex++);
        }
        return null;
    }

    public void resetSession() {
        currentIndex = 0;
        deck.shuffleDeck();
    }

    public int getDailyGoal() {
        return dailyGoal;
    }
}