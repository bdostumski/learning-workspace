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
// Import functionallity from other file
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

