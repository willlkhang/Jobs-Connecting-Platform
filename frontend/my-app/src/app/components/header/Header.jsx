"use client";
import { redirect } from "next/navigation";
import React from "react";
import { useEffect, useState } from "react";

const Header = () => {
  const [hasToken, setHasToken] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem("accessToken");
    setHasToken(!!token);
  }, []);

  if (!hasToken) return null;

  return (
    <div className='header'>

      <div className="header-top">
        <div className="logo-group">
          <div className="block-center">
            <div className="logo">
              <a href="">
                <img src="/logo/newlogo.png" alt="Job hub Logo" />
              </a>
            </div>
              <p className='slogan'>This is where you find your jobs and solutions for life</p>
          </div>
        </div>
        <div className="group-right">
          <button className='my-btn my-btn-primary'>Login</button>
          <button className='my-btn my-btn-solid'
            onClick={() => {
              localStorage.removeItem("accessToken");
              localStorage.removeItem("user");
              redirect("/login");
            }}
          >
            Logout
          </button>
        </div>
      </div>
    </div>
  )
}

export default Header  