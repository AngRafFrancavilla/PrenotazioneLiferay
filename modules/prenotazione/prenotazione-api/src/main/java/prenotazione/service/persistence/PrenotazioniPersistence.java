/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import prenotazione.exception.NoSuchPrenotazioniException;

import prenotazione.model.Prenotazioni;

/**
 * The persistence interface for the prenotazioni service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioniUtil
 * @generated
 */
@ProviderType
public interface PrenotazioniPersistence extends BasePersistence<Prenotazioni> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PrenotazioniUtil} to access the prenotazioni persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the prenotazionis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prenotazionis
	 */
	public java.util.List<Prenotazioni> findByUuid(String uuid);

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
	public java.util.List<Prenotazioni> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Prenotazioni> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator);

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
	public java.util.List<Prenotazioni> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public Prenotazioni findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
				orderByComparator)
		throws NoSuchPrenotazioniException;

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public Prenotazioni fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator);

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public Prenotazioni findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
				orderByComparator)
		throws NoSuchPrenotazioniException;

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public Prenotazioni fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator);

	/**
	 * Returns the prenotazionis before and after the current prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param prenotazioneId the primary key of the current prenotazioni
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	public Prenotazioni[] findByUuid_PrevAndNext(
			long prenotazioneId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
				orderByComparator)
		throws NoSuchPrenotazioniException;

	/**
	 * Removes all the prenotazionis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of prenotazionis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prenotazionis
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPrenotazioniException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public Prenotazioni findByUUID_G(String uuid, long groupId)
		throws NoSuchPrenotazioniException;

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public Prenotazioni fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public Prenotazioni fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the prenotazioni where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the prenotazioni that was removed
	 */
	public Prenotazioni removeByUUID_G(String uuid, long groupId)
		throws NoSuchPrenotazioniException;

	/**
	 * Returns the number of prenotazionis where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching prenotazionis
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching prenotazionis
	 */
	public java.util.List<Prenotazioni> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator);

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
	public java.util.List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public Prenotazioni findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
				orderByComparator)
		throws NoSuchPrenotazioniException;

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public Prenotazioni fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator);

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	public Prenotazioni findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
				orderByComparator)
		throws NoSuchPrenotazioniException;

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	public Prenotazioni fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator);

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
	public Prenotazioni[] findByUuid_C_PrevAndNext(
			long prenotazioneId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
				orderByComparator)
		throws NoSuchPrenotazioniException;

	/**
	 * Removes all the prenotazionis where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching prenotazionis
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the prenotazioni in the entity cache if it is enabled.
	 *
	 * @param prenotazioni the prenotazioni
	 */
	public void cacheResult(Prenotazioni prenotazioni);

	/**
	 * Caches the prenotazionis in the entity cache if it is enabled.
	 *
	 * @param prenotazionis the prenotazionis
	 */
	public void cacheResult(java.util.List<Prenotazioni> prenotazionis);

	/**
	 * Creates a new prenotazioni with the primary key. Does not add the prenotazioni to the database.
	 *
	 * @param prenotazioneId the primary key for the new prenotazioni
	 * @return the new prenotazioni
	 */
	public Prenotazioni create(long prenotazioneId);

	/**
	 * Removes the prenotazioni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni that was removed
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	public Prenotazioni remove(long prenotazioneId)
		throws NoSuchPrenotazioniException;

	public Prenotazioni updateImpl(Prenotazioni prenotazioni);

	/**
	 * Returns the prenotazioni with the primary key or throws a <code>NoSuchPrenotazioniException</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	public Prenotazioni findByPrimaryKey(long prenotazioneId)
		throws NoSuchPrenotazioniException;

	/**
	 * Returns the prenotazioni with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni, or <code>null</code> if a prenotazioni with the primary key could not be found
	 */
	public Prenotazioni fetchByPrimaryKey(long prenotazioneId);

	/**
	 * Returns all the prenotazionis.
	 *
	 * @return the prenotazionis
	 */
	public java.util.List<Prenotazioni> findAll();

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
	public java.util.List<Prenotazioni> findAll(int start, int end);

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
	public java.util.List<Prenotazioni> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator);

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
	public java.util.List<Prenotazioni> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazioni>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the prenotazionis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of prenotazionis.
	 *
	 * @return the number of prenotazionis
	 */
	public int countAll();

}