<%@ page import="lp2a4.controller.CommandEnum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Configurar o escopo com request permite receber o atributo colocado no request -->
<!-- o id deve ter o mesmo nome do atributo configurado no request -->
<jsp:useBean id="aluno" class="lp2a4.modelo.AlunoPOJO" scope="request"></jsp:useBean>

<form id="create_form" action="./controller" method="post">
	<input type="hidden" name="acao" id="acao" value="<%=CommandEnum.CREATE%>"/>
	<!-- <input type="hidden" name="matricula" id="matricula" value="<jsp:getProperty property="matricula" name="aluno"/>"/> -->
	<table border="1">
		<tr>
			<td>Matrícula : </td>
			<td>
			<input class="edicao" type="text" id="matricula" name="matricula"/>
			</td>
		</tr>
		<tr>
			<td>Nome : </td>
			<td>
				<input class="edicao" type="text" id="nome" name="nome"/>
			</td>
		</tr>
		<tr>
			<td>Endereço : </td>
			<td>
				<input class="edicao" type="text" id="endereco" name="endereco"/>
			</td>
		</tr>
		<tr>
			<td>Data Ingresso (dd/mm/aaaa) : </td>
			<td>
				<input class="edicao" type="text" id="dataIngresso" name="dataIngresso"/>
			</td>
		</tr>
		<tr>
			<td>Data Término (dd/mm/aaaa) : </td>
			<td>
				<input class="edicao" type="text" id="dataConclusao" name="dataConclusao"/>
			</td>
		</tr>
	</table>
	<input type="submit" value="Confirmar criação!"/>
</form>
</body>
</html>