import { Link, useLocation } from 'react-router-dom';
import { PenLine, Home, Plus } from 'lucide-react';

const Navbar = () => {
    const location = useLocation();

    const isActive = (path) => location.pathname === path;

    return (
        <nav className="navbar">
            <div className="navbar-container">
                <Link to="/" className="navbar-brand">
                    <PenLine className="brand-icon" size={24} />
                    <span className="brand-text">The Blog Website </span>
                </Link>

                <div className="navbar-links">
                    <Link
                        to="/"
                        className={`nav-link ${isActive('/') ? 'active' : ''}`}
                    >
                        <Home size={14} />
                        Home
                    </Link>
                    <Link
                        to="/create"
                        className={`nav-link create-btn ${isActive('/create') ? 'active' : ''}`}
                    >
                        <Plus size={14} />
                        New Post
                    </Link>
                </div>
            </div>
        </nav>
    );
};

export default Navbar;
