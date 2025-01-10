require('dotenv').config();

const mockJobsDataJson = require('./mock-jobs-data.json');
const Job = require('./models/Job');
const connectDB = require('./database/connect');

const mockJobsData = async () => {
  try {
    await connectDB(process.env.MONGO_URI);
    await Job.create(mockJobsDataJson);
    console.log('Mock Jobs data added to database');
    process.exit(0);
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

mockJobsData();
