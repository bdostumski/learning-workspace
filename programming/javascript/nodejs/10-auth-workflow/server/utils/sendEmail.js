const nodemailer = require('nodemailer');
const nodemailerConfig = require('./nodemailerConfig');

const sendEmail = async ({ to, subject, html }) => {

  let testAccount = await nodemailer.createTestAccount();

  const transporter = nodemailer.createTransport(nodemailerConfig);

  return transporter.sendMail({
    from: '"Test User  👻" <test.user@mail.dd>',
    to: to,
    subject: subject,
    html: html,
  });
};

module.exports = sendEmail;
