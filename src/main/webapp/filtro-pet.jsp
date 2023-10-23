<div class="container-filtro">
	<div class="filtro">
	<form action="filtrar-pets" method="post">

	<select name="especie" id="Espécie">
		<option value="cachorros">Cachorros</option>
		<option value="gato">Gatos</option>
	</select>
	
	<select name="porte" id="Porte">
		<option value="mini">Mini</option>
		<option value="pequeno">Pequeno</option>
		<option value="médio">Médio</option>
		<option value="grande">Grande</option>
		<option value="gigante">Gigante</option>
	</select> 
	
	<select name="sexo" id="Sexo">
		<option value="macho">Macho</option>
		<option value="fêmea">Fêmea</option>
	</select> 
	
	<select name="pelagem" id="Pelagem">
		<option value="curta">Curta</option>
		<option value="media">Média</option>
		<option value="longa">Longa</option>
	</select> 
	
	<button type="submit" class="btn-filtrar">Filtrar</button>
	</form>
</div>
</div>