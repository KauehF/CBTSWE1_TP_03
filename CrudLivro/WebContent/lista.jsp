<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.crud.Livro"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD Livros</title>
</head>
<body>

<h1>Lista de Livros</h1>

<a href="<%=request.getContextPath()%>/?acao=novo">
Novo Livro
</a>

<br><br>

<table border="1">

<tr>
<th>ID</th>
<th>Título</th>
<th>Autor</th>
<th>Preço</th>
<th>Ações</th>
</tr>

<%

List<Livro> lista = (List<Livro>) request.getAttribute("lista");

for(Livro livro : lista){

%>

<tr>

<td><%=livro.getId()%></td>
<td><%=livro.getTitulo()%></td>
<td><%=livro.getAutor()%></td>
<td><%=livro.getPreco()%></td>

<td>

<a href="?acao=editar&id=<%=livro.getId()%>">
Editar
</a>

|

<a href="?acao=excluir&id=<%=livro.getId()%>">
Excluir
</a>

</td>

</tr>

<%
}
%>

</table>

</body>
</html>