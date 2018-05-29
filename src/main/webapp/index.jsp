<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto ASR</title>

<!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/clean-blog.min.css" rel="stylesheet">


</head>
<body>

<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="index.html">Start Bootstrap</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.jsp">Home</a>
            </li>

          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('http://acerestetica.com.ar/img/home-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="site-heading">
              <h1>El Blog</h1>
              <span class="subheading">Un blog interactivo</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-preview">
            <a href="post.html">
              <h2 class="post-title">
                Man must explore, and this is exploration at its greatest
              </h2>
              <h3 class="post-subtitle">
                Problems look mighty small from 150 miles up
              </h3>
            </a>
            <p class="post-meta">Posted by
              <a href="#">Start Bootstrap</a>
              on September 24, 2018</p>
          </div>
          <hr>
          <div class="post-preview">
            <a href="post.html">
              <h2 class="post-title">
                I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.
              </h2>
            </a>
            <p class="post-meta">Posted by
              <a href="#">Start Bootstrap</a>
              on September 18, 2018</p>
          </div>
          <hr>
          <div class="post-preview">
            <a href="post.html">
              <h2 class="post-title">
                Science has not yet mastered prophecy
              </h2>
              <h3 class="post-subtitle">
                We predict too much for the next year and yet far too little for the next ten.
              </h3>
            </a>
            <p class="post-meta">Posted by
              <a href="#">Start Bootstrap</a>
              on August 24, 2018</p>
          </div>
          <hr>
          <div class="post-preview">
            <a href="post.html">
              <h2 class="post-title">
                Failure is not an option
              </h2>
              <h3 class="post-subtitle">
                Many say exploration is part of our destiny, but it’s actually our duty to future generations.
              </h3>
            </a>
            <p class="post-meta">Posted by
              <a href="#">Start Bootstrap</a>
              on July 8, 2018</p>
          </div>
          <hr>
          <!-- Pager -->
          <div class="card my-4">
            <h5 class="card-header">Deja un comentario:</h5>
            <div class="card-body">
              <form>
                <div class="form-group">
                  <textarea class="form-control" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
            </div>
          </div>


			<div class="media mb-4">
			<p>Opciones de la clase de ASR:</p>
				<ul>
				<li><a href="listar">Listar comentarios</a></li>
				<li>
					<form role="formInsert" action="insertar" method="POST" >
				        <div class="form-group">
				            <label>Deja un comentario:</label>
				            <select name="idioma">
							    <option value="ingles">Español a Inglés</option>
							    <option value="espanol">Inglés a Español</option>
							  </select>
				            <input type="text" name="palabra" id="formInsertPalabra">
				        	<button type="submit" class="btn">Submit</button>
				        </div>
				    </form>
				    <form role="formLeer" action="toSpeech" method="POST" >
				        <div class="form-group">
				            <label>Insertar palabra:</label>
				            <select name="voice">
							    <option value="ingles">Inglés</option>
							    <option value="espanol">Español</option>
							    <option value="frances">Francés</option>
							    <option value="japo">Japonés</option>
							  </select>
				            <input type="text" name="speech" id="formLeerTexto">
				        	<button type="submit" class="btn">Leer</button>
				        </div>
				        <!-- <div>
				       		<object type="text/html" data="https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?voice=es-LA_SofiaVoice&text=Text%20to%20synthesize" width="330 px" height="860 px">
				        	</object>
						</div>-->
				    </form>
				    
				    <form role="formLeer" action="toSpeech" method="POST" >
				        <div class="form-group">
				            <label>Insertar palabra:</label>
				            <select name="voice">
							    <option value="ingles">Inglés</option>
							    <option value="espanol">Español</option>
							    <option value="frances">Francés</option>
							    <option value="japo">Japonés</option>
							  </select>
				            <input type="text" name="speech" id="formLeerTexto">
				        	<button href="https://51cffcad-3cb8-4c54-aa28-fd1f0c04b502:uNDSYwnfUJ8v@stream.watsonplatform.net/text-to-speech/api/v1/synthesize?voice=en-US_AllisonVoice&text=hi" class="btn">Leer</button>
				       		<c:if test="${sessionScope.valor==true}">
                                <div class="alert alert-success fade in alertIndex">
                                    <a class="close" data-dismiss="alert" aria-label="close" title="close"><i class="fa fa-times" aria-hidden="true"></i></a>
                                    Esta acci&oacute;n se ha realizado con <strong>&eacute;xito!</strong>
                                </div>
                            </c:if>
                            <c:if test="${sessionScope.valor==true}">
                                <div class="alert alert-success fade in alertIndex">
                                    <a class="close" data-dismiss="alert" aria-label="close" title="close"><i class="fa fa-times" aria-hidden="true"></i></a>
                                    Esta acci&oacute;n se ha realizado con <strong>&eacute;xito!</strong>
                                </div>
                            </c:if>
				       
				        </div>
				        </form>
				    
				</li>
				</ul>
			</div>
        </div>
          
        </div>
      </div>
    </div>

    <hr>

    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Copyright &copy; Your Website 2018</p>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/clean-blog.min.js"></script>

  </body>

</html>
</body>
</html>
