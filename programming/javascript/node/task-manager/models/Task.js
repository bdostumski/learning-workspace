const mongoose = require('mongoose');

// create schema structure for the collection
const TaskSchema = new mongoose.Schema({

  // fields with validations with mongoose validations
  name: {
    type: String,
    required: [true, 'Must provide name'],
    trim: true,
    maxlength: [20, 'Name can not be more then 20 characters']
  },

  completed: {
    type: Boolean,
    default: false
  }

})

// create collection for the schema
module.exports = mongoose.model('Task', TaskSchema)
