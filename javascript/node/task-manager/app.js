const express = require('express')
const tasks = require('./routes/tasks')
const connectDB = require('./database/connect')

// get .env variables
require('dotenv').config()

// server config
const port = 3000
const app = express()

// middleware
app.use(express.json())
app.use('/api/v1/tasks', tasks)

// routes
app.get('/')
app.post('/')
app.get('/:id')
app.patch('/:id')
app.delete('/:id')

const startApp = async () => {
  try {
    await connectDB(process.env.MONGO_URI.replace('\''))
    app.listen(port, console.log(`Server is listening on port ${port}...`))
  } catch (error) {
    console.log(error)
  }
}

startApp()
