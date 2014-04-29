<%-- 
    Document   : contact
    Created on : 30/09/2013, 00:10:04
    Author     : Marcio Ballem
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Spring MVC and Ajax : Contact</title>

        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

        <script src="<c:url value="/resources/js/contact.js"/>"></script>

    </head>
    <body>
        <div id="container">
            <h2>Find Contact By Name</h2>
            <div>
                <label for="firstInput">First Name</label>
                <input type="text" name="firstName" id="firstInput"/>
            </div>
            <div>
                <label for="lastInput">Last Name</label>
                <input type="text" name="lastName" id="lastInput"/>
            </div>
            <div id="theJson"></div>
            <button type="button" id="button">Find</button>

            <h2>Submit new Contact</h2>
            <form id="saveContact">
                <div>
                    <label for="firstNameInput">First Name</label>
                    <input type="text" name="firstName" id="firstNameInput" />
                </div>
                <div>
                    <label for="lastNameInput">Last Name</label>
                    <input type="text" name="lastName" id="lastNameInput"  />
                </div>
                <div>
                    <label for="ageInput">Age</label>
                    <input type="text" name="age" id="ageInput" />
                </div>

                <div><input id="submit" type="submit" value="Save Contact"></div>
            </form>

            <br><br>
            <h2>Table Contact</h2>
            <table id="contactTableResponse" class="table tr">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Age</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th scope="row">Spring-Ajax</th>
                        <td colspan="4">JQuery Ajax</td>
                    </tr>
                </tfoot>
                <tbody>
                    <c:forEach items="${contacts}" var="contact">
                        <tr>
                            <td>${contact.id}</td>
                            <td>${contact.firstName}</td>
                            <td>${contact.lastName}</td>
                            <td>${contact.age}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <a href="/spring-ajax/contact/load">JQuery By Load Method</a>
    </body>
</html>
