import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import BoardList from "./BoardList";

function Community(props) {
  const isLogin = props.isLogin;
  const navigate = useNavigate();

  useEffect(() => {
    if (!isLogin) navigate("/community", true);
  }, []);

  return (
    <>
      <BoardList />
    </>
  );
}

export default Community;
