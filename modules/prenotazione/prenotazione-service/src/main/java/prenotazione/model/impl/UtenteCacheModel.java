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

import prenotazione.model.Utente;

/**
 * The cache model class for representing Utente in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UtenteCacheModel implements CacheModel<Utente>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UtenteCacheModel)) {
			return false;
		}

		UtenteCacheModel utenteCacheModel = (UtenteCacheModel)object;

		if (id == utenteCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", cognome=");
		sb.append(cognome);
		sb.append(", email=");
		sb.append(email);
		sb.append(", password=");
		sb.append(password);
		sb.append(", percorsoFoto=");
		sb.append(percorsoFoto);
		sb.append(", annoAssunzione=");
		sb.append(annoAssunzione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Utente toEntityModel() {
		UtenteImpl utenteImpl = new UtenteImpl();

		utenteImpl.setId(id);

		if (nome == null) {
			utenteImpl.setNome("");
		}
		else {
			utenteImpl.setNome(nome);
		}

		if (cognome == null) {
			utenteImpl.setCognome("");
		}
		else {
			utenteImpl.setCognome(cognome);
		}

		if (email == null) {
			utenteImpl.setEmail("");
		}
		else {
			utenteImpl.setEmail(email);
		}

		if (password == null) {
			utenteImpl.setPassword("");
		}
		else {
			utenteImpl.setPassword(password);
		}

		if (percorsoFoto == null) {
			utenteImpl.setPercorsoFoto("");
		}
		else {
			utenteImpl.setPercorsoFoto(percorsoFoto);
		}

		if (annoAssunzione == Long.MIN_VALUE) {
			utenteImpl.setAnnoAssunzione(null);
		}
		else {
			utenteImpl.setAnnoAssunzione(new Date(annoAssunzione));
		}

		utenteImpl.resetOriginalValues();

		return utenteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		nome = objectInput.readUTF();
		cognome = objectInput.readUTF();
		email = objectInput.readUTF();
		password = objectInput.readUTF();
		percorsoFoto = objectInput.readUTF();
		annoAssunzione = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (cognome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cognome);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (percorsoFoto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(percorsoFoto);
		}

		objectOutput.writeLong(annoAssunzione);
	}

	public long id;
	public String nome;
	public String cognome;
	public String email;
	public String password;
	public String percorsoFoto;
	public long annoAssunzione;

}