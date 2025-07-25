package com.example.portlet.actioncommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Prenotazione;
import prenotazione.service.PrenotazioneLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
        "mvc.command.name=/prenotazione"
    },
    service = MVCActionCommand.class
)
public class PrenotazioneActionCommand implements MVCActionCommand {

    @Reference
    private PrenotazioneLocalService prenotazioneLocalService;

    @Reference
    private CounterLocalService counterLocalService;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        System.out.println("Esecuzione processAction in PrenotazioneActionCommand");

        String email = ParamUtil.getString(request, "email");
        String dataStr = ParamUtil.getString(request, "data");
        String oraInizioStr = ParamUtil.getString(request, "oraInizio");
        String oraFineStr = ParamUtil.getString(request, "oraFine");
        long postazioneId = ParamUtil.getLong(request, "postazioneId");

        System.out.println("Email: " + email);
        System.out.println("Data: " + dataStr);
        System.out.println("Ora inizio: " + oraInizioStr + ", fine: " + oraFineStr);
        System.out.println("ID postazione: " + postazioneId);

        try {
            // Validazione email - verifica se esiste nel database
            if (!isEmailValidInDatabase(email)) {
                SessionErrors.add(request, "email-non-corretta");
                System.out.println("Email non trovata nel database: " + email);
                return false;
            }

            Date dataPrenotazione = _toDate(dataStr);
            Date oggi = _toDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

            if (dataPrenotazione.before(oggi)) {
                throw new PortletException("La data selezionata è già passata.");
            }

            // Parsing orari
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Date oraInizio = timeFormat.parse(oraInizioStr);
            Date oraFine = timeFormat.parse(oraFineStr);
            Date oraAttuale = timeFormat.parse(timeFormat.format(new Date()));

            if (dataPrenotazione.before(oggi)) {
                SessionErrors.add(request, "data-passata");
                return false;
            }

            if (dataPrenotazione.equals(oggi) && oraInizio.before(oraAttuale)) {
                SessionErrors.add(request, "ora-inizio-passata");
                return false;
            }

            if (!oraFine.after(oraInizio)) {
                SessionErrors.add(request, "ora-fine-non-valida");
                return false;
            }

            // Creazione e salvataggio prenotazione
            long prenotazioneId = counterLocalService.increment();
            Prenotazione prenotazione = prenotazioneLocalService.createPrenotazione(prenotazioneId);

            prenotazione.setEmail(email);
            prenotazione.setData(dataPrenotazione);
            prenotazione.setOraInizio(oraInizioStr);
            prenotazione.setOraFine(oraFineStr);
            prenotazione.setPostazioneId(String.valueOf(postazioneId));

            prenotazioneLocalService.addPrenotazione(prenotazione);

            System.out.println("Prenotazione salvata con successo!");

        } catch (Exception e) {
            System.err.println("Errore durante la creazione della prenotazione:");
            e.printStackTrace();
            throw new PortletException("Errore salvataggio prenotazione", e);
        }

        return true;
    }

    /**
     * Verifica se l'email esiste già nel database delle prenotazioni
     */
    private boolean isEmailValidInDatabase(String email) {
        if (Validator.isNull(email) || email.trim().isEmpty()) {
            return false;
        }

        try {
            // Ottieni tutte le prenotazioni e verifica se l'email esiste
            List<Prenotazione> prenotazioni = prenotazioneLocalService.getPrenotaziones(-1, -1);
            
            for (Prenotazione prenotazione : prenotazioni) {
                if (email.trim().equalsIgnoreCase(prenotazione.getEmail().trim())) {
                    System.out.println("Email trovata nel database: " + email);
                    return true;
                }
            }
            
            System.out.println("Email NON trovata nel database: " + email);
            return false;
            
        } catch (Exception e) {
            System.err.println("Errore durante la verifica dell'email: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private Date _toDate(String yyyyMMdd) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(yyyyMMdd);
    }
}