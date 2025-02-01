const Review = require('../models/Review');
const CustomError = require('../errors');
const StatusCodes = require('http-status-codes');

const createReview = async (req, res) => {
  req.send('createReview');
}

const getAllReviews = async (req, res) => {
  req.send('getAllReviews');
}

const getSingleReview = async (req, res) => {
  req.send('getSingleReview');
}

const updateReview = async (req, res) => {
  req.send('updateReview');
}

const deleteReview = async (req, res) => {
  req.send('deleteReview');
}

module.exports = {
  createReview,
  getAllReviews,
  getSingleReview,
  updateReview,
  deleteReview
}
