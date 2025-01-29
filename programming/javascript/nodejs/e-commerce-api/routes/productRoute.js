const express = require('express');
const router = express.Router();
const {
  authenticateUser,
  authorizePermissions
} = require('../middleware/authentication');

const {
  createProduct,
  getAllProducts,
  getSingleProduct,
  updateProduct,
  deleteProduct,
  uploadImage
} = require('../controllers/productController');

router.route('/').get(getAllProducts);

router
  .route('/createProduct')
  .post([authenticateUser, authorizePermissions('admin')], createProduct);

router.route('/uploadImage').post([authenticateUser, authorizePermissions('admin')] uploadImage);

router
  .route('/:id')
  .get(getSingleProduct)
  .patch([authenticateUser, authorizePermissions('admin')], updateProduct)
  .patch([authenticateUser, authorizePermissions('admin')], deleteProduct);


module.exports = router;
