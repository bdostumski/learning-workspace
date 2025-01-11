const express = require('express')
const demoUser = require('../middleware/demo-user')

const router = express.Router()
const {
  createJob,
  deleteJob,
  getAllJobs,
  updateJob,
  getJob,
} = require('../controllers/jobs')

router.route('/').post(demoUser, createJob).get(getAllJobs)
router.route('/:id').get(getJob).delete(demoUser, deleteJob).patch(demoUser, updateJob)

module.exports = router
