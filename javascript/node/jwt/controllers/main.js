const CustomApiError = require('../errors/custom-error');

const login = async (req, res) => {
  const { username, password } = req.body;

  if (!username || !password)
    throw new CustomApiError('Please provide username and password', 400);

  res.status(200).json({
    msg: 'Fake Login/Register/Signup Route'
  });
}

const dashboard = async (req, res) => {
  const luckyNumber = Math.floor(Math.random() * 100);
  res.status(200).json({
    msg: `Hello John Doe`,
    luckyNumber: `Your lucky number is ${luckyNumber}`
  })
}

module.exports = {
  login,
  dashboard
}
