<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<div class="container mt-4">
    <h2>Elenco Prenotazioni</h2>

    <liferay-ui:search-container total="${prenotazioni.size()}">
        <liferay-ui:search-container-results results="${prenotazioni}" />
        
        <liferay-ui:search-container-row
            className="prenotazione.model.Prenotazione"
            modelVar="pren"
            keyProperty="prenotazioneId">
            
            <liferay-ui:search-container-column-text name="Email" value="${pren.email}" />
            
            <liferay-ui:search-container-column-text name="Data">
                <fmt:formatDate value="${pren.data}" pattern="dd/MM/yyyy" />
            </liferay-ui:search-container-column-text>
            
            <liferay-ui:search-container-column-text name="Ora Inizio" value="${pren.oraInizio}" />
            
            <liferay-ui:search-container-column-text name="Ora Fine" value="${pren.oraFine}" />
            
            <liferay-ui:search-container-column-text name="Postazione" value="${pren.postazioneId}" />

            <!-- Colonna Azioni -->
			<liferay-ui:search-container-column-text name="Azioni">
                <form
                    action="<portlet:actionURL name='/eliminaPrenotazione' />"
                    method="post"
                    onsubmit="return confirm('Sei sicuro di voler eliminare questa prenotazione?');">
                    <!-- namespace sul name -->
                    <input
                        type="hidden"
                        name="<portlet:namespace/>prenotazioneId"
                        value="${pren.prenotazioneId}"
                    />
                    <button type="submit" class="btn btn-danger btn-sm">
                        Elimina
                    </button>
                </form>
            </liferay-ui:search-container-column-text>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator />
    </liferay-ui:search-container>

    <a href="<portlet:renderURL />" class="btn btn-primary">
        Torna alla Home
    </a>
</div>
