create table PRE_Prenotazione (
	uuid_ VARCHAR(75) null,
	prenotazioneId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	email VARCHAR(75) null,
	data_ DATE null,
	oraInizio VARCHAR(75) null,
	oraFine VARCHAR(75) null,
	postazioneId VARCHAR(75) null
);

create table Prenotazione (
	uuid_ VARCHAR(75) null,
	prenotazioneId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	email VARCHAR(75) null,
	data_ DATE null,
	oraInizio VARCHAR(75) null,
	oraFine VARCHAR(75) null,
	postazioneId VARCHAR(75) null
);

create table postazioni (
	id LONG not null primary key,
	stanza_id LONG,
	nome_postazione VARCHAR(75) null
);