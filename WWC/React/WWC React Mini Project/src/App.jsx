import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [theme, setTheme] = useState("light");

  // Load tasks & theme
  useEffect(() => {
    const savedTasks = JSON.parse(localStorage.getItem("tasks")) || [];
    const savedTheme = localStorage.getItem("theme") || "light";

    setTasks(savedTasks);
    setTheme(savedTheme);
    document.body.className = savedTheme;
  }, []);

  // Save tasks
  useEffect(() => {
    localStorage.setItem("tasks", JSON.stringify(tasks));
  }, [tasks]);

  // Save theme
  useEffect(() => {
    localStorage.setItem("theme", theme);
    document.body.className = theme;
  }, [theme]);

  const addTask = () => {
    if (!title.trim()) return;

    setTasks([
      ...tasks,
      {
        id: Date.now(),
        title,
        description,
        completed: false,
      },
    ]);

    setTitle("");
    setDescription("");
  };

  const toggleTask = (id) => {
    setTasks(
      tasks.map((task) =>
        task.id === id ? { ...task, completed: !task.completed } : task
      )
    );
  };

  const deleteTask = (id) => {
    setTasks(tasks.filter((task) => task.id !== id));
  };

  const toggleTheme = () => {
    setTheme(theme === "light" ? "dark" : "light");
  };

  return (
    <div className="container">
      <button className="theme-btn" onClick={toggleTheme}>
        Switch to {theme === "light" ? "Dark" : "Light"} Mode
      </button>

      <input
        type="text"
        placeholder="Task Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />

      <textarea
        placeholder="Task Description"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
      />

      <button className="add-btn" onClick={addTask}>
        Add Task
      </button>

      <div className="task-list">
        {tasks.map((task) => (
          <div key={task.id} className="task-card">
            <h3 className={task.completed ? "completed" : ""}>
              {task.title}
            </h3>
            <p>{task.description}</p>

            <div className="actions">
              <button
                className="complete-btn"
                onClick={() => toggleTask(task.id)}
              >
                {task.completed ? "Undo" : "Complete"}
              </button>

              <button
                className="delete-btn"
                onClick={() => deleteTask(task.id)}
              >
                Delete
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
