import { useParams, useNavigate, Link } from 'react-router-dom';
import { useBlog } from '../context/BlogContext';
import BlogForm from '../components/BlogForm';
import { ArrowLeft, Pencil, Inbox } from 'lucide-react';

const EditPost = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const { getPost, updatePost } = useBlog();

    const post = getPost(id);

    if (!post) {
        return (
            <div className="not-found">
                <Inbox size={80} className="not-found-icon" />
                <h2>Post Not Found</h2>
                <p>The post you're trying to edit doesn't exist.</p>
                <Link to="/" className="back-btn">
                    <ArrowLeft size={16} />
                    Back to Home
                </Link>
            </div>
        );
    }

    const handleSubmit = (formData) => {
        const updated = updatePost(id, formData);
        if (updated) {
            navigate(`/post/${id}`);
        }
    };

    return (
        <div className="edit-post-page">
            <div className="page-header">
                <Link to={`/post/${id}`} className="back-link">
                    <ArrowLeft size={14} />
                    Back to post
                </Link>
                <h1 className="page-title">
                    <Pencil size={28} className="title-icon" />
                    Edit Post
                </h1>
                <p className="page-subtitle">
                    Update your post content
                </p>
            </div>

            <div className="form-container">
                <BlogForm
                    initialData={post}
                    onSubmit={handleSubmit}
                    isEditing={true}
                />
            </div>
        </div>
    );
};

export default EditPost;
