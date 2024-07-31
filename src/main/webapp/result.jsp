<%@ page import="java.util.List" %>
<%@ page import="com.dev.sunny.beerapp.model.Beer" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Beer Advisor - Recommendations</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>

<body>
    <div class="jumbotron bg-dark text-white">
        <h1 class="display-1">Beer Recommendations</h1>
        <p class="tagline">Fill your bellies with some cold stuff!</p>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h4 class="display-4">Here are some recommendations:</h4>
                <ul class="list-group list-group-flush">
                    <%
                        List<Beer> brands = (List<Beer>) request.getAttribute("brands");
                        for (Beer brand : brands) {
                    %>
                        <li class="list-group-item">
                            <%= brand.getName() %> - $<%= brand.getPrice() %> - <% if (brand.isAvailable()) { %>Available<% } else { %>Not Available<% } %>
                        </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
