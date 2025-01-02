require('dotenv').config();

// async errors

const express = require('express');
const app = express();

// errors
const notFoundMiddleware = require('./middleware/not-found');
const errorMiddleware = require('./middleware/error-handler');

// middleware
app.use(express.json());

// routes
app.get('/', (req, res) => {
  res.send('<h1>Sotere API</h1><a href= "/api/v1/products">products route</a>');
})

// products route
app.use(notFoundMiddleware)
app.use(errorMiddleware)

const port = process.env.APP_PORT || 3000;

const start = async () => {
  try {
    // connect to db
    app.listen(port, () => {
      console.log('server is listening on port ${port}');
    });
  } catch (error) {
    console.error(error);
  }
};

start();
