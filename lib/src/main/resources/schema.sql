CREATE TABLE accounts(
    acctName text primary key,
    acctBalance NUMERIC
);

CREATE TABLE Users(
    userID serial primary key,
    userName varchar(255) unique not null,
    userPassword varchar(255) unique not null
);

INSERT INTO accounts(acctName, acctBalance) VALUES ('venmo', 20) , ('cashapp', 20);
INSERT INTO Users(userName, userPassword) VALUES ('admin', 'admin');
INSERT INTO Users(userName, userPassword) VALUES ('greg', 'greg');