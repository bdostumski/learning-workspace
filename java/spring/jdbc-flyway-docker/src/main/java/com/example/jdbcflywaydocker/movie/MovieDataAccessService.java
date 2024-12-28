package com.example.jdbcflywaydocker.movie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        String sqlQuery = """
                SELECT id, movie_name, release_date
                FROM movie
                LIMIT 100;
                """;

        return jdbcTemplate.query(sqlQuery, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        String sqlQuery = """
                INSERT INTO movie(movie_name, release_date) VALUES (?, ?);
                """;
        return jdbcTemplate.update(sqlQuery, movie.movieName(), movie.releaseDate());
    }

    @Override
    public int deleteMovie(int id) {
        String sqlQuery = """
                DELETE FROM movie
                WHERE id = ?;
                """;

        return jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        String sqlQuery = """
                SELECT id, movie_name, release_date
                FROM movie
                WHERE id = ?;
                """;

        return jdbcTemplate.query(sqlQuery, new MovieRowMapper(), id)
                .stream()
                .findFirst();
    }
}
