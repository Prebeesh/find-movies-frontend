import React from "react";
import MovieCard from "./MovieCard";

function MovieList({ movies }) {
  if (!movies.length) return null;
  return (
    <div id="response_list">
      {movies.map((movie, idx) =>
        movie.locations ? <MovieCard key={idx} movie={movie} /> : null
      )}
    </div>
  );
}

export default MovieList; 