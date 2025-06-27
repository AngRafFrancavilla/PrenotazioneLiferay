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
 * The table class for the &quot;Prenotazioni&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Prenotazioni
 * @generated
 */
public class PrenotazioniTable extends BaseTable<PrenotazioniTable> {

	public static final PrenotazioniTable INSTANCE = new PrenotazioniTable();

	public final Column<PrenotazioniTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, Long> prenotazioneId = createColumn(
		"prenotazioneId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PrenotazioniTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, Date> data = createColumn(
		"data_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, String> oraInizio = createColumn(
		"oraInizio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, String> oraFine = createColumn(
		"oraFine", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrenotazioniTable, String> postazioneId = createColumn(
		"postazioneId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PrenotazioniTable() {
		super("Prenotazioni", PrenotazioniTable::new);
	}

}