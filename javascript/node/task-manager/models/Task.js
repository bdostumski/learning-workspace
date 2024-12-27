const mongoose = require('mongoose');

// create schema structure for the collection
const TaskSchema = new mongoose.Schema({
  name:String,
  completed:Boolean
})

// create collection for the schema
module.exports = mongoose.model('Task', TaskSchema)
