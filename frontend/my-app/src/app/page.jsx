"use client";

import { useEffect, useState } from "react";
import Image from "next/image"
import "bootstrap/dist/css/bootstrap.min.css";
import Link from "next/link";

import CategorySlider from "./components/pillSliderCategory/pillSilderCategory";
import { redirect } from "next/navigation";


export default function Home() {

  const [dataSolutions, setDataSolutions] = useState([]);
  const [loading, setLoading] = useState(false);

  //login varibales groups
  const [accessToken, setAccessToken] = useState();
  const [user, setUser] = useState({});

  //utilities
  const [featuredIndex, setFeaturedIndex] = useState(0);
  const [randomListIndices, setRandomListIndices] = useState([]);

  //category state
  const [currentCategory, setCurrentCategory] = useState("All");

  const [message, setMessage] = useState("");
  const [predict, setPredict] = useState("");

  const getApi = async () => {
    try{
      setLoading(true);
      const result = await fetch(
        "http://170.64.179.146:8060/api/job/solutions"
      );

      if(!result.ok) {throw new Error(`API Error: ${result.status}`);}
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

  useEffect(() => {
    const token = localStorage.getItem("accessToken");
    const user = localStorage.getItem("user");

    if (token) {
      setAccessToken(token);
    }

    if (user) {
      setUser(JSON.parse(user));
    }
  }, []);

  useEffect(() => {
    if (dataSolutions.length > 0) {
      const randomTop = Math.floor(Math.random() * dataSolutions.length);
      setFeaturedIndex(randomTop);
      const allIndices = Array.from({ length: dataSolutions.length }, (_, i) => i);
      const filteredIndices = allIndices.filter(i => i !== randomTop);
      const shuffled = filteredIndices.sort(() => 0.5 - Math.random());
      setRandomListIndices(shuffled.slice(0, 6));
    }
  }, [dataSolutions])

  const featuredItem = dataSolutions[featuredIndex];

  const filteredSolutions = currentCategory === "All" ? dataSolutions : dataSolutions.filter(
    item => //if any: ?.some
      item.categories?.some(cat => cat.categoryName === currentCategory)
  );

  const isFiltering = currentCategory !== "All";

  const AiSearch = async () => {
    if (!message) return;
    try{
      setLoading(true)

      const result = await fetch('http://localhost:5000/api/predict', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json', // telling server, I'm sending json
        },
        body: JSON.stringify({ message: message })
      });

      if (!result.ok) {
        throw new Error(`POST Error: ${result.status}`);
      }

      const res = await result.json();
      console.log("model responde:", res);
      const categoryResult = res.prediction;

      setPredict(categoryResult);
      setCurrentCategory(categoryResult);

      console.log("Current Category:", currentCategory);
      console.log("Filtered Results Count:", filteredSolutions.length);
    } catch (error) {
      console.log("Post Failed", error);
    } finally {
      setLoading(false);
    }
  };

  return (
      <div className="content-page">
          <div className="banner-home">
              <Image src="/banner/new.jpg" alt="No banner Found" fill />

              <div className="caption-home-banner">
                  <h1>All Solutions you need are here</h1>
                  <p>Your go-to hub for professional jobs and everyday solutions</p>
                  <a href="" className="my-btn my-btn-ghost">
                      Search Job
                  </a>
              </div>
          </div>

          <div className="home-categories">
              <h2 className="mb-4">Solution Categories</h2>
              <CategorySlider
              selectedCategory={currentCategory}
              onSelectCategory={(name) => setCurrentCategory(name)}
              />
          </div>

          <div className="smart-search-container my-5 p-4 rounded-4 shadow-sm">
            <div className="text-center mb-4">
              <div className="ai-badge mb-2">AI ASSISTANT</div>
              <h2 className="fw-bold">How can I help you today?</h2>
              <p className="text-muted">Describe your problem, and I'll find the right solutions for you.</p>
            </div>

            <div className="message-box-wrapper position-relative">
              <input 
              type="text"
              className={`form-control form-control-lg ai-input ${loading ? 'ai-loading' : ''}`}
              placeholder="Tell me your problems, I returns solutions for you."
              value={message}
              onChange={(e) => setMessage(e.target.value)}
              onKeyDown={(e) => {
              if (e.key === 'Enter') AiSearch();
              }}
              />
              <button 
                className="btn btn-primary btn-ai-send"
                onClick={AiSearch} 
                disabled={loading}
              >
                {loading ? (
                  <span className="spinner-border spinner-border-sm" role="status"></span>
                ) : (
                  <i className="fa-solid fa-wand-magic-sparkles"></i>
                )}
              </button>
            </div>
            {predict && !loading && (
              <div className="prediction-result mt-4 animate-fade-in">
                <div className="d-flex align-items-center justify-content-center">
                  <span className="me-2 text-muted">Identified Category:</span>
                  <span className="badge bg-info text-dark p-2 px-3 fs-6">
                    {predict}
                  </span>
                </div>
              </div>
            )}
          </div>

          <div className="home-solutions">
              <div className="container">
                  <h1>{isFiltering ? `${currentCategory} Solutions` : "Popular Solutions"}</h1>
                  <p>Lists of high-demand solutions</p>

                  {dataSolutions.length > 0 && featuredItem ? (
                      <div className="row">
                      {!isFiltering && (
                          <div className="col-md-12">
                              <div className="solution-top">
                                  <div className="solution-thumbnail-top">
                                      <Image
                                          src={featuredItem.imageUrl ?? "/error/error.png"}
                                          alt="Error"
                                          width={600}
                                          height={374}
                                          style={{ objectFit: "cover" }}
                                      />
                                  </div>
                                  <div className="solution-content">
                                      <h3 className="solution-name">{featuredItem.solutionName ?? ""}</h3>
                                      <p className="solution-description">{featuredItem.description ?? ""}</p>
                                      <p>
                                          <label className="me-2">Price: </label>
                                          <i className="fa-solid fa-dollar-sign"></i>
                                          <b>{featuredItem.price ?? ""}</b>
                                      </p>
                                      <p>
                                          <label className="me-2">Sold: </label>
                                          <b>{featuredItem.processedNumber ?? ""}</b>
                                      </p>
                                      <p>
                                          <label className="me-2">Provider: </label>
                                          <b>Update Later</b>
                                      </p>
                                      <div className="category-tags">
                                          {featuredItem.categories?.map((object, index) => (
                                          <div className="tag" key={index}>
                                              {object.categoryName}
                                          </div>
                                          ))}
                                      </div>
                                  </div>
                              </div>
                          </div>
                      )}

                      {isFiltering ? (
                          filteredSolutions.length > 0 ? (
                              filteredSolutions.map((item) => (
                                  <div key={item.solutionId} className="col-lg-4 col-md-6 col-xs-12 mb-4">
                                      <Link className="solution-item" href={`/solutions/${item.solutionId}`}>
                                          <div className="solution-thumbnail" style={{ position: "relative", height: "200px" }}>
                                              <Image
                                                  src={item.imageUrl ?? "/solutions/error.png"}
                                                  alt="Thumbnail"
                                                  fill
                                                  style={{ objectFit: "cover" }}
                                              />
                                          </div>
                                          <div className="solution-content">
                                              <h3 className="solution-name">{item.solutionName}</h3>
                                              <p className="solution-description">{item.description}</p>
                                          </div>
                                      </Link>
                                  </div>
                              ))
                          ) : (
                          <div className="col-12 text-center py-5">
                              <p>No solutions found for {currentCategory}.</p>
                              <button className="btn btn-primary" onClick={() => setCurrentCategory("All")}>
                                  Show All
                              </button>
                          </div>
                          )
                      ) : (
                          randomListIndices.map((i) => {
                          const item = dataSolutions[i];
                          // Safety check in case index doesn't exist
                          if (!item) return null;

                          return (
                              <div key={item.solutionId} className="col-lg-4 col-md-6 col-xs-12 mb-4">
                                  <Link className="solution-item" href={`/solutions/${item.solutionId}`}>
                                      <div className="solution-thumbnail" style={{ position: "relative", height: "200px" }}>
                                          <Image
                                              src={item.imageUrl ?? "/solutions/error.png"}
                                              alt="Thumbnail"
                                              fill
                                              style={{ objectFit: "cover" }}
                                          />
                                      </div>
                                      <div className="solution-content">
                                          <h3 className="solution-name">{item.solutionName}</h3>
                                          <p className="solution-description">{item.description}</p>
                                          <p>
                                              <i className="fa-solid fa-dollar-sign me-1"></i>
                                              <b>{item.price}</b>
                                          </p>
                                      </div>
                                  </Link>
                              </div>
                          );
                          })
                      )}
                      </div>
                  ) : (
                      <div className="text-center py-5">
                          {loading ? "Loading..." : "No Data Found"}
                      </div>
                  )}
              </div>
          </div>
      </div>
  );
}