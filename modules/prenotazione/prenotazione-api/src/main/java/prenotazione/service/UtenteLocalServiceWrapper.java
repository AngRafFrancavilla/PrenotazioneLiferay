/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link UtenteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLocalService
 * @generated
 */
public class UtenteLocalServiceWrapper
	implements ServiceWrapper<UtenteLocalService>, UtenteLocalService {

	public UtenteLocalServiceWrapper() {
		this(null);
	}

	public UtenteLocalServiceWrapper(UtenteLocalService utenteLocalService) {
		_utenteLocalService = utenteLocalService;
	}

	/**
	 * Adds the utente to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utente the utente
	 * @return the utente that was added
	 */
	@Override
	public prenotazione.model.Utente addUtente(
		prenotazione.model.Utente utente) {

		return _utenteLocalService.addUtente(utente);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new utente with the primary key. Does not add the utente to the database.
	 *
	 * @param id the primary key for the new utente
	 * @return the new utente
	 */
	@Override
	public prenotazione.model.Utente createUtente(long id) {
		return _utenteLocalService.createUtente(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the utente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the utente
	 * @return the utente that was removed
	 * @throws PortalException if a utente with the primary key could not be found
	 */
	@Override
	public prenotazione.model.Utente deleteUtente(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLocalService.deleteUtente(id);
	}

	/**
	 * Deletes the utente from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utente the utente
	 * @return the utente that was removed
	 */
	@Override
	public prenotazione.model.Utente deleteUtente(
		prenotazione.model.Utente utente) {

		return _utenteLocalService.deleteUtente(utente);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _utenteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _utenteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _utenteLocalService.dynamicQuery();
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

		return _utenteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.UtenteModelImpl</code>.
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

		return _utenteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.UtenteModelImpl</code>.
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

		return _utenteLocalService.dynamicQuery(
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

		return _utenteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _utenteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public prenotazione.model.Utente fetchUtente(long id) {
		return _utenteLocalService.fetchUtente(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _utenteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _utenteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _utenteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the utente with the primary key.
	 *
	 * @param id the primary key of the utente
	 * @return the utente
	 * @throws PortalException if a utente with the primary key could not be found
	 */
	@Override
	public prenotazione.model.Utente getUtente(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLocalService.getUtente(id);
	}

	/**
	 * Returns a range of all the utentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.UtenteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utentes
	 * @param end the upper bound of the range of utentes (not inclusive)
	 * @return the range of utentes
	 */
	@Override
	public java.util.List<prenotazione.model.Utente> getUtentes(
		int start, int end) {

		return _utenteLocalService.getUtentes(start, end);
	}

	/**
	 * Returns the number of utentes.
	 *
	 * @return the number of utentes
	 */
	@Override
	public int getUtentesCount() {
		return _utenteLocalService.getUtentesCount();
	}

	/**
	 * Updates the utente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UtenteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param utente the utente
	 * @return the utente that was updated
	 */
	@Override
	public prenotazione.model.Utente updateUtente(
		prenotazione.model.Utente utente) {

		return _utenteLocalService.updateUtente(utente);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _utenteLocalService.getBasePersistence();
	}

	@Override
	public UtenteLocalService getWrappedService() {
		return _utenteLocalService;
	}

	@Override
	public void setWrappedService(UtenteLocalService utenteLocalService) {
		_utenteLocalService = utenteLocalService;
	}

	private UtenteLocalService _utenteLocalService;

}