<?php

  class Article {
    public function fetch_all() {
      global $pdo;

      $query = $pdo->prepare("SELECT * FROM articles ORDER BY article_id ASC");
      $query->execute();

      return $query->fetchAll();
    }

      public function fetch_data($article_id) {
        global $pdo;

        $query = $pdo->prepare("SELECT * FROM articles WHERE article_id=? ORDER BY article_id ASC");
        $query->bindValue(1, $article_id);
        $query->execute();

        return $query->fetch();
      }
    }
    
?>
