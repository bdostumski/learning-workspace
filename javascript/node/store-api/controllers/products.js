const Product = require('../models/product');

const getAllProductsStatic = async (req, res) => {
  const products = await Product.find({})
    .sort('-name price')
    .select('name price');

  res.status(200).json({
    products,
    numberOfHits: products.length
  });
}

const getAllProducts = async (req, res) => {
  // Query parameters
  const { featured, name, company, sort, fields, numericFilters } = req.query;
  const queryObject = {};

  // Querying the database
  if (featured)
    queryObject.featured = featured === 'true' ? true : false;

  if (company)
    queryObject.company = company;

  if (name)
    queryObject.name = { $regex: name, $options: 'i' };

  if (numericFilters) {
    const operatorMap = {
      '>': '$gt',
      '>=': '$gte',
      '=': '$eq',
      '<': '$lt',
      '<=': '$lte',
    }
    const regEx = /\b(<|>|>=|=|<|<=)\b/g;
    let filters = numericFilters.replace(regEx,
      (match) => `-${operatorMap[match]}-`);
    const options = ['price', 'rating'];
    filters = filters.split(',').forEach(item => {
      const [field, operator, value] = item.split('-');
      if (options.includes(field)) {
        queryObject[field] = { [operator]: Number(value) };
      }
    });
  }

  let result = Product.find(queryObject);

  // Sorting the results
  if (sort) {
    const sortList = sort.split(',').join(' ');
    result = result.sort(sortList);
  } else {
    result = result.sort('-createdAt price -rating');
  }

  // Which fields to show in the results
  if (fields) {
    const fieldsList = fields.split(',').join(' ');
    result = result.select(fieldsList);
  }

  // Pagination
  const page = Number(req.query.page) || 1;
  const limit = Number(req.query.limit) || 10;
  const skip = (page - 1) * limit;
  result = result.skip(skip).limit(limit); // skip thefirst n results and show the next n results

  const products = await result;
  res.status(200).json({
    products,
    numberOfHits: products.length
  });
}

module.exports = {
  getAllProductsStatic,
  getAllProducts,
}
