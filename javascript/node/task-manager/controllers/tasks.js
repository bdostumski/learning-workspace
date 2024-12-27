// models
const Task = require('../models/Task')

// controllers
const getAllTasks = (req, res) => {
  res.json([
    {
      "id": "1",
      "name": "First task"
    },
    {
      "id": "2",
      "name": "Second Task"
    }
  ])
}

const createTask = async (req, res) => {
  const task = await Task.create(req.body)
  res.status(201).json({ task })
}

const getTask = (req, res) => {
  res.json({id:req.params.id})
}

const updateTask = (req, res) => {
  res.json({
    id: req.params.id,
    name:req.body.name
  })
}

const deleteTask = (req, res) => {
  res.json({id:req.params.id})
}

module.exports = {
  getAllTasks,
  createTask,
  getTask,
  updateTask,
  deleteTask
}
