const { app, port } = require('./app');

const start = async () => {
    try {
        app.listen(port, () => console.log(`Server is listening on port ${port}...`)
        );
    } catch (error) {
        console.log(error);
    }
};
exports.start = start;
