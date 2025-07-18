/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PostazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PostazioneLocalService
 * @generated
 */
public class PostazioneLocalServiceWrapper
	implements PostazioneLocalService, ServiceWrapper<PostazioneLocalService> {

	public PostazioneLocalServiceWrapper() {
		this(null);
	}

	public PostazioneLocalServiceWrapper(
		PostazioneLocalService postazioneLocalService) {

		_postazioneLocalService = postazioneLocalService;
	}

	/**
	 * Adds the postazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postazione the postazione
	 * @return the postazione that was added
	 */
	@Override
	public prenotazione.model.Postazione addPostazione(
		prenotazione.model.Postazione postazione) {

		return _postazioneLocalService.addPostazione(postazione);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postazioneLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new postazione with the primary key. Does not add the postazione to the database.
	 *
	 * @param postazioneId the primary key for the new postazione
	 * @return the new postazione
	 */
	@Override
	public prenotazione.model.Postazione createPostazione(long postazioneId) {
		return _postazioneLocalService.createPostazione(postazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postazioneLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the postazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione that was removed
	 * @throws PortalException if a postazione with the primary key could not be found
	 */
	@Override
	public prenotazione.model.Postazione deletePostazione(long postazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postazioneLocalService.deletePostazione(postazioneId);
	}

	/**
	 * Deletes the postazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postazione the postazione
	 * @return the postazione that was removed
	 */
	@Override
	public prenotazione.model.Postazione deletePostazione(
		prenotazione.model.Postazione postazione) {

		return _postazioneLocalService.deletePostazione(postazione);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _postazioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _postazioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postazioneLocalService.dynamicQuery();
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

		return _postazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PostazioneModelImpl</code>.
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

		return _postazioneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PostazioneModelImpl</code>.
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

		return _postazioneLocalService.dynamicQuery(
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

		return _postazioneLocalService.dynamicQueryCount(dynamicQuery);
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

		return _postazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public prenotazione.model.Postazione fetchPostazione(long postazioneId) {
		return _postazioneLocalService.fetchPostazione(postazioneId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _postazioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _postazioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _postazioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postazioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the postazione with the primary key.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione
	 * @throws PortalException if a postazione with the primary key could not be found
	 */
	@Override
	public prenotazione.model.Postazione getPostazione(long postazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postazioneLocalService.getPostazione(postazioneId);
	}

	/**
	 * Returns a range of all the postaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PostazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of postaziones
	 * @param end the upper bound of the range of postaziones (not inclusive)
	 * @return the range of postaziones
	 */
	@Override
	public java.util.List<prenotazione.model.Postazione> getPostaziones(
		int start, int end) {

		return _postazioneLocalService.getPostaziones(start, end);
	}

	/**
	 * Returns the number of postaziones.
	 *
	 * @return the number of postaziones
	 */
	@Override
	public int getPostazionesCount() {
		return _postazioneLocalService.getPostazionesCount();
	}

	/**
	 * Updates the postazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postazione the postazione
	 * @return the postazione that was updated
	 */
	@Override
	public prenotazione.model.Postazione updatePostazione(
		prenotazione.model.Postazione postazione) {

		return _postazioneLocalService.updatePostazione(postazione);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _postazioneLocalService.getBasePersistence();
	}

	@Override
	public PostazioneLocalService getWrappedService() {
		return _postazioneLocalService;
	}

	@Override
	public void setWrappedService(
		PostazioneLocalService postazioneLocalService) {

		_postazioneLocalService = postazioneLocalService;
	}

	private PostazioneLocalService _postazioneLocalService;

}