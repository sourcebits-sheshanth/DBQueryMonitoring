<%@ page import="com.db.*"%>
<%@ page import="com.entity.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.json.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mysql.jdbc.*"%>
<%@ page import=" java.lang.String"%>

<html>
<head>
<title>City Details</title>
</head>
<body>

	DB Records :
	<%
	List<City> resp = com.db.JDBCExample.getDBDetails();
%>

	<TABLE BORDER="1">
		<TR>
			<TH>ID</TH>
			<TH>CityName</TH>
			<TH>State</TH>
			<TH>Country</TH>
			<TH>Map</TH>
		</TR>
		<%
			for (int i = 0; i < resp.size(); i++) {
		%>
		<TR>
			<TD><%=resp.get(i).getId()%></td>
			<TD><%=resp.get(i).getName()%></TD>
			<TD><%=resp.get(i).getState()%></TD>
			<TD><%=resp.get(i).getCountry()%></TD>
			<TD><%=resp.get(i).getMap()%></TD>
		</TR>
		<%
			}
		%>
	</TABLE>
</body>
</html>