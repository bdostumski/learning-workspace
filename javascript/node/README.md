# Node JS notes

## GLOBALS
- __dirname - path to current directory
- __filename - file name
- require - function to use modules (CommonJS)
- module - info about current module (file)
- process - info about env where the program is being executed

## MODULES SETUP (file)
1. CommonJS, every file is module (by default)
2. Modules - Encapsulated Code (only share minimum)

```javascript
// Exports constants one, and two from file
module.exports = { constant_one, constant_two }
module.exports.items = ['constant_one', 'constant_two']
// Imports constants one, and two into another file
// Note file_name must be without .js extention
const constants = require('./file_name')
// Import function from other file
require('./func_file')
```

## BUILD-IN MODULES (main modules)
1. OS module
2. PATH module
3. FS module
4. HTTP module 

```javascript
// Import build-in modules
// Operating System Data
const os = require('os')
const currentOS = {
    name: os.type(),
    release: os.release(),
    totalMem: os.totalmem(),
    freeMem: os.freemem(),
}
console.log(currentOS)

// Interacts with path module
const path = require('path')
const filePath = path.join('/main_folder', 'sub_folder', 'file.txt')
console.log(filePath)

// File System module
const fs = require('fs')
// Sync read and write file
const {readFileSync, writeFileSync} = require('fs'); // destruct the fs module with {readFileSync, writeFileSync}
// Async read and write files
const {readFile, writeFile} = require('fs') 

// HTTP module
const http = require('http')
```

## Sync vs Async
1. Sync - blocking code
2. Async - non-blocking code

## HTTP module
```javascript
const http = require('http')
const server = http.createServer((req, res) => {
    console.log(req)
    if(req.url === '/') {
        res.write(`Hello to my Home Page`);
        res.end('Home Page');
        return;
    }

    if(req.url === '/about') {
        res.end('About Page');
        return;
    }

    res.end(`
    <h1>Oops!</h1>
    <p>We can't seem to find the page you are loking for</p>
    <a href="/">Back Home</a>
    `);
})

server.listen(5000);
```

## NPM (node package manager)
- npm - global command, comes with node
- npm --version
- npm i <packageName> - local dependency (use it only in this particular project)
- npm install -g <packageName> - global dependency (use it in any project)

- global dependency - use in any project
- npm install -g <packageName>

- package.json -manifest file (store important info about project/package)
- manual approach (create package.json in the root create properties etc)
- npm init (step by step, press enter to skip)
- npm init -y (everything default)
- npm i (install packages)

## Nodemon (automatically restart our application)
- npm i nodemon --save-dev (Develop dependency. Develop dependency must be delete when our application goes to 
- npm run dev (run "dev" script)

```javascript
"scripts" : {
    "start": "node application-name.js",
    "dev": "nodemon application-name.js"
}
```

## Uninstall package
- npm uninstall packageName (uninstall package)
- Other variant is to remove package from package.json file, and then to run npm install

## Global install
- The suggestion is to use npx for global dependencies. 
- Note: for example nodemon we can install it on our machine and not to be in our project dependencies, and then we can run nodemon from on our terminal to run the application

## package-lock.json
- lock the application sub dependencies of our main dependencies to not be change. 

## Important to understand

## Event Loop
- The event loop is what allows Node.js to perform non-blocking I/O operations - despite the fact that JavaScript is single-threaded.
- Event Loop registers callback and when the operation is complete it is execute (this is async request)

``` javascript
const { readFile } = require('fs')

console.log('started a first task')
readFile('./content/first.txt', 'utr8', (err, result) => {
    if(err) {
        console.log(err)
        return
    }
    console.log(result)
    console.log('completed first task')
})
console.log('start next task')
# result will be: started first task => starting next task => Hello this is first text file => completed first task

# second example
console.log('first')
setTimeout(() => {
    console.log('second')
}, 0)
console.log('third')
# result will be: first => third => second
```

## Async Patterns - Blocking Code
- Blocking code is code that is take a lot of time to be execute for example some loops. This will block all the application requests, even if loop is in the a sync block of code.
- We should always strive to make our code async.

## Async Patterns - Setup Promises
- Promises will can handle multiple requests for example array of files

``` javascript
const { readFile } = require('fs')

const getText = (path) => {
    return new Promise((resolve, reject) => {
        readFile(path, 'utf8', (err, data) => {
            if(err) {
               reject(err) 
            } else {
                resolve(data)
            }
        })
    })
}

getText('.content/first.txt')
    .then(result => console.log(result))
    .catch(err => console.log(err))
```

## Async Patterns - Refactor to Async
- Remove nestead callbac

``` javascript
const { readFile } = require('fs')

const getText = (path) => {
    return new Promise((resolve, reject) => {
        readFile(path, 'utf8', (err, data) => {
            if(err) {
               reject(err) 
            } else {
                resolve(data)
            }
        })
    })
}

const start = async() => {
    try {
        const first = await getText('./content/first.txt') // waithing for result
        const second = await getText('./content/second.txt') // waithing for result
        console.log(first) 
        console.log(second)
    } catch (error) {
        console.log(error)
    }
}

start();
```

# Async Patterns - Node's Native Option
``` javascript
const { readFile, writeFile } = require('fs')
const util = require('util')
const readFilePromise = util.promisify(readFile)
const writeFilePromise = util.promisify(writeFile)

const start = async() => {
    try {
        const first = readFilePromise('./content/first.txt', 'utf8') // waithing for result
        const second = readFilePromise('./content/second.txt', 'utf8') // waithing for result
        await writeFilePromise('./content/result.txt', `This is awsome: ${first, second}`)
        console.log(first) 
        console.log(second)
    } catch (error) {
        console.log(error)
    }
}

start();
```

## Events Emitter - Code Example
- losing for specific event and when it is trigger then callback function will start
  - on -listen for event
  - emit - emit an event
- can have multiple events with same name as we need 

``` javascript
const EventEmitter = require('events');
const customEmitter = new EventEmmiter();

customEmitter.on('respose', (name, id) => {
    console.log(`first data recieved ${name} with id ${id}`)
})

customEmitter.on('respose', () => {
    console.log(`second data recieved `)
})

// Emit must be bellow the listeners => we need first to register listeners and after that to emit them
customEmitter.emit('response', 'john', 34)
```

## Streams
- Streams read and write data sequentially
  - Writable
  - Readable
  - Duplex
  - Transform

``` javascript
const {createReadStream} = require('fs');
const stream = createReadStream('./content/big.txt', {highWaterMark: 90000, encoding: 'utf8'});

stream.on('data', (result) => {
   console.log(result) 
}):

stream.on('error', (error) => console.log(error));
```

# Express

## HTTP Request/Response Cycle
- The user sends HTTP Request Message, and the server returns HTTP Response Message.

## HTTP Messages
- Request Message
  - METHOD:
    - Request URL: https://www.syscomz.com/apis/
    - Request Method: GET
    - Status Code: 200 OK
    - Remote Address: 192.168.1.1:443
    - Referrer Policy: strict-origin-when-cross-origin
 - HEADERS (key-value, information about our request message):
   - Pragma: no-cache
   - Referer: https://www.syscomz.com/
 - BODY (optional):
   - Request Payload (view source)
     - {email: "hellow@syscomz.com"}

- Response Message
  - METHOD:
    - Request URL: https://syscomz.com/app/api
    - Request Method: POST
    - Status Code: 400
    - Remote Address: 192.168.1.2:443
    - Referrer Policy: strict-origin-when-cross-origin
  - HEADERS (key-value, information about our request message):
    - Content-Type: text/html; charset=UTF-8
    - Content-Type: application/json; charset=utf-8
  - BODY (optional):
    - some html code for example

- METHODS:
  - GET (read data)
  - POST (insert data)
  - PUT (update data)
  - DELETE (delete data)

- HTTP Basics
  - Port is a communication endpoint.

- HTTP Headers 
  - key-value metadata that describes request/response messages

- HTTP Request Object
  - It is a big object, that contains bunch of information. For example the method of request, the url of the request and etc.

- HTTP HTML File
  - Getting data from HTML file and send it as response body (index.html, about.html, test.json)

## Express Info
- 
  

