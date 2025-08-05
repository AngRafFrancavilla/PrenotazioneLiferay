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

import prenotazione.model.Utente;

/**
 * The persistence utility for the utente service. This utility wraps <code>prenotazione.service.persistence.impl.UtentePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtentePersistence
 * @generated
 */
public class UtenteUtil {

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
	public static void clearCache(Utente utente) {
		getPersistence().clearCache(utente);
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
	public static Map<Serializable, Utente> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Utente> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Utente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Utente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Utente> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Utente update(Utente utente) {
		return getPersistence().update(utente);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Utente update(Utente utente, ServiceContext serviceContext) {
		return getPersistence().update(utente, serviceContext);
	}

	/**
	 * Returns the utente where email = &#63; or throws a <code>NoSuchUtenteException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching utente
	 * @throws NoSuchUtenteException if a matching utente could not be found
	 */
	public static Utente findByEmail(String email)
		throws prenotazione.exception.NoSuchUtenteException {

		return getPersistence().findByEmail(email);
	}

	/**
	 * Returns the utente where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching utente, or <code>null</code> if a matching utente could not be found
	 */
	public static Utente fetchByEmail(String email) {
		return getPersistence().fetchByEmail(email);
	}

	/**
	 * Returns the utente where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente, or <code>null</code> if a matching utente could not be found
	 */
	public static Utente fetchByEmail(String email, boolean useFinderCache) {
		return getPersistence().fetchByEmail(email, useFinderCache);
	}

	/**
	 * Removes the utente where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the utente that was removed
	 */
	public static Utente removeByEmail(String email)
		throws prenotazione.exception.NoSuchUtenteException {

		return getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of utentes where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching utentes
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Caches the utente in the entity cache if it is enabled.
	 *
	 * @param utente the utente
	 */
	public static void cacheResult(Utente utente) {
		getPersistence().cacheResult(utente);
	}

	/**
	 * Caches the utentes in the entity cache if it is enabled.
	 *
	 * @param utentes the utentes
	 */
	public static void cacheResult(List<Utente> utentes) {
		getPersistence().cacheResult(utentes);
	}

	/**
	 * Creates a new utente with the primary key. Does not add the utente to the database.
	 *
	 * @param id the primary key for the new utente
	 * @return the new utente
	 */
	public static Utente create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the utente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the utente
	 * @return the utente that was removed
	 * @throws NoSuchUtenteException if a utente with the primary key could not be found
	 */
	public static Utente remove(long id)
		throws prenotazione.exception.NoSuchUtenteException {

		return getPersistence().remove(id);
	}

	public static Utente updateImpl(Utente utente) {
		return getPersistence().updateImpl(utente);
	}

	/**
	 * Returns the utente with the primary key or throws a <code>NoSuchUtenteException</code> if it could not be found.
	 *
	 * @param id the primary key of the utente
	 * @return the utente
	 * @throws NoSuchUtenteException if a utente with the primary key could not be found
	 */
	public static Utente findByPrimaryKey(long id)
		throws prenotazione.exception.NoSuchUtenteException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the utente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the utente
	 * @return the utente, or <code>null</code> if a utente with the primary key could not be found
	 */
	public static Utente fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the utentes.
	 *
	 * @return the utentes
	 */
	public static List<Utente> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the utentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utentes
	 * @param end the upper bound of the range of utentes (not inclusive)
	 * @return the range of utentes
	 */
	public static List<Utente> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the utentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utentes
	 * @param end the upper bound of the range of utentes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utentes
	 */
	public static List<Utente> findAll(
		int start, int end, OrderByComparator<Utente> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utentes
	 * @param end the upper bound of the range of utentes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utentes
	 */
	public static List<Utente> findAll(
		int start, int end, OrderByComparator<Utente> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the utentes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of utentes.
	 *
	 * @return the number of utentes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UtentePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(UtentePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile UtentePersistence _persistence;

}