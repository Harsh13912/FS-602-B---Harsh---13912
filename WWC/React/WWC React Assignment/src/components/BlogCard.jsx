import { Link } from 'react-router-dom';
import { Pencil, Trash2, ArrowRight } from 'lucide-react';

const BlogCard = ({ post, onDelete }) => {
    // Get first 100 characters for snippet
    const snippet = post.content.length > 100
        ? post.content.substring(0, 100) + '...'
        : post.content;

    // Format date
    const formatDate = (dateString) => {
        const date = new Date(dateString);
        return date.toLocaleDateString('en-US', {
            year: 'numeric',
            month: 'short',
            day: 'numeric'
        });
    };

    const handleDelete = (e) => {
        e.preventDefault();
        e.stopPropagation();
        if (window.confirm('Are you sure you want to delete this post?')) {
            onDelete(post.id);
        }
    };

    return (
        <article className="blog-card">
            <Link to={`/post/${post.id}`} className="blog-card-link">
                <div className="blog-card-header">
                    <span className="blog-date">{formatDate(post.createdAt)}</span>
                    <div className="blog-card-actions">
                        <Link
                            to={`/edit/${post.id}`}
                            className="action-btn edit-btn"
                            onClick={(e) => e.stopPropagation()}
                            title="Edit post"
                        >
                            <Pencil size={14} />
                        </Link>
                        <button
                            className="action-btn delete-btn"
                            onClick={handleDelete}
                            title="Delete post"
                        >
                            <Trash2 size={14} />
                        </button>
                    </div>
                </div>

                <h2 className="blog-card-title">{post.title}</h2>

                <p className="blog-card-snippet">{snippet}</p>

                <div className="blog-card-footer">
                    <div className="blog-author">
                        <span className="author-avatar">
                            {post.author.charAt(0).toUpperCase()}
                        </span>
                        <span className="author-name">{post.author}</span>
                    </div>
                    <span className="read-more">
                        Read more <ArrowRight size={12} />
                    </span>
                </div>
            </Link>
        </article>
    );
};

export default BlogCard;
