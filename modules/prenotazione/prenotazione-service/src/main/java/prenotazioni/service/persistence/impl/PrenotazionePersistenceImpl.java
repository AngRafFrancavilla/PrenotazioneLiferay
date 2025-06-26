/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazioni.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import prenotazioni.exception.NoSuchPrenotazioneException;

import prenotazioni.model.Prenotazione;
import prenotazioni.model.PrenotazioneTable;
import prenotazioni.model.impl.PrenotazioneImpl;
import prenotazioni.model.impl.PrenotazioneModelImpl;

import prenotazioni.service.persistence.PrenotazionePersistence;
import prenotazioni.service.persistence.PrenotazioneUtil;
import prenotazioni.service.persistence.impl.constants.PersistenceConstants;

/**
 * The persistence implementation for the prenotazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PrenotazionePersistence.class)
public class PrenotazionePersistenceImpl
	extends BasePersistenceImpl<Prenotazione>
	implements PrenotazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PrenotazioneUtil</code> to access the prenotazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PrenotazioneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PrenotazionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("data", "data_");
		dbColumnNames.put("oraInizio", "ora_inizio");
		dbColumnNames.put("oraFine", "ora_fine");
		dbColumnNames.put("utentiId", "utenti_id");
		dbColumnNames.put("postazioneId", "postazione_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(Prenotazione.class);

		setModelImplClass(PrenotazioneImpl.class);
		setModelPKClass(long.class);

		setTable(PrenotazioneTable.INSTANCE);
	}

	/**
	 * Caches the prenotazione in the entity cache if it is enabled.
	 *
	 * @param prenotazione the prenotazione
	 */
	@Override
	public void cacheResult(Prenotazione prenotazione) {
		entityCache.putResult(
			PrenotazioneImpl.class, prenotazione.getPrimaryKey(), prenotazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the prenotaziones in the entity cache if it is enabled.
	 *
	 * @param prenotaziones the prenotaziones
	 */
	@Override
	public void cacheResult(List<Prenotazione> prenotaziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (prenotaziones.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Prenotazione prenotazione : prenotaziones) {
			if (entityCache.getResult(
					PrenotazioneImpl.class, prenotazione.getPrimaryKey()) ==
						null) {

				cacheResult(prenotazione);
			}
		}
	}

	/**
	 * Clears the cache for all prenotaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PrenotazioneImpl.class);

		finderCache.clearCache(PrenotazioneImpl.class);
	}

	/**
	 * Clears the cache for the prenotazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Prenotazione prenotazione) {
		entityCache.removeResult(PrenotazioneImpl.class, prenotazione);
	}

	@Override
	public void clearCache(List<Prenotazione> prenotaziones) {
		for (Prenotazione prenotazione : prenotaziones) {
			entityCache.removeResult(PrenotazioneImpl.class, prenotazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PrenotazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PrenotazioneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	 *
	 * @param id the primary key for the new prenotazione
	 * @return the new prenotazione
	 */
	@Override
	public Prenotazione create(long id) {
		Prenotazione prenotazione = new PrenotazioneImpl();

		prenotazione.setNew(true);
		prenotazione.setPrimaryKey(id);

		return prenotazione;
	}

	/**
	 * Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione remove(long id) throws NoSuchPrenotazioneException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione remove(Serializable primaryKey)
		throws NoSuchPrenotazioneException {

		Session session = null;

		try {
			session = openSession();

			Prenotazione prenotazione = (Prenotazione)session.get(
				PrenotazioneImpl.class, primaryKey);

			if (prenotazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrenotazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(prenotazione);
		}
		catch (NoSuchPrenotazioneException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Prenotazione removeImpl(Prenotazione prenotazione) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(prenotazione)) {
				prenotazione = (Prenotazione)session.get(
					PrenotazioneImpl.class, prenotazione.getPrimaryKeyObj());
			}

			if (prenotazione != null) {
				session.delete(prenotazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (prenotazione != null) {
			clearCache(prenotazione);
		}

		return prenotazione;
	}

	@Override
	public Prenotazione updateImpl(Prenotazione prenotazione) {
		boolean isNew = prenotazione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(prenotazione);
			}
			else {
				prenotazione = (Prenotazione)session.merge(prenotazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PrenotazioneImpl.class, prenotazione, false, true);

		if (isNew) {
			prenotazione.setNew(false);
		}

		prenotazione.resetOriginalValues();

		return prenotazione;
	}

	/**
	 * Returns the prenotazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrenotazioneException {

		Prenotazione prenotazione = fetchByPrimaryKey(primaryKey);

		if (prenotazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrenotazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return prenotazione;
	}

	/**
	 * Returns the prenotazione with the primary key or throws a <code>NoSuchPrenotazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione findByPrimaryKey(long id)
		throws NoSuchPrenotazioneException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the prenotazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the prenotazione
	 * @return the prenotazione, or <code>null</code> if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the prenotaziones.
	 *
	 * @return the prenotaziones
	 */
	@Override
	public List<Prenotazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Prenotazione> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Prenotazione> findAll(
		int start, int end, OrderByComparator<Prenotazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Prenotazione> findAll(
		int start, int end, OrderByComparator<Prenotazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Prenotazione> list = null;

		if (useFinderCache) {
			list = (List<Prenotazione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRENOTAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRENOTAZIONE;

				sql = sql.concat(PrenotazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Prenotazione>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the prenotaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Prenotazione prenotazione : findAll()) {
			remove(prenotazione);
		}
	}

	/**
	 * Returns the number of prenotaziones.
	 *
	 * @return the number of prenotaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRENOTAZIONE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRENOTAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PrenotazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the prenotazione persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		PrenotazioneUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PrenotazioneUtil.setPersistence(null);

		entityCache.removeCache(PrenotazioneImpl.class.getName());
	}

	@Override
	@Reference(
		target = PersistenceConstants.SERVICE_CONFIGURATION_FILTER, unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRENOTAZIONE =
		"SELECT prenotazione FROM Prenotazione prenotazione";

	private static final String _SQL_COUNT_PRENOTAZIONE =
		"SELECT COUNT(prenotazione) FROM Prenotazione prenotazione";

	private static final String _ORDER_BY_ENTITY_ALIAS = "prenotazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Prenotazione exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PrenotazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"id", "data", "oraInizio", "oraFine", "utentiId", "postazioneId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}