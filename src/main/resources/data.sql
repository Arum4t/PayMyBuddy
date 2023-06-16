DROP DATABASE IF EXISTS `paymybuddy`;
create database `paymybuddy`;
use `paymybuddy`;

DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person`
(
	`id_person` INTEGER NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(100),
    `role` VARCHAR(100),
	PRIMARY KEY (`id_person`)
);
INSERT INTO `Person` (`id_person`,`email`, `password`,`role`)
VALUES
(1, 'olivier@test.com', '$2a$12$8zeEZLc3EdOUbzVfsMsEVu5SI/UnPE4wsV2cGdsFjX0seHBaXMfua', 'user'),
(2, 'bertrand@test.com', '$2a$12$UF7oLqJwmM9vjUqtjIK.GOJ..Aay.AgEY45KOJb6ukNDKloyEIY9S', 'user'),
(3, 'tim@test.com', '$2a$12$hTmdt.M.pyvj1GpYTBIlC.Er2vR6G1eK/fzs8nR4m6/Rtsetj7KKG', 'admin');

DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts`
(
	`id` INTEGER NOT NULL AUTO_INCREMENT,
    `id_person` INTEGER NOT NULL,
	`id_contact` INTEGER NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`id_person`) REFERENCES `Person`(`id_person`),
    FOREIGN KEY (`id_contact`) REFERENCES `Person`(`id_person`),
    UNIQUE (`id_person`, `id_contact`)
);

INSERT INTO `contacts` (`id`, `id_person`, `id_contact`)

VALUES
(1, 1, 2),
(2, 2, 3);

DROP TABLE IF EXISTS `Wallet`;
CREATE TABLE `Wallet`
(
	`id_wallet` INTEGER NOT NULL AUTO_INCREMENT,
    `id_person` INTEGER ,
    `amount_wallet` FLOAT,
	PRIMARY KEY (`id_wallet`),
	FOREIGN KEY (`id_person`) references `Person`(`id_person`)
);

INSERT INTO `Wallet` (`id_wallet`, `id_person`, `amount_wallet`)

VALUES
(1, 1, 500),
(2, 3, 1000),
(3, 2, 20000);


DROP TABLE IF EXISTS `Transaction`;
CREATE TABLE `Transaction`
(
	`id_transaction` INTEGER NOT NULL AUTO_INCREMENT,
	`description` VARCHAR(100),
	`amount_transaction` FLOAT NOT NULL,
    `id_wallet_emitter` INTEGER NOT NULL,
    `id_wallet_receiver` INTEGER NOT NULL,
    PRIMARY KEY (`id_transaction`),
    FOREIGN KEY (`id_wallet_emitter`) references `Wallet`(`id_wallet`),
    FOREIGN KEY (`id_wallet_receiver`) references `Wallet`(`id_wallet`)
);

INSERT INTO `Transaction` (`id_transaction`, `description`, `amount_transaction`, `id_wallet_emitter`, `id_wallet_receiver`)

VALUES
(1,'pizza', 100,1,2),
(2,'voyages', 100,2,1),
(3,'achat', 100,1,3),
(4,'restaurant', 500,3,1);