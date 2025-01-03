const jwt = require('jsonwebtoken');
const CustomApiError = require('../errors/custom-error');

const authenticationMiddleware = async (req, res, next) => {
  const authHeader = req.headers.authorization;

  if (!authHeader || !authHeader.startsWith('Bearer '))
    throw new CustomApiError('Please provide token', 401);

  try {
    const token = authHeader.split(' ')[1];
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    const { id, username } = decoded;
    req.user = { id, username };
  } catch (error) {
    throw new CustomApiError('Not authorized', 401);
  }

  next();
}

module.exports = authenticationMiddleware;
