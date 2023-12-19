
function CapOfFleet(){
		
	if (document.getElementById("Fleet1").value !== "" && document.getElementById("Region1").value !== "") {
		
		var a1 = document.getElementById("Fleet1").value;
		var a2 = document.getElementById("Region1").value;
																
		document.getElementById("Form1").submit();	
	}
}


function setVal(Reg,Flet){
	
	let element1 = document.getElementById("Fleet1");
	let element2 = document.getElementById("Region1");
	
	element1.value=Flet;
	element2.value=Reg;/*
	if(Reg == 'NRT'){
		element2.value='NRT';
	}
	else if(Reg == 'NA'){
		element2.value='NA';
	}
	else if(Reg == 'EU'){
		element2.value='EU';
	}
	else if(Reg == 'PDX'){
		element2.value='PDX';
	}
	else if(Reg == 'CN'){
		element2.value='CN';
	}
	
	
	if(Flet == 'Tier1'){
		element1.value='Tier1';
	}
	else if(Flet == 'Tier2'){
		element1.value='Tier2';
	}
	else if(Flet == 'Tier3'){
		element1.value='Tier3';
	}
	else if(Flet == 'Batch'){
		element1.value='Batch';
	}
*/	
}
