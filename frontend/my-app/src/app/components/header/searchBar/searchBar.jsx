import React, { useState } from 'react';
import styles from "./searchBar.scss"
import "@fortawesome/fontawesome-free/css/all.min.css";

export default function SearchBar () {
    const [searchQuery, setSearchQuery] = useState("");
    
    return (
        <div className="search-container">
            <div className="input-wrapper">
                <i className='fa-solid fa-magnifying-glass search-icon'></i>
                <input 
                    type="text"
                    placeholder='Tell me your problems'
                    className='search-input'
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)} 
                />
                {searchQuery && (
                    <button
                        className='clear-btn'
                        onClick={() => setSearchQuery("")}
                    >
                        &times;
                    </button>
                )}
            </div>
        </div>
    );
}