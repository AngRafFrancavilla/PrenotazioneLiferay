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
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
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

import prenotazione.exception.NoSuchRuoloException;

import prenotazione.model.Ruolo;

import prenotazione.service.RuoloLocalServiceUtil;
import prenotazione.service.persistence.RuoloPersistence;
import prenotazione.service.persistence.RuoloUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class RuoloPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "prenotazione.service"));

	@Before
	public void setUp() {
		_persistence = RuoloUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Ruolo> iterator = _ruolos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Ruolo ruolo = _persistence.create(pk);

		Assert.assertNotNull(ruolo);

		Assert.assertEquals(ruolo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Ruolo newRuolo = addRuolo();

		_persistence.remove(newRuolo);

		Ruolo existingRuolo = _persistence.fetchByPrimaryKey(
			newRuolo.getPrimaryKey());

		Assert.assertNull(existingRuolo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRuolo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Ruolo newRuolo = _persistence.create(pk);

		newRuolo.setNome(RandomTestUtil.randomString());

		newRuolo.setDescrizione(RandomTestUtil.randomString());

		_ruolos.add(_persistence.update(newRuolo));

		Ruolo existingRuolo = _persistence.findByPrimaryKey(
			newRuolo.getPrimaryKey());

		Assert.assertEquals(existingRuolo.getId(), newRuolo.getId());
		Assert.assertEquals(existingRuolo.getNome(), newRuolo.getNome());
		Assert.assertEquals(
			existingRuolo.getDescrizione(), newRuolo.getDescrizione());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Ruolo newRuolo = addRuolo();

		Ruolo existingRuolo = _persistence.findByPrimaryKey(
			newRuolo.getPrimaryKey());

		Assert.assertEquals(existingRuolo, newRuolo);
	}

	@Test(expected = NoSuchRuoloException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Ruolo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ruoli", "id", true, "nome", true, "descrizione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Ruolo newRuolo = addRuolo();

		Ruolo existingRuolo = _persistence.fetchByPrimaryKey(
			newRuolo.getPrimaryKey());

		Assert.assertEquals(existingRuolo, newRuolo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Ruolo missingRuolo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRuolo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Ruolo newRuolo1 = addRuolo();
		Ruolo newRuolo2 = addRuolo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRuolo1.getPrimaryKey());
		primaryKeys.add(newRuolo2.getPrimaryKey());

		Map<Serializable, Ruolo> ruolos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, ruolos.size());
		Assert.assertEquals(newRuolo1, ruolos.get(newRuolo1.getPrimaryKey()));
		Assert.assertEquals(newRuolo2, ruolos.get(newRuolo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		int pk1 = RandomTestUtil.nextInt();

		int pk2 = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Ruolo> ruolos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(ruolos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Ruolo newRuolo = addRuolo();

		int pk = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRuolo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Ruolo> ruolos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, ruolos.size());
		Assert.assertEquals(newRuolo, ruolos.get(newRuolo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Ruolo> ruolos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(ruolos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Ruolo newRuolo = addRuolo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRuolo.getPrimaryKey());

		Map<Serializable, Ruolo> ruolos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, ruolos.size());
		Assert.assertEquals(newRuolo, ruolos.get(newRuolo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RuoloLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Ruolo>() {

				@Override
				public void performAction(Ruolo ruolo) {
					Assert.assertNotNull(ruolo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Ruolo newRuolo = addRuolo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Ruolo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newRuolo.getId()));

		List<Ruolo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Ruolo existingRuolo = result.get(0);

		Assert.assertEquals(existingRuolo, newRuolo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Ruolo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextInt()));

		List<Ruolo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Ruolo newRuolo = addRuolo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Ruolo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newRuolo.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Ruolo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextInt()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Ruolo addRuolo() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Ruolo ruolo = _persistence.create(pk);

		ruolo.setNome(RandomTestUtil.randomString());

		ruolo.setDescrizione(RandomTestUtil.randomString());

		_ruolos.add(_persistence.update(ruolo));

		return ruolo;
	}

	private List<Ruolo> _ruolos = new ArrayList<Ruolo>();
	private RuoloPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}