/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazioni.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Prenotazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Prenotazione
 * @generated
 */
public class PrenotazioneWrapper
	extends BaseModelWrapper<Prenotazione>
	implements ModelWrapper<Prenotazione>, Prenotazione {

	public PrenotazioneWrapper(Prenotazione prenotazione) {
		super(prenotazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("data", getData());
		attributes.put("oraInizio", getOraInizio());
		attributes.put("oraFine", getOraFine());
		attributes.put("utentiId", getUtentiId());
		attributes.put("postazioneId", getPostazioneId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		Date oraInizio = (Date)attributes.get("oraInizio");

		if (oraInizio != null) {
			setOraInizio(oraInizio);
		}

		Date oraFine = (Date)attributes.get("oraFine");

		if (oraFine != null) {
			setOraFine(oraFine);
		}

		Long utentiId = (Long)attributes.get("utentiId");

		if (utentiId != null) {
			setUtentiId(utentiId);
		}

		Long postazioneId = (Long)attributes.get("postazioneId");

		if (postazioneId != null) {
			setPostazioneId(postazioneId);
		}
	}

	@Override
	public Prenotazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data of this prenotazione.
	 *
	 * @return the data of this prenotazione
	 */
	@Override
	public Date getData() {
		return model.getData();
	}

	/**
	 * Returns the ID of this prenotazione.
	 *
	 * @return the ID of this prenotazione
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the ora fine of this prenotazione.
	 *
	 * @return the ora fine of this prenotazione
	 */
	@Override
	public Date getOraFine() {
		return model.getOraFine();
	}

	/**
	 * Returns the ora inizio of this prenotazione.
	 *
	 * @return the ora inizio of this prenotazione
	 */
	@Override
	public Date getOraInizio() {
		return model.getOraInizio();
	}

	/**
	 * Returns the postazione ID of this prenotazione.
	 *
	 * @return the postazione ID of this prenotazione
	 */
	@Override
	public long getPostazioneId() {
		return model.getPostazioneId();
	}

	/**
	 * Returns the primary key of this prenotazione.
	 *
	 * @return the primary key of this prenotazione
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the utenti ID of this prenotazione.
	 *
	 * @return the utenti ID of this prenotazione
	 */
	@Override
	public long getUtentiId() {
		return model.getUtentiId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data of this prenotazione.
	 *
	 * @param data the data of this prenotazione
	 */
	@Override
	public void setData(Date data) {
		model.setData(data);
	}

	/**
	 * Sets the ID of this prenotazione.
	 *
	 * @param id the ID of this prenotazione
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the ora fine of this prenotazione.
	 *
	 * @param oraFine the ora fine of this prenotazione
	 */
	@Override
	public void setOraFine(Date oraFine) {
		model.setOraFine(oraFine);
	}

	/**
	 * Sets the ora inizio of this prenotazione.
	 *
	 * @param oraInizio the ora inizio of this prenotazione
	 */
	@Override
	public void setOraInizio(Date oraInizio) {
		model.setOraInizio(oraInizio);
	}

	/**
	 * Sets the postazione ID of this prenotazione.
	 *
	 * @param postazioneId the postazione ID of this prenotazione
	 */
	@Override
	public void setPostazioneId(long postazioneId) {
		model.setPostazioneId(postazioneId);
	}

	/**
	 * Sets the primary key of this prenotazione.
	 *
	 * @param primaryKey the primary key of this prenotazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the utenti ID of this prenotazione.
	 *
	 * @param utentiId the utenti ID of this prenotazione
	 */
	@Override
	public void setUtentiId(long utentiId) {
		model.setUtentiId(utentiId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PrenotazioneWrapper wrap(Prenotazione prenotazione) {
		return new PrenotazioneWrapper(prenotazione);
	}

}