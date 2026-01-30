"use client";

import { useEffect, useState } from "react";
import Image from "next/image"
import "bootstrap/dist/css/bootstrap.min.css";
import Link from "next/link";

import CategorySlider from "./components/pillSliderCategory/pillSilderCategory";

export default function Home() {

  const [dataSolutions, setDataSolutions] = useState([]);
  const [loading, setLoading] = useState(false); 

  const getApi = async () => {
    try{
      setLoading(true);
      const result = await fetch(
        "http://170.64.179.146:8060/api/job/solutions"
      );

      if(!result.ok) {
        throw new Error(`API Error: ${result.status}`);
      }

      const res = await result.json();
      console.log("dataProject", res);

      setDataSolutions(res ?? []);
    } catch(error) {
      console.log("Fetch Failed ", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    getApi();
  }, []);

  useEffect(() => {
    console.log("check", dataSolutions.length);
  }, [dataSolutions]);

  return (
    <div className="content-page">
      
      <div className="banner-home">
        <Image 
          src="/banner/new.jpg" 
          alt="No banner Found"
          fill
        />

        <div className="caption-home-banner">
          <h1>All Solutions you need are here</h1>
          <p>Your go-to hub for professional jobs and everyday solutions</p>
          <a href="" className="my-btn my-btn-ghost"> {/*get back to this later*/}
            Search Job
          </a>
        </div>
      </div>

      <div className="home-categories">
        <h2 className="mb-4">Solution Categories</h2>
        <CategorySlider />
      </div>

      <div className="home-solutions">
        <div className="container">
          <h1>Popular Solutions</h1>
          <p>Lists of high-demand solutions</p>
          {
            dataSolutions.length >= 4 ? (
              <div className="row">
                <div className="col-md-12">
                  <div className="solution-top">
                    <div className="solution-thumbnail-top">
                      <Image src={
                        dataSolutions[11].imageUrl ?? "/solutions/error.png"
                      } 
                      alt="Error" 
                      width={600} 
                      height={374}
                      />
                    </div>
                    <div className="solution-content">
                      <h3 className="solution-name">
                        {dataSolutions[11].solutionName ?? ""}{" "}
                      </h3>
                      <p className="solution-description">
                        {dataSolutions[11].description ?? ""}
                      </p>
                      <p>
                        <label className="me-2" htmlFor="generic-box">
                          Price:{" "}
                        </label>
                        <i className="fa-solid fa-dollar-sign"></i>
                        <span className="generic-box">
                          <b>{dataSolutions[11].price ?? ""}</b>
                        </span>
                      </p>
                      <p>
                        <label className="me-2" htmlFor="generic-box">
                          Sold:{" "}
                        </label>
                        <i className="fa-solid fa-dollar-sign"></i>
                        <span className="generic-box">
                          <b>{dataSolutions[11].processedNumber ?? ""}</b>
                        </span>
                      </p>
                      <p>
                        <label className="me-2" htmlFor="generic-box">
                          Provider:{" "}
                        </label>
                        <i className="fa-solid fa-dollar-sign"></i>
                        <span className="generic-box">
                          <b>Update Later</b>
                        </span>
                      </p>
                      <div className="category-tags">
                        {dataSolutions[11].categories?.map((object, index) => (
                          <div className="tag" key={index}>
                            {object.categoryName}
                          </div>
                        ))}
                      </div>
                    </div>
                  </div>

                </div>
                {[5, 6, 7].map((i) => (
                  <div key={i} className="col-lg-4 col-md-6 col-xs-12">
                    <Link
                      className="solution-item"
                      href={`/solutions/${dataSolutions[i].solutionId}`}
                    >
                      <div className="solution-thumbnail">
                        <Image 
                        src={dataSolutions[i].imageUrl ?? "/solutions/error.png"} 
                        alt="Error" 
                        fill
                        />
                      </div>
                      <div className="solution-content">
                        <h3 className="solution-name">
                          {dataSolutions[i].solutionName ?? ""}{" "}
                        </h3>
                        <p className="solution-description">
                          {dataSolutions[i].description ?? ""}
                        </p>
                        <p>
                          <label className="me-2" htmlFor="generic-box">
                            Price:{" "}
                          </label>
                          <i className="fa-solid fa-dollar-sign"></i>
                          <span className="generic-box">
                            <b>{dataSolutions[i].price ?? ""}</b>
                          </span>
                        </p>
                        <p>
                          <label className="me-2" htmlFor="generic-box">
                            Sold:{" "}
                          </label>
                          <i className="fa-solid fa-dollar-sign"></i>
                          <span className="generic-box">
                            <b>{dataSolutions[i].processedNumber ?? ""}</b>
                          </span>
                        </p>
                        <p>
                          <label className="me-2" htmlFor="generic-box">
                            Provider:{" "}
                          </label>
                          <i className="fa-solid fa-dollar-sign"></i>
                          <span className="generic-box">
                            <b>Update Later</b>
                          </span>
                        </p>
                        <div className="category-tags">
                          {dataSolutions[i].categories?.map((object, index) => (
                            <div className="tag" key={index}>
                              {object.categoryName}
                            </div>
                          ))}
                        </div>
                      </div>
                    </Link>
                  </div>
                ))}
              </div>
            ) : (
              <div></div>
            )
          }
        </div>
        
      </div>
    </div>
  );
}