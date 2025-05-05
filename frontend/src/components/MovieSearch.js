import React, { useState } from "react";
import axios from "axios";
import MovieList from "./MovieList";

const countryOptions = [
  { code: 0, name: "Country" },
  { code: "in", name: "India" },
  { code: "us", name: "USA" },
  { code: "uk", name: "United Kingdom" },
  { code: "ar", name: "Argentina" },
  { code: "at", name: "Austria" },
  { code: "au", name: "Australia" },
  { code: "be", name: "Belgium" },
  { code: "br", name: "Brazil" },
  { code: "ca", name: "Canada" },
  { code: "ch", name: "Switzerland" },
  { code: "cz", name: "Czechia" },
  { code: "dk", name: "Denmark" },
  { code: "de", name: "Germany" },
  { code: "ee", name: "Estonia" },
  { code: "es", name: "Spain" },
  { code: "fr", name: "France" },
  { code: "hk", name: "Hong Kong" },
  { code: "hu", name: "Hungary" },
  { code: "ie", name: "Ireland" },
  { code: "il", name: "Israel" },
  { code: "is", name: "Iceland" },
  { code: "it", name: "Italy" },
  { code: "jp", name: "Japan" },
  { code: "kr", name: "South Korea" },
  { code: "lt", name: "Lithuania" },
  { code: "lv", name: "Latvia" },
  { code: "mx", name: "Mexico" },
  { code: "nl", name: "Netherlands" },
  { code: "no", name: "Norway" },
  { code: "nz", name: "New Zealand" },
  { code: "ph", name: "Philippines" },
  { code: "pl", name: "Poland" },
  { code: "pt", name: "Portugal" },
  { code: "ro", name: "Romania" },
  { code: "ru", name: "Russia" },
  { code: "se", name: "Sweden" },
  { code: "sg", name: "Singapore" },
  { code: "sk", name: "Slovakia" },
  { code: "th", name: "Thailand" },
  { code: "za", name: "South Africa" },
];

function MovieSearch() {
  const [searchText, setSearchText] = useState("");
  const [countryCode, setCountryCode] = useState(0);
  const [movies, setMovies] = useState([]);
  const [loading, setLoading] = useState(false);

  const doSearch = async () => {
    if (!searchText || countryCode === 0) {
      alert("Inputs are not valid. Please try again");
      return;
    }
    setLoading(true);
    setMovies([]);
    try {
      const response = await axios.get(`/movieList/${searchText}/${countryCode}`);
      const resultList = response.data.results;
      if (!resultList || resultList.length === 0) {
        alert("Sorry cannot find movies. Please try another");
      } else {
        setMovies(resultList);
      }
    } catch (error) {
      if (error.response && error.response.status === 503) {
        alert("Service is down now. Please wait");
      } else {
        alert(error.message);
      }
    }
    setLoading(false);
  };

  return (
    <div className="d-flex justify-content-center align-items-center" style={{ minHeight: "180px", marginTop: "-60px" }}>
      <form className="w-100" style={{ maxWidth: 800 }} onSubmit={e => { e.preventDefault(); doSearch(); }}>
        <div className="row g-2 justify-content-center">
          <div className="col-12 col-md-5">
            <input
              type="text"
              className="form-control form-control-lg"
              placeholder="Enter the movie name..."
              value={searchText}
              onChange={e => setSearchText(e.target.value)}
              id="search_txt"
            />
          </div>
          <div className="col-12 col-md-3">
            <select
              className="form-select form-select-lg"
              value={countryCode}
              onChange={e => setCountryCode(e.target.value)}
              id="country_code"
            >
              {countryOptions.map(opt => (
                <option key={opt.code} value={opt.code} disabled={opt.code === 0} selected={opt.code === 0}>
                  {opt.name}
                </option>
              ))}
            </select>
          </div>
          <div className="col-12 col-md-2 d-grid">
            <button
              type="submit"
              className="btn btn-primary btn-lg"
              disabled={loading}
              style={{ minWidth: 100 }}
            >
              {loading ? "Searching..." : "Search!"}
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}

export default MovieSearch; 