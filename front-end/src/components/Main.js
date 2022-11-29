import { Link } from "react-router-dom";
import Nav from "./Nav";
import "./Main.css";
import img1 from "../shop.png";
import img2 from "../tshirt.png";
import img3 from "../hospital.png";
import img4 from "../chat.png";
import img5 from "../calender.png";

const Main = () => {
  return (
    <>
      <div className="main_1">
        <Nav />
      </div>
      <div className="main_2">
        <h2 id="text1">PREMIUM LIFE</h2>
        <h1 id="text1">GYONGGI APARTMENT</h1>
      </div>
      <div className="middle">
        <div className="middle1">
          <h3>관리실 전화번호</h3>
          <h4>031-245-6547</h4>
        </div>

        <div className="middle2">
          <img id="img2" src={img1} alt="" />{" "}
          중고장터&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <img id="img2" src={img2} alt="" />{" "}
          오픈카톡방&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <img id="img2" src={img3} alt="" />{" "}
          주변병원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <img id="img2" src={img4} alt="" />{" "}
          이벤트&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <img id="img2" src={img5} alt="" /> 의류수거함
          위치&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
      </div>
    </>
  );
};

export default Main;
