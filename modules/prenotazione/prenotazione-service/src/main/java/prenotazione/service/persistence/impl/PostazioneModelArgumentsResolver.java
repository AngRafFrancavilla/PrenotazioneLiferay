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

import prenotazione.model.PostazioneTable;
import prenotazione.model.impl.PostazioneImpl;
import prenotazione.model.impl.PostazioneModelImpl;

/**
 * The arguments resolver class for retrieving value from Postazione.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=prenotazione.model.impl.PostazioneImpl",
		"table.name=postazioni"
	},
	service = ArgumentsResolver.class
)
public class PostazioneModelArgumentsResolver implements ArgumentsResolver {

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

		PostazioneModelImpl postazioneModelImpl =
			(PostazioneModelImpl)baseModel;

		long columnBitmask = postazioneModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(postazioneModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= postazioneModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(postazioneModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PostazioneImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PostazioneTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PostazioneModelImpl postazioneModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = postazioneModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = postazioneModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}