
function voltar() {
	
	window.history.back();
}

function confirmarSenha() {
	
	let senha1 = document.getElementById("senha-um").value;
	let senha2 = document.getElementById("senha-dois").value;
	
	
	let campoSenha1 = document.getElementById("senha-um");
	let campoSenha2 = document.getElementById("senha-dois");
	
	let btnConfirmar = document.getElementById("btn-confirmar");
	
	if (senha1 === senha2 && senha1 !== '' && senha2 !== '') {
		
		campoSenha1.style.border = "2px solid green"
		campoSenha2.style.border = "2px solid green"
		
		btnConfirmar.disabled = false;
	} else {
		
		campoSenha1.style.border = "2px solid red"
		campoSenha2.style.border = "2px solid red"
		
		btnConfirmar.disabled = true;
	}
}