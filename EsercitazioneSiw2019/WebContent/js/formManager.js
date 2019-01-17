function Studente(matricola, nome, cognome){
	this.matricola = matricola;
	this.nome = nome;
	this.cognome = cognome;
}

function mostraScuola(studente){
	var stud = {
			matricola : studente.matricola,
			nome: studente.nome,
			cognome: studente.cognome
		};
	$.ajax({
		type: "POST",
		url: "dettagliScuola",
		datatype: "json",
		data: JSON.stringify(stud),
		success: function (data){
			var scuola = JSON.parse(data);
			$("#dettagliScuola").text(scuola.nome);
		}
	});
}

function popolaCorsiLaurea(){
	var selVal = $("#dipart").val();
	if (selVal == "---"){
		$("#cLaurea").attr("disabled", true);
	}else{
		$("#cLaurea").removeAttr("disabled");
		$.ajax({
			 type: "GET",
			 url: "popolaForm",
			 data: {idDipartimento: selVal},
			 success: function(data){
				 $("#cLaurea").empty();
				 $("#cLaurea").html(data);
			 }
			});
	
	}
}






