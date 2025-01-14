const nodemailer = require('nodemailer');

const sendEmail = async (req, res) => {
  let testAccount = await nodemailer.createTestAccount();

  const transporter = nodemailer.createTransport({
    host: 'smtp.ethereal.email',
    port: 587,
    auth: {
      user: 'judson.vonrueden41@ethereal.email',
      pass: 'GWQu2TrMguv5cAWCVH'
    }
  });

  let info = await transporter.sendMail({
    from: '"Judson VonRueden" <judson.vonrueden41@ethereal.email>',
    to: 'bar@example.com',
    subject: 'Hello ✔',
    html: '<b>Hello world?</b>'
  });

  res.json(info);
}

module.exports = sendEmail;
