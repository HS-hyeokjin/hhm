import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Nav from "../Nav";

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
      <h1>글내용</h1>
      <hr />
      <h3>{data.id}</h3>
      <h1>{data.title}</h1>
      <h2>{data.content}</h2>
    </div>
  );
};

export default ShowContent;
