const mongoose = require('mongoose');

const JobSchema = new mongoose.Schema({
  company: {
    type: String,
    required: [true, 'Please add a company name'],
    maxlenght: [50, 'Company name can not be more than 50 characters']
  },
  position: {
    type: String,
    required: [true, 'Please add a position'],
    maxlenght: [100, 'Position can not be more than 100 characters']
  },
  status: {
    type: String,
    enum: ['interview', 'declined', 'pending'],
    default: 'pending'
  },
  createdBy: {
    type: mongoose.Types.ObjectId,
    ref: 'User',
    required: [true, 'Please add a user']
  }}, { timestamps: true });

module.exports = mongoose.model('Job', JobSchema);
