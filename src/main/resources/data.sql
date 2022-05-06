DROP DATABASE IF EXISTS `paymybuddy`;
create database `paymybuddy`;
use `paymybuddy`;

DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person`
(
    `id` INTEGER ,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(100),
	primary key (`id`)
);
INSERT INTO `Person` (`id`,`email`, `password`)

VALUES

(1,'oliver@test.com', 'test1'),
(2,'bertrand@test.com', 'test2');
commit;

DROP TABLE IF EXISTS `Friend`;
CREATE TABLE `Friend`
(
    `id` INTEGER ,
	`email` VARCHAR(100) NOT NULL UNIQUE,
	primary key (`id`)
);

INSERT INTO `Friend` (`id`, `email`)

VALUES

(1, 'bernard@test_friend.com'),
(2, 'gertrude@test_friend.com');
commit;

DROP TABLE IF EXISTS `person_friend`;
CREATE TABLE `person_friend`
(
    `id_person` INTEGER ,
	`id_friend` INTEGER,
    foreign key (`id_person`) references `Person`(`id`),
    foreign key (`id_friend`) references `Friend`(`id`),
	primary key (`id_person`, `id_friend`)
    
);

INSERT INTO `person_friend` (`id_person`, `id_friend`)

VALUES

(1, 1),
(2, 2);
commit;

DROP TABLE IF EXISTS `Wallet`;
CREATE TABLE `Wallet`
(
    `id_person` INTEGER ,
    `id` INTEGER NOT NULL,
    `amount` FLOAT,
	`account` INTEGER NOT NULL UNIQUE,
	primary key (`account`),
	foreign key (`id_person`) references `Person`(`id`)
);

INSERT INTO `Wallet` (`id_person`, `id`, `amount`, `account`)

VALUES

(1,1, 500, 123456),
(1,2, 1000, 234567);
commit;

DROP TABLE IF EXISTS `Transaction`;
CREATE TABLE `Transaction`
(
    `account_wallet` INTEGER NOT NULL,
	`id` INTEGER NOT NULL,
	`type` VARCHAR(100),
	`amount` FLOAT,
	foreign key(`account_wallet`) references `Wallet`(`account`)
);

INSERT INTO `Transaction` (`account_wallet`, `id`,`type`,`amount`)

VALUES

(123456,1, 'retirer', 100),
(234567,2, 'ajouter', 100),
(123456,3, 'donner', 100);
commit;