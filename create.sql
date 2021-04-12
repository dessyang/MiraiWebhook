CREATE DATABASE db_webhook;
use db_webhook;
CREATE TABLE if not exists `friend` (
    `account` bigint (20) NOT NULL,
    `token` text NOT NULL,
    `status` boolean NOT NULL,
    `update_time` date NOT NULL,
    `create_time` date NOT NULL,
    PRIMARY KEY (`account`)
    ) ENGINE = innodb