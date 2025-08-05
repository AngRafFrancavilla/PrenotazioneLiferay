/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import prenotazione.model.Ruolo;

/**
 * The cache model class for representing Ruolo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RuoloCacheModel implements CacheModel<Ruolo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RuoloCacheModel)) {
			return false;
		}

		RuoloCacheModel ruoloCacheModel = (RuoloCacheModel)object;

		if (id == ruoloCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ruolo toEntityModel() {
		RuoloImpl ruoloImpl = new RuoloImpl();

		ruoloImpl.setId(id);

		if (nome == null) {
			ruoloImpl.setNome("");
		}
		else {
			ruoloImpl.setNome(nome);
		}

		if (descrizione == null) {
			ruoloImpl.setDescrizione("");
		}
		else {
			ruoloImpl.setDescrizione(descrizione);
		}

		ruoloImpl.resetOriginalValues();

		return ruoloImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		nome = objectInput.readUTF();
		descrizione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public int id;
	public String nome;
	public String descrizione;

}