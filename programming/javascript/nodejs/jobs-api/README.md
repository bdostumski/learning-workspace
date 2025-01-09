# Jobs API

## Swagger

URL: http://localhost:5000/api-docs/

## Environment Variables Notes:

JWT_SECRET is using Encryption key 256

## To run the application

```shell

./start-database.sh # Run database on port 27017, and mongo-express dbms on port 8081
./start-app.sh # Execute [npm install] to install all project dependencies, and then execute [node app.js] to run the application on port 5000.
./start-dev.sh # Execute [nodemon app.js] run the application in development mode on port 5000. Each save will restart the server.

```
