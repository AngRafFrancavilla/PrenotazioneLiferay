/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import prenotazione.exception.NoSuchPrenotazioneException;

import prenotazione.model.Prenotazione;

/**
 * The persistence interface for the prenotazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneUtil
 * @generated
 */
@ProviderType
public interface PrenotazionePersistence extends BasePersistence<Prenotazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PrenotazioneUtil} to access the prenotazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the prenotaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prenotaziones
	 */
	public java.util.List<Prenotazione> findByUuid(String uuid);

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
	public java.util.List<Prenotazione> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Prenotazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator);

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
	public java.util.List<Prenotazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public Prenotazione findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
				orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	 * Returns the first prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public Prenotazione fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator);

	/**
	 * Returns the last prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public Prenotazione findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
				orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	 * Returns the last prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public Prenotazione fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator);

	/**
	 * Returns the prenotaziones before and after the current prenotazione in the ordered set where uuid = &#63;.
	 *
	 * @param prenotazioneId the primary key of the current prenotazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public Prenotazione[] findByUuid_PrevAndNext(
			long prenotazioneId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
				orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	 * Removes all the prenotaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of prenotaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prenotaziones
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the prenotazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPrenotazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public Prenotazione findByUUID_G(String uuid, long groupId)
		throws NoSuchPrenotazioneException;

	/**
	 * Returns the prenotazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public Prenotazione fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the prenotazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public Prenotazione fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the prenotazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the prenotazione that was removed
	 */
	public Prenotazione removeByUUID_G(String uuid, long groupId)
		throws NoSuchPrenotazioneException;

	/**
	 * Returns the number of prenotaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching prenotaziones
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the prenotaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching prenotaziones
	 */
	public java.util.List<Prenotazione> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<Prenotazione> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Prenotazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator);

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
	public java.util.List<Prenotazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public Prenotazione findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
				orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	 * Returns the first prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public Prenotazione fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator);

	/**
	 * Returns the last prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	public Prenotazione findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
				orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	 * Returns the last prenotazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	public Prenotazione fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator);

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
	public Prenotazione[] findByUuid_C_PrevAndNext(
			long prenotazioneId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
				orderByComparator)
		throws NoSuchPrenotazioneException;

	/**
	 * Removes all the prenotaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of prenotaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching prenotaziones
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the prenotazione in the entity cache if it is enabled.
	 *
	 * @param prenotazione the prenotazione
	 */
	public void cacheResult(Prenotazione prenotazione);

	/**
	 * Caches the prenotaziones in the entity cache if it is enabled.
	 *
	 * @param prenotaziones the prenotaziones
	 */
	public void cacheResult(java.util.List<Prenotazione> prenotaziones);

	/**
	 * Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	 *
	 * @param prenotazioneId the primary key for the new prenotazione
	 * @return the new prenotazione
	 */
	public Prenotazione create(long prenotazioneId);

	/**
	 * Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param prenotazioneId the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public Prenotazione remove(long prenotazioneId)
		throws NoSuchPrenotazioneException;

	public Prenotazione updateImpl(Prenotazione prenotazione);

	/**
	 * Returns the prenotazione with the primary key or throws a <code>NoSuchPrenotazioneException</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public Prenotazione findByPrimaryKey(long prenotazioneId)
		throws NoSuchPrenotazioneException;

	/**
	 * Returns the prenotazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazione
	 * @return the prenotazione, or <code>null</code> if a prenotazione with the primary key could not be found
	 */
	public Prenotazione fetchByPrimaryKey(long prenotazioneId);

	/**
	 * Returns all the prenotaziones.
	 *
	 * @return the prenotaziones
	 */
	public java.util.List<Prenotazione> findAll();

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
	public java.util.List<Prenotazione> findAll(int start, int end);

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
	public java.util.List<Prenotazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator);

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
	public java.util.List<Prenotazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Prenotazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the prenotaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of prenotaziones.
	 *
	 * @return the number of prenotaziones
	 */
	public int countAll();

}