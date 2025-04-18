// imports and configurations
require('dotenv').config();
require('express-async-errors');
const express = require('express');
const app = express();
const connectDB = require('./database/connect');
const productsRouter = require('./routes/products');
const notFoundMiddleware = require('./middleware/not-found');
const errorMiddleware = require('./middleware/error-handler');

// middleware
app.use(express.json());

// routes
app.get('/', (req, res) => {
  res.send('<h1>Sotere API</h1><a href= "/api/v1/products">products route</a>');
});
app.use('/api/v1/products', productsRouter);

// errors handling
app.use(notFoundMiddleware);
app.use(errorMiddleware);

// server
const port = process.env.APP_PORT || 3000;

const startApp = async () => {
  try {
    await connectDB(process.env.MONGO_URI);
    app.listen(port, console.log(`server is listening on port ${port}...`));
  } catch (error) {
    console.error(error);
  }
};

startApp();
