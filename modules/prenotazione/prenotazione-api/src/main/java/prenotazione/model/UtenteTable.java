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
 * The table class for the &quot;utenti&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Utente
 * @generated
 */
public class UtenteTable extends BaseTable<UtenteTable> {

	public static final UtenteTable INSTANCE = new UtenteTable();

	public final Column<UtenteTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UtenteTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteTable, String> cognome = createColumn(
		"cognome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteTable, String> percorsoFoto = createColumn(
		"percorso_foto", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteTable, Date> annoAssunzione = createColumn(
		"anno_assunzione", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private UtenteTable() {
		super("utenti", UtenteTable::new);
	}

}