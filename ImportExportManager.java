// ImportExportManager.java
import java.io.*;
import java.util.*;

public class ImportExportManager {
    public List<Flashcard> importFromCSV(String filepath) throws IOException {
        List<Flashcard> flashcards = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                flashcards.add(new Flashcard(parts[0], parts[1]));
            }
        }
        reader.close();
        return flashcards;
    }

    public void exportToPDF(List<Flashcard> flashcards, String filepath) {
        // Simulate PDF Export (actual PDF libraries like iText can be used)
        System.out.println("Exporting to PDF at: " + filepath);
        for (Flashcard card : flashcards) {
            System.out.println(card.getQuestion() + " - " + card.getAnswer());
        }
    }

    public void backupData(List<Deck> decks, String filepath) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath));
        out.writeObject(decks);
        out.close();
    }
}