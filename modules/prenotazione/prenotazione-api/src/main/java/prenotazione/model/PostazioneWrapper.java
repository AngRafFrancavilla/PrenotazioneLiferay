/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Postazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Postazione
 * @generated
 */
public class PostazioneWrapper
	extends BaseModelWrapper<Postazione>
	implements ModelWrapper<Postazione>, Postazione {

	public PostazioneWrapper(Postazione postazione) {
		super(postazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postazioneId", getPostazioneId());
		attributes.put("stanzaId", getStanzaId());
		attributes.put("nomePostazione", getNomePostazione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postazioneId = (Long)attributes.get("postazioneId");

		if (postazioneId != null) {
			setPostazioneId(postazioneId);
		}

		Long stanzaId = (Long)attributes.get("stanzaId");

		if (stanzaId != null) {
			setStanzaId(stanzaId);
		}

		String nomePostazione = (String)attributes.get("nomePostazione");

		if (nomePostazione != null) {
			setNomePostazione(nomePostazione);
		}
	}

	@Override
	public Postazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the nome postazione of this postazione.
	 *
	 * @return the nome postazione of this postazione
	 */
	@Override
	public String getNomePostazione() {
		return model.getNomePostazione();
	}

	/**
	 * Returns the postazione ID of this postazione.
	 *
	 * @return the postazione ID of this postazione
	 */
	@Override
	public long getPostazioneId() {
		return model.getPostazioneId();
	}

	/**
	 * Returns the primary key of this postazione.
	 *
	 * @return the primary key of this postazione
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stanza ID of this postazione.
	 *
	 * @return the stanza ID of this postazione
	 */
	@Override
	public long getStanzaId() {
		return model.getStanzaId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the nome postazione of this postazione.
	 *
	 * @param nomePostazione the nome postazione of this postazione
	 */
	@Override
	public void setNomePostazione(String nomePostazione) {
		model.setNomePostazione(nomePostazione);
	}

	/**
	 * Sets the postazione ID of this postazione.
	 *
	 * @param postazioneId the postazione ID of this postazione
	 */
	@Override
	public void setPostazioneId(long postazioneId) {
		model.setPostazioneId(postazioneId);
	}

	/**
	 * Sets the primary key of this postazione.
	 *
	 * @param primaryKey the primary key of this postazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stanza ID of this postazione.
	 *
	 * @param stanzaId the stanza ID of this postazione
	 */
	@Override
	public void setStanzaId(long stanzaId) {
		model.setStanzaId(stanzaId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PostazioneWrapper wrap(Postazione postazione) {
		return new PostazioneWrapper(postazione);
	}

}