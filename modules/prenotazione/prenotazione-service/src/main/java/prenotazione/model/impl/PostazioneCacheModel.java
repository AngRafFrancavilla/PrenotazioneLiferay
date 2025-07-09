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

import prenotazione.model.Postazione;

/**
 * The cache model class for representing Postazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PostazioneCacheModel
	implements CacheModel<Postazione>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PostazioneCacheModel)) {
			return false;
		}

		PostazioneCacheModel postazioneCacheModel =
			(PostazioneCacheModel)object;

		if (postazioneId == postazioneCacheModel.postazioneId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, postazioneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{postazioneId=");
		sb.append(postazioneId);
		sb.append(", stanzaId=");
		sb.append(stanzaId);
		sb.append(", nomePostazione=");
		sb.append(nomePostazione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Postazione toEntityModel() {
		PostazioneImpl postazioneImpl = new PostazioneImpl();

		postazioneImpl.setPostazioneId(postazioneId);
		postazioneImpl.setStanzaId(stanzaId);

		if (nomePostazione == null) {
			postazioneImpl.setNomePostazione("");
		}
		else {
			postazioneImpl.setNomePostazione(nomePostazione);
		}

		postazioneImpl.resetOriginalValues();

		return postazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postazioneId = objectInput.readLong();

		stanzaId = objectInput.readLong();
		nomePostazione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(postazioneId);

		objectOutput.writeLong(stanzaId);

		if (nomePostazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomePostazione);
		}
	}

	public long postazioneId;
	public long stanzaId;
	public String nomePostazione;

}