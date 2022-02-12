<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Ajouter l'entete -->
<jsp:include page="entete.jsp" />
<div class="container container-courses mb-4">
	<div class="d-flex flex-row justify-content-between mt-2">
	<img src="images/${sessionScope.idAdherent}.jpg" class="rounded img-profile" id="img-profile" />
		<div>
			<div class="welcomeTag">Bienvenue
				${(sessionScope.prenomAdherent)}
				&nbsp;${(sessionScope.nomAdherent).toUpperCase()}</div>
		</div>
		<div class="d-flex flex-row justify-content-between">

			<form class="mr-3" action="courses" method="post"
				enctype="multipart/form-data">
				<input type="file" accept="images/*" name="fichier" /> <input type="submit"
					class="btn btn-success" value="Téleverser image">
			</form>

			<form method="POST" action="deconnexion">
				<button type="submit" class="btn btn-danger">
					<i class="bi bi-power"></i>
				</button>
			</form>
		</div>
	</div>

	<h2 class="my-3 text-center">
		<b>Vos Courses</b>
	</h2>

	<div class="mt-2 jumbotron text-center">
		<form class="d-flex flex-row">
			<label class="mr-2">Courses effectues entre le </label> <input
				type="date" id="start" name="course-start" value="01/01/2021"
				min="01/01/2021" max="01/31/2021" class="mr-2"> et le <input
				type="date" id="end" name="course-end" value="01/01/2021"
				min="01/01/2021" max="01/31/2021" class="mx-2"> <input
				type="submit" class="btn btn-primary" value="Filtrer">
		</form>
	</div>

	<div class="mx-auto">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col" class="text-center"><b>Date et heure</b></th>
					<th scope="col" class="text-center"><b>Distance(m)</b></th>
					<th scope="col" class="text-center"><b>Duree</b></th>
					<th scope="col" class="text-center"><b>Calories</b></th>
					<th scope="col" class="text-center"><b>Action</b></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses}">
					<tr>
						<th scope="row">${course.id}</th>
						<td class="text-center">${course.dateHeureDebut}</td>
						<td class="text-center">${course.distanceEnMetres}</td>
						<td class="text-center">${course.dureeEnMinutes}</td>
						<td class="text-center">${course.calories}</td>
						<td class="text-center">
							<div class="text-center">
								<form method="GET" action="course">
									<input type="hidden" name="courseId" value="${course.id}" />
									<button type="submit" id="buttonModifier"
										class="btn btn-success">
										<i class="bi bi-pencil-fill"></i>&nbsp;Modifier
									</button>
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>${course}</p>
		<div class="text-center">
			<a href="course" class="ajouterCourseLien">Ajouter une course</a>
		</div>
	</div>
</div>
</body>
</html>