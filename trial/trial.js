var oldNum;
var operator;
var theNum =[];
var nextNum = [];
var theOperator =[];
reset2 = function (){
	oldNum = document.getElementById("textt").value;
	oldNum=oldNum/10
	oldNum=Math.trunc(oldNum)
	document.getElementById("textt").value = oldNum;
}
theZero = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "0";
	document.getElementById('textt').value = hw;
}
theOne = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "1";
	document.getElementById('textt').value = hw;
}
theTwo = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "2";
	document.getElementById('textt').value = hw;	
}
theThree = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "3";
	document.getElementById('textt').value = hw;
}
theFour = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "4";
	document.getElementById('textt').value = hw;
	console.log(theOperator[1]);
}
theFive = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "5";
	document.getElementById('textt').value = hw;
}
theSix = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "6";
	document.getElementById('textt').value = hw;
}
theSeven = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "7";
	document.getElementById('textt').value = hw;
}
theEight = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "8";
	document.getElementById('textt').value = hw;
}
theNine = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + "9";
	document.getElementById('textt').value = hw;
}
theDot = function(){
	oldNum = document.getElementById("textt").value;
	var hw = oldNum + ".";
	document.getElementById('textt').value = hw;
}
thePlus =function(){
	oldNum=document.getElementById("textt").value;
	theNum[1] = oldNum * 1;
	document.getElementById("textt").value = null;
	theOperator[1] =1 ;
}
theTimes = function(){
	oldNum=document.getElementById("textt").value;
	theNum[1] = oldNum * 1;
	document.getElementById("textt").value = null;
	theOperator[1] =2;
}
 theDivide = function (){
 	oldNum=document.getElementById("textt").value;
	theNum[1] = oldNum * 1;
	document.getElementById("textt").value = null;
	theOperator[1] =3;
 }
 theMinus = function(){
 	oldNum=document.getElementById("textt").value;
	theNum[1] = oldNum * 1;
	document.getElementById("textt").value = null;
	theOperator[1] =4;
 }
 theEquals = function(){
 	oldnum= document.getElementById("textt").value;
 	nextNum[1]= oldnum * 1;
 	if(theOperator[1]===1){
 		var rest = theNum[1] +nextNum[1];
 		rest = Math.round(rest * 100)/100;
 		document.getElementById('textt').value = rest;
 	}else if(theOperator[1]===4){
 		var set = theNum[1] - nextNum[1];
 		set = Math.round(set * 100)/100;
 		document.getElementById("textt").value = set;
 	}else if(theOperator[1]===3){
 		var est = theNum[1] / nextNum[1];
 		est = Math.round(est * 100)/100;
 		document.getElementById('textt').value = est;
 	}else if(theOperator[1]===2){
 		var et = theNum[1] * nextNum[1];
 		et = Math.round(et * 100)/100;
 		document.getElementById('textt').value = et;
 	}
 	
 }