/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.CurrentConnectionUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;

import java.sql.Connection;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Prenotazioni;

import prenotazione.service.PrenotazioniService;
import prenotazione.service.persistence.PrenotazioniPersistence;

/**
 * Provides the base implementation for the prenotazioni remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link prenotazione.service.impl.PrenotazioniServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see prenotazione.service.impl.PrenotazioniServiceImpl
 * @generated
 */
public abstract class PrenotazioniServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, PrenotazioniService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>PrenotazioniService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>prenotazione.service.PrenotazioniServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			PrenotazioniService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		prenotazioniService = (PrenotazioniService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PrenotazioniService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Prenotazioni.class;
	}

	protected String getModelClassName() {
		return Prenotazioni.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		DataSource dataSource = prenotazioniPersistence.getDataSource();

		DB db = DBManagerUtil.getDB();

		Connection currentConnection = CurrentConnectionUtil.getConnection(
			dataSource);

		try {
			if (currentConnection != null) {
				db.runSQL(currentConnection, new String[] {sql});

				return;
			}

			try (Connection connection = dataSource.getConnection()) {
				db.runSQL(connection, new String[] {sql});
			}
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected prenotazione.service.PrenotazioniLocalService
		prenotazioniLocalService;

	protected PrenotazioniService prenotazioniService;

	@Reference
	protected PrenotazioniPersistence prenotazioniPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	private static final Log _log = LogFactoryUtil.getLog(
		PrenotazioniServiceBaseImpl.class);

}