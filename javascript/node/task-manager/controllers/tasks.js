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

const createTask = (req, res) => {
  res.json(req.body)
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
