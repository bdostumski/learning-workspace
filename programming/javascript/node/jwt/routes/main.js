const expres = require('express');
const router = expres.Router();

const { login, dashboard } = require('../controllers/main');

const authMiddleare = require('../middleware/auth');

router.route('/dashboard').get(authMiddleare, dashboard);
router.route('/login').post(login);

module.exports = router;
