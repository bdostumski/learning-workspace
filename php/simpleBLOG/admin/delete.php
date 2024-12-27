<?php

session_start();
include_once 'includes/connection.php';
include_once 'includes/myarticle.php';

$article = new Article;

if(isset($_SESSION['logged'])) {

  if(isset($_POST['yesBtn'], $_POST['delete_id'])) {
    $id = $_POST['delete_id'];
    $query = $pdo -> prepare('DELETE FROM articles WHERE article_id=?');
    $query -> bindValue(1, $id);
    $query -> execute();

    header("Location: index.php");
  }
  if(isset($_POST['canselBtn'])) {
    header("Location: index.php");
  }

  $articles = $article->fetch_all();

  ?>

<!doctype html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
    integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="../../style/main_style.css">
  <title>CMS - Content Management System</title>
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="navbar-mycolor">
    <a class="navbar-brand" href="../index.php"><i class="fas fa-user-astronaut mr-2"></i>SYSCOMz</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link ml-3" href="../index.php"><i class="fas fa-home"></i> Home <span
              class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link active ml-3" href="index.php"><i class="fas fa-users-cog"></i> Admin</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ml-3" href="add.php"><i class="fas fa-plus"></i> Add Article</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ml-3" href="logout.php"><i class="fas fa-sign-out-alt"></i> Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="container">
    <h1 class="lead mt-5 mb-3"><i class="far fa-trash-alt mr-1"></i> Delete Article</h1>
    <div class="row">
      <div class="col-lg-6 col-sm-12 d-flex justify-content-center  bg-dark text-light rounded-lg"
        id="article-main-mycolor" style="margin-bottom:120px;">
        <form class="form-group" action="delete.php" method="post" autocomplete="off">
          <h4 class="mt-5 mb-4">Do you want to delete this article!</h4>
          <input class="form-control mb-5" type="text" name="delete_id" style="display:none;"
            value="<?php echo $_GET['did'];?>">
          <input type="submit" name="canselBtn" value="Cansel" class="btn btn-outline-primary ml-4  mb-5 ">
          <input type="submit" name="yesBtn" value="Yes" class="btn btn-outline-danger ml-5 mb-5 pl-4 pr-4">
        </form>
      </div>
    </div>
  </div>

  <div class="container-fluid">
    <div class="row text-muted bg-dark footer p-3 mt-5" id="footer-mycolor">
      <div class="col-lg-3 col-sm-12 pl-4 mb-4">
        <h5 class="text-info mb-3"><i class="fas fa-calendar-alt"></i> Calendar</h5>
        <?php include 'includes/calendar.php' ?>
      </div>
      <div class="col-lg-3 col-sm-12 pl-4 mb-4">
        <h5 class="text-danger mb-3"><i class="far fa-thumbs-up"></i> Social Links</h5>
        <h5 class="text-white ml-4 mt-4"><i class="fab fa-linkedin"></i><a class="text-white ml-1"
            href="https://www.linkedin.com/in/borislav-dostumski/" target="_blank">LinkedIn</a></h5>
        <h5 class="text-white ml-4 mt-4"><i class="fab fa-github"></i><a class="text-white ml-1"
            href="https://github.com/bdostumski" target="_blank">GitHub</a></h5>
        <h5 class="text-white ml-4 mt-4"><i class="fab fa-youtube"></i><a class="text-white ml-1"
            href="https://www.youtube.com/channel/UC3boJA-8Mt1nYtTfuBRigrg" target="_blank">YouTube</a></h5>

      </div>
      <div class="col-lg-6 col-sm-12 pl-4">
      </div>
    </div>
  </div>
</body>

</html>


<?php
} else {
  header('Location: index.php');
}

?>
