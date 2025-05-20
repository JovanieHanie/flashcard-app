import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;


// Flashcard class
class Flashcard {
    private String question;
    private String answer;
    private boolean known;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.known = false;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }
}

// Deck class
class Deck {
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

    public String getSubject() {
        return subject;
    }
}

// Main GUI class
public class FlashcardAppGUI extends JFrame {

    private Deck deck;

    private JLabel questionLabel;
    private JLabel answerLabel;

    private JTextField questionInput;
    private JTextField answerInput;

    private int currentCardIndex = 0;

    public FlashcardAppGUI() {
        deck = new Deck("Default");

        setTitle("Flashcard Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel: Show flashcard question and answer
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        questionLabel = new JLabel("Question will appear here", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        answerLabel = new JLabel("Answer will appear here", SwingConstants.CENTER);
        answerLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        topPanel.add(questionLabel);
        topPanel.add(answerLabel);
        add(topPanel, BorderLayout.CENTER);

        // Bottom panel: Buttons for navigation
        JPanel bottomPanel = new JPanel();

        JButton showAnswerButton = new JButton("Show Answer");
        JButton nextButton = new JButton("Next Flashcard");
        JButton markKnownButton = new JButton("Mark Known");

        bottomPanel.add(showAnswerButton);
        bottomPanel.add(nextButton);
        bottomPanel.add(markKnownButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Side panel: Input fields to add flashcards
        JPanel sidePanel = new JPanel(new GridLayout(5, 1, 5, 5));
        sidePanel.setBorder(BorderFactory.createTitledBorder("Add New Flashcard"));

        sidePanel.add(new JLabel("Question:"));
        questionInput = new JTextField();
        sidePanel.add(questionInput);

        sidePanel.add(new JLabel("Answer:"));
        answerInput = new JTextField();
        sidePanel.add(answerInput);

        JButton addButton = new JButton("Add Flashcard");
        sidePanel.add(addButton);

        add(sidePanel, BorderLayout.EAST);

        // Button actions
        showAnswerButton.addActionListener(e -> {
            if (deck.getCards().size() > 0 && currentCardIndex < deck.getCards().size()) {
                answerLabel.setText(deck.getCards().get(currentCardIndex).getAnswer());
            }
        });

        nextButton.addActionListener(e -> {
            if (deck.getCards().size() > 0) {
                currentCardIndex++;
                if (currentCardIndex >= deck.getCards().size()) {
                    currentCardIndex = 0; // loop back to first card
                }
                updateCardDisplay();
            } else {
                questionLabel.setText("No flashcards available");
                answerLabel.setText("");
            }
        });

        markKnownButton.addActionListener(e -> {
            if (deck.getCards().size() > 0 && currentCardIndex < deck.getCards().size()) {
                deck.getCards().get(currentCardIndex).setKnown(true);
                JOptionPane.showMessageDialog(this, "Marked as known!");
            }
        });

        addButton.addActionListener(e -> {
            String question = questionInput.getText().trim();
            String answer = answerInput.getText().trim();

            if (!question.isEmpty() && !answer.isEmpty()) {
                Flashcard newCard = new Flashcard(question, answer);
                deck.addCard(newCard);

                questionInput.setText("");
                answerInput.setText("");

                JOptionPane.showMessageDialog(this, "Flashcard added!");
                if (deck.getCards().size() == 1) {
                    currentCardIndex = 0;
                    updateCardDisplay();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter both question and answer.");
            }
        });

        // Initialize display
        updateCardDisplay();
    }

    private void updateCardDisplay() {
        if (deck.getCards().size() > 0 && currentCardIndex < deck.getCards().size()) {
            Flashcard card = deck.getCards().get(currentCardIndex);
            questionLabel.setText(card.getQuestion());
            answerLabel.setText("Click 'Show Answer' to see it");
        } else {
            questionLabel.setText("No flashcards available");
            answerLabel.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlashcardAppGUI app = new FlashcardAppGUI();
            app.setVisible(true);
        });
    }
}