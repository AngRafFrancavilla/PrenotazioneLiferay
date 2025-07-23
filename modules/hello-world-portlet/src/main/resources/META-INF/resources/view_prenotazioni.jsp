<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>

<div class="container mt-4">
    <h2>Elenco Prenotazioni</h2>
    
    <!-- Messaggi di successo -->
    <liferay-ui:success key="prenotazione-aggiornata" 
                       message="Prenotazione aggiornata con successo!" />
    
    <!-- Messaggi di errore -->
    <liferay-ui:error key="prenotazione-non-trovata" 
                     message="Prenotazione non trovata." />
    <liferay-ui:error key="prenotazione-non-modificabile" 
                     message="La prenotazione non può essere modificata. È possibile modificare solo fino a 1 ora prima dell'inizio." />

    <!-- Form di ricerca -->
    <portlet:renderURL var="searchURL">
        <portlet:param name="mvcRenderCommandName" value="/lista-prenotazioni" />
    </portlet:renderURL>

    <form action="${searchURL}" method="post" class="mb-4">
        <div class="row">
            <!-- Ricerca per postazione -->
            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>postazioneFilter">Postazione</label>
                <select class="form-control" name="<portlet:namespace/>postazioneFilter" id="<portlet:namespace/>postazioneFilter">
                    <option value="">Tutte le postazioni</option>
                    <c:forEach items="${postazioni}" var="pst">
                        <option value="${pst.postazioneId}" ${postazioneFilter eq pst.postazioneId ? 'selected' : ''}>
                            ${pst.nomePostazione}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <!-- Data inizio -->
            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>dataFilterDa">Data DA</label>
                <input type="date" class="form-control" name="<portlet:namespace/>dataFilterDa" id="<portlet:namespace/>dataFilterDa" value="${dataFilterDa}">
            </div>

            <!-- Data fine -->
            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>dataFilterA">Data A</label>
                <input type="date" class="form-control" name="<portlet:namespace/>dataFilterA" id="<portlet:namespace/>dataFilterA" value="${dataFilterA}">
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <button type="submit" class="btn btn-primary">Cerca</button>
                <a href="${searchURL}" class="btn btn-secondary">Reset</a>
            </div>
        </div>
    </form>

    <!-- Risultati ricerca -->
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Data</th>
                    <th>Ora Inizio</th>
                    <th>Ora Fine</th>
                    <th>Postazione</th>
                    <th>Azioni</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${prenotazioni}" var="prenotazione">
                    <tr>
                        <td>${prenotazione.email}</td>
                        <td>
                            <fmt:formatDate value="${prenotazione.data}" pattern="dd/MM/yyyy"/>
                        </td>
                        <td>${prenotazione.oraInizio}</td>
                        <td>${prenotazione.oraFine}</td>
                        <td>
                            <c:forEach items="${postazioni}" var="pst">
                                <c:if test="${pst.postazioneId eq prenotazione.postazioneId}">
                                    ${pst.nomePostazione}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <%
                                // Calcolo per determinare se la prenotazione è modificabile
                                prenotazione.model.Prenotazione pren = (prenotazione.model.Prenotazione) pageContext.getAttribute("prenotazione");
                                boolean modificabile = false;
                                
                                try {
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    
                                    String dataStr = dateFormat.format(pren.getData());
                                    String dataOraInizio = dataStr + " " + pren.getOraInizio();
                                    
                                    Date dataOraInizioPren = sdf.parse(dataOraInizio);
                                    Date now = new Date();
                                    
                                    long differenza = dataOraInizioPren.getTime() - now.getTime();
                                    long oreRimanenti = differenza / (1000 * 60 * 60);
                                    
                                    modificabile = oreRimanenti >= 1;
                                } catch (Exception e) {
                                    modificabile = false;
                                }
                                
                                pageContext.setAttribute("modificabile", modificabile);
                            %>
                            
                            <c:choose>
                                <c:when test="${modificabile}">
                                    <portlet:renderURL var="editURL">
                                        <portlet:param name="mvcRenderCommandName" value="/edit-prenotazione" />
                                        <portlet:param name="prenotazioneId" value="${prenotazione.prenotazioneId}" />
                                    </portlet:renderURL>
                                    <a href="${editURL}" class="btn btn-sm btn-primary">
                                        <i class="fas fa-edit"></i> Modifica
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-secondary">Non modificabile</span>
                                    <small class="text-muted d-block">
                                        (Modificabile fino a 1 ora prima dell'inizio)
                                    </small>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <c:if test="${empty prenotazioni}">
            <div class="alert alert-info">
                Nessuna prenotazione trovata con i filtri selezionati.
            </div>
        </c:if>
    </div>
</div>