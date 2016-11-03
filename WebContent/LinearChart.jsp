<%@ page import="com.db.*"%>
<%@ page import="com.entity.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.json.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mysql.jdbc.*"%>
<%@ page import=" java.lang.String"%>

<html>
<head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	<%
	JSONArray resp = com.db.JDBCExample.getPopulationDetails();
%>
	
	
	
	function drawChart() {

		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('number', 'year');
		data.addColumn('number', 'humans');
		<% for(int idx =0 ; idx<resp.length(); idx++ ) 
		 { 
		 
			    JSONObject object = resp.getJSONObject(idx);
			    int id = object.getInt("id");
			    int year = object.getInt("year");
			    int humans = object.getInt("humans");
			    
			    System.out.println( id + " : " + year + " : " + humans);
		 
		 %>
		data.addRow(
		               [<%=year%> , <%=humans%>]
		)
		<%}%>
		var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
	                       { calc: "stringify",
	                         sourceColumn: 0,
	                         type: "string",
	                         role: "annotation" }]);
		// Set chart options
var options = {
        title: 'World Population in Log Scale',
        legend: 'none',
        width: 450,
        height: 500,
         hAxis: {
          title: 'Date',
          scaleType: 'log'
        },
        vAxis: {
          title: 'Population (millions)',
          scaleType: 'log'
          
        }
      };
		// Instantiate and draw our chart, passing in some options.
		//var chart = new google.charts.Bar(document.getElementById("chart_div"));
		var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>



</head>
<body>
	<b>Chart : </b>

	<div id="chart_div"></div>

	<br>




</body>
</html>