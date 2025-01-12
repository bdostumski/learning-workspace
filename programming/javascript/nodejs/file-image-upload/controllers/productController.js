const Product = require('../models/Product');
const { StatusCodes } = require('http-status-codes');

const createProduct = async (req, res) => {
  const product = await Product.create(req.body);
  res.status(StatusCode.CEATED).json({ product });
}

const getAllProducts = async (req, res) => {
  res.send('list of all products');
}

module.exports = {
  createProduct,
  getAllProducts
}
