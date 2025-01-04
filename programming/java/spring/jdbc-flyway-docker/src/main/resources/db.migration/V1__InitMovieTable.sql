create table movie (id bigserial, movie_name text not null, release_date date not null,
    primary key (id), unique (movie_name));