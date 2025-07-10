<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
%>

<portlet:actionURL name="/prenotazione" var="prenotazioneActionURL"/>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Form Orari</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light p-4">

  <div class="container">
    <h2 class="mb-4">Prenota Postazione</h2>

    <!-- ALERT ERRORI -->
    <%
      if (SessionErrors.contains(request, "data-passata")) {
    %>
      <div class="alert alert-danger" role="alert">
        La data selezionata è già passata.
      </div>
    <%
      }
      if (SessionErrors.contains(request, "ora-inizio-passata")) {
    %>
      <div class="alert alert-danger" role="alert">
        L'ora di inizio deve essere uguale o successiva all'ora attuale.
      </div>
    <%
      }
      if (SessionErrors.contains(request, "ora-fine-non-valida")) {
    %>
      <div class="alert alert-danger" role="alert">
        L'ora di fine deve essere successiva all'ora di inizio.
      </div>
    <%
      }
    %>
<div class="mb-4 text-end">
    <a href="<portlet:renderURL>
        <portlet:param name="mvcRenderCommandName" value="/lista-prenotazioni"/>
    </portlet:renderURL>" 
    class="btn btn-info">
        Visualizza Tutte le Prenotazioni
    </a>
</div>
 
    <form action="${prenotazioneActionURL}" method="post">
      <div class="mb-3">
        <label for="<portlet:namespace/>email" class="form-label">Inserisci Email</label>
        <input type="email" class="form-control" id="<portlet:namespace/>email" name="<portlet:namespace/>email" required>
      </div>

      <div class="mb-3">
        <label for="<portlet:namespace/>data" class="form-label">Data Prenotazione</label>
        <input type="date" class="form-control" id="<portlet:namespace/>data" name="<portlet:namespace/>data" required min="<%= today %>">
      </div>

      <div class="row">
        <div class="col-md-6 mb-3">
          <label for="<portlet:namespace/>oraInizio" class="form-label">Ora di Entrata</label>
          <input type="time" class="form-control" id="<portlet:namespace/>oraInizio" name="<portlet:namespace/>oraInizio" required>
        </div>
        <div class="col-md-6 mb-3">
          <label for="<portlet:namespace/>oraFine" class="form-label">Ora di Uscita</label>
          <input type="time" class="form-control" id="<portlet:namespace/>oraFine" name="<portlet:namespace/>oraFine" required>
        </div>
      </div>

      <div class="mb-3">
        <label for="<portlet:namespace/>postazioneId" class="form-label">ID Postazione</label>
<select class="form-select" id="<portlet:namespace/>postazioneId" name="<portlet:namespace/>postazioneId" required>
  <option value="">Seleziona una postazione</option>
  <c:forEach var="pst" items="${postazioni}">
    <option value="${pst.postazioneId}">${pst.nomePostazione}</option>
  </c:forEach>
</select>

      </div>

      <button type="submit" class="btn btn-primary">Invia</button>
      <button type="reset" class="btn btn-secondary">Reset</button>
    </form>

  </div>

</body>
