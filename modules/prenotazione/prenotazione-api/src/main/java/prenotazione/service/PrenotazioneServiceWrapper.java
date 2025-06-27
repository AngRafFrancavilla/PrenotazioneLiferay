/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PrenotazioneService}.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneService
 * @generated
 */
public class PrenotazioneServiceWrapper
	implements PrenotazioneService, ServiceWrapper<PrenotazioneService> {

	public PrenotazioneServiceWrapper() {
		this(null);
	}

	public PrenotazioneServiceWrapper(PrenotazioneService prenotazioneService) {
		_prenotazioneService = prenotazioneService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _prenotazioneService.getOSGiServiceIdentifier();
	}

	@Override
	public PrenotazioneService getWrappedService() {
		return _prenotazioneService;
	}

	@Override
	public void setWrappedService(PrenotazioneService prenotazioneService) {
		_prenotazioneService = prenotazioneService;
	}

	private PrenotazioneService _prenotazioneService;

}