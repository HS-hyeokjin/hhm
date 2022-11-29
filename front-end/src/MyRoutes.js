import React, { useEffect, useState } from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import Main from "./components/Main";
import Nav from "./components/Nav";
import Login from "./components/login/Login";
import Community from "./components/community/Community";

function MyRoutes() {
  const [isLogin, setIsLogin] = useState(false);
  const [prevPath, setPrevPath] = useState("");
  const cookie = document.cookie === "";

  useEffect(() => {
    if (cookie) setIsLogin(false);
    else setIsLogin(true);
  }, [cookie]);
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Nav isLogin={isLogin} setPrevPath={setPrevPath} />} />
        <Route
          path="/"
          element={<Main isLogin={isLogin} setIsLogin={setIsLogin} />}
        />
        <Route path="/community" element={<Community />} />
        <Route
          path="/login"
          element={
            <Login
              isLogin={isLogin}
              prevPath={prevPath}
              setPrevPath={setPrevPath}
            />
          }
        />
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </BrowserRouter>
  );
}

export default MyRoutes;
