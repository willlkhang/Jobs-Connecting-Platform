"use client";

import { useEffect, useState } from "react";
import Image from "next/image"
import "./styles/global.scss";

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
          <a href="" className="btn btn-ghost"> {/*get back to this later*/}
            Search Job
          </a>
        </div>
      </div>
      {/* <div>
        {!loading && dataSolutions && dataSolutions.length > 0 ? (
          <>
            {dataSolutions.map((object, i) => (
              <div key={i}>
                <p>{object.solutionName ?? ""}</p>
              </div>
            ))}
          </>
        ) : (
          <>
            <p>No solutions found (or loading...)</p>
          </>
        )}
      </div> */}

      
      <div className="home-solutions">
        <div className="container">
          <h1>Popular Solutions</h1>
          <p>Lists of high-demand solutions</p>
          {
            dataSolutions.length > 4 ? (
              <div className="row">
                <div className="col-md-12">
                  <div className="solution-top">
                    <div className="solution-thumbnail-top">
                      <img src={
                        dataSolutions[0].imageUrl ?? "/solutions/error.png"
                      } 
                      alt="Error" 
                      />
                    </div>
                    <div className="solution-content">
                      <h3>
                        <p className="solution-description">
                          {dataSolutions[0].description ?? ""}
                        </p>
                      </h3>
                    </div>
                  </div>
                </div>
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