import { useState } from 'react';
import { Search, X } from 'lucide-react';

const SearchBar = ({ onSearch }) => {
    const [query, setQuery] = useState('');

    const handleChange = (e) => {
        const value = e.target.value;
        setQuery(value);
        onSearch(value);
    };

    const handleClear = () => {
        setQuery('');
        onSearch('');
    };

    return (
        <div className="search-bar">
            <div className="search-input-container">
                <Search size={16} className="search-icon" />
                <input
                    type="text"
                    className="search-input"
                    placeholder="Search by title or author..."
                    value={query}
                    onChange={handleChange}
                />
                {query && (
                    <button
                        className="clear-btn"
                        onClick={handleClear}
                        type="button"
                        aria-label="Clear search"
                    >
                        <X size={14} />
                    </button>
                )}
            </div>
        </div>
    );
};

export default SearchBar;
