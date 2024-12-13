<?php

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;


if(isset($_POST['submit'])) {
  $name = $_POST['name'];
  $subject = $_POST['subject'];
  $email = $_POST['email'];
  $message = $_POST['message'];

require 'src/Exception.php';
require 'src/PHPMailer.php';
require 'src/SMTP.php';

$mail = new PHPMailer(true);
try {

    $mail->SMTPDebug = 0;                                      
    $mail->isSMTP();                                            
    $mail->Host       = 'mail.syscomz.com';  
    $mail->SMTPAuth   = false;                                   
    $mail->Username   = 'bdostumski@syscomz.com';                     
    $mail->Password   = 'password';                              
    $mail->SMTPSecure = 'tls';                                  
    $mail->Port       = 587;                                   

    $mail->setFrom($email, $name);         
    $mail->addAddress('bdostumski@syscomz.com');     
    $body = $message;

    $mail->isHTML(true);                                 
    $mail->Subject = $subject;

    $mail->Body    = $body;
    $mail->AltBody = strip_tags($body);
    $mail->send();

    header("location: email_send.php");
    ?>
<?php
} catch (Exception $e) {
    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
}
} else {
  echo "Message Not Sent";
}
?>
