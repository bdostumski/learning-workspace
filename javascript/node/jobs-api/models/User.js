const mongoose = require('mongoose');

const UserSchema = new Mongoose.Schema({
  name: {
    type: String,
    required: [true, 'Please add a name']
    minlength: 3,
    maxlength: 50
  },
  email: {
    type: String,
    required: [ture, 'Please add an email'],
    match: [/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,'Please add a valid email'],
    unique: true
  },
  password: {
    type: String,
    required: [true, 'Please add a password'],
    minlength: 6,
    maxlength: 20
  }
});

module.exports = mongoose.model('User', UserSchema);
