<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>

<portlet:actionURL name="/update-prenotazione" var="updatePrenotazioneURL"/>
<portlet:renderURL var="backURL">
    <portlet:param name="mvcRenderCommandName" value="/lista-prenotazioni" />
</portlet:renderURL>

<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String dataFormatted = sdf.format(((prenotazione.model.Prenotazione)request.getAttribute("prenotazione")).getData());
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modifica Prenotazione</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light p-4">
    <div class="container">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0">Modifica Prenotazione</h4>
                    </div>
                    <div class="card-body">
                        <!-- Alert per errori -->
                        <c:if test="${not empty sessionScope.errors}">
                            <div class="alert alert-danger">
                                <ul class="mb-0">
                                    <c:forEach var="error" items="${sessionScope.errors}">
                                        <li>${error}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                        
                        <!-- Messaggi di errore specifici -->
                        <liferay-ui:error key="prenotazione-non-modificabile" 
                                         message="La prenotazione non può essere modificata. È possibile modificare solo fino a 1 ora prima dell'inizio." />
                        <liferay-ui:error key="email-non-valida" 
                                         message="L'indirizzo email non è valido." />
                        <liferay-ui:error key="data-passata" 
                                         message="La data selezionata è già passata." />
                        <liferay-ui:error key="data-non-valida" 
                                         message="La data inserita non è valida." />
                        <liferay-ui:error key="ora-fine-non-valida" 
                                         message="L'ora di fine deve essere successiva all'ora di inizio." />
                        <liferay-ui:error key="orari-non-validi" 
                                         message="Gli orari inseriti non sono validi." />
                        <liferay-ui:error key="postazione-richiesta" 
                                         message="È necessario selezionare una postazione." />
                        <liferay-ui:error key="errore-aggiornamento" 
                                         message="Si è verificato un errore durante l'aggiornamento della prenotazione." />
                        
                        <div class="alert alert-info">
                            <i class="fas fa-info-circle"></i>
                            <strong>Attenzione:</strong> Le prenotazioni possono essere modificate solo fino a 1 ora prima dell'inizio.
                        </div>
                        
                        <form action="${updatePrenotazioneURL}" method="post">
                            <input type="hidden" name="<portlet:namespace/>prenotazioneId" 
                                   value="${prenotazione.prenotazioneId}">
                            
                            <div class="mb-3">
                                <label for="<portlet:namespace/>email" class="form-label">Email</label>
                                <input type="email" 
                                       class="form-control" 
                                       id="<portlet:namespace/>email" 
                                       name="<portlet:namespace/>email" 
                                       value="${prenotazione.email}" 
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="<portlet:namespace/>data" class="form-label">Data Prenotazione</label>
                                <input type="date" 
                                       class="form-control" 
                                       id="<portlet:namespace/>data" 
                                       name="<portlet:namespace/>data" 
                                       value="<%= dataFormatted %>" 
                                       required>
                            </div>
                            
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="<portlet:namespace/>oraInizio" class="form-label">Ora di Inizio</label>
                                    <input type="time" 
                                           class="form-control" 
                                           id="<portlet:namespace/>oraInizio" 
                                           name="<portlet:namespace/>oraInizio" 
                                           value="${prenotazione.oraInizio}" 
                                           required>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="<portlet:namespace/>oraFine" class="form-label">Ora di Fine</label>
                                    <input type="time" 
                                           class="form-control" 
                                           id="<portlet:namespace/>oraFine" 
                                           name="<portlet:namespace/>oraFine" 
                                           value="${prenotazione.oraFine}" 
                                           required>
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label for="<portlet:namespace/>postazioneId" class="form-label">Postazione</label>
                                <select class="form-select" 
                                        id="<portlet:namespace/>postazioneId" 
                                        name="<portlet:namespace/>postazioneId" 
                                        required>
                                    <option value="">Seleziona una postazione</option>
                                    <c:forEach var="pst" items="${postazioni}">
                                        <option value="${pst.postazioneId}" 
                                                ${pst.postazioneId eq prenotazione.postazioneId ? 'selected' : ''}>
                                            ${pst.nomePostazione}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                <a href="${backURL}" class="btn btn-secondary me-md-2">Annulla</a>
                                <button type="submit" class="btn btn-primary">Aggiorna Prenotazione</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>