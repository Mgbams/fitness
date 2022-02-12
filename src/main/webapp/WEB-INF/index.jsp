<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajouter l'entete -->
<jsp:include page="entete.jsp" />


<div class="container">
	<div class="card mx-auto">
		<div class="card-header text-center">Connexion</div>
		<small class="text-center text-danger"> ${error} </small>
		<div class="card-body">
			<form method="POST" action="connexion">
				<div class="mb-2">
					<label for="email">Email:</label> <input type="email" name="email"
						id="email" class="form-control" placeholder="email">
				</div>
				<div class="mb-2">
					<label for="motDePasse">Mot de Passe:</label> <input
						type="password" name="motDePasse" id="motDePasse"
						class="form-control" placeholder="Mot de Passe"><br /> <br />
					<input type="submit" name="indexSubmitButton" class="btn btn-success" value="Connexion">
				</div>
			</form>

			<div class="text-center">
				<a href="inscription" class="inscrire">Inscription</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>