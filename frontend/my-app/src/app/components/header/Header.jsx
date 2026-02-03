"use client";
import { redirect } from "next/navigation";
import React from "react";
import { useEffect, useState } from "react";

import SearchBar from "./searchBar/searchBar.jsx"

const Header = () => {
  const [hasToken, setHasToken] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem("accessToken");
    setHasToken(!!token);
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("user");
    setHasToken(false);
    redirect("/../.."); // Navigate to main page
  };

  const handleLogin = () => {
    redirect("/login");
  };

  return (
    <div className='header'>

      <div className="header-top">
        <div className="logo-group">
          <div className="block-center">
            <div className="logo">
              <a href="">
                <img src="/logo/newlogo.png" alt="/error/error.png" />
              </a>
            </div>
              {/* <p className='slogan'>This is where you find your jobs and solutions for life</p> */}
          </div>
          
        </div>
        
        <div className="search-bar-wrapper">
          <SearchBar />
        </div>

        <div className="group-right">

          {
            hasToken ? 
            (
              <button className='my-btn my-btn-solid' onClick={handleLogout}>
                Logout
              </button>
            ) : (
              <>
                <button className='my-btn my-btn-primary' onClick={handleLogin}>
                  Login
                </button>
                <button className='my-btn my-btn-solid'>
                  Sign Up
                </button>
              </>
            ) 
          } 

        </div>
      </div>
    </div>
  )
}

export default Header  