require('./database/connect')
const express = require('express')
const tasks = require('./routes/tasks')

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

app.listen(port, console.log(`server is listening on port ${port}...`))
