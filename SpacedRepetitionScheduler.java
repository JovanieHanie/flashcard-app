// SpacedRepetitionScheduler.java
import java.util.*;

public class SpacedRepetitionScheduler {
    private Map<Flashcard, Date> schedule;

    public SpacedRepetitionScheduler() {
        this.schedule = new HashMap<>();
    }

    public void scheduleCard(Flashcard card, int rating) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, rating); // Example logic
        schedule.put(card, cal.getTime());
    }

    public List<Flashcard> getDueCards(Date today) {
        List<Flashcard> due = new ArrayList<>();
        for (Map.Entry<Flashcard, Date> entry : schedule.entrySet()) {
            if (!entry.getValue().after(today)) {
                due.add(entry.getKey());
            }
        }
        return due;
    }
}