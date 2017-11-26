var http = require('http');
var url = require('url');
var mymodule = require('./myfirstmodule');


http.createServer(function(req,res){
    res.writeHead(200, {'Content-Type':'text/html'});
    console.log("修正しまkした");

    //res.write("date is "+ mymodule.myDateTime());
    var q  = url.parse(req.url, true).query;
    var txt = q.year + " "  + q.month;

    
    mymodule.fileReader();


    res.end(txt);
    

}).listen(8080);



