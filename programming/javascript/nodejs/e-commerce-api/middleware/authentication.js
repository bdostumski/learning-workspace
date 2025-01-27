const CustomError = require('../errors');
const { isTokenValid } = require('../utils');

const authenticateUser = async (req, res, next) => {
  const token = req.signedCookies.token;
  if (!token)
    throw new CustomError.UnauthenticatedError('No token provided');

  try {
    const { name, userId, role } = isTokenValid({ token });
    req.user = { name, userId, role };
    next();
  } catch (error) {
    throw new CustomError.UnauthenticatedError('Invalid token');
  }
}

const authorizePermissions = (req, res, next) => {

  next();
}

module.exports = {
  authenticateUser,
  authorizePermissions
}
