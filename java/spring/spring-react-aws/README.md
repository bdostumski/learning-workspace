# Image Upload with AWS | Spring Boot | React
1. AWS Repository: https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk/1.12.326 
2. AWS Credentials (connect my server to Amazon) 
   1. Create AWS account (choose S3 service)
   2. To check the credentials (go to account, choose my security credentials, and generate access key)
   3. Copy Access key and Secret key from generated file
3. FE React application:
   1. Use https://github.com/facebook/create-react-app
   2. Go to src/main/ and use the instruction in the link above
   3. npx create-react-app my-app
   4. cd my-app
   5. npm start
4. Basic NPM commands:
   1. npm start (starts the development server)
   2. npm run build (bundles the app into static files for production)
   3. npm test (starts the test runner)
   4. npm run eject (remove this tool and copies build dependencies, configuration files and scripts into the app directly. If you do this, you can't go back!)
5. Use VS code for JS:
   1. npm -S i axios (Axios is lightweight HTTP client based on the $http service to communicate with REST APIs)
   2. In package.json are stored all the installed packages for our application
   3. import axios from 'axios';
   4. import React, { useState, useEffect } from 'react';
   5. CORS (it happens when we have an application for example from localhostFRONTEND, and it wants to communicate with another application for example localhostBACKEND, this communication is blocked by Cross-Origin Resource Sharing to prevent malicious attacks to prevent different hosts to accessing our backend)
6. React drop zone: https://github.com/react-dropzone/react-dropzone this  link allow us to drop files
   1. npm install --save react-dropzone
   2. for usage should check the README.md file in the repo
7. To start the application should start the backend and after that to go to the frontend directory and to write: npm start