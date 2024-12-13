<?php

session_start();

include_once 'includes/connection.php';
include_once 'includes/myarticle.php';

$article = new Article;
$articles = $article->fetch_all();


if(isset($_SESSION['logged'])) {
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
  <title>[SYSCOMz] by Borislav Dostumski</title>

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
          <a class="nav-link ml-3" href="../index.php"><i class="fas fa-home"></i> Home</a>
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
    <h1 class="lead mt-5"><i class="fas fa-users-cog"></i> Article Manager</h1>
    <?php foreach($articles as $article) { ?>
    <div class='text-white bg-dark mt-3 rounded-lg' id="article-main-mycolor">
      <div class='row'>
        <div class='col-12'>
          <h3 class='card-header' id="article-header-mycolor">
            <span class='badge badge-info mr-2 p-2'>
              <?php echo $article['article_id']; ?>.
            </span>
            <?php echo $article['article_title']; ?>
          </h3>
        </div>
      </div>
      <div class='row'>
        <div class='col-lg-9 col-sm-12'>
          <div class='card-body'>
            <p class='card-text'>
              <?php echo substr($article['article_content'],0,500); ?>
            </p>
          </div>
        </div>
        <div class="col-lg-3 col-sm-12 pr-5 pl-5 text-center mt-3">
          <div class="row">
            <div class="col-12 p-2"><a class="btn btn-outline-warning d-flex align-items-stretch justify-content-center"
                href="edit.php?eid=<?php echo $article['article_id']; ?>&title=<?php echo $article['article_title']; ?>&content=<?php echo $article['article_content']; ?>"><i
                  class="far fa-edit mr-1"></i>Edit</a></div>
            <div class="col-12 p-2"><a class="btn btn-outline-danger d-flex align-items-stretch justify-content-center"
                href="delete.php?did=<?php echo $article['article_id'];?>"><i
                  class="far fa-trash-alt mr-1"></i>Delete</a></div>
            <div class="col-12 p-2 mb-3"><a
                class="btn btn-outline-success d-flex align-items-stretch justify-content-center"
                href="radmin.php?id=<?php echo $article['article_id']; ?>"><i class="fas fa-book-reader mr-1"></i>Read
                Article</a></div>
          </div>
        </div>
      </div>
    </div>
    <?php } ?>
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
        <h5 class="text-warning mb-3"><i class="fas fa-at"></i> Contact Form</h5>
        <form method="post" action="includes/phpemail.php">
          <div class='row'>
            <div class="col-lg-4 col-sm-12">
              <input name="name" type="text" class="form-control mb-2 bg-dark text-white" placeholder="Name"
                id="input-mycolor">
            </div>
            <div class="col-lg-4 col-sm-12">
              <input name="subject" type="text" class="form-control mb-2 bg-dark text-white" placeholder="Subject"
                id="input-mycolor">
            </div>
            <div class="col-lg-4 col-sm-12">
              <input name="email" type="email" class="form-control mb-2 bg-dark text-white" placeholder="Email"
                id="input-mycolor">
            </div>
            <div class="col-lg-12 col-sm-12">
              <textarea name="message" class="form-control mb-3 bg-dark text-white" placeholder="Message" rows="5"
                id="input-mycolor"></textarea>
              <button name="submit" type="submit" class="btn btn-outline-warning">Send</button>
            </div>
          </div>
        </form>
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

    if(isset($_POST['username'], $_POST['password'])) {
      $username = $_POST['username'];
      $password = md5($_POST['password']);

      if(empty($username) or empty($password)) {
        $error = 'All fields are required!';
      } else {
        $query = $pdo->prepare("SELECT * FROM users WHERE user_name=? AND user_password=?");
        $query -> bindValue(1, $username);
        $query -> bindValue(2, $password);
        $query -> execute();

        $num = $query->rowCount();

        if($num == 1) {
          $_SESSION['logged'] = true;
          header("Location: index.php");
          exit();
        } else {
            $error = 'Incorrect details!';
        }
      }
    }
    ?>

<?php if(isset($error)) { ?>
<small style="color:#aa0000"><?php echo $error; ?></small>
<br><br>
<?php } ?>

<!doctype html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="../style/main_style.css">

  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
    integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <title>[SYSCOMz] by Borislav Dostumski</title>
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="input-mycolor">
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
      </ul>
    </div>
    <form class="mr-3 form-inline" action="index.php" method="post" autocomplete="off">
      <input class="form-control mr-sm-2 text-light bg-dark" type="text" name="username" placeholder="Username"
        id="input-mycolor">
      <input class="form-control mr-sm-2 text-light bg-dark" type="password" name="password" placeholder="Password"
        id="input-mycolor">
      <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Login">
    </form>
  </nav>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
  </script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
  </script>
</body>

</html>

<?php
  }
?>
