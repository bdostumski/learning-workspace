CREATE DATABASE syscomz_blog;
\connect syscomz_blog;

DROP TABLE IF EXISTS articles;
CREATE TABLE articles (
  article_id SERIAL PRIMARY KEY,
  article_title VARCHAR(255),
  article_content TEXT,
  article_image VARCHAR(255) DEFAULT NULL,
  article_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  user_id SERIAL PRIMARY KEY,
  user_name VARCHAR(255) DEFAULT NULL,
  user_password VARCHAR(255) DEFAULT NULL
);

INSERT INTO users VALUES (1, 'root', '63a9f0ea7bb98050796b649e85481845');