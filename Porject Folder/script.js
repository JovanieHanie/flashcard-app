const flashcards = [
    { question: "What is spaced repetition?", answer: "A technique to review flashcards at increasing intervals." },
    { question: "Who created JavaScript?", answer: "Brendan Eich." },
    { question: "What does HTML stand for?", answer: "HyperText Markup Language." }
];

let currentCardIndex = 0;
const front = document.getElementById("front");
const back = document.getElementById("back");
const flashcard = document.getElementById("flashcard");

function showCard(index) {
    const card = flashcards[index];
    front.textContent = card.question;
    back.textContent = card.answer;
    // Reset flip state to show front side
    flashcard.classList.remove("flipped");
}

flashcard.addEventListener("click", () => {
    flashcard.classList.toggle("flipped");
});

document.getElementById("next-card-btn").addEventListener("click", () => {
    currentCardIndex = (currentCardIndex + 1) % flashcards.length;
    showCard(currentCardIndex);
});

document.getElementById("add-card-btn").addEventListener("click", () => {
    const q = prompt("Enter the question:");
    const a = prompt("Enter the answer:");
    if (q && a) {
        flashcards.push({ question: q, answer: a });
        currentCardIndex = flashcards.length - 1;
        showCard(currentCardIndex);
    }
});

document.getElementById("mark-known-btn").addEventListener("click", () => {
    alert(`Marked card "${flashcards[currentCardIndex].question}" as known.`);
});

document.getElementById("mark-review-btn").addEventListener("click", () => {
    alert(`Marked card "${flashcards[currentCardIndex].question}" as needs review.`);
});

// Show first card on load
showCard(currentCardIndex);
