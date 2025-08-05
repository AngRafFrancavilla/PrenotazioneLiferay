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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import prenotazione.exception.NoSuchUtenteException;

import prenotazione.model.Utente;
import prenotazione.model.UtenteTable;
import prenotazione.model.impl.UtenteImpl;
import prenotazione.model.impl.UtenteModelImpl;

import prenotazione.service.persistence.UtentePersistence;
import prenotazione.service.persistence.UtenteUtil;
import prenotazione.service.persistence.impl.constants.PersistenceConstants;

/**
 * The persistence implementation for the utente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UtentePersistence.class)
public class UtentePersistenceImpl
	extends BasePersistenceImpl<Utente> implements UtentePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UtenteUtil</code> to access the utente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UtenteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByEmail;

	/**
	 * Returns the utente where email = &#63; or throws a <code>NoSuchUtenteException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching utente
	 * @throws NoSuchUtenteException if a matching utente could not be found
	 */
	@Override
	public Utente findByEmail(String email) throws NoSuchUtenteException {
		Utente utente = fetchByEmail(email);

		if (utente == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("email=");
			sb.append(email);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUtenteException(sb.toString());
		}

		return utente;
	}

	/**
	 * Returns the utente where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching utente, or <code>null</code> if a matching utente could not be found
	 */
	@Override
	public Utente fetchByEmail(String email) {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the utente where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente, or <code>null</code> if a matching utente could not be found
	 */
	@Override
	public Utente fetchByEmail(String email, boolean useFinderCache) {
		email = Objects.toString(email, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {email};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmail, finderArgs, this);
		}

		if (result instanceof Utente) {
			Utente utente = (Utente)result;

			if (!Objects.equals(email, utente.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_UTENTE_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				List<Utente> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmail, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {email};
							}

							_log.warn(
								"UtentePersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Utente utente = list.get(0);

					result = utente;

					cacheResult(utente);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Utente)result;
		}
	}

	/**
	 * Removes the utente where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the utente that was removed
	 */
	@Override
	public Utente removeByEmail(String email) throws NoSuchUtenteException {
		Utente utente = findByEmail(email);

		return remove(utente);
	}

	/**
	 * Returns the number of utentes where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching utentes
	 */
	@Override
	public int countByEmail(String email) {
		Utente utente = fetchByEmail(email);

		if (utente == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"utente.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(utente.email IS NULL OR utente.email = '')";

	public UtentePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("password", "password_");
		dbColumnNames.put("percorsoFoto", "percorso_foto");
		dbColumnNames.put("annoAssunzione", "anno_assunzione");

		setDBColumnNames(dbColumnNames);

		setModelClass(Utente.class);

		setModelImplClass(UtenteImpl.class);
		setModelPKClass(long.class);

		setTable(UtenteTable.INSTANCE);
	}

	/**
	 * Caches the utente in the entity cache if it is enabled.
	 *
	 * @param utente the utente
	 */
	@Override
	public void cacheResult(Utente utente) {
		entityCache.putResult(UtenteImpl.class, utente.getPrimaryKey(), utente);

		finderCache.putResult(
			_finderPathFetchByEmail, new Object[] {utente.getEmail()}, utente);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the utentes in the entity cache if it is enabled.
	 *
	 * @param utentes the utentes
	 */
	@Override
	public void cacheResult(List<Utente> utentes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (utentes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Utente utente : utentes) {
			if (entityCache.getResult(
					UtenteImpl.class, utente.getPrimaryKey()) == null) {

				cacheResult(utente);
			}
		}
	}

	/**
	 * Clears the cache for all utentes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UtenteImpl.class);

		finderCache.clearCache(UtenteImpl.class);
	}

	/**
	 * Clears the cache for the utente.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Utente utente) {
		entityCache.removeResult(UtenteImpl.class, utente);
	}

	@Override
	public void clearCache(List<Utente> utentes) {
		for (Utente utente : utentes) {
			entityCache.removeResult(UtenteImpl.class, utente);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UtenteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UtenteImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(UtenteModelImpl utenteModelImpl) {
		Object[] args = new Object[] {utenteModelImpl.getEmail()};

		finderCache.putResult(_finderPathFetchByEmail, args, utenteModelImpl);
	}

	/**
	 * Creates a new utente with the primary key. Does not add the utente to the database.
	 *
	 * @param id the primary key for the new utente
	 * @return the new utente
	 */
	@Override
	public Utente create(long id) {
		Utente utente = new UtenteImpl();

		utente.setNew(true);
		utente.setPrimaryKey(id);

		return utente;
	}

	/**
	 * Removes the utente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the utente
	 * @return the utente that was removed
	 * @throws NoSuchUtenteException if a utente with the primary key could not be found
	 */
	@Override
	public Utente remove(long id) throws NoSuchUtenteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the utente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the utente
	 * @return the utente that was removed
	 * @throws NoSuchUtenteException if a utente with the primary key could not be found
	 */
	@Override
	public Utente remove(Serializable primaryKey) throws NoSuchUtenteException {
		Session session = null;

		try {
			session = openSession();

			Utente utente = (Utente)session.get(UtenteImpl.class, primaryKey);

			if (utente == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUtenteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(utente);
		}
		catch (NoSuchUtenteException noSuchEntityException) {
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
	protected Utente removeImpl(Utente utente) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(utente)) {
				utente = (Utente)session.get(
					UtenteImpl.class, utente.getPrimaryKeyObj());
			}

			if (utente != null) {
				session.delete(utente);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (utente != null) {
			clearCache(utente);
		}

		return utente;
	}

	@Override
	public Utente updateImpl(Utente utente) {
		boolean isNew = utente.isNew();

		if (!(utente instanceof UtenteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(utente.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(utente);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in utente proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Utente implementation " +
					utente.getClass());
		}

		UtenteModelImpl utenteModelImpl = (UtenteModelImpl)utente;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(utente);
			}
			else {
				utente = (Utente)session.merge(utente);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(UtenteImpl.class, utenteModelImpl, false, true);

		cacheUniqueFindersCache(utenteModelImpl);

		if (isNew) {
			utente.setNew(false);
		}

		utente.resetOriginalValues();

		return utente;
	}

	/**
	 * Returns the utente with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the utente
	 * @return the utente
	 * @throws NoSuchUtenteException if a utente with the primary key could not be found
	 */
	@Override
	public Utente findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUtenteException {

		Utente utente = fetchByPrimaryKey(primaryKey);

		if (utente == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUtenteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return utente;
	}

	/**
	 * Returns the utente with the primary key or throws a <code>NoSuchUtenteException</code> if it could not be found.
	 *
	 * @param id the primary key of the utente
	 * @return the utente
	 * @throws NoSuchUtenteException if a utente with the primary key could not be found
	 */
	@Override
	public Utente findByPrimaryKey(long id) throws NoSuchUtenteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the utente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the utente
	 * @return the utente, or <code>null</code> if a utente with the primary key could not be found
	 */
	@Override
	public Utente fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the utentes.
	 *
	 * @return the utentes
	 */
	@Override
	public List<Utente> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Utente> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Utente> findAll(
		int start, int end, OrderByComparator<Utente> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Utente> findAll(
		int start, int end, OrderByComparator<Utente> orderByComparator,
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

		List<Utente> list = null;

		if (useFinderCache) {
			list = (List<Utente>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_UTENTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_UTENTE;

				sql = sql.concat(UtenteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Utente>)QueryUtil.list(
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
	 * Removes all the utentes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Utente utente : findAll()) {
			remove(utente);
		}
	}

	/**
	 * Returns the number of utentes.
	 *
	 * @return the number of utentes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_UTENTE);

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
		return _SQL_SELECT_UTENTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UtenteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the utente persistence.
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

		_finderPathFetchByEmail = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		UtenteUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		UtenteUtil.setPersistence(null);

		entityCache.removeCache(UtenteImpl.class.getName());
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

	private static final String _SQL_SELECT_UTENTE =
		"SELECT utente FROM Utente utente";

	private static final String _SQL_SELECT_UTENTE_WHERE =
		"SELECT utente FROM Utente utente WHERE ";

	private static final String _SQL_COUNT_UTENTE =
		"SELECT COUNT(utente) FROM Utente utente";

	private static final String _SQL_COUNT_UTENTE_WHERE =
		"SELECT COUNT(utente) FROM Utente utente WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "utente.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Utente exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Utente exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UtentePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "password", "percorsoFoto", "annoAssunzione"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}