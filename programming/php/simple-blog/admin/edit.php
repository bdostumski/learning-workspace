<?php

session_start();
include_once 'includes/connection.php';
include_once 'includes/myarticle.php';
include_once 'upload.php';

if(isset($_SESSION['logged'])) {
  if (isset($_POST['title'], $_POST['content'], $_POST['page_id'])) {
    $title = $_POST['title'];
    $content = nl2br($_POST['content']);
    $id = $_POST['page_id'];

    if(empty($title) or empty($content)) {
      $error = "All fields are required!";
    } else {

      $query = $pdo -> prepare("UPDATE articles SET article_title=?, article_content=? WHERE article_id=?");

      $query -> bindValue(1, $title);
      $query -> bindValue(2, $content);
      $query -> bindValue(3, $id);

      $query -> execute();
      header('Location: index.php');
      exit();
    }
  }

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
    <div class="row">
      <div class="col-lg-6 col-sm-12">
        <h1 class="lead mt-5 mb-3"><i class="far fa-edit"></i> Edit Article <?php echo $_GET['eid']; ?></h1>

        <?php if(isset($error)) { ?>
        <small style="color:#aa0000"><?php echo $error; ?></small>
        <br><br>
        <?php } ?>


        <form class="form-group" action="edit.php" method="post" autocomplete="off">
          <input class="form-control text-white" id="input-mycolor" type="text" name="page_id" style="display:none;"
            value="<?php echo $_GET['eid'];?>">
          <input class="form-control text-white" id="input-mycolor" type="text" name="title" placeholder="Title"
            value="<?php echo $_GET['title'];?>">
          <br><br>
          <textarea class="form-control text-white" id="input-mycolor" rows="10" placeholder="Content"
            name="content"><?php echo $_GET['content']; ?></textarea>
          <br><br>
          <input class="btn btn-success" type="submit" name="submit" value="Edit Article">
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

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
  </script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
  </script>
</body>

</html>

<?php
} else {
  header('Location: index.php');
  exit();
}

?>
