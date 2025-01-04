const User = require('../models/User');

const register = async (res, req) => {
  res.send('register');
}

const login = async (res, req) => {
  res.sent('login');
}

module.exports = {
  register,
  login
}
