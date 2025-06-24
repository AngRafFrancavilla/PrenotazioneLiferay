/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import prenotazione.exception.NoSuchPrenotazioneException;

import prenotazione.model.Prenotazione;

import prenotazione.service.PrenotazioneLocalServiceUtil;
import prenotazione.service.persistence.PrenotazionePersistence;
import prenotazione.service.persistence.PrenotazioneUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PrenotazionePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "prenotazione.service"));

	@Before
	public void setUp() {
		_persistence = PrenotazioneUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Prenotazione> iterator = _prenotaziones.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazione prenotazione = _persistence.create(pk);

		Assert.assertNotNull(prenotazione);

		Assert.assertEquals(prenotazione.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Prenotazione newPrenotazione = addPrenotazione();

		_persistence.remove(newPrenotazione);

		Prenotazione existingPrenotazione = _persistence.fetchByPrimaryKey(
			newPrenotazione.getPrimaryKey());

		Assert.assertNull(existingPrenotazione);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPrenotazione();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazione newPrenotazione = _persistence.create(pk);

		newPrenotazione.setUuid(RandomTestUtil.randomString());

		newPrenotazione.setGroupId(RandomTestUtil.nextLong());

		newPrenotazione.setCompanyId(RandomTestUtil.nextLong());

		newPrenotazione.setUserId(RandomTestUtil.nextLong());

		newPrenotazione.setUserName(RandomTestUtil.randomString());

		newPrenotazione.setCreateDate(RandomTestUtil.nextDate());

		newPrenotazione.setModifiedDate(RandomTestUtil.nextDate());

		newPrenotazione.setEmail(RandomTestUtil.randomString());

		newPrenotazione.setData(RandomTestUtil.nextDate());

		newPrenotazione.setOraInizio(RandomTestUtil.randomString());

		newPrenotazione.setOraFine(RandomTestUtil.randomString());

		newPrenotazione.setPostazioneId(RandomTestUtil.randomString());

		_prenotaziones.add(_persistence.update(newPrenotazione));

		Prenotazione existingPrenotazione = _persistence.findByPrimaryKey(
			newPrenotazione.getPrimaryKey());

		Assert.assertEquals(
			existingPrenotazione.getUuid(), newPrenotazione.getUuid());
		Assert.assertEquals(
			existingPrenotazione.getPrenotazioneId(),
			newPrenotazione.getPrenotazioneId());
		Assert.assertEquals(
			existingPrenotazione.getGroupId(), newPrenotazione.getGroupId());
		Assert.assertEquals(
			existingPrenotazione.getCompanyId(),
			newPrenotazione.getCompanyId());
		Assert.assertEquals(
			existingPrenotazione.getUserId(), newPrenotazione.getUserId());
		Assert.assertEquals(
			existingPrenotazione.getUserName(), newPrenotazione.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazione.getCreateDate()),
			Time.getShortTimestamp(newPrenotazione.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazione.getModifiedDate()),
			Time.getShortTimestamp(newPrenotazione.getModifiedDate()));
		Assert.assertEquals(
			existingPrenotazione.getEmail(), newPrenotazione.getEmail());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazione.getData()),
			Time.getShortTimestamp(newPrenotazione.getData()));
		Assert.assertEquals(
			existingPrenotazione.getOraInizio(),
			newPrenotazione.getOraInizio());
		Assert.assertEquals(
			existingPrenotazione.getOraFine(), newPrenotazione.getOraFine());
		Assert.assertEquals(
			existingPrenotazione.getPostazioneId(),
			newPrenotazione.getPostazioneId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Prenotazione newPrenotazione = addPrenotazione();

		Prenotazione existingPrenotazione = _persistence.findByPrimaryKey(
			newPrenotazione.getPrimaryKey());

		Assert.assertEquals(existingPrenotazione, newPrenotazione);
	}

	@Test(expected = NoSuchPrenotazioneException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Prenotazione> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Prenotazione", "uuid", true, "prenotazioneId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "email", true, "data",
			true, "oraInizio", true, "oraFine", true, "postazioneId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Prenotazione newPrenotazione = addPrenotazione();

		Prenotazione existingPrenotazione = _persistence.fetchByPrimaryKey(
			newPrenotazione.getPrimaryKey());

		Assert.assertEquals(existingPrenotazione, newPrenotazione);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazione missingPrenotazione = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPrenotazione);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Prenotazione newPrenotazione1 = addPrenotazione();
		Prenotazione newPrenotazione2 = addPrenotazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrenotazione1.getPrimaryKey());
		primaryKeys.add(newPrenotazione2.getPrimaryKey());

		Map<Serializable, Prenotazione> prenotaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, prenotaziones.size());
		Assert.assertEquals(
			newPrenotazione1,
			prenotaziones.get(newPrenotazione1.getPrimaryKey()));
		Assert.assertEquals(
			newPrenotazione2,
			prenotaziones.get(newPrenotazione2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Prenotazione> prenotaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(prenotaziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Prenotazione newPrenotazione = addPrenotazione();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrenotazione.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Prenotazione> prenotaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, prenotaziones.size());
		Assert.assertEquals(
			newPrenotazione,
			prenotaziones.get(newPrenotazione.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Prenotazione> prenotaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(prenotaziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Prenotazione newPrenotazione = addPrenotazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrenotazione.getPrimaryKey());

		Map<Serializable, Prenotazione> prenotaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, prenotaziones.size());
		Assert.assertEquals(
			newPrenotazione,
			prenotaziones.get(newPrenotazione.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PrenotazioneLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Prenotazione>() {

				@Override
				public void performAction(Prenotazione prenotazione) {
					Assert.assertNotNull(prenotazione);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Prenotazione newPrenotazione = addPrenotazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"prenotazioneId", newPrenotazione.getPrenotazioneId()));

		List<Prenotazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Prenotazione existingPrenotazione = result.get(0);

		Assert.assertEquals(existingPrenotazione, newPrenotazione);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"prenotazioneId", RandomTestUtil.nextLong()));

		List<Prenotazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Prenotazione newPrenotazione = addPrenotazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("prenotazioneId"));

		Object newPrenotazioneId = newPrenotazione.getPrenotazioneId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"prenotazioneId", new Object[] {newPrenotazioneId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPrenotazioneId = result.get(0);

		Assert.assertEquals(existingPrenotazioneId, newPrenotazioneId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("prenotazioneId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"prenotazioneId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Prenotazione newPrenotazione = addPrenotazione();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newPrenotazione.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Prenotazione newPrenotazione = addPrenotazione();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"prenotazioneId", newPrenotazione.getPrenotazioneId()));

		List<Prenotazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Prenotazione prenotazione) {
		Assert.assertEquals(
			prenotazione.getUuid(),
			ReflectionTestUtil.invoke(
				prenotazione, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(prenotazione.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				prenotazione, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Prenotazione addPrenotazione() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazione prenotazione = _persistence.create(pk);

		prenotazione.setUuid(RandomTestUtil.randomString());

		prenotazione.setGroupId(RandomTestUtil.nextLong());

		prenotazione.setCompanyId(RandomTestUtil.nextLong());

		prenotazione.setUserId(RandomTestUtil.nextLong());

		prenotazione.setUserName(RandomTestUtil.randomString());

		prenotazione.setCreateDate(RandomTestUtil.nextDate());

		prenotazione.setModifiedDate(RandomTestUtil.nextDate());

		prenotazione.setEmail(RandomTestUtil.randomString());

		prenotazione.setData(RandomTestUtil.nextDate());

		prenotazione.setOraInizio(RandomTestUtil.randomString());

		prenotazione.setOraFine(RandomTestUtil.randomString());

		prenotazione.setPostazioneId(RandomTestUtil.randomString());

		_prenotaziones.add(_persistence.update(prenotazione));

		return prenotazione;
	}

	private List<Prenotazione> _prenotaziones = new ArrayList<Prenotazione>();
	private PrenotazionePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}