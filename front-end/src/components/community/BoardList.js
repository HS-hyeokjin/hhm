import React, { useState, useEffect } from "react";
import axios from "axios";
import ShowBoardList from "./ShowBoardList";

const BoardList = () => {
  const [boardData, setBoardData] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const loadData = async () => {
      setLoading(true);

      try {
        const res = await axios.get("http://localhost:8080/post");
        setBoardData(res.data);
        console.log(res.data);
        setLoading(false);
      } catch (e) {
        console.log(e);
      }
    };
    loadData().then(() => console.log("success"));
  }, []);

  return (
    <div>
      <ShowBoardList boardData={boardData} loading={loading} />
    </div>
  );
};

export default BoardList;
