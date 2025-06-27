/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import prenotazione.model.Prenotazione;

/**
 * Provides the local service utility for Prenotazione. This utility wraps
 * <code>prenotazione.service.impl.PrenotazioneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneLocalService
 * @generated
 */
public class PrenotazioneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>prenotazione.service.impl.PrenotazioneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Prenotazione addPrenotazione(Prenotazione prenotazione) {
		return getService().addPrenotazione(prenotazione);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	 *
	 * @param prenotazioneId the primary key for the new prenotazione
	 * @return the new prenotazione
	 */
	public static Prenotazione createPrenotazione(long prenotazioneId) {
		return getService().createPrenotazione(prenotazioneId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrenotazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param prenotazioneId the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws PortalException if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione deletePrenotazione(long prenotazioneId)
		throws PortalException {

		return getService().deletePrenotazione(prenotazioneId);
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
	public static Prenotazione deletePrenotazione(Prenotazione prenotazione) {
		return getService().deletePrenotazione(prenotazione);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Prenotazione fetchPrenotazione(long prenotazioneId) {
		return getService().fetchPrenotazione(prenotazioneId);
	}

	/**
	 * Returns the prenotazione matching the UUID and group.
	 *
	 * @param uuid the prenotazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public static Prenotazione fetchPrenotazioneByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPrenotazioneByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the prenotazione with the primary key.
	 *
	 * @param prenotazioneId the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws PortalException if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione getPrenotazione(long prenotazioneId)
		throws PortalException {

		return getService().getPrenotazione(prenotazioneId);
	}

	/**
	 * Returns the prenotazione matching the UUID and group.
	 *
	 * @param uuid the prenotazione's UUID
	 * @param groupId the primary key of the group
	 * @return the matching prenotazione
	 * @throws PortalException if a matching prenotazione could not be found
	 */
	public static Prenotazione getPrenotazioneByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPrenotazioneByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the prenotaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @return the range of prenotaziones
	 */
	public static List<Prenotazione> getPrenotaziones(int start, int end) {
		return getService().getPrenotaziones(start, end);
	}

	/**
	 * Returns all the prenotaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the prenotaziones
	 * @param companyId the primary key of the company
	 * @return the matching prenotaziones, or an empty list if no matches were found
	 */
	public static List<Prenotazione> getPrenotazionesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPrenotazionesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of prenotaziones matching the UUID and company.
	 *
	 * @param uuid the UUID of the prenotaziones
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching prenotaziones, or an empty list if no matches were found
	 */
	public static List<Prenotazione> getPrenotazionesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator) {

		return getService().getPrenotazionesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of prenotaziones.
	 *
	 * @return the number of prenotaziones
	 */
	public static int getPrenotazionesCount() {
		return getService().getPrenotazionesCount();
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
	public static Prenotazione updatePrenotazione(Prenotazione prenotazione) {
		return getService().updatePrenotazione(prenotazione);
	}

	public static PrenotazioneLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<PrenotazioneLocalService> _serviceSnapshot =
		new Snapshot<>(
			PrenotazioneLocalServiceUtil.class, PrenotazioneLocalService.class);

}