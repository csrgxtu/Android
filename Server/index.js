var express = require('express');

var app = express();

var data = {
  error: 0,
  msg: 'Success',
  recs: 'object',
};

app.put('/GPS', function cb(req, res) {
  return res.json(data);
});

app.get('/GPS', function cb(req, res) {
  return res.json(data);
});

app.post('/GPS', function cb(req, res) {
  return res.json(data);
});

app.delete('/GPS', function cb(req, res) {
  return res.json(data);
});

app.listen(3000);
