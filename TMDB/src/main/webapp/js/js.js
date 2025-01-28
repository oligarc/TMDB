document.addEventListener("DOMContentLoaded", () => {
	iniciar();
});

function iniciar(){
	mostrarInfo();
}

function mostrarInfo(){
	
	const modalInfo = document.getElementById("modalPelis")
	if(modalInfo){
		modalInfo.addEventListener("show.bs.modal", (event) =>{
			const button = event.relatedTarget // Se almacena el elemento que activó el modal en la variable
			const nombreActor = button.getAttribute("data-bs-nombre");
			const idActor = button.getAttribute("data-bs-id-actor");

			modalInfo.querySelector("h4").textContent = nombreActor;
			
			//Hacer llamada asincrona al controller con el id
			
			/*const xhr = new XMLHttpRequest();
			const url = "ControllerAdmin?operacion=listaPeliculasActorModal&idActor="+idActor
			
			Se puede usar xhr pero es mejor usar fetch ya que es más moderno */
			
			const modalBody = document.querySelector(".modal-body");
			
			fetch(`ControllerAdmin?operacion=listaPeliculasActorModal&idActor=${idActor}`).then(response => response.text()).then(data =>{
				modalBody.innerHTML = data;
			})
			
			.catch(error =>{
				modalBody.innerHTML = "<p>Error loading data.</p>";
				console.error("Error fetching movies:", error);
			});
			
			//fetch hace petición HTTP a la URL que pasamos, el .then se ejecuta cuando la promesa tiene éxito y luego con response.text lo convertimos
			//a texto plano HTML y ya luego con otro .then insertamos en el cuerpo de la modal la data que tenemos
			
		})
	}
	
	
	
}