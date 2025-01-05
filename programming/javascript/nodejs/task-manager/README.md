# Task Manager

## Run Application

``` shell
docker compose --env-file ../.env -f docker-compose.yml up # run only database server and express client
nodemod start # run task manager the application
```

<p>Mongo Express DBMS will start on port 8081</p>
<p>Task Manager Application will start on port that is set in the environment variable APP_PORT or by default 3000</p>

## Project Setup 
<p>In order to run the project, setup .env and set MONGO_URI variable equal to DB connection string.</p>
<p>In order to avoid port collision, in the source code port value is 5000</p>

## Database configuration
<p>Create new database "task-manager"</p>
<p>Example of my .env file</p>

## Environment Variables 
MONGO_INITDB_ROOT_USERNAME=root<br/>
MONGO_INITDB_ROOT_PASSWORD=password<br/>
MONGO_EXPRESS_USERNAME=admin<br/>
MONGO_EXPRESS_PASSWORD=password<br/>
MONGO_URI='mongodb://root:password@localhost:27017/task-manager?authSource=admin&retryWrites=true&w=majority'<br/>
PORT=5000<br/>
