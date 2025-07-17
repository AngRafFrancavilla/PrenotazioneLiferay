<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<div class="container mt-4">
    <h2>Elenco Prenotazioni</h2>

    <!-- Form di ricerca -->
    <portlet:renderURL var="searchURL">
        <portlet:param name="mvcRenderCommandName" value="/lista-prenotazioni" />
    </portlet:renderURL>

    <form action="${searchURL}" method="post" class="mb-4">
        <div class="row">
            <!--ricerca per postazione -->
            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>postazioneFilter">Postazione</label>
                <select class="form-control" name="<portlet:namespace/>postazioneFilter" id="<portlet:namespace/>postazioneFilter">
                    <option value="">Tutte le postazioni</option>
                    <c:forEach items="${postazioni}" var="pst">
                        <option value="${pst.postazioneId}"
                            ${postazioneFilter eq pst.postazioneId ? 'selected' : ''}>
                            ${pst.nomePostazione}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <!-- data inizio -->
            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>dataFilterDa">Data DA</label>
                <input type="date" class="form-control"
                    name="<portlet:namespace/>dataFilterDa" id="<portlet:namespace/>dataFilterDa"
                    value="${dataFilterDa}">
            </div>

            <!-- data fine -->
            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>dataFilterA">Data A</label>
                <input type="date" class="form-control"
                    name="<portlet:namespace/>dataFilterA" id="<portlet:namespace/>dataFilterA"
                    value="${dataFilterA}">
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <button type="submit" class="btn btn-primary">Cerca</button>
                <a href="${searchURL}" class="btn btn-secondary">Reset</a>
            </div>
        </div>
    </form>

    <!-- risultati ricerc -->
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Data</th>
                    <th>Ora Inizio</th>
                    <th>Ora Fine</th>
                    <th>Postazione</th>
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