<div class="container-filtro">
	<form action="filtrar-pets" method="post">
	<div class="filtro">

	<select name="especie" id="especie">
		<option value="CACHORRO">Cachorro</option>
		<option value="GATO">Gato</option>
	</select>
	
	<select name="porte" id="porte">
		<option value="MINI">Mini</option>
		<option value="PEQUENO">Pequeno</option>
		<option value="MEDIO">Médio</option>
		<option value="GRANDE">Grande</option>
		<option value="GIGANTE">Gigante</option>
	</select> 
	
	<select name="sexo" id="sexo">
		<option value="MACHO">Macho</option>
		<option value="FEMEA">Fêmea</option>
	</select> 
	
	<select name="pelagem" id="pelagem">
		<option value="CURTO">Curta</option>
		<option value="MEDIO">Média</option>
		<option value="LONGO">Longa</option>
	</select> 
	
	<button type="submit" class="btn-filtrar">Filtrar</button>
</div>
	</form>
</div>