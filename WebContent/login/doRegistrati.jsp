<jsp:useBean id="utente" class="login.Utente" scope="session" />
<!--<jsp:setProperty name="utente" property="*" />-->
<jsp:useBean id="userDAO" class="login.UtenteDao" scope="request"></jsp:useBean>
<jsp:useBean id="lista" class="login.ListaUtente" scope="session" />
<%
     String nome =request.getParameter("nome");
     String password = request.getParameter("password");
     String email = request.getParameter("email");
     Boolean esito = true;
     
	if(userDAO.aggiungi(utente)){
		
		response.sendRedirect( "../index.jsp" );
		esito = true;
	}
	else		
		response.sendRedirect( "../index.jsp?" );
	    esito = false;
%> 