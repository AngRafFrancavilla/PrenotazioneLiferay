/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Prenotazioni service. Represents a row in the &quot;Prenotazioni&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioniModel
 * @generated
 */
@ImplementationClassName("prenotazione.model.impl.PrenotazioniImpl")
@ProviderType
public interface Prenotazioni extends PersistedModel, PrenotazioniModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>prenotazione.model.impl.PrenotazioniImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Prenotazioni, Long> PRENOTAZIONE_ID_ACCESSOR =
		new Accessor<Prenotazioni, Long>() {

			@Override
			public Long get(Prenotazioni prenotazioni) {
				return prenotazioni.getPrenotazioneId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Prenotazioni> getTypeClass() {
				return Prenotazioni.class;
			}

		};

}