import React from "react";
import { Link } from "react-router-dom";
import "./ShowBoardList.css";
import Nav from "../Nav";

const ShowBoardList = ({ boardData }) => {
  return (
    <>
      <div className="board_nav">
        <Nav />
      </div>
      <table className="board_list">
        <tbody>
          <tr>
            <th>id</th>
            <th>title</th>
            <th>writer</th>
          </tr>
          {boardData.map((boardData) => (
            <tr className="board_content" key={boardData.id}>
              <td id="head_text">{boardData.id}님</td>
              <Link to={`/showcontent/${boardData.id}`}>
                <td id="board_text">{boardData.title}</td>
              </Link>
              <td id="board_text1">{boardData.writer}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
};

export default ShowBoardList;
