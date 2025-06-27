/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package prenotazioni.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPrenotazioneException extends NoSuchModelException {

	public NoSuchPrenotazioneException() {
	}

	public NoSuchPrenotazioneException(String msg) {
		super(msg);
	}

	public NoSuchPrenotazioneException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchPrenotazioneException(Throwable throwable) {
		super(throwable);
	}

}