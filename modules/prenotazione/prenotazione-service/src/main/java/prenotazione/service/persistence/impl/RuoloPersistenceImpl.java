/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence.impl;

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

import prenotazione.exception.NoSuchRuoloException;

import prenotazione.model.Ruolo;
import prenotazione.model.RuoloTable;
import prenotazione.model.impl.RuoloImpl;
import prenotazione.model.impl.RuoloModelImpl;

import prenotazione.service.persistence.RuoloPersistence;
import prenotazione.service.persistence.RuoloUtil;
import prenotazione.service.persistence.impl.constants.PersistenceConstants;

/**
 * The persistence implementation for the ruolo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RuoloPersistence.class)
public class RuoloPersistenceImpl
	extends BasePersistenceImpl<Ruolo> implements RuoloPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RuoloUtil</code> to access the ruolo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RuoloImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RuoloPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Ruolo.class);

		setModelImplClass(RuoloImpl.class);
		setModelPKClass(int.class);

		setTable(RuoloTable.INSTANCE);
	}

	/**
	 * Caches the ruolo in the entity cache if it is enabled.
	 *
	 * @param ruolo the ruolo
	 */
	@Override
	public void cacheResult(Ruolo ruolo) {
		entityCache.putResult(RuoloImpl.class, ruolo.getPrimaryKey(), ruolo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ruolos in the entity cache if it is enabled.
	 *
	 * @param ruolos the ruolos
	 */
	@Override
	public void cacheResult(List<Ruolo> ruolos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ruolos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Ruolo ruolo : ruolos) {
			if (entityCache.getResult(RuoloImpl.class, ruolo.getPrimaryKey()) ==
					null) {

				cacheResult(ruolo);
			}
		}
	}

	/**
	 * Clears the cache for all ruolos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RuoloImpl.class);

		finderCache.clearCache(RuoloImpl.class);
	}

	/**
	 * Clears the cache for the ruolo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ruolo ruolo) {
		entityCache.removeResult(RuoloImpl.class, ruolo);
	}

	@Override
	public void clearCache(List<Ruolo> ruolos) {
		for (Ruolo ruolo : ruolos) {
			entityCache.removeResult(RuoloImpl.class, ruolo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RuoloImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RuoloImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new ruolo with the primary key. Does not add the ruolo to the database.
	 *
	 * @param id the primary key for the new ruolo
	 * @return the new ruolo
	 */
	@Override
	public Ruolo create(int id) {
		Ruolo ruolo = new RuoloImpl();

		ruolo.setNew(true);
		ruolo.setPrimaryKey(id);

		return ruolo;
	}

	/**
	 * Removes the ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo that was removed
	 * @throws NoSuchRuoloException if a ruolo with the primary key could not be found
	 */
	@Override
	public Ruolo remove(int id) throws NoSuchRuoloException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ruolo
	 * @return the ruolo that was removed
	 * @throws NoSuchRuoloException if a ruolo with the primary key could not be found
	 */
	@Override
	public Ruolo remove(Serializable primaryKey) throws NoSuchRuoloException {
		Session session = null;

		try {
			session = openSession();

			Ruolo ruolo = (Ruolo)session.get(RuoloImpl.class, primaryKey);

			if (ruolo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRuoloException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ruolo);
		}
		catch (NoSuchRuoloException noSuchEntityException) {
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
	protected Ruolo removeImpl(Ruolo ruolo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ruolo)) {
				ruolo = (Ruolo)session.get(
					RuoloImpl.class, ruolo.getPrimaryKeyObj());
			}

			if (ruolo != null) {
				session.delete(ruolo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ruolo != null) {
			clearCache(ruolo);
		}

		return ruolo;
	}

	@Override
	public Ruolo updateImpl(Ruolo ruolo) {
		boolean isNew = ruolo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ruolo);
			}
			else {
				ruolo = (Ruolo)session.merge(ruolo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(RuoloImpl.class, ruolo, false, true);

		if (isNew) {
			ruolo.setNew(false);
		}

		ruolo.resetOriginalValues();

		return ruolo;
	}

	/**
	 * Returns the ruolo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ruolo
	 * @return the ruolo
	 * @throws NoSuchRuoloException if a ruolo with the primary key could not be found
	 */
	@Override
	public Ruolo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuoloException {

		Ruolo ruolo = fetchByPrimaryKey(primaryKey);

		if (ruolo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRuoloException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ruolo;
	}

	/**
	 * Returns the ruolo with the primary key or throws a <code>NoSuchRuoloException</code> if it could not be found.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo
	 * @throws NoSuchRuoloException if a ruolo with the primary key could not be found
	 */
	@Override
	public Ruolo findByPrimaryKey(int id) throws NoSuchRuoloException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the ruolo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ruolo
	 * @return the ruolo, or <code>null</code> if a ruolo with the primary key could not be found
	 */
	@Override
	public Ruolo fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the ruolos.
	 *
	 * @return the ruolos
	 */
	@Override
	public List<Ruolo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Ruolo> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Ruolo> findAll(
		int start, int end, OrderByComparator<Ruolo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Ruolo> findAll(
		int start, int end, OrderByComparator<Ruolo> orderByComparator,
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

		List<Ruolo> list = null;

		if (useFinderCache) {
			list = (List<Ruolo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUOLO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUOLO;

				sql = sql.concat(RuoloModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Ruolo>)QueryUtil.list(
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
	 * Removes all the ruolos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Ruolo ruolo : findAll()) {
			remove(ruolo);
		}
	}

	/**
	 * Returns the number of ruolos.
	 *
	 * @return the number of ruolos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUOLO);

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
		return _SQL_SELECT_RUOLO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RuoloModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ruolo persistence.
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

		RuoloUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RuoloUtil.setPersistence(null);

		entityCache.removeCache(RuoloImpl.class.getName());
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

	private static final String _SQL_SELECT_RUOLO =
		"SELECT ruolo FROM Ruolo ruolo";

	private static final String _SQL_COUNT_RUOLO =
		"SELECT COUNT(ruolo) FROM Ruolo ruolo";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ruolo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Ruolo exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RuoloPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}