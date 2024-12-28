import React, { useState, useEffect, useCallback }  from 'react'; // {useState, useEffect} are hooks (hooks are a new addtion to React, they let you to use sate and other React features without writing a class) add useCallBack for react dropzone package
import {useDropzone} from 'react-dropzone' // after install the package with (npm --save react-dropzone) we should import react dropzone package 
import         { render   }  from 'react-dom';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

const UserProfiles = () => { // create my own Functional Component

  const [userProfiles, setUserProfiles] = useState([]); // initial state is empty array
  // The React useState() Hook, allows us to track state in a function component
  // State generally refers to data or properties that need to be tracking in an application.

  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/api/v1/user-profile").then(response => { // fetch data from our backend by creating HTTP GET request and then manipulate the response
      console.log(response);
      const data = response.data; // get the data from our response
      console.log(data) 
      
      setUserProfiles(response.data); // setting the state from backend - checks if something is changed in the response.data it will be assigned to setUserProfiles
    })
  }

  useEffect(() => { // useEffect Hook lets you perform side effects in funciton components for example: fetching data, directly updating DOM, and timers
    fetchUserProfiles()
  }, []); // if anything is changed in [] the useEffect() will be trigered again

  return userProfiles.map((userProfile, index) => {
    return ( 
      // key shoud be unique
      <div key={index}>
        {/* load image from the AWS bucket as logo image of the person */}
        { userProfile.userProfileId ? <img src={`http://localhost:8080/api/v1/user-profile/${userProfile.userProfileId}/image/download`}/> : null }
        <br/>
        <br/>
        {/* userProfile.username, userProfile.userProfileId filds can be seen in the browser inspector tool on the console the object data contains this information */}
        <h1>{ userProfile.username }</h1>
        <p>{ userProfile.userProfileId }</p>
        {/* short write */}
        <Dropzone {...userProfile}/> 
        {/* long write */}
        {/* <Dropzone userProfileId={userProfile.userProfileId} />  */}
        <br/>
      </div>
    )
  }) 
}

function Dropzone({userProfileId}) { // functionall component 
  const onDrop = useCallback(acceptedFiles => {
    // Do something with the files
    const file = acceptedFiles[0]; 
    console.log(file);
    
    const formData = new FormData(); // send Multipart File to backend
    formData.append("file", file);

    // Send uploaded file from FE to BE, with multipart/form-data and POST request to the endpoint of the BE
    axios.post(
        `http://localhost:8080/api/v1/user-profile/${userProfileId}/image/upload`,
        formData, 
          { "Content-Type": "multipart/form-data" }
      ).then(() => 
        { console.log("file uploaded succesfully") }
      ).catch(error => 
        { console.log("error") }
      )
  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
       <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the files here ...</p> :
          <p>Drag 'n' drop profile image, or click to select profile image</p>
      }
    </div>
  )
}

function App() {
  return (
    <div className="App">
      {/* use UserProfiles component */}
     <UserProfiles /> 
     {/* this UserProfiles is actually the const [userProfiles] that is set by const [setUserProfiles] = useState([]) */}
    </div>
  );
}

export default App;
