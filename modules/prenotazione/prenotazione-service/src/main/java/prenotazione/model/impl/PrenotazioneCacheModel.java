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

import java.util.Date;

import prenotazione.model.Prenotazione;

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

		if (prenotazioneId == prenotazioneCacheModel.prenotazioneId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, prenotazioneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", prenotazioneId=");
		sb.append(prenotazioneId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", email=");
		sb.append(email);
		sb.append(", data=");
		sb.append(data);
		sb.append(", oraInizio=");
		sb.append(oraInizio);
		sb.append(", oraFine=");
		sb.append(oraFine);
		sb.append(", postazioneId=");
		sb.append(postazioneId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Prenotazione toEntityModel() {
		PrenotazioneImpl prenotazioneImpl = new PrenotazioneImpl();

		if (uuid == null) {
			prenotazioneImpl.setUuid("");
		}
		else {
			prenotazioneImpl.setUuid(uuid);
		}

		prenotazioneImpl.setPrenotazioneId(prenotazioneId);
		prenotazioneImpl.setGroupId(groupId);
		prenotazioneImpl.setCompanyId(companyId);
		prenotazioneImpl.setUserId(userId);

		if (userName == null) {
			prenotazioneImpl.setUserName("");
		}
		else {
			prenotazioneImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			prenotazioneImpl.setCreateDate(null);
		}
		else {
			prenotazioneImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			prenotazioneImpl.setModifiedDate(null);
		}
		else {
			prenotazioneImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (email == null) {
			prenotazioneImpl.setEmail("");
		}
		else {
			prenotazioneImpl.setEmail(email);
		}

		if (data == Long.MIN_VALUE) {
			prenotazioneImpl.setData(null);
		}
		else {
			prenotazioneImpl.setData(new Date(data));
		}

		if (oraInizio == null) {
			prenotazioneImpl.setOraInizio("");
		}
		else {
			prenotazioneImpl.setOraInizio(oraInizio);
		}

		if (oraFine == null) {
			prenotazioneImpl.setOraFine("");
		}
		else {
			prenotazioneImpl.setOraFine(oraFine);
		}

		if (postazioneId == null) {
			prenotazioneImpl.setPostazioneId("");
		}
		else {
			prenotazioneImpl.setPostazioneId(postazioneId);
		}

		prenotazioneImpl.resetOriginalValues();

		return prenotazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		prenotazioneId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		email = objectInput.readUTF();
		data = objectInput.readLong();
		oraInizio = objectInput.readUTF();
		oraFine = objectInput.readUTF();
		postazioneId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(prenotazioneId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(data);

		if (oraInizio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oraInizio);
		}

		if (oraFine == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oraFine);
		}

		if (postazioneId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postazioneId);
		}
	}

	public String uuid;
	public long prenotazioneId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String email;
	public long data;
	public String oraInizio;
	public String oraFine;
	public String postazioneId;

}