const mongoose = require('mongoose');

const ProductSchema = new mongoose.Schema({
  name: {
    type: String,
    trim: true,
    required: [true, 'Please provide a name'],
    maxlength: [100, 'Name cannot be more than 100 characters'],
  },
  price: {
    type: Number,
    required: [true, 'Please provide a price'],
    default: 0,
  },
  description: {
    type: String,
    required: [true, 'Please provide a description'],
    maxlength: [1000, 'Description cannot be more than 1000 characters'],
  },
  image: {
    type:String,
    requried: [true, 'Please provide an image'],
    default: '\uploads\no-photo.jpeg',
  },
  category: {
    type: String,
    required: [true, 'Please provide a category'],
    enum: ['office', 'kitchen', 'bedroom'],
  },
  company: {
    type: String,
    required: [true, 'Please provide a company'],
    enum: {
        values: ['ikea', 'liddy', 'marcos'],
        message: '{VALUE} is not supported',
    }
  },
  colors: {
    type: [String],
    required: true,
  },
  featured: {
    type: Boolean,
    default: false,
  },
  freeShipping: {
    type: Boolean,
    default: false,
  },
  inventory: {
    type: Number,
    required: [true, 'Please provide an inventory'],
    default: 15,
  },
  averageRating: {
    type: Number,
    default: 0,
  },
  user: {
    type: mongoose.Schema.ObjectId,
    ref: 'User',
    required: true,
  },
}, { timestamps: true });

module.exports = mongoose.model('Product', ProductSchema);
