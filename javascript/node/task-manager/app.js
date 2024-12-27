const express = require('express')
const tasks = require('./routes/tasks')
const connectDB = require('./database/connect')
const notFound = require('./middleware/not-found')

// get .env variables
require('dotenv').config()

// server config
const port = 3000
const app = express()
const router = new express.Router()

// middleware
app.use(express.json())
app.use('/api/v1/tasks', tasks)
app.use(express.static('./public'))

// custom error response
app.use(notFound)

// routes
router.get('/').post('/')
router.get('/:id').patch('/:id').delete('/:id')

const startApp = async () => {
  try {
    await connectDB(process.env.MONGO_URI.replace('\''))
    app.listen(port, console.log(`Server is listening on port ${port}...`))
  } catch (error) {
    console.log(error)
  }
}

startApp()
