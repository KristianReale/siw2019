function maschera(studente){
	svuota();
	document.getElementById("selStudente").innerHTML =
		"<h4>" + studente.matricola + " : "
		+ studente.nome + " : "
		+ studente.cognome + " </h4> ";
	var numComponenti = document.getElementById("numComponenti");
	numComponenti.addEventListener("blur", aggiungiCaselle);
}

function aggiungiCaselle(){
	var numComponenti = document.getElementById("numComponenti");
	var nComp = numComponenti.value;
	
	var tagValori = document.getElementById("valori");
	
	svuota();
	
	for (var i = 0; i < nComp; i++){
		var redd = document.createElement("div");
		redd.setAttribute("class", "form-group");
		redd.innerHTML = "<label>REDDITO del componente:</label>" +
				"<input class='redditoComponente' type='text' " +
				"class='form-control' />";
		
		var patr = document.createElement("div");
		patr.setAttribute("class", "form-group");
		patr.innerHTML = "<label>PATRIMONIO del componente:</label>" +
				"<input class='patrimonioComponente' type='text' " +
				"class='form-control' />";
		
		tagValori.appendChild(redd);
		tagValori.insertBefore(patr, redd.nextSibling);
//		tagValori.appendChild(patr);
	}
}

function svuota(){
	var tagValori = document.getElementById("valori");
	while (tagValori.firstChild){
		tagValori.removeChild(tagValori.firstChild);
	}
}

