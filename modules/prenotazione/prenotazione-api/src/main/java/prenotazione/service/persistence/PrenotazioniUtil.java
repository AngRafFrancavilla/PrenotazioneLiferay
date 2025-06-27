/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import prenotazione.model.Prenotazioni;

/**
 * The persistence utility for the prenotazioni service. This utility wraps <code>prenotazione.service.persistence.impl.PrenotazioniPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioniPersistence
 * @generated
 */
public class PrenotazioniUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Prenotazioni prenotazioni) {
		getPersistence().clearCache(prenotazioni);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Prenotazioni> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Prenotazioni> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Prenotazioni> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Prenotazioni> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Prenotazioni update(Prenotazioni prenotazioni) {
		return getPersistence().update(prenotazioni);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Prenotazioni update(
		Prenotazioni prenotazioni, ServiceContext serviceContext) {

		return getPersistence().update(prenotazioni, serviceContext);
	}

	/**
	 * Returns all the prenotazionis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prenotazionis
	 */
	public static List<Prenotazioni> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the prenotazionis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @return the range of matching prenotazionis
	 */
	public static List<Prenotazioni> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the prenotazionis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prenotazionis
	 */
	public static List<Prenotazioni> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the prenotazionis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prenotazionis
	 */
	public static List<Prenotazioni> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public static Prenotazioni findByUuid_First(
			String uuid, OrderByComparator<Prenotazioni> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public static Prenotazioni fetchByUuid_First(
		String uuid, OrderByComparator<Prenotazioni> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public static Prenotazioni findByUuid_Last(
			String uuid, OrderByComparator<Prenotazioni> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public static Prenotazioni fetchByUuid_Last(
		String uuid, OrderByComparator<Prenotazioni> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the prenotazionis before and after the current prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param prenotazioneId the primary key of the current prenotazioni
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	public static Prenotazioni[] findByUuid_PrevAndNext(
			long prenotazioneId, String uuid,
			OrderByComparator<Prenotazioni> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().findByUuid_PrevAndNext(
			prenotazioneId, uuid, orderByComparator);
	}

	/**
	 * Removes all the prenotazionis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of prenotazionis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prenotazionis
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPrenotazioniException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public static Prenotazioni findByUUID_G(String uuid, long groupId)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public static Prenotazioni fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public static Prenotazioni fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the prenotazioni where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the prenotazioni that was removed
	 */
	public static Prenotazioni removeByUUID_G(String uuid, long groupId)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of prenotazionis where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching prenotazionis
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching prenotazionis
	 */
	public static List<Prenotazioni> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @return the range of matching prenotazionis
	 */
	public static List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prenotazionis
	 */
	public static List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prenotazionis
	 */
	public static List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public static Prenotazioni findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Prenotazioni> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public static Prenotazioni fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Prenotazioni> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public static Prenotazioni findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Prenotazioni> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public static Prenotazioni fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Prenotazioni> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the prenotazionis before and after the current prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param prenotazioneId the primary key of the current prenotazioni
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	public static Prenotazioni[] findByUuid_C_PrevAndNext(
			long prenotazioneId, String uuid, long companyId,
			OrderByComparator<Prenotazioni> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().findByUuid_C_PrevAndNext(
			prenotazioneId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the prenotazionis where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching prenotazionis
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the prenotazioni in the entity cache if it is enabled.
	 *
	 * @param prenotazioni the prenotazioni
	 */
	public static void cacheResult(Prenotazioni prenotazioni) {
		getPersistence().cacheResult(prenotazioni);
	}

	/**
	 * Caches the prenotazionis in the entity cache if it is enabled.
	 *
	 * @param prenotazionis the prenotazionis
	 */
	public static void cacheResult(List<Prenotazioni> prenotazionis) {
		getPersistence().cacheResult(prenotazionis);
	}

	/**
	 * Creates a new prenotazioni with the primary key. Does not add the prenotazioni to the database.
	 *
	 * @param prenotazioneId the primary key for the new prenotazioni
	 * @return the new prenotazioni
	 */
	public static Prenotazioni create(long prenotazioneId) {
		return getPersistence().create(prenotazioneId);
	}

	/**
	 * Removes the prenotazioni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni that was removed
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	public static Prenotazioni remove(long prenotazioneId)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().remove(prenotazioneId);
	}

	public static Prenotazioni updateImpl(Prenotazioni prenotazioni) {
		return getPersistence().updateImpl(prenotazioni);
	}

	/**
	 * Returns the prenotazioni with the primary key or throws a <code>NoSuchPrenotazioniException</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	public static Prenotazioni findByPrimaryKey(long prenotazioneId)
		throws prenotazione.exception.NoSuchPrenotazioniException {

		return getPersistence().findByPrimaryKey(prenotazioneId);
	}

	/**
	 * Returns the prenotazioni with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni, or <code>null</code> if a prenotazioni with the primary key could not be found
	 */
	public static Prenotazioni fetchByPrimaryKey(long prenotazioneId) {
		return getPersistence().fetchByPrimaryKey(prenotazioneId);
	}

	/**
	 * Returns all the prenotazionis.
	 *
	 * @return the prenotazionis
	 */
	public static List<Prenotazioni> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the prenotazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @return the range of prenotazionis
	 */
	public static List<Prenotazioni> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the prenotazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of prenotazionis
	 */
	public static List<Prenotazioni> findAll(
		int start, int end, OrderByComparator<Prenotazioni> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the prenotazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of prenotazionis
	 */
	public static List<Prenotazioni> findAll(
		int start, int end, OrderByComparator<Prenotazioni> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the prenotazionis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of prenotazionis.
	 *
	 * @return the number of prenotazionis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PrenotazioniPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PrenotazioniPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PrenotazioniPersistence _persistence;

}