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
 * The extended model interface for the Ruolo service. Represents a row in the &quot;ruoli&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RuoloModel
 * @generated
 */
@ImplementationClassName("prenotazione.model.impl.RuoloImpl")
@ProviderType
public interface Ruolo extends PersistedModel, RuoloModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>prenotazione.model.impl.RuoloImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Ruolo, Integer> ID_ACCESSOR =
		new Accessor<Ruolo, Integer>() {

			@Override
			public Integer get(Ruolo ruolo) {
				return ruolo.getId();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<Ruolo> getTypeClass() {
				return Ruolo.class;
			}

		};

}