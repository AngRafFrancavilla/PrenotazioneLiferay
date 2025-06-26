/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazioni.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;prenotazioni&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Prenotazione
 * @generated
 */
public class PrenotazioneTable extends BaseTable<PrenotazioneTable> {

	public static final PrenotazioneTable INSTANCE = new PrenotazioneTable();

	public final Column<PrenotazioneTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PrenotazioneTable, Date> data = createColumn(
		"data_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Date> oraInizio = createColumn(
		"ora_inizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Date> oraFine = createColumn(
		"ora_fine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Long> utentiId = createColumn(
		"utenti_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrenotazioneTable, Long> postazioneId = createColumn(
		"postazione_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PrenotazioneTable() {
		super("prenotazioni", PrenotazioneTable::new);
	}

}