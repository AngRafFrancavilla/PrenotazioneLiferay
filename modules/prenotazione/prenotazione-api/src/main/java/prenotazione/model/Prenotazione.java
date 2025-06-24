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
 * The extended model interface for the Prenotazione service. Represents a row in the &quot;Prenotazione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneModel
 * @generated
 */
@ImplementationClassName("prenotazione.model.impl.PrenotazioneImpl")
@ProviderType
public interface Prenotazione extends PersistedModel, PrenotazioneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>prenotazione.model.impl.PrenotazioneImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Prenotazione, Long> PRENOTAZIONE_ID_ACCESSOR =
		new Accessor<Prenotazione, Long>() {

			@Override
			public Long get(Prenotazione prenotazione) {
				return prenotazione.getPrenotazioneId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Prenotazione> getTypeClass() {
				return Prenotazione.class;
			}

		};

}