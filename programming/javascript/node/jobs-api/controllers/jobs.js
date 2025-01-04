const User = require('../models/User');
const { StatusCodes } = require('http-status-codes');
const { BadRequestError, UnauthenticatedError } = require('../errors');

const getAllJobs = async (req, res) => {
  res.status(StatusCodes.OK).json(req.user);
}

const getJob = async (req, res) => {
  res.status(StatusCodes.OK).json(req.user);
}

const createJob = async (req, res) => {
  res.status(StatusCodes.OK).json(req.user);
}

const updateJob = async (req, res) => {
  res.status(StatusCodes.OK).json(req.user);
}

const deleteJob = async (req, res) => {
  res.status(StatusCodes.OK).json(req.user);
}

module.exports = {
  getAllJobs,
  getJob,
  createJob,
  updateJob,
  deleteJob
}
