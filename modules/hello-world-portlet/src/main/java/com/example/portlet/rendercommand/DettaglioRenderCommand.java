package com.example.portlet.rendercommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
	        "mvc.command.name=" + HelloWorldPortletKeys.DETTAGLIO_RENDER_COMMAND
	    },
	    service = MVCRenderCommand.class
	)
public class DettaglioRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/dettaglio.jsp"; 
	
	}
}
