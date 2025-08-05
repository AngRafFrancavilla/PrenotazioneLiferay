/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UtenteService}.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteService
 * @generated
 */
public class UtenteServiceWrapper
	implements ServiceWrapper<UtenteService>, UtenteService {

	public UtenteServiceWrapper() {
		this(null);
	}

	public UtenteServiceWrapper(UtenteService utenteService) {
		_utenteService = utenteService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _utenteService.getOSGiServiceIdentifier();
	}

	@Override
	public UtenteService getWrappedService() {
		return _utenteService;
	}

	@Override
	public void setWrappedService(UtenteService utenteService) {
		_utenteService = utenteService;
	}

	private UtenteService _utenteService;

}