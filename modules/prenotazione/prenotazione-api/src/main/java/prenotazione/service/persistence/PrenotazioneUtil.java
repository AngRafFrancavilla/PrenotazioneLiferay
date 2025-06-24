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

import prenotazione.model.Prenotazione;

/**
 * The persistence utility for the prenotazione service. This utility wraps <code>prenotazione.service.persistence.impl.PrenotazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazionePersistence
 * @generated
 */
public class PrenotazioneUtil {

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
	public static void clearCache(Prenotazione prenotazione) {
		getPersistence().clearCache(prenotazione);
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
	public static Map<Serializable, Prenotazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Prenotazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Prenotazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Prenotazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Prenotazione update(Prenotazione prenotazione) {
		return getPersistence().update(prenotazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Prenotazione update(
		Prenotazione prenotazione, ServiceContext serviceContext) {

		return getPersistence().update(prenotazione, serviceContext);
	}

	/**
	 * Returns all the prenotaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prenotaziones
	 */
	public static List<Prenotazione> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the prenotaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @return the range of matching prenotaziones
	 */
	public static List<Prenotazione> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the prenotaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prenotaziones
	 */
	public static List<Prenotazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the prenotaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prenotaziones
	 */
	public static List<Prenotazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public static Prenotazione findByUuid_First(
			String uuid, OrderByComparator<Prenotazione> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public static Prenotazione fetchByUuid_First(
		String uuid, OrderByComparator<Prenotazione> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public static Prenotazione findByUuid_Last(
			String uuid, OrderByComparator<Prenotazione> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public static Prenotazione fetchByUuid_Last(
		String uuid, OrderByComparator<Prenotazione> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the prenotaziones before and after the current prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param prenotazioneId the primary key of the current prenotazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione[] findByUuid_PrevAndNext(
			long prenotazioneId, String uuid,
			OrderByComparator<Prenotazione> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().findByUuid_PrevAndNext(
			prenotazioneId, uuid, orderByComparator);
	}

	/**
	 * Removes all the prenotaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of prenotaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prenotaziones
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the prenotazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPrenotazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public static Prenotazione findByUUID_G(String uuid, long groupId)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the prenotazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public static Prenotazione fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the prenotazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public static Prenotazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the prenotazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the prenotazione that was removed
	 */
	public static Prenotazione removeByUUID_G(String uuid, long groupId)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of prenotaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching prenotaziones
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the prenotaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching prenotaziones
	 */
	public static List<Prenotazione> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the prenotaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @return the range of matching prenotaziones
	 */
	public static List<Prenotazione> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the prenotaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prenotaziones
	 */
	public static List<Prenotazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the prenotaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prenotaziones
	 */
	public static List<Prenotazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Prenotazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public static Prenotazione findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Prenotazione> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public static Prenotazione fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Prenotazione> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public static Prenotazione findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Prenotazione> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public static Prenotazione fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Prenotazione> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the prenotaziones before and after the current prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param prenotazioneId the primary key of the current prenotazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione[] findByUuid_C_PrevAndNext(
			long prenotazioneId, String uuid, long companyId,
			OrderByComparator<Prenotazione> orderByComparator)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().findByUuid_C_PrevAndNext(
			prenotazioneId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the prenotaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of prenotaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching prenotaziones
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the prenotazione in the entity cache if it is enabled.
	 *
	 * @param prenotazione the prenotazione
	 */
	public static void cacheResult(Prenotazione prenotazione) {
		getPersistence().cacheResult(prenotazione);
	}

	/**
	 * Caches the prenotaziones in the entity cache if it is enabled.
	 *
	 * @param prenotaziones the prenotaziones
	 */
	public static void cacheResult(List<Prenotazione> prenotaziones) {
		getPersistence().cacheResult(prenotaziones);
	}

	/**
	 * Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	 *
	 * @param prenotazioneId the primary key for the new prenotazione
	 * @return the new prenotazione
	 */
	public static Prenotazione create(long prenotazioneId) {
		return getPersistence().create(prenotazioneId);
	}

	/**
	 * Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param prenotazioneId the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione remove(long prenotazioneId)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().remove(prenotazioneId);
	}

	public static Prenotazione updateImpl(Prenotazione prenotazione) {
		return getPersistence().updateImpl(prenotazione);
	}

	/**
	 * Returns the prenotazione with the primary key or throws a <code>NoSuchPrenotazioneException</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione findByPrimaryKey(long prenotazioneId)
		throws prenotazione.exception.NoSuchPrenotazioneException {

		return getPersistence().findByPrimaryKey(prenotazioneId);
	}

	/**
	 * Returns the prenotazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazione
	 * @return the prenotazione, or <code>null</code> if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione fetchByPrimaryKey(long prenotazioneId) {
		return getPersistence().fetchByPrimaryKey(prenotazioneId);
	}

	/**
	 * Returns all the prenotaziones.
	 *
	 * @return the prenotaziones
	 */
	public static List<Prenotazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the prenotaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @return the range of prenotaziones
	 */
	public static List<Prenotazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the prenotaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of prenotaziones
	 */
	public static List<Prenotazione> findAll(
		int start, int end, OrderByComparator<Prenotazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the prenotaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of prenotaziones
	 */
	public static List<Prenotazione> findAll(
		int start, int end, OrderByComparator<Prenotazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the prenotaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of prenotaziones.
	 *
	 * @return the number of prenotaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PrenotazionePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PrenotazionePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PrenotazionePersistence _persistence;

}