## Project Setup 
<p>In order to run the project, setup .env and set MONGO_URI variable equal to DB connection string.</p>
<p>In order to avoid port collision, in the source code port value is 5000</p>

## Database configuration
<p>Create new database "task-manager"</p>
<p>Example of my .env file</p>

## Environment Variables 
MONGO_INITDB_ROOT_USERNAME=root
MONGO_INITDB_ROOT_PASSWORD=password
MONGO_EXPRESS_USERNAME=admin
MONGO_EXPRESS_PASSWORD=password
MONGO_URI='mongodb://root:password@localhost:27017/task-manager?authSource=admin&retryWrites=true&w=majority'
PORT=5000
