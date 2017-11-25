var http = require('http')
http.createServer(function(requ,res){
    res.writeHead(200, {'Content-Type':'text/html'});
    console.log("xxxxxllllkkkkllxxxx");
    res.end('Hellloddo');
    

}).listen(8080);
