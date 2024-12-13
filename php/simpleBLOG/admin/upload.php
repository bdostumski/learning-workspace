<?php
include_once "includes/connection.php";

function uploadFiles() {

$target_dir = "../images/";
$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
$uploadOk = 0;
$imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));


if(isset($_POST["submit"])) {
    $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);

    if($check !== false) {
        $uploadOk = 1;
    } else {
        return "File is not an image.";
    }

    if ($_FILES["fileToUpload"]["size"] > 5000000) {
        return "Sorry, your file is too large.";
    }

    if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" && $imageFileType != "gif" ) {
        return "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
    }

    if ($uploadOk == 0) {
        return "Sorry, your file was not uploaded.";
    } else {
        if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
            echo "The file ". basename( $_FILES["fileToUpload"]["name"]). " has been uploaded.";
            return $target_file;
        } else {
            return "Sorry, there was an error uploading your file.";
        }
    }
}
}
?>
