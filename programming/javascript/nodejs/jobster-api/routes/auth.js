const express = require('express')
const router = express.Router()
const authUser = require('../middleware/authentication')
const demoUser = require('../middleware/demo-user')
const { register, login, updateUser } = require('../controllers/auth')

router.post('/register', register)
router.post('/login', login)
router.patch('/updateUser', authUser, demoUser, updateUser)

module.exports = router
