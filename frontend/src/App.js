import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import MovieSearch from "./components/MovieSearch";
import AboutMe from "./components/AboutMe";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function Masthead() {
  return (
    <header
      className="masthead text-white text-center"
      style={{
        position: "relative",
        backgroundColor: "#343a40",
        backgroundImage: `url('/img/bg-masthead-collash.jpg')`,
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center center",
        backgroundSize: "cover",
        paddingTop: "8rem",
        paddingBottom: "8rem",
      }}
    >
      <div
        className="overlay"
        style={{
          position: "absolute",
          backgroundColor: "#212529",
          height: "100%",
          width: "100%",
          top: 0,
          left: 0,
          opacity: 0.3,
        }}
      ></div>
      <div className="container" style={{ position: "relative", zIndex: 2 }}>
        <div className="row">
          <div className="col-xl-9 mx-auto">
            <h1 className="mb-5" style={{ fontWeight: 700, fontSize: "2.5rem" }}>
              Search for your favourite Movies and Shows here!
            </h1>
          </div>
          <div className="col-md-10 col-lg-8 col-xl-7 mx-auto">
            <MovieSearch />
          </div>
        </div>
      </div>
    </header>
  );
}

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<Masthead />} />
          <Route path="/about" element={<AboutMe />} />
        </Routes>
        <footer className="footer bg-light border-primary border-top mt-5">
          <div className="container">
            <div className="row">
              <div className="col-lg-6 h-75 text-center text-lg-left my-auto">
                <ul className="list-inline mb-2">
                  <li className="list-inline-item"><Link to="/about">About</Link></li>
                  <li className="list-inline-item">&sdot;</li>
                  <li className="list-inline-item"><a href="#">Terms of Use</a></li>
                </ul>
                <p className="text-muted small mb-4 mb-lg-0">&copy; Find Movies 2020. All Rights Reserved.</p>
              </div>
              <div className="col-lg-6 h-75 text-center text-lg-right my-auto">
                <ul className="list-inline mb-0">
                  <li className="list-inline-item mr-3"><a href="https://www.facebook.com/Prebeesh.S" target="_blank" rel="noopener noreferrer"><i className="fab fa-facebook fa-2x fa-fw"></i></a></li>
                  <li className="list-inline-item mr-3"><a href="https://twitter.com/PrebeeshS" target="_blank" rel="noopener noreferrer"><i className="fab fa-twitter-square fa-2x fa-fw"></i></a></li>
                  <li className="list-inline-item"><a href="https://www.instagram.com/prebeesh_s/" target="_blank" rel="noopener noreferrer"><i className="fab fa-instagram fa-2x fa-fw"></i></a></li>
                  <li className="list-inline-item"><a href="https://www.linkedin.com/in/prebeesh-s-581136153/" target="_blank" rel="noopener noreferrer"><i className="fab fa-linkedin fa-2x fa-fw"></i></a></li>
                </ul>
              </div>
            </div>
          </div>
        </footer>
      </div>
    </Router>
  );
}

export default App; 