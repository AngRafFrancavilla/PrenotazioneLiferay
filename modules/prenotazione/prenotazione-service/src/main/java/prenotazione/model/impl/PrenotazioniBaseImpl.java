/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model.impl;

import prenotazione.model.Prenotazioni;

import prenotazione.service.PrenotazioniLocalServiceUtil;

/**
 * The extended model base implementation for the Prenotazioni service. Represents a row in the &quot;Prenotazioni&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PrenotazioniImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioniImpl
 * @see Prenotazioni
 * @generated
 */
public abstract class PrenotazioniBaseImpl
	extends PrenotazioniModelImpl implements Prenotazioni {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a prenotazioni model instance should use the <code>Prenotazioni</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			PrenotazioniLocalServiceUtil.addPrenotazioni(this);
		}
		else {
			PrenotazioniLocalServiceUtil.updatePrenotazioni(this);
		}
	}

}