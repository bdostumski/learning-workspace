const path = require('path');
const Product = require('../models/Product');

const { StatusCodes } = require('http-status-codes');

const uploadProductImage = async (req, res) => {
  if (!req.files)
    throw new CustomError(StatusCodes.BAD_REQUEST, 'Please upload a file');

  const productImage = req.files.image;

  if (!productImage.image.mime.startsWith('image'))
    throw new CustomError(StatusCodes.BAD_REQUEST, 'Please upload an image file');

  const maxSize = 1024 * 1024;
  if(productImage.image.size > maxSize)
    throw new CustomError(StatusCodes.BAD_REQUEST, `Please upload an image less than ${maxSize}kb`);

  const imagePath = path.join(__dirname, '../public/uploads/' + `${productImageImage.name}`);
  await productImageImage.mv(imagePath);
  res.status(StatusCodes.OK).json({ image: { src: `/uploads/${productImageImage.name}`}});
}

module.exports = { uploadProductImage }
