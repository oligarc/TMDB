<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<c:forEach items="${listaPelisActor}" var="pelicula">
    <div class="movie-item">
  	<div class="card h-100">
    <div class="row g-0">
      <!-- Imagen a la izquierda -->
      <div class="col-md-4">
        <img
          class="img-fluid h-100"
          src="https://image.tmdb.org/t/p/w500${pelicula.poster}"
          alt="${peli.poster}"
          style="object-fit: cover;"
        />
      </div>
      <!-- Contenido a la derecha -->
      <div class="col-md-8">
        <div class="card-body">
          <h4 class="card-title text-center">${pelicula.titulo}</h4>
          <p class="card-text text-center">${pelicula.fecha}</p>
        </div>
      </div>
    </div>
  </div>
        <hr />
    </div>
</c:forEach>

<!-- Solo tenemos que devolver HTML como respuesta, no una página completa -->