/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import prenotazione.exception.NoSuchRuoloException;

import prenotazione.model.Ruolo;

/**
 * The persistence interface for the ruolo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuoloUtil
 * @generated
 */
@ProviderType
public interface RuoloPersistence extends BasePersistence<Ruolo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuoloUtil} to access the ruolo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the ruolo in the entity cache if it is enabled.
	 *
	 * @param ruolo the ruolo
	 */
	public void cacheResult(Ruolo ruolo);

	/**
	 * Caches the ruolos in the entity cache if it is enabled.
	 *
	 * @param ruolos the ruolos
	 */
	public void cacheResult(java.util.List<Ruolo> ruolos);

	/**
	 * Creates a new ruolo with the primary key. Does not add the ruolo to the database.
	 *
	 * @param id the primary key for the new ruolo
	 * @return the new ruolo
	 */
	public Ruolo create(int id);

	/**
	 * Removes the ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo that was removed
	 * @throws NoSuchRuoloException if a ruolo with the primary key could not be found
	 */
	public Ruolo remove(int id) throws NoSuchRuoloException;

	public Ruolo updateImpl(Ruolo ruolo);

	/**
	 * Returns the ruolo with the primary key or throws a <code>NoSuchRuoloException</code> if it could not be found.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo
	 * @throws NoSuchRuoloException if a ruolo with the primary key could not be found
	 */
	public Ruolo findByPrimaryKey(int id) throws NoSuchRuoloException;

	/**
	 * Returns the ruolo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo, or <code>null</code> if a ruolo with the primary key could not be found
	 */
	public Ruolo fetchByPrimaryKey(int id);

	/**
	 * Returns all the ruolos.
	 *
	 * @return the ruolos
	 */
	public java.util.List<Ruolo> findAll();

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
	public java.util.List<Ruolo> findAll(int start, int end);

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
	public java.util.List<Ruolo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ruolo>
			orderByComparator);

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
	public java.util.List<Ruolo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ruolo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ruolos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ruolos.
	 *
	 * @return the number of ruolos
	 */
	public int countAll();

}