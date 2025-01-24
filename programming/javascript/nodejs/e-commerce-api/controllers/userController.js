const User = require('../models/User');
const { StatusCodes } = require('http-status-codes');

const getAllUsers = async (req, res) => {

  res.send('get all users');
}


const getSingleUser = async (req, res) => {

  res.send('get single user');
}


const showCurrentUser = async (req, res) => {

  res.send('show current user');
}


const updateUser = async (req, res) => {

  res.send('update user user');
}


const updateUserPassowrd = async (req, res) => {

  res.send('update user passowrd');
}

module.exports = {
  getAllUsers,
  getSingleUser,
  showCurrentUser,
  updateUser,
  updateUserPassowrd
}
