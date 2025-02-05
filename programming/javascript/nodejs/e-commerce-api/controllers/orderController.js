
const createOrder = async (req, res) => {
  res.send('Create order');
}

const getAllOrders = async (req, res) => {
  res.send('All orders');
}

const getSingleOrder = async (req, res) => {
  res.send('Get Single Order');
}

const getCurrentUserOrders = async (req, res) => {
  res.send('Get Current User Orders');
}

const updateOrder = async (req, res) => {
  res.send('Update Order');
}

module.exports = {
  createOrder,
  getAllOrders,
  getSingleOrder,
  getCurrentUserOrders,
  updateOrder
}
