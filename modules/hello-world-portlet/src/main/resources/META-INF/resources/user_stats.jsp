<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="java.text.DecimalFormat" %>

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Statistiche Utenti - Anno ${annoCorrente}</h2>
        <div>
            <portlet:renderURL var="homeURL">
                <portlet:param name="mvcRenderCommandName" value="/" />
            </portlet:renderURL>
            <a href="${homeURL}" class="btn btn-secondary me-2">
                <i class="fas fa-home"></i> Home
            </a>
            
            <portlet:renderURL var="prenotazioniURL">
                <portlet:param name="mvcRenderCommandName" value="/lista-prenotazioni" />
            </portlet:renderURL>
            <a href="${prenotazioniURL}" class="btn btn-info">
                <i class="fas fa-calendar"></i> Prenotazioni
            </a>
        </div>
    </div>
    
    <div class="alert alert-info mb-4">
        <div class="row">
            <div class="col-md-3">
                <strong>Anno corrente:</strong> ${annoCorrente}
            </div>
            <div class="col-md-3">
                <strong>Giorni trascorsi:</strong> ${giornoAnno}
            </div>
            <div class="col-md-3">
                <strong>Giorni totali:</strong> ${giorniTotaliAnno}
                <c:if test="${bisestile}">
                    <span class="badge bg-warning">Bisestile</span>
                </c:if>
            </div>
            <div class="col-md-3">
                <strong>Utenti totali:</strong> ${userStatsList.size()}
            </div>
        </div>
    </div>


    <div class="card mb-4">
        <div class="card-header">
            <h5 class="mb-0">Legenda Calcolo Percentuali</h5>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-6">
                    <strong>Percentuale ad oggi:</strong><br>
                    <small class="text-muted">
                        (Numero prenotazioni / Giorni trascorsi dal 1° gennaio) × 100
                    </small>
                </div>
                <div class="col-md-6">
                    <strong>Percentuale nell'anno:</strong><br>
                    <small class="text-muted">
                        (Numero prenotazioni / Giorni totali nell'anno) × 100
                    </small>
                </div>
            </div>
        </div>
    </div>

    <!-- Tabella utenti -->
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>
                        <portlet:renderURL var="sortNomeURL">
                            <portlet:param name="mvcRenderCommandName" value="/user-stats" />
                            <portlet:param name="orderByCol" value="nome" />
                            <portlet:param name="orderByType" value="asc" />
                        </portlet:renderURL>
                        <a href="${sortNomeURL}" class="text-white text-decoration-none">
                            Nome <i class="fas fa-sort"></i>
                        </a>
                    </th>
                    <th>
                        <portlet:renderURL var="sortCognomeURL">
                            <portlet:param name="mvcRenderCommandName" value="/user-stats" />
                            <portlet:param name="orderByCol" value="cognome" />
                            <portlet:param name="orderByType" value="asc" />
                        </portlet:renderURL>
                        <a href="${sortCognomeURL}" class="text-white text-decoration-none">
                            Cognome <i class="fas fa-sort"></i>
                        </a>
                    </th>
                    <th>
                        <portlet:renderURL var="sortEmailURL">
                            <portlet:param name="mvcRenderCommandName" value="/user-stats" />
                            <portlet:param name="orderByCol" value="email" />
                            <portlet:param name="orderByType" value="asc" />
                        </portlet:renderURL>
                        <a href="${sortEmailURL}" class="text-white text-decoration-none">
                            Email <i class="fas fa-sort"></i>
                        </a>
                    </th>
                    <th>
                        <portlet:renderURL var="sortPrenotazioniURL">
                            <portlet:param name="mvcRenderCommandName" value="/user-stats" />
                            <portlet:param name="orderByCol" value="numeroPrenotazioni" />
                            <portlet:param name="orderByType" value="desc" />
                        </portlet:renderURL>
                        <a href="${sortPrenotazioniURL}" class="text-white text-decoration-none">
                            N° Prenotazioni <i class="fas fa-sort"></i>
                        </a>
                    </th>
                    <th>
                        <portlet:renderURL var="sortPercAdOggiURL">
                            <portlet:param name="mvcRenderCommandName" value="/user-stats" />
                            <portlet:param name="orderByCol" value="percentualeAdOggi" />
                            <portlet:param name="orderByType" value="desc" />
                        </portlet:renderURL>
                        <a href="${sortPercAdOggiURL}" class="text-white text-decoration-none">
                            % Ad Oggi <i class="fas fa-sort"></i>
                        </a>
                    </th>
                    <th>
                        <portlet:renderURL var="sortPercAnnoURL">
                            <portlet:param name="mvcRenderCommandName" value="/user-stats" />
                            <portlet:param name="orderByCol" value="percentualeNellAnno" />
                            <portlet:param name="orderByType" value="desc" />
                        </portlet:renderURL>
                        <a href="${sortPercAnnoURL}" class="text-white text-decoration-none">
                            % Nell'Anno <i class="fas fa-sort"></i>
                        </a>
                    </th>
                    <th>Azioni</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userStatsList}" var="userStats">
                    <tr>
                        <td>${userStats.nome}</td>
                        <td>${userStats.cognome}</td>
                        <td>
                            <small>${userStats.email}</small>
                        </td>
                        <td>
                            <span class="badge bg-primary">${userStats.numeroPrenotazioni}</span>
                        </td>
                        <td>
                            <%
                                DecimalFormat df = new DecimalFormat("#.##");
                                com.example.portlet.rendercommand.UserStatsRenderCommand.UserStats stats = 
                                    (com.example.portlet.rendercommand.UserStatsRenderCommand.UserStats) pageContext.getAttribute("userStats");
                                String percAdOggiStr = df.format(stats.getPercentualeAdOggi());
                                pageContext.setAttribute("percAdOggiStr", percAdOggiStr);
                                
                                // Determina il colore del badge in base alla percentuale
                                double percAdOggi = stats.getPercentualeAdOggi();
                                String badgeClass = "bg-secondary";
                                if (percAdOggi >= 80) badgeClass = "bg-success";
                                else if (percAdOggi >= 60) badgeClass = "bg-warning";
                                else if (percAdOggi >= 40) badgeClass = "bg-info";
                                else if (percAdOggi > 0) badgeClass = "bg-danger";
                                pageContext.setAttribute("badgeClassAdOggi", badgeClass);
                            %>
                            <span class="badge ${badgeClassAdOggi}">${percAdOggiStr}%</span>
                        </td>
                        <td>
                            <%
                                String percAnnoStr = df.format(stats.getPercentualeNellAnno());
                                pageContext.setAttribute("percAnnoStr", percAnnoStr);
                                
                                // Determina il colore del badge in base alla percentuale
                                double percAnno = stats.getPercentualeNellAnno();
                                String badgeClassAnno = "bg-secondary";
                                if (percAnno >= 80) badgeClassAnno = "bg-success";
                                else if (percAnno >= 60) badgeClassAnno = "bg-warning";
                                else if (percAnno >= 40) badgeClassAnno = "bg-info";
                                else if (percAnno > 0) badgeClassAnno = "bg-danger";
                                pageContext.setAttribute("badgeClassAnno", badgeClassAnno);
                            %>
                            <span class="badge ${badgeClassAnno}">${percAnnoStr}%</span>
                        </td>
                        <td>
                            <portlet:renderURL var="detailsURL">
                                <portlet:param name="mvcRenderCommandName" value="/user-details" />
                                <portlet:param name="email" value="${userStats.email}" />
                            </portlet:renderURL>
                            <a href="${detailsURL}" class="btn btn-sm btn-outline-primary" title="Visualizza dettagli">
                                <i class="fas fa-eye"></i> Dettagli
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <c:if test="${empty userStatsList}">
            <div class="alert alert-warning text-center">
                <i class="fas fa-info-circle"></i> 
                Nessun utente trovato con prenotazioni nell'anno ${annoCorrente}.
            </div>
        </c:if>
    </div>
</div>

<!-- Script per migliorare l'interfaccia -->
<script>
document.addEventListener('DOMContentLoaded', function() {
    // Aggiungi tooltip per le percentuali
    const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    const tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });
});
</script>