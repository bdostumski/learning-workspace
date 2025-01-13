const path = require('path');
const Product = require('../models/Product');

const { StatusCodes } = require('http-status-codes');

const uploadProductImage = async (req, res) => {
  if (!req.files)
    throw new CustomError(StatusCodes.BAD_REQUEST, 'Please upload a file');

  const productImage = req.files.image;
  const imagePath = path.join(__dirname, '../public/uploads/' + `${productImage.name}`);
  await productImage.mv(imagePath);
  res.status(StatusCodes.OK).json({ image: { src: `/uploads/${productImage.name}`}});
}

module.exports = { uploadProductImage }
