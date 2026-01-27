"use-client";

import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

import React from "react";
import Slider from "react-slick";
import Image from "next/image";

import "./PillSliderCategory.scss";

const categories = [
    { name: "Fast Food", icon: "🍟" },
    { name: "Burgers", icon: "🍔" },
    { name: "Deals", icon: "🏷️" },
    { name: "Sushi", icon: "🍣" },
    { name: "Healthy", icon: "🥗" },
    { name: "Asian", icon: "🍜" },
    { name: "Chicken", icon: "🍗" },
    { name: "Breakfast", icon: "🥞" },
    { name: "Mexican", icon: "🌮" },
    { name: "Pizza", icon: "🍕" },
];

export default function CategorySlider( {id} ) {
    const settings = {
        dots: false,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 2,
        variableWidth: true, //pill slider
        swipeToSlides: true,
        swipe: true,
        arrow: true,
        draggable: true
    };
    
    return (
        <div className="cateogry-slider-wrapper">
            <Slider {...settings}>
                {
                    categories.map((category, index) => (
                        <div className="category-slide-item" key={index}>
                            <div className="category-pill">
                                <span className="category-icon">{category.icon}</span>
                                <span className="category-name">{category.name}</span>
                            </div>
                        </div>
                    ))
                }
            </Slider>
        </div>
    );
}