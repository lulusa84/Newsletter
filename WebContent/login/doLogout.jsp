<%

session.setAttribute("utente",null);
session.setAttribute("password",null);
session.invalidate();
response.sendRedirect("index.jsp");
%>


