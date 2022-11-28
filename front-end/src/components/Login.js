import React, { useState } from "react";
import axios from "axios";

function Login() {
  const [memberId, setMemberId] = useState("");
  const [password, setPassword] = useState("");

  // input data 의 변화가 있을 때마다 value 값을 변경해서 useState 해준다
  const handleInputId = (e) => {
    setMemberId(e.target.value);
  };

  const handleInputPw = (e) => {
    setPassword(e.target.value);
  };

  const onClickLogin = () => {
    console.log("click login");
    axios
      .get("http://localhost:8080/member/login", {
        params: {
          memberId,
          password,
        },
      })
      .then(function (res) {})
      .catch(function (error) {});
  };

  return (
    <div>
      <h2>Login</h2>
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
      <div>
        <button type="button" onClick={onClickLogin}>
          Login
        </button>
      </div>
    </div>
  );
}

export default Login;
