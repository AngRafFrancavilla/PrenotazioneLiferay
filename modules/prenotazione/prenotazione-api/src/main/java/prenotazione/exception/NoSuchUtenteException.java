/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package prenotazione.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUtenteException extends NoSuchModelException {

	public NoSuchUtenteException() {
	}

	public NoSuchUtenteException(String msg) {
		super(msg);
	}

	public NoSuchUtenteException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchUtenteException(Throwable throwable) {
		super(throwable);
	}

}