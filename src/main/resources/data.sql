DROP DATABASE IF EXISTS `paymybuddy`;
create database `paymybuddy`;
use `paymybuddy`;

DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person`
(
	`id`INTEGER NOT NULL auto_increment,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(100),
    `role` VARCHAR(100),
	PRIMARY KEY (`id`)
);
INSERT INTO `Person` (`id`,`email`, `password`,`role`)
VALUES
(1,'olivier@test.com', '$2a$12$8zeEZLc3EdOUbzVfsMsEVu5SI/UnPE4wsV2cGdsFjX0seHBaXMfua','user'),
(2,'bertrand@test.com', '$2a$12$UF7oLqJwmM9vjUqtjIK.GOJ..Aay.AgEY45KOJb6ukNDKloyEIY9S','user'),
(3,'tim@test.com', '$2a$12$hTmdt.M.pyvj1GpYTBIlC.Er2vR6G1eK/fzs8nR4m6/Rtsetj7KKG','admin');

DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts`
(
	`id`INTEGER NOT NULL,
    `id_person` INTEGER NOT NULL,
	`id_contact` INTEGER NOT NULL,
    FOREIGN KEY (`id_person`) REFERENCES `Person`(`id`),
    FOREIGN KEY (`id_contact`) REFERENCES `Person`(`id`)
);

INSERT INTO `contacts` (`id`,`id_person`, `id_contact`)

VALUES
(1,1,2),
(2,1,3),
(3,2,1),
(4,3,1);

DROP TABLE IF EXISTS `Wallet`;
CREATE TABLE `Wallet`
(
	`id` INTEGER NOT NULL,
    `id_person` INTEGER ,
    `amount_wallet` FLOAT,
	`account` INTEGER NOT NULL UNIQUE,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`id_person`) references `Person`(`id`)
);

INSERT INTO `Wallet` (`id`,`id_person`, `amount_wallet`, `account`)

VALUES
(1,1,500, 123456),
(2,2,1000, 234567),
(3,3,20000, 345678);


DROP TABLE IF EXISTS `Transaction`;
CREATE TABLE `Transaction`
(
    `id_wallet` INTEGER NOT NULL,
	`id` INTEGER NOT NULL,
	`type` VARCHAR(100),
	`amount_transaction` FLOAT,
    `receiver_id` INTEGER NOT NULL,
    `emitter_id` INTEGER NOT NULL,
	FOREIGN KEY (`id_wallet`) references `Wallet`(`id`),
    FOREIGN KEY (`receiver_id`) references `Person`(`id`),
    FOREIGN KEY (`emitter_id`) references `Person`(`id`)
);

INSERT INTO `Transaction` (`id_wallet`, `id`,`type`,`amount_transaction`,`receiver_id`,`emitter_id`)

VALUES
(1,1,'pizza', 100,1,2),
(2,2,'voyages', 100,2,1),
(1,3,'achat', 100,1,3),
(3,4,'restaurant', 500,3,1);