const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');

const UserSchema = new mongoose.Schema({
  name: {
    type: String,
    required: [true, 'Please add a name'],
    minlength: 3,
    maxlength: 50
  },
  email: {
    type: String,
    required: [true, 'Please add an email'],
    match: [/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,'Please add a valid email'],
    unique: true
  },
  password: {
    type: String,
    required: [true, 'Please add a password'],
    minlength: 6
  }
});

UserSchema.pre('save', async function() {
  this.password = await bcrypt.hash(this.password, 10);
})

module.exports = mongoose.model('User', UserSchema);
