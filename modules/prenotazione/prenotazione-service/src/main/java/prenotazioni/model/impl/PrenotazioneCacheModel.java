/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazioni.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import prenotazioni.model.Prenotazione;

/**
 * The cache model class for representing Prenotazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PrenotazioneCacheModel
	implements CacheModel<Prenotazione>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PrenotazioneCacheModel)) {
			return false;
		}

		PrenotazioneCacheModel prenotazioneCacheModel =
			(PrenotazioneCacheModel)object;

		if (id == prenotazioneCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", data=");
		sb.append(data);
		sb.append(", oraInizio=");
		sb.append(oraInizio);
		sb.append(", oraFine=");
		sb.append(oraFine);
		sb.append(", utentiId=");
		sb.append(utentiId);
		sb.append(", postazioneId=");
		sb.append(postazioneId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Prenotazione toEntityModel() {
		PrenotazioneImpl prenotazioneImpl = new PrenotazioneImpl();

		prenotazioneImpl.setId(id);

		if (data == Long.MIN_VALUE) {
			prenotazioneImpl.setData(null);
		}
		else {
			prenotazioneImpl.setData(new Date(data));
		}

		if (oraInizio == Long.MIN_VALUE) {
			prenotazioneImpl.setOraInizio(null);
		}
		else {
			prenotazioneImpl.setOraInizio(new Date(oraInizio));
		}

		if (oraFine == Long.MIN_VALUE) {
			prenotazioneImpl.setOraFine(null);
		}
		else {
			prenotazioneImpl.setOraFine(new Date(oraFine));
		}

		prenotazioneImpl.setUtentiId(utentiId);
		prenotazioneImpl.setPostazioneId(postazioneId);

		prenotazioneImpl.resetOriginalValues();

		return prenotazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		data = objectInput.readLong();
		oraInizio = objectInput.readLong();
		oraFine = objectInput.readLong();

		utentiId = objectInput.readLong();

		postazioneId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(data);
		objectOutput.writeLong(oraInizio);
		objectOutput.writeLong(oraFine);

		objectOutput.writeLong(utentiId);

		objectOutput.writeLong(postazioneId);
	}

	public long id;
	public long data;
	public long oraInizio;
	public long oraFine;
	public long utentiId;
	public long postazioneId;

}