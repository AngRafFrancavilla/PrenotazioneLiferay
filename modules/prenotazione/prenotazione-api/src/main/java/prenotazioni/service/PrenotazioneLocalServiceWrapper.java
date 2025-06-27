/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazioni.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PrenotazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneLocalService
 * @generated
 */
public class PrenotazioneLocalServiceWrapper
	implements PrenotazioneLocalService,
			   ServiceWrapper<PrenotazioneLocalService> {

	public PrenotazioneLocalServiceWrapper() {
		this(null);
	}

	public PrenotazioneLocalServiceWrapper(
		PrenotazioneLocalService prenotazioneLocalService) {

		_prenotazioneLocalService = prenotazioneLocalService;
	}

	/**
	 * Adds the prenotazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param prenotazione the prenotazione
	 * @return the prenotazione that was added
	 */
	@Override
	public prenotazioni.model.Prenotazione addPrenotazione(
		prenotazioni.model.Prenotazione prenotazione) {

		return _prenotazioneLocalService.addPrenotazione(prenotazione);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioneLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	 *
	 * @param id the primary key for the new prenotazione
	 * @return the new prenotazione
	 */
	@Override
	public prenotazioni.model.Prenotazione createPrenotazione(long id) {
		return _prenotazioneLocalService.createPrenotazione(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioneLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws PortalException if a prenotazione with the primary key could not be found
	 */
	@Override
	public prenotazioni.model.Prenotazione deletePrenotazione(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioneLocalService.deletePrenotazione(id);
	}

	/**
	 * Deletes the prenotazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param prenotazione the prenotazione
	 * @return the prenotazione that was removed
	 */
	@Override
	public prenotazioni.model.Prenotazione deletePrenotazione(
		prenotazioni.model.Prenotazione prenotazione) {

		return _prenotazioneLocalService.deletePrenotazione(prenotazione);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _prenotazioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _prenotazioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _prenotazioneLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _prenotazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazioni.model.impl.PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _prenotazioneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazioni.model.impl.PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _prenotazioneLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _prenotazioneLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _prenotazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public prenotazioni.model.Prenotazione fetchPrenotazione(long id) {
		return _prenotazioneLocalService.fetchPrenotazione(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _prenotazioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _prenotazioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _prenotazioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the prenotazione with the primary key.
	 *
	 * @param id the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws PortalException if a prenotazione with the primary key could not be found
	 */
	@Override
	public prenotazioni.model.Prenotazione getPrenotazione(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioneLocalService.getPrenotazione(id);
	}

	/**
	 * Returns a range of all the prenotaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazioni.model.impl.PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @return the range of prenotaziones
	 */
	@Override
	public java.util.List<prenotazioni.model.Prenotazione> getPrenotaziones(
		int start, int end) {

		return _prenotazioneLocalService.getPrenotaziones(start, end);
	}

	/**
	 * Returns the number of prenotaziones.
	 *
	 * @return the number of prenotaziones
	 */
	@Override
	public int getPrenotazionesCount() {
		return _prenotazioneLocalService.getPrenotazionesCount();
	}

	/**
	 * Updates the prenotazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param prenotazione the prenotazione
	 * @return the prenotazione that was updated
	 */
	@Override
	public prenotazioni.model.Prenotazione updatePrenotazione(
		prenotazioni.model.Prenotazione prenotazione) {

		return _prenotazioneLocalService.updatePrenotazione(prenotazione);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _prenotazioneLocalService.getBasePersistence();
	}

	@Override
	public PrenotazioneLocalService getWrappedService() {
		return _prenotazioneLocalService;
	}

	@Override
	public void setWrappedService(
		PrenotazioneLocalService prenotazioneLocalService) {

		_prenotazioneLocalService = prenotazioneLocalService;
	}

	private PrenotazioneLocalService _prenotazioneLocalService;

}