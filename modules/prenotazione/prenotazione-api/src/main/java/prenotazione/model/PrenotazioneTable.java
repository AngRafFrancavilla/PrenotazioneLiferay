/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Prenotazione&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Prenotazione
 * @generated
 */
public class PrenotazioneTable extends BaseTable<PrenotazioneTable> {

	public static final PrenotazioneTable INSTANCE = new PrenotazioneTable();

	public final Column<PrenotazioneTable, Long> prenotazioneId = createColumn(
		"prenotazioneId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PrenotazioneTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Date> data = createColumn(
		"data_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, String> oraInizio = createColumn(
		"oraInizio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, String> oraFine = createColumn(
		"oraFine", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, String> postazioneId = createColumn(
		"postazioneId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PrenotazioneTable() {
		super("Prenotazione", PrenotazioneTable::new);
	}

}