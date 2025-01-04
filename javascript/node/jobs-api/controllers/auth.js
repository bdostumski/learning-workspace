const User = require('../models/User');
const { StatusCodes } = require('http-status-codes');

const register = async (req, res) => {
  const user = await User.create({ ...req.body });
  console.log(user);
  const token = user.createJWT();
  console.log(token);
  res.status(StatusCodes.CREATED).json({ user: { name: user.name }, token });
}

const login = async (req, res) => {
  Res.status(StatusCodes.OK).json(req.headers);
}

module.exports = {
  register,
  login
}
