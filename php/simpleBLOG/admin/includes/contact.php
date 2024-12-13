  <form method="post" action="admin/includes/phpemail.php">
    <div class='row'>
      <div class="col-lg-4 col-sm-12">
        <input name="name" type="text" class="form-control mb-2 bg-dark text-white" placeholder="Name">
      </div>
      <div class="col-lg-4 col-sm-12">
        <input name="subject" type="text" class="form-control mb-2 bg-dark text-white" placeholder="Subject">
      </div>
      <div class="col-lg-4 col-sm-12">
        <input name="email" type="email" class="form-control mb-2 bg-dark text-white" placeholder="Email">
      </div>
      <div class="col-lg-12 col-sm-12">
        <textarea name="message" class="form-control mb-3 bg-dark text-white" placeholder="Message"
          rows="5"></textarea>
        <button name="submit" type="submit" class="btn btn-outline-warning">Send</button>
      </div>
  </form>