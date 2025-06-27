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

import prenotazione.model.Prenotazioni;

/**
 * Provides the local service utility for Prenotazioni. This utility wraps
 * <code>prenotazione.service.impl.PrenotazioniLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioniLocalService
 * @generated
 */
public class PrenotazioniLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>prenotazione.service.impl.PrenotazioniLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Prenotazioni addPrenotazioni(Prenotazioni prenotazioni) {
		return getService().addPrenotazioni(prenotazioni);
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
	 * Creates a new prenotazioni with the primary key. Does not add the prenotazioni to the database.
	 *
	 * @param prenotazioneId the primary key for the new prenotazioni
	 * @return the new prenotazioni
	 */
	public static Prenotazioni createPrenotazioni(long prenotazioneId) {
		return getService().createPrenotazioni(prenotazioneId);
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
	public static Prenotazioni deletePrenotazioni(long prenotazioneId)
		throws PortalException {

		return getService().deletePrenotazioni(prenotazioneId);
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
	public static Prenotazioni deletePrenotazioni(Prenotazioni prenotazioni) {
		return getService().deletePrenotazioni(prenotazioni);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PrenotazioniModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>prenotazione.model.impl.PrenotazioniModelImpl</code>.
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

	public static Prenotazioni fetchPrenotazioni(long prenotazioneId) {
		return getService().fetchPrenotazioni(prenotazioneId);
	}

	/**
	 * Returns the prenotazioni matching the UUID and group.
	 *
	 * @param uuid the prenotazioni's UUID
	 * @param groupId the primary key of the group
	 * @return the matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public static Prenotazioni fetchPrenotazioniByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPrenotazioniByUuidAndGroupId(uuid, groupId);
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
	 * Returns the prenotazioni with the primary key.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni
	 * @throws PortalException if a prenotazioni with the primary key could not be found
	 */
	public static Prenotazioni getPrenotazioni(long prenotazioneId)
		throws PortalException {

		return getService().getPrenotazioni(prenotazioneId);
	}

	/**
	 * Returns the prenotazioni matching the UUID and group.
	 *
	 * @param uuid the prenotazioni's UUID
	 * @param groupId the primary key of the group
	 * @return the matching prenotazioni
	 * @throws PortalException if a matching prenotazioni could not be found
	 */
	public static Prenotazioni getPrenotazioniByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPrenotazioniByUuidAndGroupId(uuid, groupId);
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
	public static List<Prenotazioni> getPrenotazionis(int start, int end) {
		return getService().getPrenotazionis(start, end);
	}

	/**
	 * Returns all the prenotazionis matching the UUID and company.
	 *
	 * @param uuid the UUID of the prenotazionis
	 * @param companyId the primary key of the company
	 * @return the matching prenotazionis, or an empty list if no matches were found
	 */
	public static List<Prenotazioni> getPrenotazionisByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPrenotazionisByUuidAndCompanyId(uuid, companyId);
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
	public static List<Prenotazioni> getPrenotazionisByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator) {

		return getService().getPrenotazionisByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of prenotazionis.
	 *
	 * @return the number of prenotazionis
	 */
	public static int getPrenotazionisCount() {
		return getService().getPrenotazionisCount();
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
	public static Prenotazioni updatePrenotazioni(Prenotazioni prenotazioni) {
		return getService().updatePrenotazioni(prenotazioni);
	}

	public static PrenotazioniLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<PrenotazioniLocalService> _serviceSnapshot =
		new Snapshot<>(
			PrenotazioniLocalServiceUtil.class, PrenotazioniLocalService.class);

}