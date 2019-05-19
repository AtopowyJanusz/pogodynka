<%@ page import="services.SelectCityGenerator" %>
<%@ page import="services.ShowWeather" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css" />
    <title>Pogoda</title>

    <jsp:useBean id="apiService" class="services.OpenWeatherMapApi" scope="application"/>
    <jsp:setProperty property="city" name="apiService" param="city"/>

    <% SelectCityGenerator selectCityGenerator = new SelectCityGenerator("src/cityPL.txt"); %>

</head>
<body>
<h2>Aktualna pogoda w Polsce:</h2>
<br>
<form action="index.jsp">
    Miejsce:&nbsp
    <select name="city">
        <%=selectCityGenerator.make()%>
    </select>

    <input type="submit" value="wybierz">
</form>

<% if (apiService.getCity()!=null) {
    ShowWeather showWeather = new ShowWeather();
    out.print(showWeather.make(apiService));
} %>
</body>
</html>
