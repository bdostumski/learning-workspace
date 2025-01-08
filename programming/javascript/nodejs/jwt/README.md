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

## To run the application

```shell
./start-database.sh # Run database on port 27017, and mongo-express dbms on port 8081
./start-app.sh # Execute [npm install] to install all project dependencies, and then execute [node app.js] to run the application on port 5000.
./start-dev.sh # Execute [nodemon app.js] run the application in development mode on port 5000. Each save will restart the server.
```
