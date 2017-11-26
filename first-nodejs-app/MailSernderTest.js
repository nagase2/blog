
var nodemailer = require('nodemailer');

/**
 * this is mail sending test. it was confirmed that it can send email as I thought 
 * if I change the from email address and to email address accordingly.
 */
var transporter = nodemailer.createTransport({
  service: 'gmail',
  auth: {
    user: 'mymailaddless@xxxxmail.com',
    pass: 'mypassword'
  }
});

var mailOptions = {
  from: 'mymailaddless@xxxxmail.com',
  to: 'toaddress@xxxxmail.com',
  subject: 'Sending Email using Node.js',
  text: 'That was easy!'
};

transporter.sendMail(mailOptions, function(error, info){
  if (error) {
    console.log(error);
  } else {
    console.log('Email sent: ' + info.response);
  }
});