package com.example.portlet.rendercommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Postazione;
import prenotazione.model.Prenotazione;
import prenotazione.service.PostazioneLocalService;
import prenotazione.service.PrenotazioneLocalService;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.util.*;
import java.util.stream.Collectors;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
        "mvc.command.name=/user-details"
    },
    service = MVCRenderCommand.class
)
public class UserDetailsRenderCommand implements MVCRenderCommand {

    @Reference
    private PrenotazioneLocalService prenotazioneLocalService;
    
    @Reference
    private PostazioneLocalService postazioneLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        
        String email = ParamUtil.getString(renderRequest, "email");
        
        if (email == null || email.isEmpty()) {
            // Redirect alla lista utenti se non è specificata l'email
            return "/user_stats.jsp";
        }

        List<Prenotazione> tuttePrenotazioni = prenotazioneLocalService.getPrenotaziones(-1, -1);

        Calendar cal = Calendar.getInstance();
        int annoCorrente = cal.get(Calendar.YEAR);
        
        List<Prenotazione> prenotazioniUtente = tuttePrenotazioni.stream()
            .filter(p -> email.equalsIgnoreCase(p.getEmail()))
            .filter(p -> {
                Calendar prenCal = Calendar.getInstance();
                prenCal.setTime(p.getData());
                return prenCal.get(Calendar.YEAR) == annoCorrente;
            })
            .collect(Collectors.toList());

        String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, "data");
        String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, "desc");
        
        Comparator<Prenotazione> comparator = null;
        
        switch (orderByCol) {
            case "data":
                comparator = Comparator.comparing(Prenotazione::getData);
                break;
            case "oraInizio":
                comparator = Comparator.comparing(Prenotazione::getOraInizio);
                break;
            case "oraFine":
                comparator = Comparator.comparing(Prenotazione::getOraFine);
                break;
            case "postazioneId":
                comparator = Comparator.comparing(Prenotazione::getPostazioneId);
                break;
            default:
                comparator = Comparator.comparing(Prenotazione::getData);
        }
        
        if ("desc".equalsIgnoreCase(orderByType)) {
            comparator = comparator.reversed();
        }
        
        prenotazioniUtente = prenotazioniUtente.stream()
            .sorted(comparator)
            .collect(Collectors.toList());

        String[] emailParts = email.split("@")[0].split("\\.");
        String nome = emailParts.length > 0 ? capitalizeFirst(emailParts[0]) : "";
        String cognome = emailParts.length > 1 ? capitalizeFirst(emailParts[1]) : "";
        
        int numeroPrenotazioni = prenotazioniUtente.size();

        Calendar inizioAnno = Calendar.getInstance();
        inizioAnno.set(annoCorrente, Calendar.JANUARY, 1, 0, 0, 0);
        inizioAnno.set(Calendar.MILLISECOND, 0);
        
        Calendar oggi = Calendar.getInstance();
        oggi.set(Calendar.HOUR_OF_DAY, 23);
        oggi.set(Calendar.MINUTE, 59);
        oggi.set(Calendar.SECOND, 59);
        oggi.set(Calendar.MILLISECOND, 999);
        
        long differenzaMillis = oggi.getTimeInMillis() - inizioAnno.getTimeInMillis();
        int giorniTrascorsi = (int) (differenzaMillis / (1000 * 60 * 60 * 24)) + 1;

        //questo pezzo di codice serve per capire se un anno è bisestile
        boolean bisestile = new GregorianCalendar().isLeapYear(annoCorrente);
        int giorniTotaliAnno = bisestile ? 366 : 365;
        
        //questo pezzo calcola le % di presenza
        double percentualeAdOggi = giorniTrascorsi > 0 ? 
            (double) numeroPrenotazioni / giorniTrascorsi * 100 : 0.0;
        
        double percentualeNellAnno = 
            (double) numeroPrenotazioni / giorniTotaliAnno * 100;
        
    
        List<Postazione> postazioni = postazioneLocalService.getPostaziones(-1, -1);
        
        renderRequest.setAttribute("email", email);
        renderRequest.setAttribute("nome", nome);
        renderRequest.setAttribute("cognome", cognome);
        renderRequest.setAttribute("numeroPrenotazioni", numeroPrenotazioni);
        renderRequest.setAttribute("percentualeAdOggi", percentualeAdOggi);
        renderRequest.setAttribute("percentualeNellAnno", percentualeNellAnno);
        renderRequest.setAttribute("prenotazioniUtente", prenotazioniUtente);
        renderRequest.setAttribute("postazioni", postazioni);
        renderRequest.setAttribute("annoCorrente", annoCorrente);
        renderRequest.setAttribute("giorniTrascorsi", giorniTrascorsi);
        renderRequest.setAttribute("giorniTotaliAnno", giorniTotaliAnno);
        renderRequest.setAttribute("bisestile", bisestile);
        
        return "/user_details.jsp";
    }
    
    private String capitalizeFirst(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}