/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

import prenotazione.model.PrenotazioniTable;
import prenotazione.model.impl.PrenotazioniImpl;
import prenotazione.model.impl.PrenotazioniModelImpl;

/**
 * The arguments resolver class for retrieving value from Prenotazioni.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=prenotazione.model.impl.PrenotazioniImpl",
		"table.name=Prenotazioni"
	},
	service = ArgumentsResolver.class
)
public class PrenotazioniModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		PrenotazioniModelImpl prenotazioniModelImpl =
			(PrenotazioniModelImpl)baseModel;

		long columnBitmask = prenotazioniModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(prenotazioniModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					prenotazioniModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(prenotazioniModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PrenotazioniImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PrenotazioniTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PrenotazioniModelImpl prenotazioniModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = prenotazioniModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = prenotazioniModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}