<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container mt-4">
    <h2>Elenco Prenotazioni</h2>
    
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Email</th>
                <th>Data</th>
                <th>Ora Inizio</th>
                <th>Ora Fine</th>
                <th>Postazione</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${prenotazioni}" var="pren">
                <tr>
                    <td>${pren.email}</td>
                    <td><fmt:formatDate value="${pren.data}" pattern="dd/MM/yyyy"/></td>
                    <td>${pren.oraInizio}</td>
                    <td>${pren.oraFine}</td>
                    <td>${pren.postazioneId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <a href="<portlet:renderURL />" class="btn btn-primary">
        Torna alla Home
    </a>
</div>