DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS workers;

CREATE TABLE users
(
    user_Id  INTEGER GENERATED ALWAYS AS IDENTITY,
    name     varchar(255),
    password varchar(255)
);

CREATE TABLE workers
(
    worker_id      INTEGER GENERATED ALWAYS AS IDENTITY,
    name           varchar(255),
    email          varchar(255),
    workplace      varchar(255),
    position       varchar(255),
    status         varchar(255),
    holidayInAYear INTEGER,
    usedHoliday    INTEGER
);