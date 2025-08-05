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

import prenotazione.model.Ruolo;

/**
 * The persistence utility for the ruolo service. This utility wraps <code>prenotazione.service.persistence.impl.RuoloPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuoloPersistence
 * @generated
 */
public class RuoloUtil {

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
	public static void clearCache(Ruolo ruolo) {
		getPersistence().clearCache(ruolo);
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
	public static Map<Serializable, Ruolo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ruolo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ruolo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ruolo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Ruolo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ruolo update(Ruolo ruolo) {
		return getPersistence().update(ruolo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ruolo update(Ruolo ruolo, ServiceContext serviceContext) {
		return getPersistence().update(ruolo, serviceContext);
	}

	/**
	 * Caches the ruolo in the entity cache if it is enabled.
	 *
	 * @param ruolo the ruolo
	 */
	public static void cacheResult(Ruolo ruolo) {
		getPersistence().cacheResult(ruolo);
	}

	/**
	 * Caches the ruolos in the entity cache if it is enabled.
	 *
	 * @param ruolos the ruolos
	 */
	public static void cacheResult(List<Ruolo> ruolos) {
		getPersistence().cacheResult(ruolos);
	}

	/**
	 * Creates a new ruolo with the primary key. Does not add the ruolo to the database.
	 *
	 * @param id the primary key for the new ruolo
	 * @return the new ruolo
	 */
	public static Ruolo create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo that was removed
	 * @throws NoSuchRuoloException if a ruolo with the primary key could not be found
	 */
	public static Ruolo remove(int id)
		throws prenotazione.exception.NoSuchRuoloException {

		return getPersistence().remove(id);
	}

	public static Ruolo updateImpl(Ruolo ruolo) {
		return getPersistence().updateImpl(ruolo);
	}

	/**
	 * Returns the ruolo with the primary key or throws a <code>NoSuchRuoloException</code> if it could not be found.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo
	 * @throws NoSuchRuoloException if a ruolo with the primary key could not be found
	 */
	public static Ruolo findByPrimaryKey(int id)
		throws prenotazione.exception.NoSuchRuoloException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the ruolo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo, or <code>null</code> if a ruolo with the primary key could not be found
	 */
	public static Ruolo fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the ruolos.
	 *
	 * @return the ruolos
	 */
	public static List<Ruolo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuoloModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ruolos
	 * @param end the upper bound of the range of ruolos (not inclusive)
	 * @return the range of ruolos
	 */
	public static List<Ruolo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuoloModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ruolos
	 * @param end the upper bound of the range of ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ruolos
	 */
	public static List<Ruolo> findAll(
		int start, int end, OrderByComparator<Ruolo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuoloModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ruolos
	 * @param end the upper bound of the range of ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ruolos
	 */
	public static List<Ruolo> findAll(
		int start, int end, OrderByComparator<Ruolo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ruolos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ruolos.
	 *
	 * @return the number of ruolos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RuoloPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(RuoloPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile RuoloPersistence _persistence;

}