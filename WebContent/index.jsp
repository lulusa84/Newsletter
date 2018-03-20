<jsp:useBean id="lista2" class="connessione.Connessione" scope="session"></jsp:useBean>
<jsp:useBean id="main" class="login.Test" scope="session"></jsp:useBean>
<jsp:useBean id="utente" class="login.Utente" scope="session"></jsp:useBean>
<jsp:useBean id="lista" class="login.ListaUtente" scope="session"></jsp:useBean>
<jsp:useBean id="userDAO" class="login.UtenteDao" scope="request"></jsp:useBean>

<%@page import="login.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<hr> NEWSLETTER LOGIN </hr> <br></br>
  
	
	<form action="http://localhost:9080/JB/login/doRegistrati.jsp" method="post">
		<input type="text" name="nome" placeholder="Inserisci nome" oninput="document.getElementById('1').style.display='none'"; />
		<input type="password" name="password" placeholder="Inserisci password" />
		<input type="email" name="email" placeholder="Inserisci email" />
		<input type="submit" value="REGISTRATI" id="rg"/>
	</form>
	
 
 
 <p id="1">
 <% 
 
 String nome = request.getParameter("nome");
 String email = request.getParameter("email");
 String password = request.getParameter("password");
 String esito = "";
 esito = request.getParameter(esito.toString());
 if(esito =="true"){
	 out.print("ok, sei registrato al servizio newsletter");
    }
    else 
	out.print("impossibile procedere alla registrazione utente già presente");
  %>
</p>


   <table> 
   <thead id="thead">
   <tr>
   <th align=left>nome</th>
   <th>email</th>
   <th>password</th>
   </tr>
   </thead>
   <%
		int i = 0;
   
		for(; i < lista.getLista().size(); i++ ){
			
			out.println("<tr>");
			out.print("<td>" + lista.getLista().get(i).getNome() + " " + "</td>");
			out.print("<td>" + lista.getLista().get(i).getEmail() + " " + "</td>");
			out.print("<td>" + lista.getLista().get(i).getPassword() + " " +"</td>" );
			
			 nome = lista.getLista().get(i).getNome();
			 password = lista.getLista().get(i).getPassword();
			 password = lista.getLista().get(i).getEmail();
			 
	%>
	
     <
    
    <%
	
	}
	
	%>
	</table>
	<
	
 <jsp:include page="footer.jsp"></jsp:include>     
	
</body>
</html>