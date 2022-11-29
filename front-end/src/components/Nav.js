import { Link } from "react-router-dom";
import React from "react";
import logo1 from "../logo1.png";
import "./Nav.css";

function Nav({ isLogin, prevPath, setPrevPath }) {
  return (
    <>
      <nav>
        <Link to="/">
          <img src={logo1} id="apt_logo" alt="apt_logo" />
        </Link>
        <div>
          <ul id="nav_list">
            <li id="category">
              <Link to="/">홈</Link>
            </li>
            {!isLogin && (
              <li id="category">
                <Link to="/login">로그인</Link>
              </li>
            )}
            <li id="category">
              <Link to={isLogin ? "/community" : "/login"}>관리사무소</Link>
            </li>
            <li id="category">
              <Link to="/community">커뮤니티</Link>
            </li>
            <li id="category">
              <Link to={isLogin ? "/community" : "/login"}>정보마당</Link>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
}

export default Nav;
