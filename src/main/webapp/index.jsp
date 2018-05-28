<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto ASR</title>
</head>
<body>
<h1>Ejemplo de Proyecto de ASR BEGO =) con DevOps y tal</h1>
<hr />
<p>Opciones de la clase de ASR:</p>
<ul>
<li><a href="listar">Listar</a></li>
<li>
	<form role="formInsert" action="insertar" method="POST" >
        <div class="form-group">
            <label>Insertar palabra en español:</label>
            <input type="text" name="palabra" id="formInsertPalabra">
        	<button type="submit" class="btn">Insertar en BD</button>
        </div>
    </form>
    <form role="formLeer" action="leer" method="POST" >
        <div class="form-group">
            <label>Insertar palabra en ingles:</label>
            <input type="text" name="texto" id="formInsertPalabra">
        	<button type="submit" class="btn">Leer</button>
        </div>
        <div>
       		<object type="text/html" data="https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?voice=es-LA_SofiaVoice&text=Text%20to%20synthesize" width="330 px" height="860 px">
        	</object>
		</div>
    </form>
</li>
</ul>
</body>
</html>
