const jwt = require('jsonwebtoken');
const { BadRequestError } = require('../errors');
const { StatusCodes } = require('http-status-codes');

const login = async (req, res) => {
  const { username, password } = req.body;

  if (!username || !password)
    throw new BadRequestError('Please provide username and password');

  const id = new Date().getDate();
  const token = jwt.sign({ id, username }, process.env.JWT_SECRET, { expiresIn: '30d' })

  res.status(StatusCodes.OK).json({
    msg: 'user created',
    token: token
  });
}

const dashboard = async (req, res) => {
  const user = req.user;

  const luckyNumber = Math.floor(Math.random() * 100);
  res.status(StatusCodes.OK).json({
    msg: `Hello ${user.username}`,
    secret: `Here is your authorized data, your lucky number is ${luckyNumber}`
  });
}

module.exports = {
  login,
  dashboard
}
