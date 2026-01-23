import React from 'react';

const Header = () => {
  return (
    <div className='header'>

      <div className="header-top">
        <div className="logo-group">
          {/* <button className='btn-toggleMenu hide-desktop'>Button </button> */}
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
          <button className='my-btn my-btn-solid'>Sign up</button>
        </div>
      </div>
    </div>
  )
}

export default Header  