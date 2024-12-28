package com.syscomz.springreactaws.bucket;

// Bucket also can be created trough Terraform, or other tools
// But it is not recommended tp create bucket trough Java code
public enum BucketName {

    PROFILE_IMAGE("syscomz-image-upload-123"); // name of the bucket in the AWS S3 service, that I created

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
