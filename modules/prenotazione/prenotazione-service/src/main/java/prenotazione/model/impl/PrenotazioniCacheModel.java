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

import prenotazione.model.Prenotazioni;

/**
 * The cache model class for representing Prenotazioni in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PrenotazioniCacheModel
	implements CacheModel<Prenotazioni>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PrenotazioniCacheModel)) {
			return false;
		}

		PrenotazioniCacheModel prenotazioniCacheModel =
			(PrenotazioniCacheModel)object;

		if (prenotazioneId == prenotazioniCacheModel.prenotazioneId) {
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
	public Prenotazioni toEntityModel() {
		PrenotazioniImpl prenotazioniImpl = new PrenotazioniImpl();

		if (uuid == null) {
			prenotazioniImpl.setUuid("");
		}
		else {
			prenotazioniImpl.setUuid(uuid);
		}

		prenotazioniImpl.setPrenotazioneId(prenotazioneId);
		prenotazioniImpl.setGroupId(groupId);
		prenotazioniImpl.setCompanyId(companyId);
		prenotazioniImpl.setUserId(userId);

		if (userName == null) {
			prenotazioniImpl.setUserName("");
		}
		else {
			prenotazioniImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			prenotazioniImpl.setCreateDate(null);
		}
		else {
			prenotazioniImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			prenotazioniImpl.setModifiedDate(null);
		}
		else {
			prenotazioniImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (email == null) {
			prenotazioniImpl.setEmail("");
		}
		else {
			prenotazioniImpl.setEmail(email);
		}

		if (data == Long.MIN_VALUE) {
			prenotazioniImpl.setData(null);
		}
		else {
			prenotazioniImpl.setData(new Date(data));
		}

		if (oraInizio == null) {
			prenotazioniImpl.setOraInizio("");
		}
		else {
			prenotazioniImpl.setOraInizio(oraInizio);
		}

		if (oraFine == null) {
			prenotazioniImpl.setOraFine("");
		}
		else {
			prenotazioniImpl.setOraFine(oraFine);
		}

		if (postazioneId == null) {
			prenotazioniImpl.setPostazioneId("");
		}
		else {
			prenotazioniImpl.setPostazioneId(postazioneId);
		}

		prenotazioniImpl.resetOriginalValues();

		return prenotazioniImpl;
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