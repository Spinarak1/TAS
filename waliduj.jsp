<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Użycie tagu jsp:useBean. Tag ten szuka obiektu klasy User z pakiecie
	javastart.jspexample.model w sesji użytkownika. Jeśli znajdzie, to go 
	wykorzysta, jeśli nie stworzy nowy obiekt klasy user o nazwie "user"-->
	<jsp:useBean id="user" class="com.packt.project1.controller.User"
		scope="session"></jsp:useBean>

	<!-- Użycie tagu jsp:setProperty. Tag ten umieszcza wszystkie parametry
	przesyłane z innych plików jsp pasujące do obiektu o nazwie user. Jeśli
	parametry te nie będą się zgadzać, tomcat wyrzuci wyjątkiem -->
	<jsp:setProperty property="*" name="user" />

	<!-- Ponowne użycie tagu jsp:useBean ładujący źródło danych. -->
	<jsp:useBean id="dataSource"
		class="com.packt.project1.controller.DataSource" scope="session"></jsp:useBean>

	<!-- Wyświetlenie nazwy użytkownika. -->
	Nazwa: <%= user.getName() %><br />

	<!-- Logika sprawdzająca poprawność parametrów logowania. -->
	<% String result = "Dane niepoprawne";

	if(dataSource.userExists(user)) {
		result = "Poprawny użytkownik oraz hasło";
		}
	%>

	<!-- Zwrócenie wynikowego stringa "result" -->
	<%= result %>
</body>
</html>