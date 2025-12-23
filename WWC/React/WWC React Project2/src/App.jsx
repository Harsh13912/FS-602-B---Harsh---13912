import { useEffect, useState } from "react";
import "./App.css";

const questions = [
  {
    question: "Which device is required for the Internet connection?",
    options: ["Modem", "Router", "LAN Cable", "Pen Drive"],
    answer: "Modem",
  },
  {
    question: "Which language runs in a web browser?",
    options: ["Java", "C", "Python", "JavaScript"],
    answer: "JavaScript",
  },
  {
    question: "What does HTML stand for?",
    options: [
      "Hyper Trainer Marking Language",
      "Hyper Text Markup Language",
      "Hyper Text Marketing Language",
      "Hyper Tool Markup Language",
    ],
    answer: "Hyper Text Markup Language",
  },
  {
    question: "Which company developed React?",
    options: ["Google", "Facebook", "Amazon", "Microsoft"],
    answer: "Facebook",
  },
  {
    question: "Which hook is used for state in React?",
    options: ["useRef", "useState", "useEffect", "useContext"],
    answer: "useState",
  },
];

function App() {
  const [step, setStep] = useState(0);
  const [name, setName] = useState("");
  const [current, setCurrent] = useState(0);
  const [selected, setSelected] = useState("");
  const [score, setScore] = useState(0);
  const [history, setHistory] = useState([]);

  useEffect(() => {
    const data = JSON.parse(localStorage.getItem("quizHistory")) || [];
    setHistory(data);
  }, []);

  const nextQuestion = () => {
    if (selected === questions[current].answer) {
      setScore(score + 1);
    }
    setSelected("");

    if (current + 1 < questions.length) {
      setCurrent(current + 1);
    } else {
      setStep(2);
    }
  };

  const saveHistory = () => {
    const entry = { name, score };
    const updated = [...history, entry];
    setHistory(updated);
    localStorage.setItem("quizHistory", JSON.stringify(updated));
  };

  const resetQuiz = () => {
    setStep(0);
    setName("");
    setCurrent(0);
    setScore(0);
    setSelected("");
  };

  return (
    <div className="app">
      <h2>Quiz App</h2>

      {step === 0 && (
        <>
          <input
            type="text"
            placeholder="Enter Your Full Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <button onClick={() => name && setStep(1)}>Start Quiz</button>
        </>
      )}

      {step === 1 && (
        <>
          <h4>{questions[current].question}</h4>
          {questions[current].options.map((opt) => (
            <button
              key={opt}
              className={selected === opt ? "selected" : ""}
              onClick={() => setSelected(opt)}
            >
              {opt}
            </button>
          ))}
          <button disabled={!selected} onClick={nextQuestion}>
            Next
          </button>
        </>
      )}

      {step === 2 && (
        <>
          <h3>
            {name}, You Scored {score} out of {questions.length}
          </h3>
          <button onClick={resetQuiz}>Reset</button>
          <button onClick={saveHistory}>Save History</button>

          <div className="history">
            <h4>Previous Attempts</h4>
            {history.map((h, i) => (
              <p key={i}>
                Name: {h.name} <br />
                Score: {h.score}
              </p>
            ))}
          </div>
        </>
      )}
    </div>
  );
}

export default App;
