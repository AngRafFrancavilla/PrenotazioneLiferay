package com.example.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;

import prenotazione.model.Utente;
import prenotazione.service.UtenteLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Crea Account",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/crea-account.jsp",
        "javax.portlet.name=com_example_CreaAccountPortlet",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class CreaAccountPortlet extends MVCPortlet {

    private static final Log _log = LogFactoryUtil.getLog(CreaAccountPortlet.class);

    @Reference
    private UtenteLocalService _utenteLocalService;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) 
            throws IOException, PortletException {
        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = "creaAccount")
    public void creaAccount(ActionRequest actionRequest, ActionResponse actionResponse) {
        
        try {
            // Recupera i parametri dal form
            String nome = ParamUtil.getString(actionRequest, "nome");
            String cognome = ParamUtil.getString(actionRequest, "cognome");
            String email = ParamUtil.getString(actionRequest, "email");
            String password = ParamUtil.getString(actionRequest, "password");
            int ruoloId = ParamUtil.getInteger(actionRequest, "ruoloId");

            // Validazione dei campi obbligatori
            if (nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || password.isEmpty()) {
                SessionErrors.add(actionRequest, "campi-obbligatori");
                return;
            }

            // Controlla se l'email esiste già (semplificato per ora)
            try {
                Utente esistente = _utenteLocalService.fetchUtente(1); // Temporaneo
                // TODO: implementare ricerca per email quando il finder sarà generato
            } catch (Exception e) {
                // Email non trovata, ok per continuare
            }

            // Crea il nuovo utente
            long utenteId = _utenteLocalService.getUtentesCount() + 1;
            Utente nuovoUtente = _utenteLocalService.createUtente(utenteId);
            
            nuovoUtente.setNome(nome);
            nuovoUtente.setCognome(cognome);
            nuovoUtente.setEmail(email);
            nuovoUtente.setPassword(password); // In produzione, hashare la password!
            
            // Imposta automaticamente l'anno corrente
            Calendar cal = Calendar.getInstance();
            nuovoUtente.setAnnoAssunzione(cal.getTime());

            // Salva l'utente
            _utenteLocalService.addUtente(nuovoUtente);

            SessionMessages.add(actionRequest, "account-creato-successo");
            _log.info("Nuovo account creato per: " + email);

        } catch (Exception e) {
            _log.error("Errore nella creazione dell'account", e);
            SessionErrors.add(actionRequest, "errore-creazione");
        }
    }
}