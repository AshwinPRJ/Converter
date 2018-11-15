var MobileNumberMessage ="Mobile Number Should Be Numbers Only";
var AlphabetMessage     ="Only Alphabets Allowed";
var EmailIDMessage      ="Not A Valid Character For Email ID";
var NumberMessage       ="Only Numbers are Allowed";
var UpperCaseAlphabetMessage = "Enter Only A-Z uppercase Alphabet";
var NumberInValid       = "Not A Valid Number";
var DecimalMesssage     = "Only Two Decimal Allowed";
var MinPassword = "Password Should Be minimum 8 Characters with One Special Character";
var MaxPassword = "Password Should Be Maximum Of 16 Characters with One Special Character";
var NotAllowedSpecialChar = "Special Characters not Allowed";
var numValid="Only Numerics Allowed";
var charValid="Only Alphabets Allowed";
var mailID="Not a Valid ID";
var digitPrsn="2 Digit Precision";
var digitPrsn1="4 Digit Precision";
var validNO="Not a Valid Number";
var charMand="Entry in Mandatory Fields Required";
var alNum="Only Numerics And Alphabets Allowed";
var alNumWC="Only Numerics And Alphabets with Comma Allowed";
var numValidNeg = "Only Negative / Positive Numbers Allowed";
var alNumWS="Only Numerics And Alphabets with Single Slash Allowed";
var panNO="Enter a Valid Pan Number";


function MobileNumberValidation(fieldValue) {
	var src;
	if (document.all) {
		src= fieldValue.srcElement;
    }else {
    	src= fieldValue.target;
	}
	var field=src.value;
	var len=field.length;
	if(len) {
		for(var i=0;i< len;i++) {
			var str=field.charAt(i);
			if(!(str>="0" && str<="9")) {
				alert(MobileNumberMessage,'../img/help.jpg',"Ok",3);
				src.value="";
				src.focus();
				return;
			}
		}
	}
}

function DecimalValidation(fieldValue) {
	var src;
	if (document.all) {
		src= fieldValue.srcElement;
	} else {
		src= fieldValue.target;
	}
	var field=src.value;
	var len=field.length;
	var letters = /[0-9.]/;
	if(len) {
		for(var i=0;i< len;i++) {
			var str=field.charAt(i);
			if(!str.match(letters) ) {
				alert(NumberMessage,'../img/help.jpg',"Ok",3);
				src.value="";
				src.focus();
				return;
			}
			if (str==".") {
				if ((field.lastIndexOf(str)!=field.indexOf(str))) {
					alert(NumberInValid,'../img/help.jpg',"Ok",3);
					src.value="";
					return;
				}
			}
			if(!(field.indexOf(".")<0)) {
				var PeriodPosition=field.indexOf(".");
				var DigitsAfterPeriod=field.substr(PeriodPosition+1,len);
				if(DigitsAfterPeriod.length>2) {
					alert(DecimalMesssage,"../img/help.jpg","Ok",3);
					src.value="";
					return;
				}
			}
		}
	}
}

function NumberValidation(fieldValue){
	var src;
	if (document.all) {
		src= fieldValue.srcElement;
	} else {
		src= fieldValue.target;
	}
	var field=src.value;
	var len=field.length;
	if(len) {
		for(var i=0;i< len;i++) {
			var str=field.charAt(i);
			if(!(str>="0" && str<="9")) {
				alert(NumberMessage,'../img/help.jpg',"Ok",3);
				src.value="";
				src.focus();
				return;
			}
		}
	}
}

function  CheckAlphabetonly(fieldValue) {
	var letters = /[a-zA-Z ]/;
	var source_Field;
	if (document.all) {
		source_Field= fieldValue.srcElement;
	} else {
		source_Field= fieldValue.target;
	}
	var field=source_Field.value;
	var len=field.length;
	if(len) {
		for(var i=0;i< len;i++) {
			var str=field.charAt(i);
			if(!str.match(letters)) {
				alert(AlphabetMessage,'../img/help.jpg',"Ok",3);
				src.value="";
				src.focus();
				return;
			}
		}
	}
}

function  CheckAlphabetUpperCaseonly(fieldValue){
	var letters = /[A-Z ]/;
	var source_Field;
	if (document.all) {
		source_Field= fieldValue.srcElement;
	} else {
		source_Field= fieldValue.target;
	}
	var field=source_Field.value;
	var len=field.length;
	if(len) {
		for(var i=0;i< len;i++) {
			var str=field.charAt(i);
			if(!str.match(letters)) {
				alert(UpperCaseAlphabetMessage,'../img/help.jpg',"Ok",3);
				src.value="";
				src.focus();
				return;
			}
		}
	}
}

function  CheckEMailID(fieldValue){
	var letters =  /[0-9a-zA-Z@$+_.-]/;
	var source_Field;
	if (document.all) {
		source_Field= fieldValue.srcElement;
	} else {
		source_Field= fieldValue.target;
	}
	var field=source_Field.value;
	var len=field.length;
	if(len) {
		for(var i=0;i< len;i++) {
			var str=field.charAt(i);
			if(!str.match(letters)) {
				alert(EmailIDMessage,'../img/help.jpg',"Ok",3);
				src.value="";
				src.focus();
				return;
			}
		}
	}
}

function emiCal() {
	var loanamt	= parseInt(document.emicalculator.loanamount.value);
	var rateofins	= parseFloat(document.emicalculator.rateofinterest.value);
	var nofins	= parseInt(document.emicalculator.noofins.value);
	var roi         = rateofins/(12*100);
	var CalEMI      = Math.pow((1+roi),nofins);
	document.emicalculator.monthemiamt.value = Math.round(((roi * CalEMI) / (CalEMI-1)) * parseInt(loanamt));
}
function fnClose() {
	window.close();
}

function ValidatePasswordPolicy(event) {
	var src;
	if (document.all) {
		src= event.srcElement;
	} else {
		src= event.target;
	}
	var field=src.value;
	var len=field.length;
	if(len<8) {
		alert(MinPassword,"../img/help.jpg","Ok",3);
		src.value="";
		src.focus();
		return;
	}if(len>16) {
		alert(MaxPassword,"../img/help.jpg","Ok",3);
		src.value="";
		src.focus();
		return;
	}
	var alphaFlag= 0;
	var NumberFlag= 0;
	var SpecialFlag= 0;
	for(var i=0;i< len;i++) {
		var str=field.charAt(i);
		if(str>=0 && str<=9) {
			NumberFlag = 1;
		}
		if( (str>="a"&&str<="z") || (str>="A"&&str<="Z") ) {
			alphaFlag = 1;
		}
		if(str=="!" || str=="!" || str=="@" || str=="#" || str=="$" || str=="^" || str=="&" || str=="*" || str=="_" || str=="-" || str=="=" || str=="+" ) {
			SpecialFlag=1;
		}
	}
	if(alphaFlag==0) {
		alert("Password Should Contain Atleast One  Alphabet","../img/help.jpg","Ok",3);
		src.value="";
		src.focus();
		return;
	}
	if(NumberFlag==0) {
		alert("Password Must Contain Atleast One Number","../img/help.jpg","Ok",3);
		src.value="";
		src.focus();
		return;
	}
	if(SpecialFlag==0) {
		alert("Password Must Contain Atleast One Special Character like !@#$^&*_+=-","../img/help.jpg","Ok",3);
		src.value="";
		src.focus();
		return;
	}
}

function compoundCal() {
	var principle = parseInt(document.compoundcalculator.prinamount.value);
	var rateofint   = parseInt(document.compoundcalculator.rateofinterest.value);
	var periodsinmonths  = parseInt(document.compoundcalculator.prdinmonths.value);
	var frequency   = parseInt(document.compoundcalculator.selfeq.value);
	document.compoundcalculator.compoundamt.value = Math.round(( (Math.pow(1 + (rateofint / (1200 / frequency)), (periodsinmonths / frequency))) * principle));
}

function radcal(){
	var Principle = parseInt(document.recurringdepositcal.monthdepamount.value);
	var RateOfInterest = parseInt(document.recurringdepositcal.rateofinterest.value);
	var PeriodInMonths = parseInt(document.recurringdepositcal.rdperiodmonths.value);
	var CompoundingFrequency = parseInt(document.recurringdepositcal.compoundfeq.value);
	var a=parseFloat(1+(RateOfInterest/400)) ;
	var Numerator=parseFloat(Principle*( (Math.pow( (1+ (((CompoundingFrequency)*RateOfInterest)/1200)),(PeriodInMonths/(CompoundingFrequency))))-1));
	var b=parseFloat(0.3333333333333);
	var Denominator=parseFloat(1-(Math.pow(a,-b)));
	var mature_val  = parseFloat(Math.round((Numerator/Denominator)));
	document.recurringdepositcal.rdmaturityamt.value = mature_val;
}
function NotValidAllowedSpecialChar(fieldValue) {
	var source_Field;
	if (document.all){
		source_Field = fieldValue.srcElement;
	} else {
		source_Field = fieldValue.target;
	}
	var field = source_Field.value;
	var len = field.length;
	if (len) {
		for (var i = 0; i < len; i++) {
			var str = field.charAt(i);
			if (str == "%" || str == "'" || str == "/" || str == "&" || str == "\"" || str == "\\") {
				alert("No Special Characters Allowed...");
				source_Field.value = "";
				source_Field.focus();
				return;
			}
		}
	}
}