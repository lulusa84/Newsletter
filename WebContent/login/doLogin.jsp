<jsp:useBean id="lista" class="connessione.Connessione" scope="session"></jsp:useBean>
<jsp:useBean id="main" class="login.Test" scope="session"></jsp:useBean>

<%
 
String nome = request.getParameter("nome");
String password = request.getParameter("password");


main.selezionaUtente(nome, password);


if(main.selezionaUtente(nome, password) == true){
	session.setAttribute("utente",nome);
	session.setAttribute("password",password);

	response.sendRedirect("./gioco/gioco.jsp");
//	out.print("ciao");
}
else{
response.sendRedirect("../index.jsp");
//out.print("ciao");
}
%>

