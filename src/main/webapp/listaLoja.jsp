<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Loja</title>
</head>
<body>
	<ul>
		<c:forEach items="${lojas}" var="lsLoja">
			<li>
				${lsLoja.nome} - 
				${lsLoja.descricao} - 
				<fmt:formatDate value="${lsLoja.dataCadastro}" pattern="dd/MM/yyyy"/>
				<a href="formEditaLoja.html"><button>Editar</button></a>
				<a href="formExcluiLoja.html"><button>Excluir</button></a>
			</li>
		</c:forEach>
		
		<a href="formCadastraLoja.html">
			<button>Cadastrar</button>
		</a>
	</ul>
</body>
</html>