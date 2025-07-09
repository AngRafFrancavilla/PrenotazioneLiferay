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

import prenotazione.exception.NoSuchPostazioneException;

import prenotazione.model.Postazione;

import prenotazione.service.PostazioneLocalServiceUtil;
import prenotazione.service.persistence.PostazionePersistence;
import prenotazione.service.persistence.PostazioneUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PostazionePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "prenotazione.service"));

	@Before
	public void setUp() {
		_persistence = PostazioneUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Postazione> iterator = _postaziones.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Postazione postazione = _persistence.create(pk);

		Assert.assertNotNull(postazione);

		Assert.assertEquals(postazione.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Postazione newPostazione = addPostazione();

		_persistence.remove(newPostazione);

		Postazione existingPostazione = _persistence.fetchByPrimaryKey(
			newPostazione.getPrimaryKey());

		Assert.assertNull(existingPostazione);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPostazione();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Postazione newPostazione = _persistence.create(pk);

		newPostazione.setStanzaId(RandomTestUtil.nextLong());

		newPostazione.setNomePostazione(RandomTestUtil.randomString());

		_postaziones.add(_persistence.update(newPostazione));

		Postazione existingPostazione = _persistence.findByPrimaryKey(
			newPostazione.getPrimaryKey());

		Assert.assertEquals(
			existingPostazione.getPostazioneId(),
			newPostazione.getPostazioneId());
		Assert.assertEquals(
			existingPostazione.getStanzaId(), newPostazione.getStanzaId());
		Assert.assertEquals(
			existingPostazione.getNomePostazione(),
			newPostazione.getNomePostazione());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Postazione newPostazione = addPostazione();

		Postazione existingPostazione = _persistence.findByPrimaryKey(
			newPostazione.getPrimaryKey());

		Assert.assertEquals(existingPostazione, newPostazione);
	}

	@Test(expected = NoSuchPostazioneException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Postazione> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"postazioni", "postazioneId", true, "stanzaId", true,
			"nomePostazione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Postazione newPostazione = addPostazione();

		Postazione existingPostazione = _persistence.fetchByPrimaryKey(
			newPostazione.getPrimaryKey());

		Assert.assertEquals(existingPostazione, newPostazione);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Postazione missingPostazione = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPostazione);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Postazione newPostazione1 = addPostazione();
		Postazione newPostazione2 = addPostazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPostazione1.getPrimaryKey());
		primaryKeys.add(newPostazione2.getPrimaryKey());

		Map<Serializable, Postazione> postaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, postaziones.size());
		Assert.assertEquals(
			newPostazione1, postaziones.get(newPostazione1.getPrimaryKey()));
		Assert.assertEquals(
			newPostazione2, postaziones.get(newPostazione2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Postazione> postaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(postaziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Postazione newPostazione = addPostazione();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPostazione.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Postazione> postaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, postaziones.size());
		Assert.assertEquals(
			newPostazione, postaziones.get(newPostazione.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Postazione> postaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(postaziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Postazione newPostazione = addPostazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPostazione.getPrimaryKey());

		Map<Serializable, Postazione> postaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, postaziones.size());
		Assert.assertEquals(
			newPostazione, postaziones.get(newPostazione.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PostazioneLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Postazione>() {

				@Override
				public void performAction(Postazione postazione) {
					Assert.assertNotNull(postazione);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Postazione newPostazione = addPostazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Postazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"postazioneId", newPostazione.getPostazioneId()));

		List<Postazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Postazione existingPostazione = result.get(0);

		Assert.assertEquals(existingPostazione, newPostazione);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Postazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"postazioneId", RandomTestUtil.nextLong()));

		List<Postazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Postazione newPostazione = addPostazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Postazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("postazioneId"));

		Object newPostazioneId = newPostazione.getPostazioneId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"postazioneId", new Object[] {newPostazioneId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPostazioneId = result.get(0);

		Assert.assertEquals(existingPostazioneId, newPostazioneId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Postazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("postazioneId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"postazioneId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Postazione addPostazione() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Postazione postazione = _persistence.create(pk);

		postazione.setStanzaId(RandomTestUtil.nextLong());

		postazione.setNomePostazione(RandomTestUtil.randomString());

		_postaziones.add(_persistence.update(postazione));

		return postazione;
	}

	private List<Postazione> _postaziones = new ArrayList<Postazione>();
	private PostazionePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}