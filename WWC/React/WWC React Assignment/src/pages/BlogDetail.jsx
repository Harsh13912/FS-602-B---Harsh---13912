import { useParams, useNavigate, Link } from 'react-router-dom';
import { useBlog } from '../context/BlogContext';
import { ArrowLeft, Pencil, Trash2, Inbox } from 'lucide-react';

const BlogDetail = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const { getPost, deletePost } = useBlog();

    const post = getPost(id);

    if (!post) {
        return (
            <div className="not-found">
                <Inbox size={80} className="not-found-icon" />
                <h2>Post Not Found</h2>
                <p>The post you're looking for doesn't exist or has been deleted.</p>
                <Link to="/" className="back-btn">
                    <ArrowLeft size={16} />
                    Back to Home
                </Link>
            </div>
        );
    }

    const formatDate = (dateString) => {
        const date = new Date(dateString);
        return date.toLocaleDateString('en-US', {
            weekday: 'long',
            year: 'numeric',
            month: 'long',
            day: 'numeric'
        });
    };

    const handleDelete = () => {
        if (window.confirm('Are you sure you want to delete this post?')) {
            deletePost(post.id);
            navigate('/');
        }
    };

    return (
        <div className="blog-detail-page">
            <article className="blog-detail">
                <header className="detail-header">
                    <Link to="/" className="back-link">
                        <ArrowLeft size={14} />
                        Back to all posts
                    </Link>

                    <div className="detail-meta">
                        <span className="detail-date">{formatDate(post.createdAt)}</span>
                        {post.updatedAt !== post.createdAt && (
                            <span className="updated-tag">Updated</span>
                        )}
                    </div>

                    <h1 className="detail-title">{post.title}</h1>

                    <div className="detail-author">
                        <span className="author-avatar large">
                            {post.author.charAt(0).toUpperCase()}
                        </span>
                        <div className="author-info">
                            <span className="author-name">{post.author}</span>
                            <span className="author-role">Author</span>
                        </div>
                    </div>
                </header>

                <div className="detail-content">
                    {post.content.split('\n').map((paragraph, index) => (
                        paragraph.trim() && <p key={index}>{paragraph}</p>
                    ))}
                </div>

                <footer className="detail-footer">
                    <div className="detail-actions">
                        <Link to={`/edit/${post.id}`} className="action-btn-large edit">
                            <Pencil size={16} />
                            Edit Post
                        </Link>
                        <button onClick={handleDelete} className="action-btn-large delete">
                            <Trash2 size={16} />
                            Delete Post
                        </button>
                    </div>
                </footer>
            </article>
        </div>
    );
};

export default BlogDetail;
