<%-- 
    Document   : search
    Created on : 30/09/2013, 01:13:52
    Author     : Marcio Ballem
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${contacts}" var="contact">
    <tr id="tr_${contact.id}">
        <td>${contact.id}</td>
        <td>${contact.firstName}</td>
        <td>${contact.lastName}</td>
        <td>${contact.age}</td>
    </tr>
</c:forEach>
