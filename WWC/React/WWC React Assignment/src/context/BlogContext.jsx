import React, { createContext, useContext, useReducer, useEffect } from 'react';

const BlogContext = createContext();

// Load initial state from localStorage
const loadFromStorage = () => {
  try {
    const saved = localStorage.getItem('blogPosts');
    if (saved) {
      return JSON.parse(saved);
    }
  } catch (error) {
    console.error('Error loading from localStorage:', error);
  }
  return [];
};

// Reducer for blog actions
const blogReducer = (state, action) => {
  switch (action.type) {
    case 'ADD_POST':
      return [...state, action.payload];
    case 'UPDATE_POST':
      return state.map(post => 
        post.id === action.payload.id ? action.payload : post
      );
    case 'DELETE_POST':
      return state.filter(post => post.id !== action.payload);
    default:
      return state;
  }
};

// Provider component
export const BlogProvider = ({ children }) => {
  const [posts, dispatch] = useReducer(blogReducer, [], loadFromStorage);

  // Save to localStorage whenever posts change
  useEffect(() => {
    localStorage.setItem('blogPosts', JSON.stringify(posts));
  }, [posts]);

  // Action creators
  const addPost = (post) => {
    const newPost = {
      ...post,
      id: Date.now().toString(),
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString()
    };
    dispatch({ type: 'ADD_POST', payload: newPost });
    return newPost;
  };

  const updatePost = (id, updates) => {
    const post = posts.find(p => p.id === id);
    if (post) {
      const updatedPost = {
        ...post,
        ...updates,
        updatedAt: new Date().toISOString()
      };
      dispatch({ type: 'UPDATE_POST', payload: updatedPost });
      return updatedPost;
    }
    return null;
  };

  const deletePost = (id) => {
    dispatch({ type: 'DELETE_POST', payload: id });
  };

  const getPost = (id) => {
    return posts.find(post => post.id === id);
  };

  const value = {
    posts,
    addPost,
    updatePost,
    deletePost,
    getPost
  };

  return (
    <BlogContext.Provider value={value}>
      {children}
    </BlogContext.Provider>
  );
};

// Custom hook for using blog context
export const useBlog = () => {
  const context = useContext(BlogContext);
  if (!context) {
    throw new Error('useBlog must be used within a BlogProvider');
  }
  return context;
};

export default BlogContext;
