var express = require('express');

var app = express();

app.get('/GPS', function cb(req, res) {
  console.log("INFO: client connected");

  var data = {
    name: 'archer',
    sex: 'male',
    rich: false
  };

  return res.json(data);
});

app.listen(3000);
