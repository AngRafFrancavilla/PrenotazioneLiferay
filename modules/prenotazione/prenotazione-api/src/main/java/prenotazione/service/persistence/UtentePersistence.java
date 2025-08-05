/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import prenotazione.exception.NoSuchUtenteException;

import prenotazione.model.Utente;

/**
 * The persistence interface for the utente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteUtil
 * @generated
 */
@ProviderType
public interface UtentePersistence extends BasePersistence<Utente> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UtenteUtil} to access the utente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the utente where email = &#63; or throws a <code>NoSuchUtenteException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching utente
	 * @throws NoSuchUtenteException if a matching utente could not be found
	 */
	public Utente findByEmail(String email) throws NoSuchUtenteException;

	/**
	 * Returns the utente where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching utente, or <code>null</code> if a matching utente could not be found
	 */
	public Utente fetchByEmail(String email);

	/**
	 * Returns the utente where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente, or <code>null</code> if a matching utente could not be found
	 */
	public Utente fetchByEmail(String email, boolean useFinderCache);

	/**
	 * Removes the utente where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the utente that was removed
	 */
	public Utente removeByEmail(String email) throws NoSuchUtenteException;

	/**
	 * Returns the number of utentes where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching utentes
	 */
	public int countByEmail(String email);

	/**
	 * Caches the utente in the entity cache if it is enabled.
	 *
	 * @param utente the utente
	 */
	public void cacheResult(Utente utente);

	/**
	 * Caches the utentes in the entity cache if it is enabled.
	 *
	 * @param utentes the utentes
	 */
	public void cacheResult(java.util.List<Utente> utentes);

	/**
	 * Creates a new utente with the primary key. Does not add the utente to the database.
	 *
	 * @param id the primary key for the new utente
	 * @return the new utente
	 */
	public Utente create(long id);

	/**
	 * Removes the utente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the utente
	 * @return the utente that was removed
	 * @throws NoSuchUtenteException if a utente with the primary key could not be found
	 */
	public Utente remove(long id) throws NoSuchUtenteException;

	public Utente updateImpl(Utente utente);

	/**
	 * Returns the utente with the primary key or throws a <code>NoSuchUtenteException</code> if it could not be found.
	 *
	 * @param id the primary key of the utente
	 * @return the utente
	 * @throws NoSuchUtenteException if a utente with the primary key could not be found
	 */
	public Utente findByPrimaryKey(long id) throws NoSuchUtenteException;

	/**
	 * Returns the utente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the utente
	 * @return the utente, or <code>null</code> if a utente with the primary key could not be found
	 */
	public Utente fetchByPrimaryKey(long id);

	/**
	 * Returns all the utentes.
	 *
	 * @return the utentes
	 */
	public java.util.List<Utente> findAll();

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
	public java.util.List<Utente> findAll(int start, int end);

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
	public java.util.List<Utente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Utente>
			orderByComparator);

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
	public java.util.List<Utente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Utente>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the utentes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of utentes.
	 *
	 * @return the number of utentes
	 */
	public int countAll();

}