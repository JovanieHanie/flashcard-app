
public class Flashcard {
    private String question;
    private String answer;
    private boolean known;
    private int difficultyRating;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.known = false;
        this.difficultyRating = 0;
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

    public int getDifficultyRating() {
        return difficultyRating;
    }

    public void rateDifficulty(int rating) {
        this.difficultyRating = rating;
    }
}

