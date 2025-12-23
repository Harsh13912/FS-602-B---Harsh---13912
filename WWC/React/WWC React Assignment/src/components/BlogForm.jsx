import { useState, useEffect } from 'react';
import { Type, User, FileText, Send, Save, Loader } from 'lucide-react';

const BlogForm = ({ initialData, onSubmit, isEditing = false }) => {
    const [formData, setFormData] = useState({
        title: '',
        author: '',
        content: ''
    });
    const [errors, setErrors] = useState({});
    const [isSubmitting, setIsSubmitting] = useState(false);

    // Load initial data for editing
    useEffect(() => {
        if (initialData) {
            setFormData({
                title: initialData.title || '',
                author: initialData.author || '',
                content: initialData.content || ''
            });
        }
    }, [initialData]);

    const validate = () => {
        const newErrors = {};

        if (!formData.title.trim()) {
            newErrors.title = 'Title is required';
        } else if (formData.title.length < 3) {
            newErrors.title = 'Title must be at least 3 characters';
        }

        if (!formData.author.trim()) {
            newErrors.author = 'Author name is required';
        } else if (formData.author.length < 2) {
            newErrors.author = 'Author name must be at least 2 characters';
        }

        if (!formData.content.trim()) {
            newErrors.content = 'Content is required';
        } else if (formData.content.length < 10) {
            newErrors.content = 'Content must be at least 10 characters';
        }

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: value
        }));
        // Clear error when user starts typing
        if (errors[name]) {
            setErrors(prev => ({
                ...prev,
                [name]: ''
            }));
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!validate()) return;

        setIsSubmitting(true);
        try {
            await onSubmit(formData);
            if (!isEditing) {
                setFormData({ title: '', author: '', content: '' });
            }
        } catch (error) {
            console.error('Error submitting form:', error);
        } finally {
            setIsSubmitting(false);
        }
    };

    return (
        <form className="blog-form" onSubmit={handleSubmit}>
            <div className="form-group">
                <label htmlFor="title" className="form-label">
                    <Type size={14} />
                    Title
                </label>
                <input
                    type="text"
                    id="title"
                    name="title"
                    value={formData.title}
                    onChange={handleChange}
                    className={`form-input ${errors.title ? 'error' : ''}`}
                    placeholder="Enter an engaging title..."
                    disabled={isSubmitting}
                />
                {errors.title && <span className="form-error">{errors.title}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="author" className="form-label">
                    <User size={14} />
                    Author
                </label>
                <input
                    type="text"
                    id="author"
                    name="author"
                    value={formData.author}
                    onChange={handleChange}
                    className={`form-input ${errors.author ? 'error' : ''}`}
                    placeholder="Your name..."
                    disabled={isSubmitting}
                />
                {errors.author && <span className="form-error">{errors.author}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="content" className="form-label">
                    <FileText size={14} />
                    Content
                </label>
                <textarea
                    id="content"
                    name="content"
                    value={formData.content}
                    onChange={handleChange}
                    className={`form-textarea ${errors.content ? 'error' : ''}`}
                    placeholder="Share your thoughts..."
                    rows={10}
                    disabled={isSubmitting}
                />
                {errors.content && <span className="form-error">{errors.content}</span>}
                <span className="char-count">{formData.content.length} characters</span>
            </div>

            <button
                type="submit"
                className="submit-btn"
                disabled={isSubmitting}
            >
                {isSubmitting ? (
                    <>
                        <Loader size={16} className="spinner" />
                        {isEditing ? 'Updating...' : 'Publishing...'}
                    </>
                ) : (
                    <>
                        {isEditing ? <Save size={16} /> : <Send size={16} />}
                        {isEditing ? 'Update Post' : 'Publish Post'}
                    </>
                )}
            </button>
        </form>
    );
};

export default BlogForm;
