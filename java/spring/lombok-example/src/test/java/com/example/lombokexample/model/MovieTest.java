package com.example.lombokexample.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private Movie movie;

    @BeforeEach
    void setUp() throws MalformedURLException {

        movie = Movie.builder()
                .id(1L)
                .title("Man in Black")
                .description("Man in Black best move ever")
                .country("USA")
                .language("EN")
                .rating(7)
                .officialSite(new URL("https://www.imdb.com/title/tt0119654/"))
                .minutes(120)
                .cast("string")
                .build();
    }

    @Test
    void getId() {
        assertNotNull(movie);
        assertEquals(1L, movie.id());
    }

    @Test
    void setId() {
        assertNotNull(movie);
        movie.id(2L);
        assertEquals(2L, movie.id());
    }

    @Test
    void getTitle() {
        assertNotNull(movie);
        assertEquals("Man in Black", movie.getTitle());
    }

    @Test
    void setTitle() {
        assertNotNull(movie);
        movie.setTitle("Joe Black");
        assertEquals("Joe Black", movie.getTitle());
    }

    @Test
    void getDescription() {
        assertNotNull(movie);
        assertEquals("Man in Black best move ever", movie.getDescription());
    }

    @Test
    void setDescription() {
        assertNotNull(movie);
        movie.setDescription("Joe Black is good move");
        assertEquals("Joe Black is good move", movie.getDescription());
    }

    @Test
    void getCountry() {
        assertNotNull(movie);
        assertEquals("USA", movie.getCountry());
    }

    @Test
    void setCountry() {
        assertNotNull(movie);
        movie.setCountry("United States of America");
        assertEquals("United States of America", movie.getCountry());
    }

    @Test
    void getRating() {
        assertNotNull(movie);
        assertEquals(7, movie.getRating());
    }

    @Test
    void setRating() {
        assertNotNull(movie);
        movie.setRating(5);
        assertEquals(5, movie.getRating());
    }

    @Test
    void getOfficialSite() {
        assertNotNull(movie);
        assertEquals("https://www.imdb.com/title/tt0119654/", movie.getOfficialSite().toString());
    }

    @Test
    void setOfficialSite() throws MalformedURLException {
        assertNotNull(movie);
        movie.setOfficialSite(new URL("https://www.imdb.com/title/tt0119643/"));
        assertEquals("https://www.imdb.com/title/tt0119643/", movie.getOfficialSite().toString());
    }

    @Test
    void getLanguage() {
        assertNotNull(movie);
        assertEquals("EN", movie.getLanguage());
    }

    @Test
    void setLanguage() {
        assertNotNull(movie);
        movie.setLanguage("English");
        assertEquals("English", movie.getLanguage());
    }

    @Test
    void getMinutesPlusX() {
        int minutesPlusX = movie.getMinutesPlusX(1);
        assertNotNull(minutesPlusX);
        assertEquals(121, minutesPlusX);
    }
}