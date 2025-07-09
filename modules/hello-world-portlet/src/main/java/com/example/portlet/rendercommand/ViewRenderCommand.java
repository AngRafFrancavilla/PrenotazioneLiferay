package com.example.portlet.rendercommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Postazione;
import prenotazione.service.PostazioneLocalService;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
        "mvc.command.name=/"
    },
    service = MVCRenderCommand.class
)
public class ViewRenderCommand implements MVCRenderCommand {

    @Reference
    private PostazioneLocalService postazioneLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        List<Postazione> postazioni = postazioneLocalService.getPostaziones(-1, -1);
        renderRequest.setAttribute("postazioni", postazioni);

        return "/view.jsp";
    }
}
