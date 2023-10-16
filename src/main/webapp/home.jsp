<DOCTYPE! html>


<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		 <style><%@include file="/resources/css/estilo.css"%></style>
        <title> Home </title>

        <link rel="stylesheet" href="cara.css">
    
    </head>
    
    
    <body>







        <header>
            <div>
                <img class="img" src="c:\Users\Quick\Downloads\LOGO (1).png" alt="logo">
            </div>
            
            <ul>
                <a href=""><li>Buscar Pets</li></a>
                <a href="<%=request.getContextPath()%>/mostrar-perfil-ong"><li>Ongs</li></a>
            </ul>

            <ul class="ul">
                <a href=""><button>Adotar</button></a>
                <a href="file:///C:/Users/Quick/Documents/projeto/login/login.html"><li>Entrar</li></a>
                <a href="<%=request.getContextPath()%>/mostrar-selecao-cadastro"><li>Cadastrar</li></a>
            </ul>

        </header>






        <main>

            <div>
                
                <img src="c:\Users\Quick\Downloads\LOGO (1).png" alt="logoDaHome">

            </div>
            
            <div>

                <h2><b>ADOTE</b> <br>e ajude um <br> animalzinho <br>a encontrar um <br>lar.</h2>
                
            </div>
            

        </main>

        <main>
            <div class="caixa2-1">

                <div class="cardgrid">
                    <div class="card"></div>
                    <div class="card">
                    </div>
                    <div class="card">
                    </div>
                    
            
                    <p>Dê o primeiro passo para encontrar 
                    seu novo amigo peludo! 
                    Nesta etapa, 
                    explore os pets disponíveis para adoção. 
                    Veja suas fotos, leia suas histórias e descubra 
                    qual deles toca seu coração.
                   </p>
                </div>

            </div>


            <div class="caixa2-2">
                <a href=""><span>Busque</span></a>
            </div>

        </main>

        <main></main>

        <main>
            
            <div class="caixa3-1"></div>

            <div class="caixa3-2">
                <div class="caixa3-2-counter">
                    <h1> 0 0 0 0 0 </h1>
                </div>

                <h1> Já foram adotados pela central pet até agora.</h1>

            </div>

        </main>

        <main></main>
        
        <footer class="footer-content">
            
            <h1>Central Pet é desenvolvido por <span>ADOTABLU.</span> </h1>
            
            <ul>
                <h3><span>ADOTABLU</span></h3>
                <a href=""><li>ADOTABLU</li></a>
                <a href=""><li>ADOTABLU Comunidade</li></a>
                <a href=""><li>Legal</li></a>
                <a href=""><li>Parceria</li></a>
            </ul>

            <ul>
                <h3><span>CENTRAL PET</span></h3>
                <a href=""><li>Home</li></a>
                <a href=""><li>Buscar</li></a>
                <a href=""><li>Minha Conta</li></a>
            </ul>
            
            <ul>
                <h3><span>ACOMPANHE-NOS</span></h3>
                <a href=""><li>Instagram</li></a>
                <a href=""><li>Twitter</li></a>
            </ul>



        </footer>

    </body>

</html>
