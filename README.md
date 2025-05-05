# FindMovies Frontend & Backend

## Overview
FindMovies is a full-stack application for searching movie availability and details. It features a React.js frontend and a Spring Boot backend, with support for GraalVM Native Image for ultra-fast startup and low memory usage.

---

## Technical Stack
- **Frontend:** React.js (Bootstrap, Axios, React Router, FontAwesome)
- **Backend:** Spring Boot 3.2, Java 21 (GraalVM CE 21.0.2)
- **Build Tools:** Maven, frontend-maven-plugin
- **Native Image:** GraalVM Native Image (for fast, lightweight executables)

---

## Prerequisites
- **Java 21 (GraalVM CE 21.0.2)**
- **Maven 3.8+**
- **Node.js 18+ & npm** (managed by Maven plugin)
- **GraalVM Native Image** (`gu install native-image` if not already installed)

---

## Project Structure
```
find-movies-frontend/
  frontend/         # React app source
  src/main/java/    # Spring Boot backend
  src/main/resources/application.yml  # Backend config
  ...
```

---

## How to Build & Run

### 1. **Standard JVM Mode**
```sh
# Build frontend and backend
git clone <repo-url>
cd find-movies-frontend
mvn clean package

# Run Spring Boot app (serves React build from /static)
mvn spring-boot:run
# or
java -jar target/FindMovies_FrontEnd-0.0.1-SNAPSHOT.jar
```
- The app will be available at [http://localhost:8080](http://localhost:8080)

### 2. **Build & Run as Native Image (GraalVM)**
```sh
# Prerequisite: GraalVM 21.0.2 and native-image installed
mvn -Pnative native:compile
# Run the native executable
./target/FindMovies_FrontEnd
```
- Native image starts instantly and uses less memory.

---

## Frontend (React)
- Located in `frontend/`
- Built automatically by Maven during backend build
- Uses proxy to backend for API calls during development
- Main scripts:
  - `npm start` (dev mode)
  - `npm run build` (production build)

---

## Backend (Spring Boot)
- Serves the React build from `/static` (no source pollution)
- Uses Java 21 features (including virtual threads)
- GraalVM Native Image compatible

---

## API Endpoints

### `GET /movieList/{searchText}/{countryCode}`
- **Description:** Search for movies by name and country code.
- **Parameters:**
  - `searchText` (string): Movie name or search term
  - `countryCode` (string): Two-letter country code (e.g., `us`, `in`, `uk`, ...)
- **Response:** `200 OK` with JSON body:
```json
{
  "results": [
    {
      "id": "string",
      "name": "string",
      "picture": "string",
      "locations": [
        {
          "icon": "string",
          "id": "string",
          "displayName": "string",
          "name": "string",
          "url": "string"
        }
      ],
      "externalIds": {
        "imdb": { "id": "string", "url": "string" },
        "tmdb": { "id": "string", "url": "string" },
        "wikiData": { "id": "string", "url": "string" }
      }
    }
  ]
}
```
- **Error Codes:**
  - `400 Bad Request`: Invalid input
  - `503 Service Unavailable`: Downstream API error

### `GET /{path:[^\.]*}`, `/home`, `/about`, `/`
- **Description:** All other paths are forwarded to the React SPA (`index.html`).

---

## Configuration
- **Backend API URL:** Set in `src/main/resources/application.yml`:
  - `service.url.movieNameService` (default: `http://localhost:8082/movies/`)
- **Server Port:** `server.port` (default: `8080`)

---

## Country Codes Supported
- `in`, `us`, `uk`, `ar`, `at`, `au`, `be`, `br`, `ca`, `ch`, `cz`, `dk`, `de`, `ee`, `es`, `fr`, `hk`, `hu`, `ie`, `il`, `is`, `it`, `jp`, `kr`, `lt`, `lv`, `mx`, `nl`, `no`, `nz`, `ph`, `pl`, `pt`, `ro`, `ru`, `se`, `sg`, `sk`, `th`, `za`

---

## Testing
- Run all tests:
```sh
mvn test
```
- Tests cover service, controller, DTOs, and configuration.

---

## Notes
- For local development, you can run the React app separately (`cd frontend && npm start`) and the backend (`mvn spring-boot:run`).
- The Maven build will always produce a full-stack artifact with the latest frontend build.
- Native image builds may require additional GraalVM configuration for advanced features.
