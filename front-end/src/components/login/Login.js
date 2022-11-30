import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import logo1 from "../../../src/logo1.png";
import "./Login.css";

function Login({ isLogin, prevPath, setPrevPath }) {
  const navigate = useNavigate();
  const [memberId, setMemberId] = useState("");
  const [password, setPassword] = useState("");

  useEffect(() => {
    if (isLogin) navigate("/", true);
  });

  // input data 의 변화가 있을 때마다 value 값을 변경해서 useState 해준다
  const handleInputId = (e) => {
    setMemberId(e.target.value);
  };

  const handleInputPw = (e) => {
    setPassword(e.target.value);
  };

  const onClickLogin = () => {
    console.log("click login");
    console.log("ID", memberId);
    console.log("PW", password);
    axios
      .get(
        "http://localhost:8080/member/login?memberId=" +
          memberId +
          "&password=" +
          password
      )
      .then(function (res) {
        console.log(res.data);
        console.log("memberId", memberId);
        if (memberId) {
          console.log("success");
          sessionStorage.setItem("memberId", memberId);
        }
        document.location.href = "/";
      })
      .catch(function (error) {});
  };

  return (
    <div className="login_all">
      <Link to="/">
        <img src={logo1} id="logo_image" alt="apt_logo"></img>
      </Link>
      <h3 id="login_text1">
        Welcome to visit our website! <br />
        Please login with your personal account.
      </h3>
      <div className="login_table">
        <div>
          <label htmlFor="memberId">ID : </label>
          <input
            type="text"
            name="memberId"
            value={memberId}
            onChange={handleInputId}
          />
        </div>
        <div>
          <label htmlFor="password">PW : </label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handleInputPw}
          />
        </div>
        <div className="login_btn">
          <button id="login_btn_fix" type="button" onClick={onClickLogin}>
            LOGIN
          </button>
        </div>
      </div>
    </div>
  );
}

export default Login;
