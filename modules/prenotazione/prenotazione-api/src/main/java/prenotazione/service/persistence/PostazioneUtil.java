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

import prenotazione.model.Postazione;

/**
 * The persistence utility for the postazione service. This utility wraps <code>prenotazione.service.persistence.impl.PostazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostazionePersistence
 * @generated
 */
public class PostazioneUtil {

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
	public static void clearCache(Postazione postazione) {
		getPersistence().clearCache(postazione);
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
	public static Map<Serializable, Postazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Postazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Postazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Postazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Postazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Postazione update(Postazione postazione) {
		return getPersistence().update(postazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Postazione update(
		Postazione postazione, ServiceContext serviceContext) {

		return getPersistence().update(postazione, serviceContext);
	}

	/**
	 * Caches the postazione in the entity cache if it is enabled.
	 *
	 * @param postazione the postazione
	 */
	public static void cacheResult(Postazione postazione) {
		getPersistence().cacheResult(postazione);
	}

	/**
	 * Caches the postaziones in the entity cache if it is enabled.
	 *
	 * @param postaziones the postaziones
	 */
	public static void cacheResult(List<Postazione> postaziones) {
		getPersistence().cacheResult(postaziones);
	}

	/**
	 * Creates a new postazione with the primary key. Does not add the postazione to the database.
	 *
	 * @param postazioneId the primary key for the new postazione
	 * @return the new postazione
	 */
	public static Postazione create(long postazioneId) {
		return getPersistence().create(postazioneId);
	}

	/**
	 * Removes the postazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione that was removed
	 * @throws NoSuchPostazioneException if a postazione with the primary key could not be found
	 */
	public static Postazione remove(long postazioneId)
		throws prenotazione.exception.NoSuchPostazioneException {

		return getPersistence().remove(postazioneId);
	}

	public static Postazione updateImpl(Postazione postazione) {
		return getPersistence().updateImpl(postazione);
	}

	/**
	 * Returns the postazione with the primary key or throws a <code>NoSuchPostazioneException</code> if it could not be found.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione
	 * @throws NoSuchPostazioneException if a postazione with the primary key could not be found
	 */
	public static Postazione findByPrimaryKey(long postazioneId)
		throws prenotazione.exception.NoSuchPostazioneException {

		return getPersistence().findByPrimaryKey(postazioneId);
	}

	/**
	 * Returns the postazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione, or <code>null</code> if a postazione with the primary key could not be found
	 */
	public static Postazione fetchByPrimaryKey(long postazioneId) {
		return getPersistence().fetchByPrimaryKey(postazioneId);
	}

	/**
	 * Returns all the postaziones.
	 *
	 * @return the postaziones
	 */
	public static List<Postazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the postaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of postaziones
	 * @param end the upper bound of the range of postaziones (not inclusive)
	 * @return the range of postaziones
	 */
	public static List<Postazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the postaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of postaziones
	 * @param end the upper bound of the range of postaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of postaziones
	 */
	public static List<Postazione> findAll(
		int start, int end, OrderByComparator<Postazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the postaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of postaziones
	 * @param end the upper bound of the range of postaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of postaziones
	 */
	public static List<Postazione> findAll(
		int start, int end, OrderByComparator<Postazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the postaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of postaziones.
	 *
	 * @return the number of postaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PostazionePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PostazionePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PostazionePersistence _persistence;

}