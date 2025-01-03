const jwt = require('jsonwebtoken');
const CustomApiError = require('../errors/custom-error');

const login = async (req, res) => {
  const { username, password } = req.body;
  console.log(req.body)

  if (!username || !password)
    throw new CustomApiError('Please provide username and password', 400);

  const id = new Date().getDate();
  const token = jwt.sign({ id, username }, process.env.JWT_SECRET, { expiresIn: '30d' })

  res.status(200).json({
    msg: 'user created',
    token: token
  });
}

const dashboard = async (req, res) => {
  const authHeader = req.headers.authorization;

  if (!authHeader || !authHeader.startsWith('Bearer '))
    throw new CustomApiError('Please provide token', 401);

  try {
    const token = authHeader.split(' ')[1];
    const decoded = jwt.verify(token, process.env.JWT_SECRET);

    const luckyNumber = Math.floor(Math.random() * 100);
    res.status(200).json({
      msg: `Hello ${decoded.username}`,
      secret: `Here is your authorized data, your lucky number is ${luckyNumber}`
    });
  } catch (error) {
    throw new CustomApiError('Not authorized', 401);
  }
}

module.exports = {
  login,
  dashboard
}
