const { BadRequestError } = require('../errors')

const demoUser = (req, res, next) => {
  if(req.user.demoUser)
    throw new BadRequestError('Demo User. Read Only Mode')
  next()
}

module.exports = demoUser
