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
 * The extended model interface for the Postazione service. Represents a row in the &quot;postazioni&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PostazioneModel
 * @generated
 */
@ImplementationClassName("prenotazione.model.impl.PostazioneImpl")
@ProviderType
public interface Postazione extends PersistedModel, PostazioneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>prenotazione.model.impl.PostazioneImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Postazione, Long> POSTAZIONE_ID_ACCESSOR =
		new Accessor<Postazione, Long>() {

			@Override
			public Long get(Postazione postazione) {
				return postazione.getPostazioneId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Postazione> getTypeClass() {
				return Postazione.class;
			}

		};

}