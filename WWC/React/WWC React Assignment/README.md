# The Blog Website  - Modern React Blog Application

A beautiful, fully-functional blog application built with React. Create, view, edit, and delete blog posts with a modern dark theme and responsive design.

![React](https://img.shields.io/badge/React-18.x-61DAFB?logo=react)
![Vite](https://img.shields.io/badge/Vite-5.x-646CFF?logo=vite)
![React Router](https://img.shields.io/badge/React_Router-6.x-CA4245?logo=reactrouter)

## ✨ Features

### Core Features
- **Blog Creation**: Create new blog posts with title, author, and content
- **Blog Listing**: View all posts with title, author, and content snippet (first 100 characters)
- **Detailed View**: Click any post to view full content
- **Navigation**: Smooth navigation between pages using React Router

### Bonus Features
- **Edit Posts**: Modify existing blog posts
- **Delete Posts**: Remove posts with confirmation dialog
- **Search/Filter**: Search posts by title or author name
- **Data Persistence**: Posts are saved to localStorage and persist across sessions
- **Responsive Design**: Works beautifully on mobile and desktop

### Design Highlights
- Modern dark theme with glassmorphism effects
- Vibrant gradient accents (cyan to magenta)
- Smooth animations and micro-interactions
- Clean typography using Inter font family

## 🚀 Getting Started

### Prerequisites
- Node.js 16+ installed
- npm or yarn package manager

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd blog
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

4. Open your browser and visit `http://localhost:5173`

### Build for Production

```bash
npm run build
```

The production build will be in the `dist` folder.

## 📁 Project Structure

```
blog/
├── index.html              # Entry HTML file
├── package.json            # Dependencies and scripts
├── vite.config.js          # Vite configuration
└── src/
    ├── main.jsx            # Application entry point
    ├── App.jsx             # Main App component with routing
    ├── index.css           # Global styles and design system
    ├── context/
    │   └── BlogContext.jsx # State management with Context API
    ├── components/
    │   ├── Navbar.jsx      # Navigation bar
    │   ├── BlogCard.jsx    # Blog post card component
    │   ├── BlogForm.jsx    # Reusable form for create/edit
    │   └── SearchBar.jsx   # Search functionality
    └── pages/
        ├── Home.jsx        # Main blog listing page
        ├── CreatePost.jsx  # Create new post page
        ├── BlogDetail.jsx  # Full post view page
        └── EditPost.jsx    # Edit existing post page
```

## 🛠️ Technologies Used

- **React 18**: Frontend library
- **Vite**: Build tool and dev server
- **React Router DOM v6**: Client-side routing
- **Context API + useReducer**: State management
- **localStorage**: Data persistence
- **CSS3**: Custom styling with CSS variables

## 📝 Usage Guide

### Creating a Post
1. Click "New Post" in the navigation bar
2. Fill in the title, author name, and content
3. Click "Publish Post" to save

### Viewing Posts
- All posts appear on the homepage
- Click any post card to view the full content

### Editing a Post
1. Navigate to a post's detail page
2. Click the "Edit Post" button
3. Modify the content and save

### Deleting a Post
1. Navigate to a post's detail page OR hover over a card
2. Click the delete button (🗑️)
3. Confirm deletion in the dialog

### Searching Posts
- Use the search bar on the homepage
- Filter by title or author name
- Results update in real-time

## 🐛 Known Issues / Limitations

- No backend server; data is stored in browser's localStorage only
- Images cannot be added to blog posts
- No user authentication system

## 🤝 Peer Review

This project was reviewed by:
- [Reviewer 1 Name]
- [Reviewer 2 Name]

Feedback addressed:
- [List any feedback items that were addressed]

## 📄 License

This project is open source and available under the MIT License.

## 👨‍💻 Author

Built with ❤️ for learning React development.
# Assignment Submission
# Assignment Submission
# Assignment Submission
