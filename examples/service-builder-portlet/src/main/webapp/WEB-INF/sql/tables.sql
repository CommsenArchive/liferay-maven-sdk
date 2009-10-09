
create table SB_Player (
	playerId LONG not null primary key,
	name VARCHAR(75) null,
	active_ BOOLEAN,
	score INTEGER,
	birthday DATE null,
	description VARCHAR(75) null
);