
//関数コレクションファイル

var fs = require('fs');

exports.myDateTime = function(){
    return Date();
};

exports.showBigNumber= function(){
    return 100000098000000990990;
}


exports.fileReader = function(){
    console.log("file read first line.");
    fs.appendFile('mynewfile1.txt', 'Hello content!!!!!!!!\n', function (err) {
    if (err) throw err;
    console.log('Saved!');
    });
}


