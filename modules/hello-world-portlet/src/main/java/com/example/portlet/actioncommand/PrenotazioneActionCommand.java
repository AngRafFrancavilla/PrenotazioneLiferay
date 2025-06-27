package com.example.portlet.actioncommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Prenotazioni;
import prenotazione.service.PrenotazioniLocalService;

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
    private PrenotazioniLocalService prenotazioneLocalService;

    @Reference
    private CounterLocalService counterLocalService;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        System.out.println("Esecuzione processAction in PrenotazioneActionCommand");

        String email = ParamUtil.getString(request, "email");
        String dataStr = ParamUtil.getString(request, "data");
        String oraInizio = ParamUtil.getString(request, "oraInizio");
        String oraFine = ParamUtil.getString(request, "oraFine");
        long postazioneId = ParamUtil.getLong(request, "postazioneId");

        System.out.println("Email: " + email);
        System.out.println("Data: " + dataStr);
        System.out.println("Ora inizio: " + oraInizio + ", fine: " + oraFine);
        System.out.println("ID postazione: " + postazioneId);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Prenotazioni.class.getName(), request);
            Date data = _toDate(dataStr);

            long prenotazioneId = counterLocalService.increment(Prenotazioni.class.getName());

            Prenotazioni prenotazione = prenotazioneLocalService.createPrenotazioni(prenotazioneId);

            prenotazione.setEmail(email);
            prenotazione.setData(data);
            prenotazione.setOraInizio(oraInizio);
            prenotazione.setOraFine(oraFine);
            prenotazione.setPostazioneId(String.valueOf(postazioneId));

            prenotazioneLocalService.updatePrenotazioni(prenotazione);

            System.out.println("Prenotazione salvata con successo!");

        } catch (Exception e) {
            System.err.println("Errore durante la creazione della prenotazione:");
            e.printStackTrace();
            throw new PortletException("Errore salvataggio prenotazione", e);
        }

        return true;
    }

    private Date _toDate(String yyyyMMdd) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(yyyyMMdd);
    }
}
