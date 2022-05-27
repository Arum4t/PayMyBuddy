DROP DATABASE IF EXISTS `paymybuddy`;
create database `paymybuddy`;
use `paymybuddy`;

DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person`
(
	`id`INTEGER NOT NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(100),
    `role` VARCHAR(100),
	PRIMARY KEY (`id`)
);
INSERT INTO `Person` (`id`,`email`, `password`,`role`)

VALUES
(1,'oliver@test.com', '$2a$12$8zeEZLc3EdOUbzVfsMsEVu5SI/UnPE4wsV2cGdsFjX0seHBaXMfua','user'),
(2,'bertrand@test.com', '$2a$12$UF7oLqJwmM9vjUqtjIK.GOJ..Aay.AgEY45KOJb6ukNDKloyEIY9S','user'),
(3,'tim@test.com', '$2a$12$hTmdt.M.pyvj1GpYTBIlC.Er2vR6G1eK/fzs8nR4m6/Rtsetj7KKG','admin');

DROP TABLE IF EXISTS `Friend`;
CREATE TABLE `Friend`
(
	`id`INTEGER NOT NULL,
	`email` VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
);

INSERT INTO `Friend` (`id`, `email`)

VALUES
(1, 'bernard@test_friend.com'),
(2, 'gertrude@test_friend.com'),
(3, 'georges@test_friend.com');

DROP TABLE IF EXISTS `person_friend`;
CREATE TABLE `person_friend`
(
    `id_person` INTEGER NOT NULL,
	`id_friend` INTEGER NOT NULL,
    FOREIGN KEY (`id_person`) REFERENCES `Person`(`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (`id_friend`) REFERENCES `Friend`(`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
	PRIMARY KEY (`id_person`, `id_friend`)
    
);

INSERT INTO `person_friend` (`id_person`, `id_friend`)

VALUES
(1, 1),
(1,2),
(2, 2);

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
	FOREIGN KEY (`id_wallet`) references `Wallet`(`id`)
);

INSERT INTO `Transaction` (`id_wallet`, `id`,`type`,`amount_transaction`)

VALUES
(1,1,'retirer', 100),
(2,2,'ajouter', 100),
(1,3,'donner', 100),
(3,4,'retirer', 500);