<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.crud.Livro"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário</title>		
</head>
<body>

<%

Livro livro = (Livro) request.getAttribute("livro");

boolean editar = livro != null;

%>

<h1>

<%= editar ? "Editar Livro" : "Novo Livro" %>

</h1>

<form action="<%=request.getContextPath()%>/" method="get">

<input type="hidden" name="acao"
value="<%= editar ? "atualizar" : "inserir" %>">

<%

if(editar){

%>

<input type="hidden" name="id"
value="<%=livro.getId()%>">

<%
}
%>

Título:

<input type="text" name="titulo"

value="<%= editar ? livro.getTitulo() : "" %>">

<br><br>

Autor:

<input type="text" name="autor"

value="<%= editar ? livro.getAutor() : "" %>">

<br><br>

Preço:

<input type="text" name="preco"

value="<%= editar ? livro.getPreco() : "" %>">

<br><br>

<button type="submit">
Salvar
</button>

</form>

</body>
</html>