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

import prenotazione.exception.NoSuchPostazioneException;

import prenotazione.model.Postazione;
import prenotazione.model.PostazioneTable;
import prenotazione.model.impl.PostazioneImpl;
import prenotazione.model.impl.PostazioneModelImpl;

import prenotazione.service.persistence.PostazionePersistence;
import prenotazione.service.persistence.PostazioneUtil;
import prenotazione.service.persistence.impl.constants.PersistenceConstants;

/**
 * The persistence implementation for the postazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PostazionePersistence.class)
public class PostazionePersistenceImpl
	extends BasePersistenceImpl<Postazione> implements PostazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PostazioneUtil</code> to access the postazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PostazioneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PostazionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("postazioneId", "id");
		dbColumnNames.put("stanzaId", "stanza_id");
		dbColumnNames.put("nomePostazione", "nome_postazione");

		setDBColumnNames(dbColumnNames);

		setModelClass(Postazione.class);

		setModelImplClass(PostazioneImpl.class);
		setModelPKClass(long.class);

		setTable(PostazioneTable.INSTANCE);
	}

	/**
	 * Caches the postazione in the entity cache if it is enabled.
	 *
	 * @param postazione the postazione
	 */
	@Override
	public void cacheResult(Postazione postazione) {
		entityCache.putResult(
			PostazioneImpl.class, postazione.getPrimaryKey(), postazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the postaziones in the entity cache if it is enabled.
	 *
	 * @param postaziones the postaziones
	 */
	@Override
	public void cacheResult(List<Postazione> postaziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (postaziones.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Postazione postazione : postaziones) {
			if (entityCache.getResult(
					PostazioneImpl.class, postazione.getPrimaryKey()) == null) {

				cacheResult(postazione);
			}
		}
	}

	/**
	 * Clears the cache for all postaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PostazioneImpl.class);

		finderCache.clearCache(PostazioneImpl.class);
	}

	/**
	 * Clears the cache for the postazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Postazione postazione) {
		entityCache.removeResult(PostazioneImpl.class, postazione);
	}

	@Override
	public void clearCache(List<Postazione> postaziones) {
		for (Postazione postazione : postaziones) {
			entityCache.removeResult(PostazioneImpl.class, postazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PostazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PostazioneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new postazione with the primary key. Does not add the postazione to the database.
	 *
	 * @param postazioneId the primary key for the new postazione
	 * @return the new postazione
	 */
	@Override
	public Postazione create(long postazioneId) {
		Postazione postazione = new PostazioneImpl();

		postazione.setNew(true);
		postazione.setPrimaryKey(postazioneId);

		return postazione;
	}

	/**
	 * Removes the postazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione that was removed
	 * @throws NoSuchPostazioneException if a postazione with the primary key could not be found
	 */
	@Override
	public Postazione remove(long postazioneId)
		throws NoSuchPostazioneException {

		return remove((Serializable)postazioneId);
	}

	/**
	 * Removes the postazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the postazione
	 * @return the postazione that was removed
	 * @throws NoSuchPostazioneException if a postazione with the primary key could not be found
	 */
	@Override
	public Postazione remove(Serializable primaryKey)
		throws NoSuchPostazioneException {

		Session session = null;

		try {
			session = openSession();

			Postazione postazione = (Postazione)session.get(
				PostazioneImpl.class, primaryKey);

			if (postazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(postazione);
		}
		catch (NoSuchPostazioneException noSuchEntityException) {
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
	protected Postazione removeImpl(Postazione postazione) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(postazione)) {
				postazione = (Postazione)session.get(
					PostazioneImpl.class, postazione.getPrimaryKeyObj());
			}

			if (postazione != null) {
				session.delete(postazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (postazione != null) {
			clearCache(postazione);
		}

		return postazione;
	}

	@Override
	public Postazione updateImpl(Postazione postazione) {
		boolean isNew = postazione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(postazione);
			}
			else {
				postazione = (Postazione)session.merge(postazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PostazioneImpl.class, postazione, false, true);

		if (isNew) {
			postazione.setNew(false);
		}

		postazione.resetOriginalValues();

		return postazione;
	}

	/**
	 * Returns the postazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the postazione
	 * @return the postazione
	 * @throws NoSuchPostazioneException if a postazione with the primary key could not be found
	 */
	@Override
	public Postazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostazioneException {

		Postazione postazione = fetchByPrimaryKey(primaryKey);

		if (postazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return postazione;
	}

	/**
	 * Returns the postazione with the primary key or throws a <code>NoSuchPostazioneException</code> if it could not be found.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione
	 * @throws NoSuchPostazioneException if a postazione with the primary key could not be found
	 */
	@Override
	public Postazione findByPrimaryKey(long postazioneId)
		throws NoSuchPostazioneException {

		return findByPrimaryKey((Serializable)postazioneId);
	}

	/**
	 * Returns the postazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postazioneId the primary key of the postazione
	 * @return the postazione, or <code>null</code> if a postazione with the primary key could not be found
	 */
	@Override
	public Postazione fetchByPrimaryKey(long postazioneId) {
		return fetchByPrimaryKey((Serializable)postazioneId);
	}

	/**
	 * Returns all the postaziones.
	 *
	 * @return the postaziones
	 */
	@Override
	public List<Postazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Postazione> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Postazione> findAll(
		int start, int end, OrderByComparator<Postazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Postazione> findAll(
		int start, int end, OrderByComparator<Postazione> orderByComparator,
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

		List<Postazione> list = null;

		if (useFinderCache) {
			list = (List<Postazione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POSTAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POSTAZIONE;

				sql = sql.concat(PostazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Postazione>)QueryUtil.list(
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
	 * Removes all the postaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Postazione postazione : findAll()) {
			remove(postazione);
		}
	}

	/**
	 * Returns the number of postaziones.
	 *
	 * @return the number of postaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POSTAZIONE);

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
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POSTAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PostazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the postazione persistence.
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

		PostazioneUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PostazioneUtil.setPersistence(null);

		entityCache.removeCache(PostazioneImpl.class.getName());
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

	private static final String _SQL_SELECT_POSTAZIONE =
		"SELECT postazione FROM Postazione postazione";

	private static final String _SQL_COUNT_POSTAZIONE =
		"SELECT COUNT(postazione) FROM Postazione postazione";

	private static final String _ORDER_BY_ENTITY_ALIAS = "postazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Postazione exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PostazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"postazioneId", "stanzaId", "nomePostazione"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}