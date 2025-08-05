/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RuoloLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RuoloLocalService
 * @generated
 */
public class RuoloLocalServiceWrapper
	implements RuoloLocalService, ServiceWrapper<RuoloLocalService> {

	public RuoloLocalServiceWrapper() {
		this(null);
	}

	public RuoloLocalServiceWrapper(RuoloLocalService ruoloLocalService) {
		_ruoloLocalService = ruoloLocalService;
	}

	/**
	 * Adds the ruolo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RuoloLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ruolo the ruolo
	 * @return the ruolo that was added
	 */
	@Override
	public prenotazione.model.Ruolo addRuolo(prenotazione.model.Ruolo ruolo) {
		return _ruoloLocalService.addRuolo(ruolo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruoloLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new ruolo with the primary key. Does not add the ruolo to the database.
	 *
	 * @param id the primary key for the new ruolo
	 * @return the new ruolo
	 */
	@Override
	public prenotazione.model.Ruolo createRuolo(int id) {
		return _ruoloLocalService.createRuolo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruoloLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RuoloLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo that was removed
	 * @throws PortalException if a ruolo with the primary key could not be found
	 */
	@Override
	public prenotazione.model.Ruolo deleteRuolo(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruoloLocalService.deleteRuolo(id);
	}

	/**
	 * Deletes the ruolo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RuoloLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ruolo the ruolo
	 * @return the ruolo that was removed
	 */
	@Override
	public prenotazione.model.Ruolo deleteRuolo(
		prenotazione.model.Ruolo ruolo) {

		return _ruoloLocalService.deleteRuolo(ruolo);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ruoloLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ruoloLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ruoloLocalService.dynamicQuery();
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

		return _ruoloLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.RuoloModelImpl</code>.
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

		return _ruoloLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.RuoloModelImpl</code>.
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

		return _ruoloLocalService.dynamicQuery(
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

		return _ruoloLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ruoloLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public prenotazione.model.Ruolo fetchRuolo(int id) {
		return _ruoloLocalService.fetchRuolo(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ruoloLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ruoloLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ruoloLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruoloLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ruolo with the primary key.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo
	 * @throws PortalException if a ruolo with the primary key could not be found
	 */
	@Override
	public prenotazione.model.Ruolo getRuolo(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruoloLocalService.getRuolo(id);
	}

	/**
	 * Returns a range of all the ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.RuoloModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ruolos
	 * @param end the upper bound of the range of ruolos (not inclusive)
	 * @return the range of ruolos
	 */
	@Override
	public java.util.List<prenotazione.model.Ruolo> getRuolos(
		int start, int end) {

		return _ruoloLocalService.getRuolos(start, end);
	}

	/**
	 * Returns the number of ruolos.
	 *
	 * @return the number of ruolos
	 */
	@Override
	public int getRuolosCount() {
		return _ruoloLocalService.getRuolosCount();
	}

	/**
	 * Updates the ruolo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RuoloLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ruolo the ruolo
	 * @return the ruolo that was updated
	 */
	@Override
	public prenotazione.model.Ruolo updateRuolo(
		prenotazione.model.Ruolo ruolo) {

		return _ruoloLocalService.updateRuolo(ruolo);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _ruoloLocalService.getBasePersistence();
	}

	@Override
	public RuoloLocalService getWrappedService() {
		return _ruoloLocalService;
	}

	@Override
	public void setWrappedService(RuoloLocalService ruoloLocalService) {
		_ruoloLocalService = ruoloLocalService;
	}

	private RuoloLocalService _ruoloLocalService;

}