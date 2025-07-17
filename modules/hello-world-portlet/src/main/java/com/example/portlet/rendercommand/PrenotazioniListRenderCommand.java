package com.example.portlet.rendercommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Postazione;
import prenotazione.model.Prenotazione;
import prenotazione.service.PostazioneLocalService;
import prenotazione.service.PrenotazioneLocalService;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Calendar;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
        "mvc.command.name=/lista-prenotazioni"
    },
    service = MVCRenderCommand.class
)
public class PrenotazioniListRenderCommand implements MVCRenderCommand {

    @Reference
    private PrenotazioneLocalService prenotazioneLocalService;

    @Reference
    private PostazioneLocalService postazioneLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        List<Prenotazione> prenotazioni = prenotazioneLocalService.getPrenotaziones(-1, -1);
        System.out.println("Prenotazioni totali: " + prenotazioni.size());

        // recupera parametri con namespace
        String postazioneFilter = ParamUtil.getString(renderRequest, "postazioneFilter");
        String dataFilterDa = ParamUtil.getString(renderRequest, "dataFilterDa");
        String dataFilterA = ParamUtil.getString(renderRequest, "dataFilterA");

        // stampa risultati ricevuti per debug
        System.out.println("Parametri ricevuti");
        System.out.println("postazioneFilter: " + postazioneFilter);
        System.out.println("dataFilterDa: " + dataFilterDa);
        System.out.println("dataFilterA: " + dataFilterA);

        // filtra per postazione
        if (Validator.isNotNull(postazioneFilter) && !postazioneFilter.isEmpty()) {
            System.out.println("Applicando filtro postazione: " + postazioneFilter);
            prenotazioni = prenotazioni.stream()
                .filter(p -> String.valueOf(p.getPostazioneId()).equals(postazioneFilter))
                .collect(Collectors.toList());
            System.out.println("Prenotazioni dopo filtro postazione: " + prenotazioni.size());
        }

        // filtra per data inizio
        if (Validator.isNotNull(dataFilterDa) && !dataFilterDa.isEmpty()) {
            System.out.println("Applicando filtro data DA: " + dataFilterDa);
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date filterDateDa = sdf.parse(dataFilterDa);
                
                prenotazioni = prenotazioni.stream()
                    .filter(p -> {
                        Calendar calPren = Calendar.getInstance();
                        calPren.setTime(p.getData());
                        calPren.set(Calendar.HOUR_OF_DAY, 0);
                        calPren.set(Calendar.MINUTE, 0);
                        calPren.set(Calendar.SECOND, 0);
                        calPren.set(Calendar.MILLISECOND, 0);
                        
                        Calendar calFilterDa = Calendar.getInstance();
                        calFilterDa.setTime(filterDateDa);
                        calFilterDa.set(Calendar.HOUR_OF_DAY, 0);
                        calFilterDa.set(Calendar.MINUTE, 0);
                        calFilterDa.set(Calendar.SECOND, 0);
                        calFilterDa.set(Calendar.MILLISECOND, 0);
                        
                        return calPren.compareTo(calFilterDa) >= 0;
                    })
                    .collect(Collectors.toList());
                System.out.println("Prenotazioni dopo filtro data DA: " + prenotazioni.size());
            } catch (Exception e) {
                System.err.println("Errore parsing data DA: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // filtra per data fine
        if (Validator.isNotNull(dataFilterA) && !dataFilterA.isEmpty()) {
            System.out.println("Applicando filtro data A: " + dataFilterA);
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date filterDateA = sdf.parse(dataFilterA);
                
                prenotazioni = prenotazioni.stream()
                    .filter(p -> {
                        Calendar calPren = Calendar.getInstance();
                        calPren.setTime(p.getData());
                        calPren.set(Calendar.HOUR_OF_DAY, 23);
                        calPren.set(Calendar.MINUTE, 59);
                        calPren.set(Calendar.SECOND, 59);
                        calPren.set(Calendar.MILLISECOND, 999);
                        
                        Calendar calFilterA = Calendar.getInstance();
                        calFilterA.setTime(filterDateA);
                        calFilterA.set(Calendar.HOUR_OF_DAY, 23);
                        calFilterA.set(Calendar.MINUTE, 59);
                        calFilterA.set(Calendar.SECOND, 59);
                        calFilterA.set(Calendar.MILLISECOND, 999);
                        
                        return calPren.compareTo(calFilterA) <= 0;
                    })
                    .collect(Collectors.toList());
                System.out.println("Prenotazioni dopo filtro data A: " + prenotazioni.size());
            } catch (Exception e) {
                System.err.println("Errore parsing data A: " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println("Prenotazioni filtrate finali: " + prenotazioni.size());

        // ordinamento
        String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, "data");
        String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, "asc");

        if ("data".equals(orderByCol)) {
            Comparator<Prenotazione> comparator = Comparator.comparing(Prenotazione::getData);
            if ("desc".equalsIgnoreCase(orderByType)) {
                comparator = comparator.reversed();
            }
            prenotazioni = prenotazioni.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        }

        
        renderRequest.setAttribute("postazioneFilter", postazioneFilter);
        renderRequest.setAttribute("dataFilterDa", dataFilterDa);
        renderRequest.setAttribute("dataFilterA", dataFilterA);

        List<Postazione> postazioni = postazioneLocalService.getPostaziones(-1, -1);
        renderRequest.setAttribute("postazioni", postazioni);
        renderRequest.setAttribute("prenotazioni", prenotazioni);

        return "/view_prenotazioni.jsp";
    }
}