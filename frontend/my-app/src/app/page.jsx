"use client";

import { useEffect, useState } from "react";
import Image from "next/image"
import "./styles/global.scss";

export default function Home() {

  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false); 

  const getApi = async () => {
    try{
      setLoading(true);
      const result = await fetch(
        "https://houze-portal-api.houze.io/portal/project-developers?limit=12"
      );

      if(!result.ok) {
        throw new Error(`API Error: ${result.status}`);
      }

      const dataProject = await result.json();
      console.log("dataProject", dataProject);

      setData(dataProject.result ?? []);
    } catch(error) {
      console.log("Fetch Failed ", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    getApi();
  }, []);

  return (
    <div className="content-page">
      
      <div className="banner-home">
        <Image 
          src="/banner/new.jpg" 
          alt="No banner Found"
          fill
        />

        <div className="caption-home">
          <h1>All Solutions you need are here</h1>
          <p>Your go-to hub for professional jobs and everyday solutions</p>
          <a href="" className="btn btn-ghost"> {/*get back to this later*/}
            Search Job
          </a>
        </div>

      </div>

    </div>
  );
}