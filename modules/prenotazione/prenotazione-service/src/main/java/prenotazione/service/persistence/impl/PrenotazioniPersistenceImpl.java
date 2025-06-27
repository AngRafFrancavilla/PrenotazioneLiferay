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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
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

import prenotazione.exception.NoSuchPrenotazioniException;

import prenotazione.model.Prenotazioni;
import prenotazione.model.PrenotazioniTable;
import prenotazione.model.impl.PrenotazioniImpl;
import prenotazione.model.impl.PrenotazioniModelImpl;

import prenotazione.service.persistence.PrenotazioniPersistence;
import prenotazione.service.persistence.PrenotazioniUtil;
import prenotazione.service.persistence.impl.constants.PersistenceConstants;

/**
 * The persistence implementation for the prenotazioni service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PrenotazioniPersistence.class)
public class PrenotazioniPersistenceImpl
	extends BasePersistenceImpl<Prenotazioni>
	implements PrenotazioniPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PrenotazioniUtil</code> to access the prenotazioni persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PrenotazioniImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the prenotazionis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prenotazionis
	 */
	@Override
	public List<Prenotazioni> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prenotazionis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @return the range of matching prenotazionis
	 */
	@Override
	public List<Prenotazioni> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the prenotazionis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prenotazionis
	 */
	@Override
	public List<Prenotazioni> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prenotazionis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prenotazionis
	 */
	@Override
	public List<Prenotazioni> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Prenotazioni> list = null;

		if (useFinderCache) {
			list = (List<Prenotazioni>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Prenotazioni prenotazioni : list) {
					if (!uuid.equals(prenotazioni.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PRENOTAZIONI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrenotazioniModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Prenotazioni>)QueryUtil.list(
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
	 * Returns the first prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni findByUuid_First(
			String uuid, OrderByComparator<Prenotazioni> orderByComparator)
		throws NoSuchPrenotazioniException {

		Prenotazioni prenotazioni = fetchByUuid_First(uuid, orderByComparator);

		if (prenotazioni != null) {
			return prenotazioni;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPrenotazioniException(sb.toString());
	}

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni fetchByUuid_First(
		String uuid, OrderByComparator<Prenotazioni> orderByComparator) {

		List<Prenotazioni> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni findByUuid_Last(
			String uuid, OrderByComparator<Prenotazioni> orderByComparator)
		throws NoSuchPrenotazioniException {

		Prenotazioni prenotazioni = fetchByUuid_Last(uuid, orderByComparator);

		if (prenotazioni != null) {
			return prenotazioni;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPrenotazioniException(sb.toString());
	}

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni fetchByUuid_Last(
		String uuid, OrderByComparator<Prenotazioni> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Prenotazioni> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the prenotazionis before and after the current prenotazioni in the ordered set where uuid = &#63;.
	 *
	 * @param prenotazioneId the primary key of the current prenotazioni
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	@Override
	public Prenotazioni[] findByUuid_PrevAndNext(
			long prenotazioneId, String uuid,
			OrderByComparator<Prenotazioni> orderByComparator)
		throws NoSuchPrenotazioniException {

		uuid = Objects.toString(uuid, "");

		Prenotazioni prenotazioni = findByPrimaryKey(prenotazioneId);

		Session session = null;

		try {
			session = openSession();

			Prenotazioni[] array = new PrenotazioniImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, prenotazioni, uuid, orderByComparator, true);

			array[1] = prenotazioni;

			array[2] = getByUuid_PrevAndNext(
				session, prenotazioni, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Prenotazioni getByUuid_PrevAndNext(
		Session session, Prenotazioni prenotazioni, String uuid,
		OrderByComparator<Prenotazioni> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRENOTAZIONI_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PrenotazioniModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(prenotazioni)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Prenotazioni> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the prenotazionis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Prenotazioni prenotazioni :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(prenotazioni);
		}
	}

	/**
	 * Returns the number of prenotazionis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prenotazionis
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRENOTAZIONI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"prenotazioni.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(prenotazioni.uuid IS NULL OR prenotazioni.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPrenotazioniException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni findByUUID_G(String uuid, long groupId)
		throws NoSuchPrenotazioniException {

		Prenotazioni prenotazioni = fetchByUUID_G(uuid, groupId);

		if (prenotazioni == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPrenotazioniException(sb.toString());
		}

		return prenotazioni;
	}

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the prenotazioni where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Prenotazioni) {
			Prenotazioni prenotazioni = (Prenotazioni)result;

			if (!Objects.equals(uuid, prenotazioni.getUuid()) ||
				(groupId != prenotazioni.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRENOTAZIONI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Prenotazioni> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Prenotazioni prenotazioni = list.get(0);

					result = prenotazioni;

					cacheResult(prenotazioni);
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
			return (Prenotazioni)result;
		}
	}

	/**
	 * Removes the prenotazioni where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the prenotazioni that was removed
	 */
	@Override
	public Prenotazioni removeByUUID_G(String uuid, long groupId)
		throws NoSuchPrenotazioniException {

		Prenotazioni prenotazioni = findByUUID_G(uuid, groupId);

		return remove(prenotazioni);
	}

	/**
	 * Returns the number of prenotazionis where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching prenotazionis
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Prenotazioni prenotazioni = fetchByUUID_G(uuid, groupId);

		if (prenotazioni == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"prenotazioni.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(prenotazioni.uuid IS NULL OR prenotazioni.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"prenotazioni.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching prenotazionis
	 */
	@Override
	public List<Prenotazioni> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @return the range of matching prenotazionis
	 */
	@Override
	public List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prenotazionis
	 */
	@Override
	public List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prenotazionis
	 */
	@Override
	public List<Prenotazioni> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Prenotazioni> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Prenotazioni> list = null;

		if (useFinderCache) {
			list = (List<Prenotazioni>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Prenotazioni prenotazioni : list) {
					if (!uuid.equals(prenotazioni.getUuid()) ||
						(companyId != prenotazioni.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PRENOTAZIONI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrenotazioniModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Prenotazioni>)QueryUtil.list(
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
	 * Returns the first prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Prenotazioni> orderByComparator)
		throws NoSuchPrenotazioniException {

		Prenotazioni prenotazioni = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (prenotazioni != null) {
			return prenotazioni;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPrenotazioniException(sb.toString());
	}

	/**
	 * Returns the first prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Prenotazioni> orderByComparator) {

		List<Prenotazioni> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni
	 * @throws NoSuchPrenotazioniException if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Prenotazioni> orderByComparator)
		throws NoSuchPrenotazioniException {

		Prenotazioni prenotazioni = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (prenotazioni != null) {
			return prenotazioni;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPrenotazioniException(sb.toString());
	}

	/**
	 * Returns the last prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazioni, or <code>null</code> if a matching prenotazioni could not be found
	 */
	@Override
	public Prenotazioni fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Prenotazioni> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Prenotazioni> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the prenotazionis before and after the current prenotazioni in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param prenotazioneId the primary key of the current prenotazioni
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	@Override
	public Prenotazioni[] findByUuid_C_PrevAndNext(
			long prenotazioneId, String uuid, long companyId,
			OrderByComparator<Prenotazioni> orderByComparator)
		throws NoSuchPrenotazioniException {

		uuid = Objects.toString(uuid, "");

		Prenotazioni prenotazioni = findByPrimaryKey(prenotazioneId);

		Session session = null;

		try {
			session = openSession();

			Prenotazioni[] array = new PrenotazioniImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, prenotazioni, uuid, companyId, orderByComparator,
				true);

			array[1] = prenotazioni;

			array[2] = getByUuid_C_PrevAndNext(
				session, prenotazioni, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Prenotazioni getByUuid_C_PrevAndNext(
		Session session, Prenotazioni prenotazioni, String uuid, long companyId,
		OrderByComparator<Prenotazioni> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PRENOTAZIONI_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PrenotazioniModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(prenotazioni)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Prenotazioni> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the prenotazionis where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Prenotazioni prenotazioni :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(prenotazioni);
		}
	}

	/**
	 * Returns the number of prenotazionis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching prenotazionis
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRENOTAZIONI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"prenotazioni.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(prenotazioni.uuid IS NULL OR prenotazioni.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"prenotazioni.companyId = ?";

	public PrenotazioniPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("data", "data_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Prenotazioni.class);

		setModelImplClass(PrenotazioniImpl.class);
		setModelPKClass(long.class);

		setTable(PrenotazioniTable.INSTANCE);
	}

	/**
	 * Caches the prenotazioni in the entity cache if it is enabled.
	 *
	 * @param prenotazioni the prenotazioni
	 */
	@Override
	public void cacheResult(Prenotazioni prenotazioni) {
		entityCache.putResult(
			PrenotazioniImpl.class, prenotazioni.getPrimaryKey(), prenotazioni);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {prenotazioni.getUuid(), prenotazioni.getGroupId()},
			prenotazioni);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the prenotazionis in the entity cache if it is enabled.
	 *
	 * @param prenotazionis the prenotazionis
	 */
	@Override
	public void cacheResult(List<Prenotazioni> prenotazionis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (prenotazionis.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Prenotazioni prenotazioni : prenotazionis) {
			if (entityCache.getResult(
					PrenotazioniImpl.class, prenotazioni.getPrimaryKey()) ==
						null) {

				cacheResult(prenotazioni);
			}
		}
	}

	/**
	 * Clears the cache for all prenotazionis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PrenotazioniImpl.class);

		finderCache.clearCache(PrenotazioniImpl.class);
	}

	/**
	 * Clears the cache for the prenotazioni.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Prenotazioni prenotazioni) {
		entityCache.removeResult(PrenotazioniImpl.class, prenotazioni);
	}

	@Override
	public void clearCache(List<Prenotazioni> prenotazionis) {
		for (Prenotazioni prenotazioni : prenotazionis) {
			entityCache.removeResult(PrenotazioniImpl.class, prenotazioni);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PrenotazioniImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PrenotazioniImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PrenotazioniModelImpl prenotazioniModelImpl) {

		Object[] args = new Object[] {
			prenotazioniModelImpl.getUuid(), prenotazioniModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, prenotazioniModelImpl);
	}

	/**
	 * Creates a new prenotazioni with the primary key. Does not add the prenotazioni to the database.
	 *
	 * @param prenotazioneId the primary key for the new prenotazioni
	 * @return the new prenotazioni
	 */
	@Override
	public Prenotazioni create(long prenotazioneId) {
		Prenotazioni prenotazioni = new PrenotazioniImpl();

		prenotazioni.setNew(true);
		prenotazioni.setPrimaryKey(prenotazioneId);

		String uuid = PortalUUIDUtil.generate();

		prenotazioni.setUuid(uuid);

		prenotazioni.setCompanyId(CompanyThreadLocal.getCompanyId());

		return prenotazioni;
	}

	/**
	 * Removes the prenotazioni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni that was removed
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	@Override
	public Prenotazioni remove(long prenotazioneId)
		throws NoSuchPrenotazioniException {

		return remove((Serializable)prenotazioneId);
	}

	/**
	 * Removes the prenotazioni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the prenotazioni
	 * @return the prenotazioni that was removed
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	@Override
	public Prenotazioni remove(Serializable primaryKey)
		throws NoSuchPrenotazioniException {

		Session session = null;

		try {
			session = openSession();

			Prenotazioni prenotazioni = (Prenotazioni)session.get(
				PrenotazioniImpl.class, primaryKey);

			if (prenotazioni == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrenotazioniException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(prenotazioni);
		}
		catch (NoSuchPrenotazioniException noSuchEntityException) {
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
	protected Prenotazioni removeImpl(Prenotazioni prenotazioni) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(prenotazioni)) {
				prenotazioni = (Prenotazioni)session.get(
					PrenotazioniImpl.class, prenotazioni.getPrimaryKeyObj());
			}

			if (prenotazioni != null) {
				session.delete(prenotazioni);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (prenotazioni != null) {
			clearCache(prenotazioni);
		}

		return prenotazioni;
	}

	@Override
	public Prenotazioni updateImpl(Prenotazioni prenotazioni) {
		boolean isNew = prenotazioni.isNew();

		if (!(prenotazioni instanceof PrenotazioniModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(prenotazioni.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					prenotazioni);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in prenotazioni proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Prenotazioni implementation " +
					prenotazioni.getClass());
		}

		PrenotazioniModelImpl prenotazioniModelImpl =
			(PrenotazioniModelImpl)prenotazioni;

		if (Validator.isNull(prenotazioni.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			prenotazioni.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (prenotazioni.getCreateDate() == null)) {
			if (serviceContext == null) {
				prenotazioni.setCreateDate(date);
			}
			else {
				prenotazioni.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!prenotazioniModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				prenotazioni.setModifiedDate(date);
			}
			else {
				prenotazioni.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(prenotazioni);
			}
			else {
				prenotazioni = (Prenotazioni)session.merge(prenotazioni);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PrenotazioniImpl.class, prenotazioniModelImpl, false, true);

		cacheUniqueFindersCache(prenotazioniModelImpl);

		if (isNew) {
			prenotazioni.setNew(false);
		}

		prenotazioni.resetOriginalValues();

		return prenotazioni;
	}

	/**
	 * Returns the prenotazioni with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the prenotazioni
	 * @return the prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	@Override
	public Prenotazioni findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrenotazioniException {

		Prenotazioni prenotazioni = fetchByPrimaryKey(primaryKey);

		if (prenotazioni == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrenotazioniException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return prenotazioni;
	}

	/**
	 * Returns the prenotazioni with the primary key or throws a <code>NoSuchPrenotazioniException</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni
	 * @throws NoSuchPrenotazioniException if a prenotazioni with the primary key could not be found
	 */
	@Override
	public Prenotazioni findByPrimaryKey(long prenotazioneId)
		throws NoSuchPrenotazioniException {

		return findByPrimaryKey((Serializable)prenotazioneId);
	}

	/**
	 * Returns the prenotazioni with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param prenotazioneId the primary key of the prenotazioni
	 * @return the prenotazioni, or <code>null</code> if a prenotazioni with the primary key could not be found
	 */
	@Override
	public Prenotazioni fetchByPrimaryKey(long prenotazioneId) {
		return fetchByPrimaryKey((Serializable)prenotazioneId);
	}

	/**
	 * Returns all the prenotazionis.
	 *
	 * @return the prenotazionis
	 */
	@Override
	public List<Prenotazioni> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prenotazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @return the range of prenotazionis
	 */
	@Override
	public List<Prenotazioni> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the prenotazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of prenotazionis
	 */
	@Override
	public List<Prenotazioni> findAll(
		int start, int end, OrderByComparator<Prenotazioni> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prenotazionis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrenotazioniModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotazionis
	 * @param end the upper bound of the range of prenotazionis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of prenotazionis
	 */
	@Override
	public List<Prenotazioni> findAll(
		int start, int end, OrderByComparator<Prenotazioni> orderByComparator,
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

		List<Prenotazioni> list = null;

		if (useFinderCache) {
			list = (List<Prenotazioni>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRENOTAZIONI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRENOTAZIONI;

				sql = sql.concat(PrenotazioniModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Prenotazioni>)QueryUtil.list(
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
	 * Removes all the prenotazionis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Prenotazioni prenotazioni : findAll()) {
			remove(prenotazioni);
		}
	}

	/**
	 * Returns the number of prenotazionis.
	 *
	 * @return the number of prenotazionis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRENOTAZIONI);

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
		return "prenotazioneId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRENOTAZIONI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PrenotazioniModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the prenotazioni persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		PrenotazioniUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PrenotazioniUtil.setPersistence(null);

		entityCache.removeCache(PrenotazioniImpl.class.getName());
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

	private static final String _SQL_SELECT_PRENOTAZIONI =
		"SELECT prenotazioni FROM Prenotazioni prenotazioni";

	private static final String _SQL_SELECT_PRENOTAZIONI_WHERE =
		"SELECT prenotazioni FROM Prenotazioni prenotazioni WHERE ";

	private static final String _SQL_COUNT_PRENOTAZIONI =
		"SELECT COUNT(prenotazioni) FROM Prenotazioni prenotazioni";

	private static final String _SQL_COUNT_PRENOTAZIONI_WHERE =
		"SELECT COUNT(prenotazioni) FROM Prenotazioni prenotazioni WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "prenotazioni.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Prenotazioni exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Prenotazioni exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PrenotazioniPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "data"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}