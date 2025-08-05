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
 * This class is a wrapper for {@link Ruolo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ruolo
 * @generated
 */
public class RuoloWrapper
	extends BaseModelWrapper<Ruolo> implements ModelWrapper<Ruolo>, Ruolo {

	public RuoloWrapper(Ruolo ruolo) {
		super(ruolo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public Ruolo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the descrizione of this ruolo.
	 *
	 * @return the descrizione of this ruolo
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the ID of this ruolo.
	 *
	 * @return the ID of this ruolo
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the nome of this ruolo.
	 *
	 * @return the nome of this ruolo
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this ruolo.
	 *
	 * @return the primary key of this ruolo
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the descrizione of this ruolo.
	 *
	 * @param descrizione the descrizione of this ruolo
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the ID of this ruolo.
	 *
	 * @param id the ID of this ruolo
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the nome of this ruolo.
	 *
	 * @param nome the nome of this ruolo
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this ruolo.
	 *
	 * @param primaryKey the primary key of this ruolo
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RuoloWrapper wrap(Ruolo ruolo) {
		return new RuoloWrapper(ruolo);
	}

}