import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { BlogProvider } from './context/BlogContext';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import CreatePost from './pages/CreatePost';
import BlogDetail from './pages/BlogDetail';
import EditPost from './pages/EditPost';

function App() {
  return (
    <BlogProvider>
      <Router>
        <div className="app">
          <Navbar />
          <main className="main-content">
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/create" element={<CreatePost />} />
              <Route path="/post/:id" element={<BlogDetail />} />
              <Route path="/edit/:id" element={<EditPost />} />
            </Routes>
          </main>
          <footer className="footer">
            <p>© 2025 Blog Website. Made with ❤️ using React </p>
          </footer>
        </div>
      </Router>
    </BlogProvider>
  );
}

export default App;
