package com.syscomz.springreactaws.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin("*") // enable CORS requests from (* anywhere) its bad idea to use it for production, in production we need to create more restrictions for the endpoints
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfiles();
    }

    @PostMapping(
            path = "{userProfileId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId, // @PathVariable extract value from the URI path
                                       @RequestParam("file") MultipartFile file) { // @RequestParams extract values from the query strings,
        // MultipartFile representation of an uploaded file received in a multipart request
        // (Multipart Request - is and HTTP request that HTTP clients construct to send files and data over to an HTTP Server. It is commonly used by browsers and HTTP clients to upload files to the server).
        userProfileService.uploadUserProfileImage(userProfileId, file);
    }

    @GetMapping("{userProfileId}/image/download")
    public byte[] downloadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId) {
        return userProfileService.downloadUserProfileImage(userProfileId);
    }

}