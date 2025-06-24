/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import prenotazione.model.Prenotazione;
import prenotazione.service.base.PrenotazioneLocalServiceBaseImpl;

@Component(
	property = "model.class.name=prenotazione.model.Prenotazione",
	service = AopService.class
)
public class PrenotazioneLocalServiceImpl
	extends PrenotazioneLocalServiceBaseImpl {

	public Prenotazione aggiungiPrenotazione(
			long userId,
			String email,
			Date data,
			String oraInizio,
			String oraFine,
			String postazioneId,
			ServiceContext serviceContext
		) throws PortalException {

			System.out.println("Esecuzione aggiungiPrenotazione");

			long id = counterLocalService.increment(Prenotazione.class.getName());
			Prenotazione p = createPrenotazione(id);

			p.setUserId(userId);
			p.setGroupId(serviceContext.getScopeGroupId());
			p.setCompanyId(serviceContext.getCompanyId());

			User user = userLocalService.getUser(userId);
			p.setUserName(user.getFullName());

			p.setCreateDate(serviceContext.getCreateDate());
			p.setModifiedDate(serviceContext.getModifiedDate());

			p.setEmail(email);
			p.setData(data);
			p.setOraInizio(oraInizio);
			p.setOraFine(oraFine);
			p.setPostazioneId(postazioneId);

			// ✅ Salva nel database
			Prenotazione salvata = addPrenotazione(p);
			System.out.println("Prenotazione salvata con ID: " + salvata.getPrenotazioneId());

			return salvata;
		}

}
