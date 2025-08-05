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

import prenotazione.exception.NoSuchUtenteException;

import prenotazione.model.Utente;

import prenotazione.service.UtenteLocalServiceUtil;
import prenotazione.service.persistence.UtentePersistence;
import prenotazione.service.persistence.UtenteUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class UtentePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "prenotazione.service"));

	@Before
	public void setUp() {
		_persistence = UtenteUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Utente> iterator = _utentes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Utente utente = _persistence.create(pk);

		Assert.assertNotNull(utente);

		Assert.assertEquals(utente.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Utente newUtente = addUtente();

		_persistence.remove(newUtente);

		Utente existingUtente = _persistence.fetchByPrimaryKey(
			newUtente.getPrimaryKey());

		Assert.assertNull(existingUtente);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUtente();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Utente newUtente = _persistence.create(pk);

		newUtente.setNome(RandomTestUtil.randomString());

		newUtente.setCognome(RandomTestUtil.randomString());

		newUtente.setEmail(RandomTestUtil.randomString());

		newUtente.setPassword(RandomTestUtil.randomString());

		newUtente.setPercorsoFoto(RandomTestUtil.randomString());

		newUtente.setAnnoAssunzione(RandomTestUtil.nextDate());

		_utentes.add(_persistence.update(newUtente));

		Utente existingUtente = _persistence.findByPrimaryKey(
			newUtente.getPrimaryKey());

		Assert.assertEquals(existingUtente.getId(), newUtente.getId());
		Assert.assertEquals(existingUtente.getNome(), newUtente.getNome());
		Assert.assertEquals(
			existingUtente.getCognome(), newUtente.getCognome());
		Assert.assertEquals(existingUtente.getEmail(), newUtente.getEmail());
		Assert.assertEquals(
			existingUtente.getPassword(), newUtente.getPassword());
		Assert.assertEquals(
			existingUtente.getPercorsoFoto(), newUtente.getPercorsoFoto());
		Assert.assertEquals(
			Time.getShortTimestamp(existingUtente.getAnnoAssunzione()),
			Time.getShortTimestamp(newUtente.getAnnoAssunzione()));
	}

	@Test
	public void testCountByEmail() throws Exception {
		_persistence.countByEmail("");

		_persistence.countByEmail("null");

		_persistence.countByEmail((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Utente newUtente = addUtente();

		Utente existingUtente = _persistence.findByPrimaryKey(
			newUtente.getPrimaryKey());

		Assert.assertEquals(existingUtente, newUtente);
	}

	@Test(expected = NoSuchUtenteException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Utente> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"utenti", "id", true, "nome", true, "cognome", true, "email", true,
			"password", true, "percorsoFoto", true, "annoAssunzione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Utente newUtente = addUtente();

		Utente existingUtente = _persistence.fetchByPrimaryKey(
			newUtente.getPrimaryKey());

		Assert.assertEquals(existingUtente, newUtente);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Utente missingUtente = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUtente);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Utente newUtente1 = addUtente();
		Utente newUtente2 = addUtente();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUtente1.getPrimaryKey());
		primaryKeys.add(newUtente2.getPrimaryKey());

		Map<Serializable, Utente> utentes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, utentes.size());
		Assert.assertEquals(
			newUtente1, utentes.get(newUtente1.getPrimaryKey()));
		Assert.assertEquals(
			newUtente2, utentes.get(newUtente2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Utente> utentes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(utentes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Utente newUtente = addUtente();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUtente.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Utente> utentes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, utentes.size());
		Assert.assertEquals(newUtente, utentes.get(newUtente.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Utente> utentes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(utentes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Utente newUtente = addUtente();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUtente.getPrimaryKey());

		Map<Serializable, Utente> utentes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, utentes.size());
		Assert.assertEquals(newUtente, utentes.get(newUtente.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			UtenteLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Utente>() {

				@Override
				public void performAction(Utente utente) {
					Assert.assertNotNull(utente);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Utente newUtente = addUtente();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Utente.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newUtente.getId()));

		List<Utente> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Utente existingUtente = result.get(0);

		Assert.assertEquals(existingUtente, newUtente);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Utente.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Utente> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Utente newUtente = addUtente();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Utente.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newUtente.getId();

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
			Utente.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Utente newUtente = addUtente();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newUtente.getPrimaryKey()));
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

		Utente newUtente = addUtente();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Utente.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newUtente.getId()));

		List<Utente> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Utente utente) {
		Assert.assertEquals(
			utente.getEmail(),
			ReflectionTestUtil.invoke(
				utente, "getColumnOriginalValue", new Class<?>[] {String.class},
				"email"));
	}

	protected Utente addUtente() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Utente utente = _persistence.create(pk);

		utente.setNome(RandomTestUtil.randomString());

		utente.setCognome(RandomTestUtil.randomString());

		utente.setEmail(RandomTestUtil.randomString());

		utente.setPassword(RandomTestUtil.randomString());

		utente.setPercorsoFoto(RandomTestUtil.randomString());

		utente.setAnnoAssunzione(RandomTestUtil.nextDate());

		_utentes.add(_persistence.update(utente));

		return utente;
	}

	private List<Utente> _utentes = new ArrayList<Utente>();
	private UtentePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}