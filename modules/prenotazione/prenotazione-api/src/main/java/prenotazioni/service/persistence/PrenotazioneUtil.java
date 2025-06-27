/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazioni.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import prenotazioni.model.Prenotazione;

/**
 * The persistence utility for the prenotazione service. This utility wraps <code>prenotazioni.service.persistence.impl.PrenotazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
	 * @param id the primary key for the new prenotazione
	 * @return the new prenotazione
	 */
	public static Prenotazione create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione remove(long id)
		throws prenotazioni.exception.NoSuchPrenotazioneException {

		return getPersistence().remove(id);
	}

	public static Prenotazione updateImpl(Prenotazione prenotazione) {
		return getPersistence().updateImpl(prenotazione);
	}

	/**
	 * Returns the prenotazione with the primary key or throws a <code>NoSuchPrenotazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione findByPrimaryKey(long id)
		throws prenotazioni.exception.NoSuchPrenotazioneException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the prenotazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the prenotazione
	 * @return the prenotazione, or <code>null</code> if a prenotazione with the primary key could not be found
	 */
	public static Prenotazione fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
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