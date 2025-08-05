/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for Utente. This utility wraps
 * <code>prenotazione.service.impl.UtenteServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteService
 * @generated
 */
public class UtenteServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>prenotazione.service.impl.UtenteServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static UtenteService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<UtenteService> _serviceSnapshot =
		new Snapshot<>(UtenteServiceUtil.class, UtenteService.class);

}