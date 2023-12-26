<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Simple Song Site</title>
</head>
<body>
    <!-- Include Header Section -->
    <%@ include file="header.html"%>

    <!-- Heading and Separation Line -->
    <h3>Welcome to Simple Song Service</h3>
    <br>
    <hr>

    <!-- JSP UseBean Tag: Declare or Locate JavaBean -->
    <jsp:useBean id="user" class="com.music.model.User"></jsp:useBean>

    <!-- JSP SetProperty Tags: Set Properties from Request Parameters -->
    <jsp:setProperty name="user" property="userName" param="name" />
    <jsp:setProperty name="user" property="ip" />

    <!-- Display User Information Using JSP GetProperty Tags -->
    <p>
        Welcome
        <jsp:getProperty name="user" property="userName" /><br />
        I see your IP Address is:
        <jsp:getProperty name="user" property="ip" />
    </p>

    <!-- Declaration Section: Define a Discount Code and Method -->
    <%!
        private String discountCode = "VIPCUST10";

        private String getDiscountCode() {
            return discountCode;
        }
    %>

    <!-- Display Discount Code Using Java Code in HTML -->
    <div>
        Use this code to get an additional 10% discount:
        <h4><%=getDiscountCode()%></h4>
    </div>

    <!-- HTML Link: Navigate to SongServlet -->
    <a href="SongServlet">Show All Songs</a>

</body>
</html>
