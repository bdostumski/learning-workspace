<?php

  $hostname =  'postgres';
  $username = 'user';
  $password = 'password';
  $dsn = 'pgsql:host=postgres;port=5432;dbname=syscomz_blog';

  try {
    $pdo = new PDO($dsn, $username, $password);
  } catch(PDOException $e) {
    exit('Database error: ' . $e->getMessage());
  }

?>
