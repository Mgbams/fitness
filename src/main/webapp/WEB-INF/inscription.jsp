<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajouter l'entete -->
<jsp:include page="entete.jsp" />


<div class="container">
	<div class="card mx-auto">
		<div class="card-header text-center">Inscription</div>
		<div class="card-body">
			<form method="POST" action="">
				<div class="mb-3">
					<label for="nom">Nom:</label> <input type="text" name="nom"
						id="nom" class="form-control" placeholder="nom">
				</div>
				<div class="mb-3">
					<label for="prenom">PréNom:</label> <input type="text"
						name="prenom" id="prenom" class="form-control"
						placeholder="Prénom">
				</div>
				<div class="mb-3">
					<label for="email">Email:</label> <input type="email" name="email"
						id="email" class="form-control" placeholder="email">
				</div>
				<div class="mb-3">
					<label for="motDePasse">Mot de Passe:</label> <input
						type="password" name="motDePasse" id="motDePasse"
						class="form-control" placeholder="Mot de Passe">
				</div>
				<div class="text-center">
					<input type="submit" class="btn btn-success" value="Inscription">
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>