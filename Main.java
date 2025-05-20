// Main.java
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck("Biology");
        deck.addCard(new Flashcard("What is the powerhouse of the cell?", "Mitochondria"));
        deck.addCard(new Flashcard("What carries genetic information?", "DNA"));

        StudySession session = new StudySession(deck, 2);
        Flashcard card;
        while ((card = session.nextCard()) != null) {
            System.out.println("Q: " + card.getQuestion());
            System.out.println("A: " + card.getAnswer());
            card.setKnown(true);
        }

        SpacedRepetitionScheduler scheduler = new SpacedRepetitionScheduler();
        scheduler.scheduleCard(deck.getCards().get(0), 3);

        ProgressTracker tracker = new ProgressTracker();
        tracker.updateDeckMastery(deck.getSubject(), 2);

        NotificationManager notifier = new NotificationManager();
        notifier.sendReminder("Time to study your flashcards!");

        ImportExportManager manager = new ImportExportManager();
        try {
           // List<Flashcard> imported = manager.importFromCSV("flashcards.csv");
           // manager.exportToPDF(imported, "output.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}