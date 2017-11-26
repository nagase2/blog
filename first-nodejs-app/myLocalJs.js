/**
 * 普通にJavascripを実行するだけのファイル
 */
var uc = require('upper-case');
var moment = require('moment');
var dt = require('./myfirstmodule')


console.log("現在の時刻は"+dt.myDateTime());
console.log("大きな数字："+ dt.showBigNumber())

console.log(dt.fileReader());

console.log(uc("THis is Upper case demo"));

console.log("moment demo: "+moment().format("ddd,,,Ha"));

