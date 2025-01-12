const Product = require('../models/Product');
const { StatusCodes } = require('http-status-codes');
const CustomError = require('../errors'):

const createProduct = async (req, res) => {
  if (!req.files)
    throw new CustomError(StatusCodes.BAD_REQUEST, 'Please upload a file');

  const product = await Product.create(req.body);

  if (!product.image.mime.startsWith('image'))
    throw new CustomError(StatusCodes.BAD_REQUEST, 'Please upload an image file');

  const maxSize = 1024 * 1024;
  if(product.image.size > maxSize)
    throw new CustomError(StatusCodes.BAD_REQUEST, `Please upload an image less than ${maxSize}kb`);

  return res.status(StatusCodes.CREATED).json({ product });

  const getAllProducts = async (req, res) => {
    const products = await Product.find({});
    res.status(StatusCodes.OK).json({ products });
  }

  module.exports = {
    createProduct,
    getAllProducts
  }
}
