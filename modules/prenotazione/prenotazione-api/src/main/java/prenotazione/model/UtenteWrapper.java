/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Utente}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Utente
 * @generated
 */
public class UtenteWrapper
	extends BaseModelWrapper<Utente> implements ModelWrapper<Utente>, Utente {

	public UtenteWrapper(Utente utente) {
		super(utente);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("cognome", getCognome());
		attributes.put("email", getEmail());
		attributes.put("password", getPassword());
		attributes.put("percorsoFoto", getPercorsoFoto());
		attributes.put("annoAssunzione", getAnnoAssunzione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String cognome = (String)attributes.get("cognome");

		if (cognome != null) {
			setCognome(cognome);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String percorsoFoto = (String)attributes.get("percorsoFoto");

		if (percorsoFoto != null) {
			setPercorsoFoto(percorsoFoto);
		}

		Date annoAssunzione = (Date)attributes.get("annoAssunzione");

		if (annoAssunzione != null) {
			setAnnoAssunzione(annoAssunzione);
		}
	}

	@Override
	public Utente cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the anno assunzione of this utente.
	 *
	 * @return the anno assunzione of this utente
	 */
	@Override
	public Date getAnnoAssunzione() {
		return model.getAnnoAssunzione();
	}

	/**
	 * Returns the cognome of this utente.
	 *
	 * @return the cognome of this utente
	 */
	@Override
	public String getCognome() {
		return model.getCognome();
	}

	/**
	 * Returns the email of this utente.
	 *
	 * @return the email of this utente
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the ID of this utente.
	 *
	 * @return the ID of this utente
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the nome of this utente.
	 *
	 * @return the nome of this utente
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the password of this utente.
	 *
	 * @return the password of this utente
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the percorso foto of this utente.
	 *
	 * @return the percorso foto of this utente
	 */
	@Override
	public String getPercorsoFoto() {
		return model.getPercorsoFoto();
	}

	/**
	 * Returns the primary key of this utente.
	 *
	 * @return the primary key of this utente
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the anno assunzione of this utente.
	 *
	 * @param annoAssunzione the anno assunzione of this utente
	 */
	@Override
	public void setAnnoAssunzione(Date annoAssunzione) {
		model.setAnnoAssunzione(annoAssunzione);
	}

	/**
	 * Sets the cognome of this utente.
	 *
	 * @param cognome the cognome of this utente
	 */
	@Override
	public void setCognome(String cognome) {
		model.setCognome(cognome);
	}

	/**
	 * Sets the email of this utente.
	 *
	 * @param email the email of this utente
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the ID of this utente.
	 *
	 * @param id the ID of this utente
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the nome of this utente.
	 *
	 * @param nome the nome of this utente
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the password of this utente.
	 *
	 * @param password the password of this utente
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the percorso foto of this utente.
	 *
	 * @param percorsoFoto the percorso foto of this utente
	 */
	@Override
	public void setPercorsoFoto(String percorsoFoto) {
		model.setPercorsoFoto(percorsoFoto);
	}

	/**
	 * Sets the primary key of this utente.
	 *
	 * @param primaryKey the primary key of this utente
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UtenteWrapper wrap(Utente utente) {
		return new UtenteWrapper(utente);
	}

}