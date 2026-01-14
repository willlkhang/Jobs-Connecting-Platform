"use client";

import { useEffect, useState } from "react";
export default function Home() {

  const [count, setCount] = useState(1);
  const [sum, setSum] = useState(1);

  useEffect(() => {
    console.log("check ");
  }, []);

  useEffect(() => {
    console.log("Check no depend");
  });

  const getApi = async () => {
    const result = await fetch("http://170.64.179.146:8060/api/job/solution/3").catch((error) => {
      console.log()
  });
    const data = result.json();
    console.log("Data: ", data);
  };

  useEffect(() => {
    getApi()
  }, []);

  return (
    <>
      <button onClick={() => {
        setCount(pre => pre + 1)
      }}>Count {count} </button>

      <br />

      <button onClick={() => {
        setSum(pre => pre + pre)
      }}>Sum {sum}</button>
    </>
  );
}