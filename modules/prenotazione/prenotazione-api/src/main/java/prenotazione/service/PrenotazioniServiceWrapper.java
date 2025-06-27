/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PrenotazioniService}.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioniService
 * @generated
 */
public class PrenotazioniServiceWrapper
	implements PrenotazioniService, ServiceWrapper<PrenotazioniService> {

	public PrenotazioniServiceWrapper() {
		this(null);
	}

	public PrenotazioniServiceWrapper(PrenotazioniService prenotazioniService) {
		_prenotazioniService = prenotazioniService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _prenotazioniService.getOSGiServiceIdentifier();
	}

	@Override
	public PrenotazioniService getWrappedService() {
		return _prenotazioniService;
	}

	@Override
	public void setWrappedService(PrenotazioniService prenotazioniService) {
		_prenotazioniService = prenotazioniService;
	}

	private PrenotazioniService _prenotazioniService;

}