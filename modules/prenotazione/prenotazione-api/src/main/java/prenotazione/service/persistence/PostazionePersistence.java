/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import prenotazione.exception.NoSuchPostazioneException;

import prenotazione.model.Postazione;

/**
 * The persistence interface for the postazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostazioneUtil
 * @generated
 */
@ProviderType
public interface PostazionePersistence extends BasePersistence<Postazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostazioneUtil} to access the postazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the postazione in the entity cache if it is enabled.
	 *
	 * @param postazione the postazione
	 */
	public void cacheResult(Postazione postazione);

	/**
	 * Caches the postaziones in the entity cache if it is enabled.
	 *
	 * @param postaziones the postaziones
	 */
	public void cacheResult(java.util.List<Postazione> postaziones);

	/**
	 * Creates a new postazione with the primary key. Does not add the postazione to the database.
	 *
	 * @param postazioneId the primary key for the new postazione
	 * @return the new postazione
	 */
	public Postazione create(long postazioneId);

	/**
	 * Removes the postazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione that was removed
	 * @throws NoSuchPostazioneException if a postazione with the primary key could not be found
	 */
	public Postazione remove(long postazioneId)
		throws NoSuchPostazioneException;

	public Postazione updateImpl(Postazione postazione);

	/**
	 * Returns the postazione with the primary key or throws a <code>NoSuchPostazioneException</code> if it could not be found.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione
	 * @throws NoSuchPostazioneException if a postazione with the primary key could not be found
	 */
	public Postazione findByPrimaryKey(long postazioneId)
		throws NoSuchPostazioneException;

	/**
	 * Returns the postazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione, or <code>null</code> if a postazione with the primary key could not be found
	 */
	public Postazione fetchByPrimaryKey(long postazioneId);

	/**
	 * Returns all the postaziones.
	 *
	 * @return the postaziones
	 */
	public java.util.List<Postazione> findAll();

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
	public java.util.List<Postazione> findAll(int start, int end);

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
	public java.util.List<Postazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Postazione>
			orderByComparator);

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
	public java.util.List<Postazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Postazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the postaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of postaziones.
	 *
	 * @return the number of postaziones
	 */
	public int countAll();

}