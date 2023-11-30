
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

    function adicionarFoto(input) {
        const file = input.files[0];

        if (file) {
            const reader = new FileReader();

            reader.onload = function(e) {
                document.getElementById('fotoPerfil').getElementsByTagName('img')[0].src = e.target.result;
            };

            reader.readAsDataURL(file);
        }
    }
    

let etapaAtual = 0;    

function proximaEtapa(numero) {
	
	etapaAtual = numero;
	
	if (etapaAtual == 1) {
		
		document.getElementById('etapa-um').style.display = 'none';
		document.getElementById('etapa-um-parte-dois').style.display = 'none';
		document.getElementById('etapa-dois').style.display = 'flex';
		
		document.getElementById('botao-proximo').style.display = 'none';
		document.getElementById('botao-voltar').style.border = '1px solid var(--roxo)';
		document.getElementById('div-container-editar').style.flexDirection = 'column';
		document.getElementById('div-container-editar').style.display = 'flex';
		document.getElementById('botao-salvar').style.display = 'block';
	}
}

function voltarEtapa(numero) {
	
	etapaAtual = numero;
	
	if (etapaAtual == 0) {
		
		document.getElementById('etapa-um').style.display = 'flex';
		document.getElementById('etapa-um-parte-dois').style.display = 'flex';
		document.getElementById('etapa-dois').style.display = 'none';
		
		document.getElementById('botao-proximo').style.display = '';
		document.getElementById('botao-voltar').style.border = '';
		document.getElementById('div-container-editar').style.display = '';
		document.getElementById('div-container-editar').style.flexDirection = '';
		document.getElementById('botao-salvar').style.display = '';
	}
}

