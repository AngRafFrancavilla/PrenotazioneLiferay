<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="java.text.DecimalFormat" %>

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Dettagli Utente - ${nome} ${cognome}</h2>
        <div>
            <portlet:renderURL var="backURL">
                <portlet:param name="mvcRenderCommandName" value="/user-stats" />
            </portlet:renderURL>
            <a href="${backURL}" class="btn btn-secondary">
                <i class="fas fa-arrow-left"></i> Torna alla Lista
            </a>
        </div>
    </div>

    <!-- Card informazioni utente -->
    <div class="row mb-4">
        <div class="col-lg-8">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0"><i class="fas fa-user"></i> Informazioni Utente</h5>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Nome:</strong> ${nome}</p>
                            <p><strong>Cognome:</strong> ${cognome}</p>
                            <p><strong>Email:</strong> ${email}</p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Anno:</strong> ${annoCorrente}</p>
                            <p><strong>Giorni trascorsi:</strong> ${giorniTrascorsi}</p>
                            <p><strong>Giorni totali anno:</strong> ${giorniTotaliAnno}
                                <c:if test="${bisestile}">
                                    <span class="badge bg-warning">Bisestile</span>
                                </c:if>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="col-lg-4">
            <div class="card">
                <div class="card-header bg-success text-white">
                    <h5 class="mb-0"><i class="fas fa-chart-pie"></i> Statistiche</h5>
                </div>
                <div class="card-body text-center">
                    <div class="mb-3">
                        <h3 class="text-primary">${numeroPrenotazioni}</h3>
                        <small class="text-muted">Prenotazioni totali</small>
                    </div>
                    
                    <%
                        DecimalFormat df = new DecimalFormat("#.##");
                        Double percAdOggi = (Double) request.getAttribute("percentualeAdOggi");
                        Double percAnno = (Double) request.getAttribute("percentualeNellAnno");
                        
                        String percAdOggiStr = df.format(percAdOggi);
                        String percAnnoStr = df.format(percAnno);
                        
                        pageContext.setAttribute("percAdOggiStr", percAdOggiStr);
                        pageContext.setAttribute("percAnnoStr", percAnnoStr);
                        
                        // Colori per le percentuali
                        String colorAdOggi = percAdOggi >= 80 ? "success" : 
                                           percAdOggi >= 60 ? "warning" : 
                                           percAdOggi >= 40 ? "info" : 
                                           percAdOggi > 0 ? "danger" : "secondary";
                        
                        String colorAnno = percAnno >= 80 ? "success" : 
                                         percAnno >= 60 ? "warning" : 
                                         percAnno >= 40 ? "info" : 
                                         percAnno > 0 ? "danger" : "secondary";
                        
                        pageContext.setAttribute("colorAdOggi", colorAdOggi);
                        pageContext.setAttribute("colorAnno", colorAnno);
                    %>
                    
                    <div class="row">
                        <div class="col-6">
                            <h4 class="text-${colorAdOggi}">${percAdOggiStr}%</h4>
                            <small class="text-muted">% ad oggi</small>
                        </div>
                        <div class="col-6">
                            <h4 class="text-${colorAnno}">${percAnnoStr}%</h4>
                            <small class="text-muted">% nell'anno</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Tabella prenotazioni -->
    <div class="card">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0"><i class="fas fa-calendar-alt"></i> Prenotazioni ${annoCorrente}</h5>
            <span class="badge bg-primary">${numeroPrenotazioni} prenotazioni</span>
        </div>
        <div class="card-body">
            <c:if test="${not empty prenotazioniUtente}">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>
                                    <portlet:renderURL var="sortDataURL">
                                        <portlet:param name="mvcRenderCommandName" value="/user-details" />
                                        <portlet:param name="email" value="${email}" />
                                        <portlet:param name="orderByCol" value="data" />
                                        <portlet:param name="orderByType" value="desc" />
                                    </portlet:renderURL>
                                    <a href="${sortDataURL}" class="text-white text-decoration-none">
                                        Data <i class="fas fa-sort"></i>
                                    </a>
                                </th>
                                <th>
                                    <portlet:renderURL var="sortOraInizioURL">
                                        <portlet:param name="mvcRenderCommandName" value="/user-details" />
                                        <portlet:param name="email" value="${email}" />
                                        <portlet:param name="orderByCol" value="oraInizio" />
                                        <portlet:param name="orderByType" value="asc" />
                                    </portlet:renderURL>
                                    <a href="${sortOraInizioURL}" class="text-white text-decoration-none">
                                        Ora Inizio <i class="fas fa-sort"></i>
                                    </a>
                                </th>
                                <th>
                                    <portlet:renderURL var="sortOraFineURL">
                                        <portlet:param name="mvcRenderCommandName" value="/user-details" />
                                        <portlet:param name="email" value="${email}" />
                                        <portlet:param name="orderByCol" value="oraFine" />
                                        <portlet:param name="orderByType" value="asc" />
                                    </portlet:renderURL>
                                    <a href="${sortOraFineURL}" class="text-white text-decoration-none">
                                        Ora Fine <i class="fas fa-sort"></i>
                                    </a>
                                </th>
                                <th>
                                    <portlet:renderURL var="sortPostazioneURL">
                                        <portlet:param name="mvcRenderCommandName" value="/user-details" />
                                        <portlet:param name="email" value="${email}" />
                                        <portlet:param name="orderByCol" value="postazioneId" />
                                        <portlet:param name="orderByType" value="asc" />
                                    </portlet:renderURL>
                                    <a href="${sortPostazioneURL}" class="text-white text-decoration-none">
                                        Postazione <i class="fas fa-sort"></i>
                                    </a>
                                </th>
                                <th>Durata</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${prenotazioniUtente}" var="prenotazione" varStatus="status">
                                <tr class="${status.index % 2 == 0 ? '' : 'table-light'}">
                                    <td>
                                        <fmt:formatDate value="${prenotazione.data}" pattern="dd/MM/yyyy"/>
                                        <br>
                                        <small class="text-muted">
                                            <fmt:formatDate value="${prenotazione.data}" pattern="EEEE" var="dayName"/>
                                            ${dayName}
                                        </small>
                                    </td>
                                    <td>
                                        <span class="badge bg-info">${prenotazione.oraInizio}</span>
                                    </td>
                                    <td>
                                        <span class="badge bg-warning">${prenotazione.oraFine}</span>
                                    </td>
                                    <td>
                                        <c:forEach items="${postazioni}" var="pst">
                                            <c:if test="${pst.postazioneId eq prenotazione.postazioneId}">
                                                <span class="badge bg-secondary">${pst.nomePostazione}</span>
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <%
                                            // Calcolo durata prenotazione
                                            prenotazione.model.Prenotazione pren = 
                                                (prenotazione.model.Prenotazione) pageContext.getAttribute("prenotazione");
                                            
                                            try {
                                                String[] oraInizio = pren.getOraInizio().split(":");
                                                String[] oraFine = pren.getOraFine().split(":");
                                                
                                                int oreInizio = Integer.parseInt(oraInizio[0]);
                                                int minutiInizio = Integer.parseInt(oraInizio[1]);
                                                int oreFine = Integer.parseInt(oraFine[0]);
                                                int minutiFine = Integer.parseInt(oraFine[1]);
                                                
                                                int minutiTotaliInizio = oreInizio * 60 + minutiInizio;
                                                int minutiTotaliFine = oreFine * 60 + minutiFine;
                                                
                                                int durataMinuti = minutiTotaliFine - minutiTotaliInizio;
                                                int ore = durataMinuti / 60;
                                                int minuti = durataMinuti % 60;
                                                
                                                String durata = ore + "h";
                                                if (minuti > 0) {
                                                    durata += " " + minuti + "m";
                                                }
                                                
                                                pageContext.setAttribute("durata", durata);
                                            } catch (Exception e) {
                                                pageContext.setAttribute("durata", "N/A");
                                            }
                                        %>
                                        <span class="badge bg-success">${durata}</span>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                
                <!-- Riepilogo mensile -->
                <div class="mt-4">
                    <h6><i class="fas fa-chart-bar"></i> Riepilogo Mensile</h6>
                    <div class="row">
                        <%
                            // Calcolo prenotazioni per mese
                            java.util.Map<String, Integer> prenotazioniPerMese = new java.util.LinkedHashMap<>();
                            String[] mesi = {"Gen", "Feb", "Mar", "Apr", "Mag", "Giu", 
                                           "Lug", "Ago", "Set", "Ott", "Nov", "Dic"};
                            
                            // Inizializza tutti i mesi a 0
                            for (int i = 0; i < 12; i++) {
                                prenotazioniPerMese.put(mesi[i], 0);
                            }
                            
                            // Conta le prenotazioni per mese
                            java.util.List<prenotazione.model.Prenotazione> prenotazioni = 
                                (java.util.List<prenotazione.model.Prenotazione>) request.getAttribute("prenotazioniUtente");
                            
                            if (prenotazioni != null) {
                                java.util.Calendar cal = java.util.Calendar.getInstance();
                                for (prenotazione.model.Prenotazione pren : prenotazioni) {
                                    cal.setTime(pren.getData());
                                    int mese = cal.get(java.util.Calendar.MONTH);
                                    String nomeMese = mesi[mese];
                                    prenotazioniPerMese.put(nomeMese, prenotazioniPerMese.get(nomeMese) + 1);
                                }
                            }
                            
                            pageContext.setAttribute("prenotazioniPerMese", prenotazioniPerMese);
                        %>
                        
                        <c:forEach items="${prenotazioniPerMese}" var="entry">
                            <div class="col-md-2 col-sm-3 col-4 mb-2">
                                <div class="text-center p-2 border rounded ${entry.value > 0 ? 'bg-light' : ''}">
                                    <small class="text-muted">${entry.key}</small><br>
                                    <strong class="${entry.value > 0 ? 'text-primary' : 'text-muted'}">${entry.value}</strong>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                
            </c:if>
            
            <c:if test="${empty prenotazioniUtente}">
                <div class="alert alert-warning text-center">
                    <i class="fas fa-info-circle"></i> 
                    Nessuna prenotazione trovata per ${nome} ${cognome} nell'anno ${annoCorrente}.
                </div>
            </c:if>
        </div>
    </div>
</div>