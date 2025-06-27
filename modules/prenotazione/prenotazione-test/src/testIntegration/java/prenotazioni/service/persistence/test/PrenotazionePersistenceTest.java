/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazioni.service.persistence.test;

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

import prenotazioni.exception.NoSuchPrenotazioneException;

import prenotazioni.model.Prenotazione;

import prenotazioni.service.PrenotazioneLocalServiceUtil;
import prenotazioni.service.persistence.PrenotazionePersistence;
import prenotazioni.service.persistence.PrenotazioneUtil;

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
				Propagation.REQUIRED, "prenotazioni.service"));

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

		newPrenotazione.setData(RandomTestUtil.nextDate());

		newPrenotazione.setOraInizio(RandomTestUtil.nextDate());

		newPrenotazione.setOraFine(RandomTestUtil.nextDate());

		newPrenotazione.setUtentiId(RandomTestUtil.nextLong());

		newPrenotazione.setPostazioneId(RandomTestUtil.nextLong());

		_prenotaziones.add(_persistence.update(newPrenotazione));

		Prenotazione existingPrenotazione = _persistence.findByPrimaryKey(
			newPrenotazione.getPrimaryKey());

		Assert.assertEquals(
			existingPrenotazione.getId(), newPrenotazione.getId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazione.getData()),
			Time.getShortTimestamp(newPrenotazione.getData()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazione.getOraInizio()),
			Time.getShortTimestamp(newPrenotazione.getOraInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrenotazione.getOraFine()),
			Time.getShortTimestamp(newPrenotazione.getOraFine()));
		Assert.assertEquals(
			existingPrenotazione.getUtentiId(), newPrenotazione.getUtentiId());
		Assert.assertEquals(
			existingPrenotazione.getPostazioneId(),
			newPrenotazione.getPostazioneId());
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
			"prenotazioni", "id", true, "data", true, "oraInizio", true,
			"oraFine", true, "utentiId", true, "postazioneId", true);
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
			RestrictionsFactoryUtil.eq("id", newPrenotazione.getId()));

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
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Prenotazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Prenotazione newPrenotazione = addPrenotazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Prenotazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newPrenotazione.getId();

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
			Prenotazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Prenotazione addPrenotazione() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Prenotazione prenotazione = _persistence.create(pk);

		prenotazione.setData(RandomTestUtil.nextDate());

		prenotazione.setOraInizio(RandomTestUtil.nextDate());

		prenotazione.setOraFine(RandomTestUtil.nextDate());

		prenotazione.setUtentiId(RandomTestUtil.nextLong());

		prenotazione.setPostazioneId(RandomTestUtil.nextLong());

		_prenotaziones.add(_persistence.update(prenotazione));

		return prenotazione;
	}

	private List<Prenotazione> _prenotaziones = new ArrayList<Prenotazione>();
	private PrenotazionePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}