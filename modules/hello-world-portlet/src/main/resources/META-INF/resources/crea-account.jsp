<%@ include file="/init.jsp" %>

<portlet:actionURL name="creaAccount" var="creaAccountURL" />

<div class="container-fluid">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">Crea Nuovo Account</h3>
                </div>
                <div class="card-body">
                    
                    <!-- Messaggi di errore -->
                    <liferay-ui:error key="campi-obbligatori" message="Tutti i campi sono obbligatori." />
                    <liferay-ui:error key="email-esistente" message="Email già esistente nel sistema." />
                    <liferay-ui:error key="errore-creazione" message="Errore durante la creazione dell'account." />
                    
                    <!-- Messaggio di successo -->
                    <liferay-ui:success key="account-creato-successo" message="Account creato con successo!" />

                    <aui:form action="<%= creaAccountURL %>" method="post" name="creaAccountForm">
                        
                        <div class="row">
                            <div class="col-md-6">
                                <aui:input name="nome" type="text" label="Nome" required="true">
                                    <aui:validator name="required" />
                                    <aui:validator name="maxLength">50</aui:validator>
                                </aui:input>
                            </div>
                            <div class="col-md-6">
                                <aui:input name="cognome" type="text" label="Cognome" required="true">
                                    <aui:validator name="required" />
                                    <aui:validator name="maxLength">50</aui:validator>
                                </aui:input>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <aui:input name="email" type="email" label="Email" required="true">
                                    <aui:validator name="required" />
                                    <aui:validator name="email" />
                                    <aui:validator name="maxLength">255</aui:validator>
                                </aui:input>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <aui:input name="password" type="password" label="Password" required="true">
                                    <aui:validator name="required" />
                                    <aui:validator name="minLength">6</aui:validator>
                                    <aui:validator name="maxLength">255</aui:validator>
                                </aui:input>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <aui:select name="ruoloId" label="Ruolo" required="true">
                                    <aui:option value="">Seleziona un ruolo</aui:option>
                                    <aui:option value="1">Admin</aui:option>
                                    <aui:option value="2">Utente</aui:option>
                                </aui:select>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Anno Assunzione</label>
                                    <input type="text" class="form-control" value="2025" disabled>
                                    <small class="form-text text-muted">L'anno di assunzione viene impostato automaticamente.</small>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12 text-center">
                                <aui:button type="submit" value="Crea Account" cssClass="btn btn-primary" />
                                <aui:button type="cancel" value="Annulla" cssClass="btn btn-secondary" />
                            </div>
                        </div>

                    </aui:form>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
.card {
    margin-top: 20px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.card-header {
    background-color: #007bff;
    color: white;
}

.form-group label {
    font-weight: 600;
}

.btn {
    margin: 5px;
}

.text-center {
    text-align: center;
}
</style>