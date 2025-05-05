import React from "react";

function MovieCard({ movie }) {
  return (
    <div className="row border border-light rounded mb-3">
      <div className="col-lg-6 order-lg-1">
        <img className="img-fluid" src={movie.picture} alt={movie.name} />
      </div>
      <div className="col-lg-6 order-lg-2 my-auto">
        <h2 className="text-center">{movie.name}</h2>
        <br />
        <LocationHtml locations={movie.locations} />
        <DetailsHtml external_ids={movie.external_ids} />
      </div>
    </div>
  );
}

function LocationHtml({ locations }) {
  return (
    <>
      <h4>Watch the movie here:</h4>
      <br />
      <div className="container-fluid">
        <div className="row">
          {locations.map((loc, idx) => (
            <div className="col-md-3 col-6" key={idx}>
              <a href={loc.url} target="_blank" rel="noopener noreferrer">
                <img alt="" src={loc.icon} />
              </a>
            </div>
          ))}
        </div>
      </div>
      <br />
    </>
  );
}

function DetailsHtml({ external_ids }) {
  return (
    <>
      <h4>For Details:</h4>
      <br />
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-3 col-6">
            <a href={external_ids.imdb.url} target="_blank" rel="noopener noreferrer">
              <img alt="" src="/img/imdb-logo.png" />
            </a>
          </div>
          <div className="col-md-3 col-6">
            <a href={external_ids.tmdb.url} target="_blank" rel="noopener noreferrer">
              <img alt="" src="/img/tmdb_icon.png" />
            </a>
          </div>
          <div className="col-md-3 col-6">
            <a href={external_ids.wiki_data.url} target="_blank" rel="noopener noreferrer">
              <img alt="" src="/img/wikidata_logo.png" />
            </a>
          </div>
        </div>
      </div>
      <br />
    </>
  );
}

export default MovieCard; 