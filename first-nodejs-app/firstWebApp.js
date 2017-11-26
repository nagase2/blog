var http = require('http')
var dt = require('./myfirstmodule')


http.createServer(function(req,res){
    res.writeHead(200, {'Content-Type':'text/html'});
    console.log("修正しました");

    //res.write("date is "+ dt.myDateTime());
    res.write(req.url);

    res.end();
    

}).listen(8080);
