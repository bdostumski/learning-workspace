const User = require('../models/User');
const { StatusCodes } = require('http-status-codes');
const CustomError = require('../errors');
const { checkPermissions, createTokenUser, attachCookiesToResponse } = require('../utils');

const getAllUsers = async (req, res) => {
  const users = await User.find({ role: 'user' }).select('-password');
  res.status(StatusCodes.OK).json({ users });
}

const getSingleUser = async (req, res) => {
  const user = await User.findOne({ _id: req.params.id }).select('-password');
  if (!user)
    throw new CustomError.NotFoundError(`No user found with id: ${req.params.id}`);

  checkPermissions(req.user, user._id);

  res.status(StatusCodes.OK).json({ user });
}

const showCurrentUser = async (req, res) => {
  res.status(StatusCodes.OK).json({ user: req.user });
}

// update user with User.findOneAndUpdate()
//const updateUser = async (req, res) => {
//const { name, email } = req.body;
//if (!name || !email)
//throw new CustomError.BadRequestError('Please provide username and email');
//
//const user = await User.findOneAndUpdate(
//{ _id: req.user.userId },
//{ name, email },
//{ new: true, runValidators: true }
//);
//
//const tokenUser = createTokenUser({ user: user });
//attachCookiesToResponse({ res, user: tokenUser });
//return res.status(StatusCodes.OK).json({ user: tokenUser });
//}

// update user with User.save()
const updateUser = async (req, res) => {
  const { name, email } = req.body;
  if (!name || !email)
    throw new CustomError.BadRequestError('Please provide username and email');

  const user = await User.findOne({ _id: req.user.userId });
  user.email = email;
  user.name = name;
  await user.save();

  const tokenUser = createTokenUser({ user: user });
  attachCookiesToResponse({ res, user: tokenUser });
  return res.status(StatusCodes.OK).json({ user: tokenUser });
}

const updateUserPassowrd = async (req, res) => {
  const { oldPassword, newPassword } = req.body;
  if (!oldPassword || !newPassword)
    throw new CustomError.BadRequestError('Please provide old password and new password');

  const user = await User.findOne({ _id: req.user.userId });

  const isPasswordCorrect = await user.comparePassword(oldPassword);
  if (!isPasswordCorrect)
    throw new CustomError.UnauthenticatedError('Old password is incorrect');

  user.password = newPassword;
  await user.save();

  res.status(StatusCodes.OK).json({ msg: 'Password updated successfully' });
}

module.exports = {
  getAllUsers,
  getSingleUser,
  showCurrentUser,
  updateUser,
  updateUserPassowrd
}
