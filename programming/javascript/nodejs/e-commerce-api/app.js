// app config
require('dotenv').config();

// express
const express = require('express');
const app = express();
const port = process.env.APP_PORT || 3000;

// database
const connectDB = require('./database/connect');

const start = async () => {
  try {
    await connectDB(process.env.MONGO_URI);
    app.listen(port, () => {
      console.log(`Server is running on port ${port}`);
    });
  } catch (error) {
    console.log(error);
  }
};

start();
