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

import prenotazione.exception.NoSuchPrenotazioniException;

import prenotazione.model.Prenotazioni;

import prenotazione.service.PrenotazioniLocalServiceUtil;
import prenotazione.service.persistence.PrenotazioniPersistence;
import prenotazione.service.persistence.PrenotazioniUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PrenotazioniPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "prenotazione.service"));

	@Before
	public void setUp() {
		_persistence = PrenotazioniUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Prenotazioni> iterator = _prenotazionis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazioni prenotazioni = _persistence.create(pk);

		Assert.assertNotNull(prenotazioni);

		Assert.assertEquals(prenotazioni.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Prenotazioni newPrenotazioni = addPrenotazioni();

		_persistence.remove(newPrenotazioni);

		Prenotazioni existingPrenotazioni = _persistence.fetchByPrimaryKey(
			newPrenotazioni.getPrimaryKey());

		Assert.assertNull(existingPrenotazioni);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPrenotazioni();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazioni newPrenotazioni = _persistence.create(pk);

		newPrenotazioni.setUuid(RandomTestUtil.randomString());

		newPrenotazioni.setGroupId(RandomTestUtil.nextLong());

		newPrenotazioni.setCompanyId(RandomTestUtil.nextLong());

		newPrenotazioni.setUserId(RandomTestUtil.nextLong());

		newPrenotazioni.setUserName(RandomTestUtil.randomString());

		newPrenotazioni.setCreateDate(RandomTestUtil.nextDate());

		newPrenotazioni.setModifiedDate(RandomTestUtil.nextDate());

		newPrenotazioni.setEmail(RandomTestUtil.randomString());

		newPrenotazioni.setData(RandomTestUtil.nextDate());

		newPrenotazioni.setOraInizio(RandomTestUtil.randomString());

		newPrenotazioni.setOraFine(RandomTestUtil.randomString());

		newPrenotazioni.setPostazioneId(RandomTestUtil.randomString());

		_prenotazionis.add(_persistence.update(newPrenotazioni));

		Prenotazioni existingPrenotazioni = _persistence.findByPrimaryKey(
			newPrenotazioni.getPrimaryKey());

		Assert.assertEquals(
			existingPrenotazioni.getUuid(), newPrenotazioni.getUuid());
		Assert.assertEquals(
			existingPrenotazioni.getPrenotazioneId(),
			newPrenotazioni.getPrenotazioneId());
		Assert.assertEquals(
			existingPrenotazioni.getGroupId(), newPrenotazioni.getGroupId());
		Assert.assertEquals(
			existingPrenotazioni.getCompanyId(),
			newPrenotazioni.getCompanyId());
		Assert.assertEquals(
			existingPrenotazioni.getUserId(), newPrenotazioni.getUserId());
		Assert.assertEquals(
			existingPrenotazioni.getUserName(), newPrenotazioni.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazioni.getCreateDate()),
			Time.getShortTimestamp(newPrenotazioni.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazioni.getModifiedDate()),
			Time.getShortTimestamp(newPrenotazioni.getModifiedDate()));
		Assert.assertEquals(
			existingPrenotazioni.getEmail(), newPrenotazioni.getEmail());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazioni.getData()),
			Time.getShortTimestamp(newPrenotazioni.getData()));
		Assert.assertEquals(
			existingPrenotazioni.getOraInizio(),
			newPrenotazioni.getOraInizio());
		Assert.assertEquals(
			existingPrenotazioni.getOraFine(), newPrenotazioni.getOraFine());
		Assert.assertEquals(
			existingPrenotazioni.getPostazioneId(),
			newPrenotazioni.getPostazioneId());
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
		Prenotazioni newPrenotazioni = addPrenotazioni();

		Prenotazioni existingPrenotazioni = _persistence.findByPrimaryKey(
			newPrenotazioni.getPrimaryKey());

		Assert.assertEquals(existingPrenotazioni, newPrenotazioni);
	}

	@Test(expected = NoSuchPrenotazioniException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Prenotazioni> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Prenotazioni", "uuid", true, "prenotazioneId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "email", true, "data",
			true, "oraInizio", true, "oraFine", true, "postazioneId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Prenotazioni newPrenotazioni = addPrenotazioni();

		Prenotazioni existingPrenotazioni = _persistence.fetchByPrimaryKey(
			newPrenotazioni.getPrimaryKey());

		Assert.assertEquals(existingPrenotazioni, newPrenotazioni);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazioni missingPrenotazioni = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPrenotazioni);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Prenotazioni newPrenotazioni1 = addPrenotazioni();
		Prenotazioni newPrenotazioni2 = addPrenotazioni();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrenotazioni1.getPrimaryKey());
		primaryKeys.add(newPrenotazioni2.getPrimaryKey());

		Map<Serializable, Prenotazioni> prenotazionis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, prenotazionis.size());
		Assert.assertEquals(
			newPrenotazioni1,
			prenotazionis.get(newPrenotazioni1.getPrimaryKey()));
		Assert.assertEquals(
			newPrenotazioni2,
			prenotazionis.get(newPrenotazioni2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Prenotazioni> prenotazionis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(prenotazionis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Prenotazioni newPrenotazioni = addPrenotazioni();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrenotazioni.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Prenotazioni> prenotazionis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, prenotazionis.size());
		Assert.assertEquals(
			newPrenotazioni,
			prenotazionis.get(newPrenotazioni.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Prenotazioni> prenotazionis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(prenotazionis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Prenotazioni newPrenotazioni = addPrenotazioni();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrenotazioni.getPrimaryKey());

		Map<Serializable, Prenotazioni> prenotazionis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, prenotazionis.size());
		Assert.assertEquals(
			newPrenotazioni,
			prenotazionis.get(newPrenotazioni.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PrenotazioniLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Prenotazioni>() {

				@Override
				public void performAction(Prenotazioni prenotazioni) {
					Assert.assertNotNull(prenotazioni);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Prenotazioni newPrenotazioni = addPrenotazioni();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazioni.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"prenotazioneId", newPrenotazioni.getPrenotazioneId()));

		List<Prenotazioni> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Prenotazioni existingPrenotazioni = result.get(0);

		Assert.assertEquals(existingPrenotazioni, newPrenotazioni);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazioni.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"prenotazioneId", RandomTestUtil.nextLong()));

		List<Prenotazioni> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Prenotazioni newPrenotazioni = addPrenotazioni();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazioni.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("prenotazioneId"));

		Object newPrenotazioneId = newPrenotazioni.getPrenotazioneId();

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
			Prenotazioni.class, _dynamicQueryClassLoader);

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
		Prenotazioni newPrenotazioni = addPrenotazioni();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newPrenotazioni.getPrimaryKey()));
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

		Prenotazioni newPrenotazioni = addPrenotazioni();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazioni.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"prenotazioneId", newPrenotazioni.getPrenotazioneId()));

		List<Prenotazioni> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Prenotazioni prenotazioni) {
		Assert.assertEquals(
			prenotazioni.getUuid(),
			ReflectionTestUtil.invoke(
				prenotazioni, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(prenotazioni.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				prenotazioni, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Prenotazioni addPrenotazioni() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazioni prenotazioni = _persistence.create(pk);

		prenotazioni.setUuid(RandomTestUtil.randomString());

		prenotazioni.setGroupId(RandomTestUtil.nextLong());

		prenotazioni.setCompanyId(RandomTestUtil.nextLong());

		prenotazioni.setUserId(RandomTestUtil.nextLong());

		prenotazioni.setUserName(RandomTestUtil.randomString());

		prenotazioni.setCreateDate(RandomTestUtil.nextDate());

		prenotazioni.setModifiedDate(RandomTestUtil.nextDate());

		prenotazioni.setEmail(RandomTestUtil.randomString());

		prenotazioni.setData(RandomTestUtil.nextDate());

		prenotazioni.setOraInizio(RandomTestUtil.randomString());

		prenotazioni.setOraFine(RandomTestUtil.randomString());

		prenotazioni.setPostazioneId(RandomTestUtil.randomString());

		_prenotazionis.add(_persistence.update(prenotazioni));

		return prenotazioni;
	}

	private List<Prenotazioni> _prenotazionis = new ArrayList<Prenotazioni>();
	private PrenotazioniPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}