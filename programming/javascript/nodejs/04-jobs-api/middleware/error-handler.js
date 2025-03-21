const { CustomAPIError } = require('../errors')
const { StatusCodes } = require('http-status-codes')
const errorHandlerMiddleware = (err, req, res, next) => {

  let customError = {
    statusCode: err.statusCode || StatusCodes.INTERNAL_SERVER_ERROR,
    msg: err.message || 'Something went wrong, please try again later'
  }

  if (err.name === 'CastError') {
    customError = {
      statusCode: StatusCodes.BAD_REQUEST,
      msg: `Invalid ${err.path} : ${err.value}`
    }
  }

  if (err.name === 'ValidationError') {
    customError = {
      statusCode: StatusCodes.BAD_REQUEST,
      msg: Object.values(err.errors).map(item => item.message).join(', ')
    }
  }

  if (err.code && err.code === 11000) {
    customError = {
      statusCode: StatusCodes.BAD_REQUEST,
      msg: `Duplicate value entered for ${Object.keys(err.keyValue)} field, please choose another value`
    }
  }

  return res.status(customError.statusCode).json({ msg: customError.msg })
}

module.exports = errorHandlerMiddleware
