<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>TMDB</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS v5.2.1 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
    
    <link href="style/style.css" rel="stylesheet" />
  </head>
<body>

<header>
      <div class="container-fluid shadow p-0 overflow-hidden">
        <nav class="navbar navbar-expand-md navbar-light bg-dark">
          <div class="d-flex justify-content-between align-items-center w-100">
            <div>
              <a class="navbar-brand" href="ControllerAdmin?operacion=iniciar">
                <img
                  src="${pageContext.request.contextPath}/img/logotmdb.png"
                  alt="logoTMDB"
                  width="80"
                  style="margin-left: 20px"
                />
              </a>
              <a href="ControllerAdmin?operacion=iniciar" class="text-white text-decoration-none fs-1 me-2"
                >Person</a
              >
              <a href="ControllerAdmin?operacion=movies" class="text-white text-decoration-none fs-1">Movie</a>
            </div>
            <div>
            
            <c:choose>
            <c:when test="${usuario==null}">
              <form
                action="ControllerAdmin?operacion=login"
                method="post"
                class="d-flex align-items-center"
              >
                <input
                  type="email"
                  name="email"
                  class="form-control me-2 bg-dark text-white border-0"
                  placeholder="Email"
                  required
                  style="max-width: 200px"
                />
                <input
                  type="password"
                  name="password"
                  class="form-control me-2 bg-dark text-white border-0"
                  placeholder="Password"
                  required
                  style="max-width: 200px"
                />
                <button
                  type="submit"
                  class="btn me-4"
                  style="
                    background-color: rgb(42, 41, 41);
                    color: rgb(29, 139, 119);
                    border: 2px solid rgb(29, 139, 119);
                  "
                >
                  Login/Register
                </button>
              </form>
              </c:when>
              <c:otherwise>
              
              <span class="text-white">Welcome ${usuario.nick}</span>
              <a href="ControllerAdmin?operacion=logout" class="btn me-4" style="
                    background-color: rgb(42, 41, 41);
                    color: rgb(29, 139, 119);
                    border: 2px solid rgb(29, 139, 119);
                  ">Logout</a>
              
              </c:otherwise>
              </c:choose>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <main>
    <div class="container mt-4">
      <div class="row justify-content-center overflow-hidden">
      <c:forEach items="${listaPeliculas}" var="peli">
	<div class="col-xl-6 col-sm-12 mb-3">
  	<div class="card h-100">
    <div class="row g-0">
      <!-- Imagen a la izquierda -->
      <div class="col-md-4">
        <img
          class="img-fluid h-100"
          src="https://image.tmdb.org/t/p/w500${peli.poster}"
          alt="${peli.poster}"
          style="object-fit: cover;"
        />
      </div>
      <!-- Contenido a la derecha -->
      <div class="col-md-8">
        <div class="card-body">
          <h4 class="card-title text-center">${peli.titulo}</h4>
          <p class="card-text text-center">${peli.fecha}</p>
          <p class="card-text text-center">${peli.trama}</p>
        </div>
      </div>
    </div>
  </div>
</div>
        </c:forEach>
      </div>
      </div>
    </main>

    <footer>
      <h2 class="bg-dark text-success text-center p-3 overflow-hidden">The Movie DB</h2>
    </footer>

    <!-- Bootstrap JavaScript Libraries -->
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
      integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
      crossorigin="anonymous"
    ></script>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
      integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
      crossorigin="anonymous"
    ></script>

</body>
</html>