const mongoose = require('mongoose')

const connectionString = 'mongodb://localhost:27017/task-manager'

mongoose.connect(connectionString,
                {
                        useNewUrlParser: true,
                        useUnifiedTopology: true
                })
        .then(() => console.log('Connected to database'))
        .catch((err) => console.log(err))
