/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PrenotazioniLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioniLocalService
 * @generated
 */
public class PrenotazioniLocalServiceWrapper
	implements PrenotazioniLocalService,
			   ServiceWrapper<PrenotazioniLocalService> {

	public PrenotazioniLocalServiceWrapper() {
		this(null);
	}

	public PrenotazioniLocalServiceWrapper(
		PrenotazioniLocalService prenotazioniLocalService) {

		_prenotazioniLocalService = prenotazioniLocalService;
	}

	/**
	 * Adds the prenotazioni to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioniLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param prenotazioni the prenotazioni
	 * @return the prenotazioni that was added
	 */
	@Override
	public prenotazione.model.Prenotazioni addPrenotazioni(
		prenotazione.model.Prenotazioni prenotazioni) {

		return _prenotazioniLocalService.addPrenotazioni(prenotazioni);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioniLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new prenotazioni with the primary key. Does not add the prenotazioni to the database.
	 *
	 * @param prenotazioneId the primary key for the new prenotazioni
	 * @return the new prenotazioni
	 */
	@Override
	public prenotazione.model.Prenotazioni createPrenotazioni(
		long prenotazioneId) {

		return _prenotazioniLocalService.createPrenotazioni(prenotazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioniLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the prenotazioni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioniLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni that was removed
	 * @throws PortalException if a prenotazioni with the primary key could not be found
	 */
	@Override
	public prenotazione.model.Prenotazioni deletePrenotazioni(
			long prenotazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioniLocalService.deletePrenotazioni(prenotazioneId);
	}

	/**
	 * Deletes the prenotazioni from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioniLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param prenotazioni the prenotazioni
	 * @return the prenotazioni that was removed
	 */
	@Override
	public prenotazione.model.Prenotazioni deletePrenotazioni(
		prenotazione.model.Prenotazioni prenotazioni) {

		return _prenotazioniLocalService.deletePrenotazioni(prenotazioni);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _prenotazioniLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _prenotazioniLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _prenotazioniLocalService.dynamicQuery();
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

		return _prenotazioniLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PrenotazioniModelImpl</code>.
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

		return _prenotazioniLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PrenotazioniModelImpl</code>.
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

		return _prenotazioniLocalService.dynamicQuery(
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

		return _prenotazioniLocalService.dynamicQueryCount(dynamicQuery);
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

		return _prenotazioniLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public prenotazione.model.Prenotazioni fetchPrenotazioni(
		long prenotazioneId) {

		return _prenotazioniLocalService.fetchPrenotazioni(prenotazioneId);
	}

	/**
	 * Returns the prenotazioni matching the UUID and group.
	 *
	 * @param uuid the prenotazioni's UUID
	 * @param groupId the primary key of the group
	 * @return the matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	@Override
	public prenotazione.model.Prenotazioni fetchPrenotazioniByUuidAndGroupId(
		String uuid, long groupId) {

		return _prenotazioniLocalService.fetchPrenotazioniByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _prenotazioniLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _prenotazioniLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _prenotazioniLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _prenotazioniLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioniLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the prenotazioni with the primary key.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni
	 * @throws PortalException if a prenotazioni with the primary key could not be found
	 */
	@Override
	public prenotazione.model.Prenotazioni getPrenotazioni(long prenotazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioniLocalService.getPrenotazioni(prenotazioneId);
	}

	/**
	 * Returns the prenotazioni matching the UUID and group.
	 *
	 * @param uuid the prenotazioni's UUID
	 * @param groupId the primary key of the group
	 * @return the matching prenotazioni
	 * @throws PortalException if a matching prenotazioni could not be found
	 */
	@Override
	public prenotazione.model.Prenotazioni getPrenotazioniByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _prenotazioniLocalService.getPrenotazioniByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the prenotazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @return the range of prenotazionis
	 */
	@Override
	public java.util.List<prenotazione.model.Prenotazioni> getPrenotazionis(
		int start, int end) {

		return _prenotazioniLocalService.getPrenotazionis(start, end);
	}

	/**
	 * Returns all the prenotazionis matching the UUID and company.
	 *
	 * @param uuid the UUID of the prenotazionis
	 * @param companyId the primary key of the company
	 * @return the matching prenotazionis, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<prenotazione.model.Prenotazioni>
		getPrenotazionisByUuidAndCompanyId(String uuid, long companyId) {

		return _prenotazioniLocalService.getPrenotazionisByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of prenotazionis matching the UUID and company.
	 *
	 * @param uuid the UUID of the prenotazionis
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching prenotazionis, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<prenotazione.model.Prenotazioni>
		getPrenotazionisByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<prenotazione.model.Prenotazioni> orderByComparator) {

		return _prenotazioniLocalService.getPrenotazionisByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of prenotazionis.
	 *
	 * @return the number of prenotazionis
	 */
	@Override
	public int getPrenotazionisCount() {
		return _prenotazioniLocalService.getPrenotazionisCount();
	}

	/**
	 * Updates the prenotazioni in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioniLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param prenotazioni the prenotazioni
	 * @return the prenotazioni that was updated
	 */
	@Override
	public prenotazione.model.Prenotazioni updatePrenotazioni(
		prenotazione.model.Prenotazioni prenotazioni) {

		return _prenotazioniLocalService.updatePrenotazioni(prenotazioni);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _prenotazioniLocalService.getBasePersistence();
	}

	@Override
	public PrenotazioniLocalService getWrappedService() {
		return _prenotazioniLocalService;
	}

	@Override
	public void setWrappedService(
		PrenotazioniLocalService prenotazioniLocalService) {

		_prenotazioniLocalService = prenotazioniLocalService;
	}

	private PrenotazioniLocalService _prenotazioniLocalService;

}