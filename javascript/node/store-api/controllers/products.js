const Product = require('../models/product');

const getAllProductsStatic = async (req, res) => {
  const products = await Product.find({
    name: 'vase table'
  });
  res.status(200).json({
    products,
    numberOfHits: products.length
  });
}

const getAllProducts = async (req, res) => {
  const { featured, name, company } = req.query;
  const queryObject = { };

  if(featured)
    queryObject.featured = featured === 'true' ? true : false;

  if(company)
    queryObject.company = company;

  if(name)
    queryObject.name = { $regex: name, $options: 'i' };

  const products = await Product.find(queryObject);
  res.status(200).json({
    products,
    numberOfHits: products.length
  });
}

module.exports = {
  getAllProductsStatic,
  getAllProducts,
}
