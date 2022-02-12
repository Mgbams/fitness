<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Ajouter l'entete -->
<jsp:include page="entete.jsp" />
<div class="container mt-3">
	<div class="container">
		<div class="d-flex flex-row justify-content-between">
			<div>
				<p class="welcomeTag">
					<a href="courses" class="mr-2 backButton"> <i
						class="bi bi-arrow-left-circle-fill"></i>
					</a>Bienvenue ${(sessionScope.prenomAdherent)}
					&nbsp;${(sessionScope.nomAdherent).toUpperCase()}
				</p>
			</div>
			<div class="d-flex flex-row justify-content-between">
				<form class="mr-3">
					<input type="submit" class="btn btn-success"
						value="Téleverser un image">
				</form>
				<form method="POST" action="deconnexion">
					<button type="submit" class="btn btn-danger">
						<i class="bi bi-power"></i>
					</button>
				</form>
			</div>
		</div>

		<h2 class="text-center my-4">
			<b>Ajout d'une course(bravo) !</b>
		</h2>

		<div class="mt-2 jumbotron text-center">
			<form method="POST" action="course"
				class="d-flex flex-column align-items-start">
				<div id="tapisWrapper" class="mb-3 mr-2">
					<label for="tapis" class="mr-2">Tapis</label> <select name="tapis"
						class="roundedInputTapis" id="tapis">
						<c:forEach var="tapis" items="${tapis}">
							<option selected="${tapisSelected}" value="${tapis.id}">${tapis.designation}</option>
						</c:forEach>
					</select>
				</div>

				<div>
					<label class="mr-2">Date et heure </label> 
					
					<input type="date"
						name="dateEntree" value="${dateFromDateTime}"
						class="mx-2 pb-2 
							align-items-center text-center roundedInput"
						placeholder="01/31/2021"> 
						
						<input type="time"
						id="minuteHeure" name="minuteHeure" value="${timeFromDateTime}"
						placeholder="${timeFromDateTime}"
						class="mx-2 pb-1 align-items-center text-center roundedInput" />
						
				</div>

				<div class="mt-3">
					<label for="distance" class="mr-3">Distance (en mètres)</label> <input
						type="number" name="distance" id="distance"
						value="${course.distanceEnMetres}" class="roundedInput" />
				</div>

				<div>
					<label for="duree" class="mr-3">Durée (en minutes)</label> <input
						type="number" name="duree" id="duree" class="roundedInput"
						value="${course.dureeEnMinutes}" />
				</div>

				<div>
					<label for="calories" class="mr-3">Calories</label> <input
						type="number" name="calories" id="calories"
						value="${course.calories}" class="roundedInput" />
				</div>

				<c:if test="${idExists}">
					<c:if test="${idExists eq true}"><input type="hidden" name="courseAModifierId" value="${course.id}"></c:if>
					<div class="text-center">
						<input type="submit" value="Update"
							class="ajouterCourseLien btn btn-success" />
					</div>
				</c:if>

				<c:if test="${ not idExists}">
					<div class="text-center">
						<input type="submit" value="Ajouter"
							class="ajouterCourseLien btn btn-success" />
					</div>
				</c:if>

			</form>
		</div>

	</div>
</div>
</body>
</html>