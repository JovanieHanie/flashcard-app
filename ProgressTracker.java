// ProgressTracker.java
import java.util.*;

public class ProgressTracker {
    private Map<String, Integer> deckMastery;
    private Map<Date, Integer> studyHistory;

    public ProgressTracker() {
        this.deckMastery = new HashMap<>();
        this.studyHistory = new TreeMap<>();
    }

    public void updateDeckMastery(String deck, int masteredCards) {
        deckMastery.put(deck, masteredCards);
    }

    public void recordStudy(Date date, int cardsStudied) {
        studyHistory.put(date, studyHistory.getOrDefault(date, 0) + cardsStudied);
    }

    public Map<String, Integer> getDeckMastery() {
        return deckMastery;
    }

    public Map<Date, Integer> getStudyHistory() {
        return studyHistory;
    }
}
