package com.example.portlet.rendercommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.servlet.SessionErrors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Postazione;
import prenotazione.model.Prenotazione;
import prenotazione.service.PostazioneLocalService;
import prenotazione.service.PrenotazioneLocalService;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
        "mvc.command.name=/edit-prenotazione"
    },
    service = MVCRenderCommand.class
)
public class EditPrenotazioneRenderCommand implements MVCRenderCommand {

    @Reference
    private PrenotazioneLocalService prenotazioneLocalService;

    @Reference
    private PostazioneLocalService postazioneLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {
        
        long prenotazioneId = ParamUtil.getLong(renderRequest, "prenotazioneId");
        
        if (prenotazioneId <= 0) {
            SessionErrors.add(renderRequest, "prenotazione-non-trovata");
            return "/view_prenotazioni.jsp";
        }
        
        try {
            Prenotazione prenotazione = prenotazioneLocalService.getPrenotazione(prenotazioneId);

            if (!isModificabile(prenotazione)) {
                SessionErrors.add(renderRequest, "prenotazione-non-modificabile");
                return "/view_prenotazioni.jsp";
            }
            
            List<Postazione> postazioni = postazioneLocalService.getPostaziones(-1, -1);
            
            renderRequest.setAttribute("prenotazione", prenotazione);
            renderRequest.setAttribute("postazioni", postazioni);
            
            return "/edit_prenotazione.jsp";
            
        } catch (Exception e) {
            SessionErrors.add(renderRequest, "prenotazione-non-trovata");
            return "/view_prenotazioni.jsp";
        }
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
            
            System.out.println("Prenotazione ID: " + prenotazione.getPrenotazioneId());
            System.out.println("Data/Ora inizio: " + dataOraInizio);
            System.out.println("Ora attuale: " + sdf.format(now));
            System.out.println("Ore rimanenti: " + oreRimanenti);
            
            return oreRimanenti >= 1;
            
        } catch (Exception e) {
            System.err.println("Errore nel calcolo modificabilità: " + e.getMessage());
            return false;
        }
    }
}