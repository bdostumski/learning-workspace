package com.example.jdbcflywaydocker.movie;

import java.time.LocalDate;

public record Movie(Integer id,
                    String movieName,
                    LocalDate releaseDate) {
}
