/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ruoli&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Ruolo
 * @generated
 */
public class RuoloTable extends BaseTable<RuoloTable> {

	public static final RuoloTable INSTANCE = new RuoloTable();

	public final Column<RuoloTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<RuoloTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RuoloTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RuoloTable() {
		super("ruoli", RuoloTable::new);
	}

}