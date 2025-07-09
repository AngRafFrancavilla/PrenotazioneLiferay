/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazione.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;postazioni&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Postazione
 * @generated
 */
public class PostazioneTable extends BaseTable<PostazioneTable> {

	public static final PostazioneTable INSTANCE = new PostazioneTable();

	public final Column<PostazioneTable, Long> postazioneId = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PostazioneTable, Long> stanzaId = createColumn(
		"stanza_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PostazioneTable, String> nomePostazione = createColumn(
		"nome_postazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PostazioneTable() {
		super("postazioni", PostazioneTable::new);
	}

}