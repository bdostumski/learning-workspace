
const getAllJobs = async (res, req) => {
  res.send('get all jobs');
}

const getJob = async (res, req) => {
  res.send('get job');
}

const createJob = async (res, req) => {
  res.send('create job');
}

const updateJob = async (res, req) => {
  res.send('update job');
}

const deleteJob = async (res, req) => {
  res.send('delete job');
}

module.exports = {
  getAllJobs,
  getJob,
  createJob,
  updateJob,
  deleteJob
}
