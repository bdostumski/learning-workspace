const express = require('express');
const router = express.Router();
const { authenticateUser } = require('../middleware/authentication');

const {
  getProducts,
  getProductById,
  createProduct,
  updateProduct,
  deleteProduct
} = require('../controllers/productController');

router
  .route('/')
  .post(authenticateUser, createReview)
  .get(getReviews);

router
    .route('/:id')
    .get(getReviewById)
    .put(authenticateUser, updateReview)
    .delete(authenticateUser, deleteReview);

module.exports = router;
