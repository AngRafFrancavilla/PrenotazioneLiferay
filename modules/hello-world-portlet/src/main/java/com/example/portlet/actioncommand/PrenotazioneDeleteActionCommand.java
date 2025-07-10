package com.example.portlet.actioncommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.service.PrenotazioneLocalService;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
        "mvc.command.name=/eliminaPrenotazione"
    },
    service = MVCActionCommand.class
)
public class PrenotazioneDeleteActionCommand implements MVCActionCommand {

    @Reference
    private PrenotazioneLocalService prenotazioneLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        long prenotazioneId = ParamUtil.getLong(actionRequest, "prenotazioneId");

        if (prenotazioneId > 0) {
            try {
                prenotazioneLocalService.deletePrenotazione(prenotazioneId);
                SessionMessages.add(actionRequest, "prenotazioneDeleted");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        actionResponse.getRenderParameters().setValue("mvcRenderCommandName", "/lista-prenotazioni");
        return true;
    }
}
