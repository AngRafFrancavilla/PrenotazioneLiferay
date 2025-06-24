/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
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

		attributes.put("uuid", getUuid());
		attributes.put("prenotazioneId", getPrenotazioneId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("email", getEmail());
		attributes.put("data", getData());
		attributes.put("oraInizio", getOraInizio());
		attributes.put("oraFine", getOraFine());
		attributes.put("postazioneId", getPostazioneId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long prenotazioneId = (Long)attributes.get("prenotazioneId");

		if (prenotazioneId != null) {
			setPrenotazioneId(prenotazioneId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String oraInizio = (String)attributes.get("oraInizio");

		if (oraInizio != null) {
			setOraInizio(oraInizio);
		}

		String oraFine = (String)attributes.get("oraFine");

		if (oraFine != null) {
			setOraFine(oraFine);
		}

		String postazioneId = (String)attributes.get("postazioneId");

		if (postazioneId != null) {
			setPostazioneId(postazioneId);
		}
	}

	@Override
	public Prenotazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this prenotazione.
	 *
	 * @return the company ID of this prenotazione
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this prenotazione.
	 *
	 * @return the create date of this prenotazione
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
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
	 * Returns the email of this prenotazione.
	 *
	 * @return the email of this prenotazione
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this prenotazione.
	 *
	 * @return the group ID of this prenotazione
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this prenotazione.
	 *
	 * @return the modified date of this prenotazione
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the ora fine of this prenotazione.
	 *
	 * @return the ora fine of this prenotazione
	 */
	@Override
	public String getOraFine() {
		return model.getOraFine();
	}

	/**
	 * Returns the ora inizio of this prenotazione.
	 *
	 * @return the ora inizio of this prenotazione
	 */
	@Override
	public String getOraInizio() {
		return model.getOraInizio();
	}

	/**
	 * Returns the postazione ID of this prenotazione.
	 *
	 * @return the postazione ID of this prenotazione
	 */
	@Override
	public String getPostazioneId() {
		return model.getPostazioneId();
	}

	/**
	 * Returns the prenotazione ID of this prenotazione.
	 *
	 * @return the prenotazione ID of this prenotazione
	 */
	@Override
	public long getPrenotazioneId() {
		return model.getPrenotazioneId();
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
	 * Returns the user ID of this prenotazione.
	 *
	 * @return the user ID of this prenotazione
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this prenotazione.
	 *
	 * @return the user name of this prenotazione
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this prenotazione.
	 *
	 * @return the user uuid of this prenotazione
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this prenotazione.
	 *
	 * @return the uuid of this prenotazione
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this prenotazione.
	 *
	 * @param companyId the company ID of this prenotazione
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this prenotazione.
	 *
	 * @param createDate the create date of this prenotazione
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
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
	 * Sets the email of this prenotazione.
	 *
	 * @param email the email of this prenotazione
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this prenotazione.
	 *
	 * @param groupId the group ID of this prenotazione
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this prenotazione.
	 *
	 * @param modifiedDate the modified date of this prenotazione
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the ora fine of this prenotazione.
	 *
	 * @param oraFine the ora fine of this prenotazione
	 */
	@Override
	public void setOraFine(String oraFine) {
		model.setOraFine(oraFine);
	}

	/**
	 * Sets the ora inizio of this prenotazione.
	 *
	 * @param oraInizio the ora inizio of this prenotazione
	 */
	@Override
	public void setOraInizio(String oraInizio) {
		model.setOraInizio(oraInizio);
	}

	/**
	 * Sets the postazione ID of this prenotazione.
	 *
	 * @param postazioneId the postazione ID of this prenotazione
	 */
	@Override
	public void setPostazioneId(String postazioneId) {
		model.setPostazioneId(postazioneId);
	}

	/**
	 * Sets the prenotazione ID of this prenotazione.
	 *
	 * @param prenotazioneId the prenotazione ID of this prenotazione
	 */
	@Override
	public void setPrenotazioneId(long prenotazioneId) {
		model.setPrenotazioneId(prenotazioneId);
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
	 * Sets the user ID of this prenotazione.
	 *
	 * @param userId the user ID of this prenotazione
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this prenotazione.
	 *
	 * @param userName the user name of this prenotazione
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this prenotazione.
	 *
	 * @param userUuid the user uuid of this prenotazione
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this prenotazione.
	 *
	 * @param uuid the uuid of this prenotazione
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PrenotazioneWrapper wrap(Prenotazione prenotazione) {
		return new PrenotazioneWrapper(prenotazione);
	}

}