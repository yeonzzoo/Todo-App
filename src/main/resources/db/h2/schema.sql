CREATE TABLE IF NOT EXISTS TODO (
    TODO_ID bigint NOT NULL AUTO_INCREMENT,
    TITLE varchar(100) NOT NULL UNIQUE,
    TODO_ORDER int NOT NULL,
    COMPLETED boolean NOT NULL,
    PRIMARY KEY (TODO_ID)
);