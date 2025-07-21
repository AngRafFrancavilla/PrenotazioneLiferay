package com.example.portlet.actioncommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Prenotazione;
import prenotazione.service.PrenotazioneLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
        "mvc.command.name=/update-prenotazione"
    },
    service = MVCActionCommand.class
)
public class EditPrenotazioneActionCommand implements MVCActionCommand {

    @Reference
    private PrenotazioneLocalService prenotazioneLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {
        
        long prenotazioneId = ParamUtil.getLong(actionRequest, "prenotazioneId");
        String email = ParamUtil.getString(actionRequest, "email");
        String dataStr = ParamUtil.getString(actionRequest, "data");
        String oraInizio = ParamUtil.getString(actionRequest, "oraInizio");
        String oraFine = ParamUtil.getString(actionRequest, "oraFine");
        String postazioneId = ParamUtil.getString(actionRequest, "postazioneId");
        
        try {
            Prenotazione prenotazione = prenotazioneLocalService.getPrenotazione(prenotazioneId);
            
            // Verifica nuovamente se la prenotazione è modificabile
            if (!isModificabile(prenotazione)) {
                SessionErrors.add(actionRequest, "prenotazione-non-modificabile");
                return false;
            }
            
            // Validazioni
            if (!validateInput(actionRequest, email, dataStr, oraInizio, oraFine, postazioneId)) {
                return false;
            }
            
            // Parsing della data
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date data = sdf.parse(dataStr);
            
            // Aggiorna la prenotazione
            prenotazione.setEmail(email);
            prenotazione.setData(data);
            prenotazione.setOraInizio(oraInizio);
            prenotazione.setOraFine(oraFine);
            prenotazione.setPostazioneId(postazioneId);
            prenotazione.setModifiedDate(new Date());
            
            prenotazioneLocalService.updatePrenotazione(prenotazione);
            
            SessionMessages.add(actionRequest, "prenotazione-aggiornata");
            
            // Redirect alla lista prenotazioni
            actionResponse.setRenderParameter("mvcRenderCommandName", "/lista-prenotazioni");
            
        } catch (Exception e) {
            System.err.println("Errore nell'aggiornamento prenotazione: " + e.getMessage());
            e.printStackTrace();
            SessionErrors.add(actionRequest, "errore-aggiornamento");
            return false;
        }
        
        return true;
    }
    
    private boolean isModificabile(Prenotazione prenotazione) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            String dataStr = dateFormat.format(prenotazione.getData());
            String dataOraInizio = dataStr + " " + prenotazione.getOraInizio();
            
            Date dataOraInizioPren = sdf.parse(dataOraInizio);
            Date now = new Date();
            
            long differenza = dataOraInizioPren.getTime() - now.getTime();
            long oreRimanenti = differenza / (1000 * 60 * 60);
            
            return oreRimanenti >= 1;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean validateInput(ActionRequest actionRequest, String email, String dataStr, 
                                 String oraInizio, String oraFine, String postazioneId) {
        
        // Validazione email
        if (Validator.isNull(email) || !Validator.isEmailAddress(email)) {
            SessionErrors.add(actionRequest, "email-non-valida");
            return false;
        }
        
        // Validazione data
        if (Validator.isNull(dataStr)) {
            SessionErrors.add(actionRequest, "data-richiesta");
            return false;
        }
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date data = sdf.parse(dataStr);
            Date oggi = new Date();
            
            // Normalizza le date per confronto (solo giorno, mese, anno)
            Calendar calData = Calendar.getInstance();
            calData.setTime(data);
            calData.set(Calendar.HOUR_OF_DAY, 0);
            calData.set(Calendar.MINUTE, 0);
            calData.set(Calendar.SECOND, 0);
            calData.set(Calendar.MILLISECOND, 0);
            
            Calendar calOggi = Calendar.getInstance();
            calOggi.setTime(oggi);
            calOggi.set(Calendar.HOUR_OF_DAY, 0);
            calOggi.set(Calendar.MINUTE, 0);
            calOggi.set(Calendar.SECOND, 0);
            calOggi.set(Calendar.MILLISECOND, 0);
            
            if (calData.before(calOggi)) {
                SessionErrors.add(actionRequest, "data-passata");
                return false;
            }
            
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "data-non-valida");
            return false;
        }
        
        // Validazione orari
        if (Validator.isNull(oraInizio) || Validator.isNull(oraFine)) {
            SessionErrors.add(actionRequest, "orari-richiesti");
            return false;
        }
        
        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Date inizioTime = timeFormat.parse(oraInizio);
            Date fineTime = timeFormat.parse(oraFine);
            
            if (fineTime.before(inizioTime) || fineTime.equals(inizioTime)) {
                SessionErrors.add(actionRequest, "ora-fine-non-valida");
                return false;
            }
            
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "orari-non-validi");
            return false;
        }
        
        // Validazione postazione
        if (Validator.isNull(postazioneId)) {
            SessionErrors.add(actionRequest, "postazione-richiesta");
            return false;
        }
        
        return true;
    }
}