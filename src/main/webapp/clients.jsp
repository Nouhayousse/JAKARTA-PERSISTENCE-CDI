<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8" />
  <title>Liste des Clients</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 20px;
    }

    h2, h3 {
      color: #333;
    }

    .error {
      color: red;
      margin-bottom: 15px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
      background-color: #fff;
      box-shadow: 0 0 5px rgba(0,0,0,0.1);
    }

    table th, table td {
      padding: 10px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    table th {
      background-color: #4CAF50;
      color: white;
    }

    table tr:hover {
      background-color: #f1f1f1;
    }

    a {
      text-decoration: none;
      color: #2196F3;
    }

    a:hover {
      text-decoration: underline;
    }

    form {
      background-color: #fff;
      padding: 15px;
      box-shadow: 0 0 5px rgba(0,0,0,0.1);
      max-width: 500px;
    }

    input[type=text], input[type=email] {
      width: 100%;
      padding: 8px;
      margin: 5px 0 15px 0;
      box-sizing: border-box;
    }

    input[type=submit] {
      background-color: #4CAF50;
      color: white;
      padding: 10px 15px;
      border: none;
      cursor: pointer;
    }

    input[type=submit]:hover {
      background-color: #45a049;
    }

  </style>
</head>
<body>
<h2>Liste des Clients</h2>

<c:if test="${not empty error}">
  <div class="error">${error}</div>
</c:if>

<table>
  <tr>
    <th>ID</th>
    <th>Nom</th>
    <th>Prénom</th>
    <th>Email</th>
    <th>Téléphone</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="client" items="${clients}">
    <tr>
      <td>${client.id}</td>
      <td>${client.firstName}</td>
      <td>${client.lastName}</td>
      <td>${client.email}</td>
      <td>${client.phone}</td>
      <td>
        <a href="ClientServlet?action=edit&id=${client.id}">Modifier</a> |
        <a href="ClientServlet?action=delete&id=${client.id}" onclick="return confirm('Supprimer ce client ?');">Supprimer</a>
      </td>
    </tr>
  </c:forEach>
</table>

<h3>Ajouter / Modifier un client</h3>
<form action="ClientServlet" method="post">
  <input type="hidden" name="id" value="${clientEdit.id}" />
  Nom: <input type="text" name="nom" value="${clientEdit.firstName}" required/>
  Prénom: <input type="text" name="prenom" value="${clientEdit.lastName}" required/>
  Email: <input type="email" name="email" value="${clientEdit.email}" required/>
  Téléphone: <input type="text" name="telephone" value="${clientEdit.phone}" />
  <input type="submit" value="Enregistrer" />
</form>

</body>
</html>
