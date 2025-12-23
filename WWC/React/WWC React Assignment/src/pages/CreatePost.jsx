import { useNavigate } from 'react-router-dom';
import { useBlog } from '../context/BlogContext';
import BlogForm from '../components/BlogForm';
import { Sparkles } from 'lucide-react';

const CreatePost = () => {
    const { addPost } = useBlog();
    const navigate = useNavigate();

    const handleSubmit = (formData) => {
        const newPost = addPost(formData);
        if (newPost) {
            navigate(`/post/${newPost.id}`);
        }
    };

    return (
        <div className="create-post-page">
            <div className="page-header">
                <h1 className="page-title">
                    <Sparkles size={32} className="title-icon" />
                    Create New Post
                </h1>
                <p className="page-subtitle">
                    Share your thoughts with the world
                </p>
            </div>

            <div className="form-container">
                <BlogForm onSubmit={handleSubmit} />
            </div>
        </div>
    );
};

export default CreatePost;
