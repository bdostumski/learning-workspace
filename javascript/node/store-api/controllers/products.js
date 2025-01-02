
const getAllProductsStatic = async (req, res) => {
  try {
    res.status(200).json({msg: 'static products testing route'});
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
}

const getAllProducts = async (req, res) => {
  try {
    res.status(200).json({msg: 'products testing route'});
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
}

module.exports = {
  getAllProducts,
  getAllProductsStatic
}
