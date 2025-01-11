const User = require('../models/User')
const jwt = require('jsonwebtoken')
const { UnauthenticatedError } = require('../errors')

const auth = async (req, res, next) => {
  // check header
  const authHeader = req.headers.authorization
  if (!authHeader || !authHeader.startsWith('Bearer')) {
    throw new UnauthenticatedError('Authentication invalid')
  }
  const token = authHeader.split(' ')[1]

  try {
    const payload = jwt.verify(token, process.env.JWT_SECRET)
    const demoUser = payload.userId === '6782247541839689c2b3bdc8'

    req.user = { userId: payload.userId, demoUser }
    next()
  } catch (error) {
    throw new UnauthenticatedError('Authentication invalid')
  }
}

module.exports = auth
