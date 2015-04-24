var express = require('express');
var bodyParser = require('body-parser');

var app = express();
app.use(bodyParser.urlencoded({extended: false}));

var data = {
  error: 0,
  msg: 'Success',
  recs: 'object',
};

app.post('/GPS', function cb(req, res) {
  console.log(req.body.data);

  return res.json(data);
});

app.get('/GPS', function cb(req, res) {
  return res.json(data);
});

app.put('/GPS', function cb(req, res) {
  return res.json(data);
});

app.delete('/GPS', function cb(req, res) {
  return res.json(data);
});

app.listen(3000);
