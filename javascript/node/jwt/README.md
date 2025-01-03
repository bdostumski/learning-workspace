# JWT (JSON Web Token) Authentication Basics

## How JWT works
### First Request from the CLIENT:
    - The CLIENT sends correct username and password for Login Request message [CLIENT -> SERVER]
    - The SERVER return Response + Signed JWT to the CLIENT [CLIENT <- SERVER]

### Other Requests from the CLIENT:
    - The CLIENT send Request + Signed JWT to the SERVER [CLIENT -> SERVER]
    - The SERVER returns Response messages [CLIENT <- SERVER]
    
### JWT Structure (xxxxx.yyyyy.zzzzz):
    - HEADER (type of token, and algorithm) encoded in Base64Url
    - PAYLOAD (some data) encoded in Base64Url
    - SIGNATURE (secret) encoded in Base64Url

``` shell
HMACSHA256 (
    base64UrlEncode(header) + "." +
    base64UrlEncode(payload),
    secret
)
```

### This is HOW the CLIENT sends back the token to the SERVER

``` shell
Authorization: Bearer <token>
```


## Run Application

``` shell
docker compose --env-file ../.env -f docker-compose.yml up # run only database server and express client
npm start # run task manager the application
```

<p>Mongo Express DBMS will start on port 8081</p>
<p>Task Manager Application will start on port that is set in the environment variable APP_PORT or by default 3000</p>

## Project Setup 
<p>In order to run the project, setup .env and set MONGO_URI variable equal to DB connection string.</p>
<p>In order to avoid port collision, in the source code port value is 5000</p>

## Database configuration
<p>Create new database "jwt-auth"</p>
<p>Example of my .env file</p>

## Environment Variables 
MONGO_INITDB_ROOT_USERNAME=root<br/>
MONGO_INITDB_ROOT_PASSWORD=password<br/>
MONGO_EXPRESS_USERNAME=admin<br/>
MONGO_EXPRESS_PASSWORD=password<br/>
MONGO_URI='mongodb://root:password@localhost:27017/jwt-auth?authSource=admin&retryWrites=true&w=majority'<br/>
PORT=5000<br/>
