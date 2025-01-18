// app config
require('dotenv').config();
require('express-async-errors');

// express
const express = require('express');
const app = express();
const port = process.env.APP_PORT || 3000;

// other packages
const morgan = require('morgan');

// database
const connectDB = require('./database/connect');

// routers
const authRouter = require('./routes/authRoute');

// middleware
const notFoundMiddleware = require('./middleware/not-found');
const errorHandlerMiddleware = require('./middleware/error-handler');

app.use(morgan('tiny'));
app.use(express.json());

// route
app.get('/', (req, res) => {
  res.send('e-commerce api');
});

app.use('/api/v1/auth', authRouter);

// error handling
app.use(notFoundMiddleware);
app.use(errorHandlerMiddleware);

// start server
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
