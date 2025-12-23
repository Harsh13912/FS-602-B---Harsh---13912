import { useState, useMemo } from 'react';
import { Link } from 'react-router-dom';
import { useBlog } from '../context/BlogContext';
import BlogCard from '../components/BlogCard';
import SearchBar from '../components/SearchBar';
import { Search, PenLine, Plus } from 'lucide-react';

const Home = () => {
    const { posts, deletePost } = useBlog();
    const [searchQuery, setSearchQuery] = useState('');

    // Filter posts based on search query
    const filteredPosts = useMemo(() => {
        if (!searchQuery.trim()) {
            return posts;
        }
        const query = searchQuery.toLowerCase();
        return posts.filter(post =>
            post.title.toLowerCase().includes(query) ||
            post.author.toLowerCase().includes(query)
        );
    }, [posts, searchQuery]);

    // Sort posts by date (newest first)
    const sortedPosts = useMemo(() => {
        return [...filteredPosts].sort((a, b) =>
            new Date(b.createdAt) - new Date(a.createdAt)
        );
    }, [filteredPosts]);

    return (
        <div className="home-page">
            {/* Hero Section */}
            <section className="hero">
                <div className="hero-content">
                    <h1 className="hero-title">
                        Welcome to <span className="gradient-text">The Blog Website </span>
                    </h1>
                    <p className="hero-subtitle">
                        Discover stories, insights, and ideas from creative minds around the world.
                    </p>
                </div>
                <div className="hero-decoration">
                    <div className="floating-shape shape-1"></div>
                    <div className="floating-shape shape-2"></div>
                    <div className="floating-shape shape-3"></div>
                </div>
            </section>

            {/* Search and Posts Section */}
            <section className="posts-section">
                <div className="section-header">
                    <h2 className="section-title">Latest Posts</h2>
                    <span className="post-count">{sortedPosts.length} posts</span>
                </div>

                <SearchBar onSearch={setSearchQuery} />

                {sortedPosts.length > 0 ? (
                    <div className="posts-grid">
                        {sortedPosts.map(post => (
                            <BlogCard
                                key={post.id}
                                post={post}
                                onDelete={deletePost}
                            />
                        ))}
                    </div>
                ) : (
                    <div className="empty-state">
                        {searchQuery ? (
                            <>
                                <Search size={64} className="empty-icon" />
                                <h3>No posts found</h3>
                                <p>Try adjusting your search terms.</p>
                            </>
                        ) : (
                            <>
                                <PenLine size={64} className="empty-icon" />
                                <h3>No posts yet</h3>
                                <p>Be the first to share your story!</p>
                                <Link to="/create" className="cta-btn">
                                    <Plus size={16} />
                                    Create Your First Post
                                </Link>
                            </>
                        )}
                    </div>
                )}
            </section>
        </div>
    );
};

export default Home;
