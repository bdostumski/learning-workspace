const CustomError = require('../errors');

const checkPermissions = (requestUser, resourceId) => {
  if (requestUser.role === 'admin')
    return;

  if (requestUser.userId === resourceId.toString())
    return;
  throw new CustomError.UnauthorizedError('You do not have permission to access this resource');
}

module.exports = checkPermissions;
