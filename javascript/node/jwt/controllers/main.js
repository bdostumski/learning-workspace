const login = async (req, res) => {
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
