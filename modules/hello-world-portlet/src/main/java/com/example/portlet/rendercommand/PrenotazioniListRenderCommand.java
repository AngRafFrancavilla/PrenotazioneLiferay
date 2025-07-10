package com.example.portlet.rendercommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import prenotazione.model.Prenotazione;
import prenotazione.service.PrenotazioneLocalService;
import java.util.List;

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

    @Override
    public String render(
        RenderRequest renderRequest, RenderResponse renderResponse) {
        
        List<Prenotazione> prenotazioni = prenotazioneLocalService.getPrenotaziones(-1, -1);
        renderRequest.setAttribute("prenotazioni", prenotazioni);
        
        return "/view_prenotazioni.jsp";
    }
}