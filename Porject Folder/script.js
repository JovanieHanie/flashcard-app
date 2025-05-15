let flashcards = [
    { question: "What is JavaScript?", answer: "A programming language for the web.", rating: null, known: false },
    { question: "What does HTML stand for?", answer: "HyperText Markup Language", rating: null, known: false }
];

let currentCardIndex = 0;

// Load the first card
window.onload = () => {
    showCard(currentCardIndex);
    updateProgress();
};

function showCard(index) {
    const front = document.getElementById("card-front");
    const back = document.getElementById("card-back");
    const card = flashcards[index];

    front.innerText = card.question;
    back.innerText = card.answer;

    // Remove flipped state
    document.getElementById("flashcard").classList.remove("flipped");
}

function flipCard() {
    const card = document.getElementById("flashcard");
    card.classList.toggle("flipped");
}

function nextCard() {
    if (flashcards.length === 0) return;
    currentCardIndex = (currentCardIndex + 1) % flashcards.length;
    showCard(currentCardIndex);
}

function prevCard() {
    if (flashcards.length === 0) return;
    currentCardIndex = (currentCardIndex - 1 + flashcards.length) % flashcards.length;
    showCard(currentCardIndex);
}

function addCard() {
    const question = document.getElementById("new-question").value.trim();
    const answer = document.getElementById("new-answer").value.trim();

    if (question && answer) {
        flashcards.push({ question, answer, rating: null, known: false });
        document.getElementById("new-question").value = "";
        document.getElementById("new-answer").value = "";
        currentCardIndex = flashcards.length - 1;
        showCard(currentCardIndex);
        updateProgress();
    } else {
        alert("Please enter both a question and an answer.");
    }
}

function markKnown() {
    if (flashcards.length === 0) return;
    flashcards[currentCardIndex].known = true;
    updateProgress();
    nextCard();
}

function markReview() {
    if (flashcards.length === 0) return;
    flashcards[currentCardIndex].known = false;
    updateProgress();
    nextCard();
}

function rateCard(difficulty) {
    if (flashcards.length === 0) return;
    flashcards[currentCardIndex].rating = difficulty;
    updateProgress();
}

function updateProgress() {
    const knownCount = flashcards.filter(card => card.known).length;
    const total = flashcards.length;
    const progressText = `Progress: ${knownCount}/${total} cards known`;
    document.getElementById("progress").innerText = progressText;
}
