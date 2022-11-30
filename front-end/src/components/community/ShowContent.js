import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Nav from "../Nav";
import "./ShowContent.css";

const ShowContent = ({ boardData }) => {
  const { id } = useParams();

  const [data, setData] = useState({
    id: "",
    title: "",
    content: "",
  });

  useEffect(() => {
    fetch(`http://localhost:8080/post/detail/${id}`)
      .then((res) => res.json())
      .then((res) => {
        setData(res);
      });
  }, []);

  return (
    <div>
      <Nav />
      <div className="get_content">
        <h1>Contents</h1>
        <div className="title_box">
          <h1>{data.title}</h1>
        </div>
        <div className="content_box">
          <h2>{data.content}</h2>
        </div>

        <div className="button">
          <p>수정</p>
        </div>
      </div>
    </div>
  );
};

export default ShowContent;
