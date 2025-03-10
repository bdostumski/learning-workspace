<?php
  include_once 'admin/includes/connection.php';
  include_once 'admin/includes/myarticle.php';

  $article = new Article;
  $articles = $article->fetch_all();
?>

<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="style/main_style.css">

  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
    integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <title>[SYSCOMz] by Borislav Dostumski</title>
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="navbar-mycolor">
    <a class="navbar-brand" href="index.php"><i class="fas fa-user-astronaut mr-2"></i>SYSCOMz</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link ml-3" href="index.php"><i class="fas fa-home"></i> Home <span
              class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link ml-3" href="/admin/index.php"><i class="fas fa-users-cog"></i> Admin</a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="container">
    <h1 class="lead mt-5"><i class="fas fa-mail-bulk"></i> SYSCOMz Blog Page</h1>
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
        <div class='col-12'>
          <div class='card-body'>
            <p class='card-text'>
              <?php echo substr($article['article_content'],0, 300);?>
            </p>
          </div>
        </div>
      </div>
      <div class='row'>
        <div class='col-lg-4'><a href="article.php?id=<?php echo $article['article_id']; ?>"
            class="btn btn-outline-light p-2 mr-3 ml-3 mt-3">Read Article...</a></div>
        <div class='col-lg-4'></div>
        <div class='col-lg-4 col-sm-12'>
          <div class='alert text-center p-2 mr-3 ml-3 mt-3'><small>
              Published:
              <?php
            $dateRow = $article['article_timestamp'];
            echo date('d / M / Y', strtotime($dateRow));
            ?></small></div>
        </div>
      </div>
    </div>
    <?php } ?>
  </div>

  <div class="container-fluid">
    <div class="row text-muted bg-dark footer p-3 mt-5" id="footer-mycolor">
      <div class="col-lg-3 col-sm-12  pl-4 mb-4">
        <h5 class="text-info mb-3"><i class="fas fa-calendar-alt"></i> Calendar</h5>
        <?php include 'admin/includes/calendar.php' ?>
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
