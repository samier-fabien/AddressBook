/*
Table pour application carnet d'adresse
La base de données doit s'appeler CarnetAdressesJava
*/
create table contact (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	con_nom VARCHAR(50),
	con_prenom VARCHAR(50),
	con_statut VARCHAR(50),
	con_tel VARCHAR(50),
	con_mail VARCHAR(50)
);
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (1, 'Makinson', 'Médiamass', '5419787560', 'fmakinson0@prweb.com', 'dmakinson0@mediafire.com');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (2, 'Sidary', 'Méryl', '9975331060', 'dsidary1@edublogs.org', 'asidary1@posterous.com');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (3, 'Nanson', 'Dù', '9009237132', 'lnanson2@purevolume.com', 'vnanson2@cbsnews.com');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (4, 'Copping', 'Cécile', '1039495995', 'dcopping3@ehow.com', 'ccopping3@bizjournals.com');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (5, 'Caulliere', 'Björn', '9651286177', 'bcaulliere4@mit.edu', 'ecaulliere4@ucoz.ru');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (6, 'Brogan', 'Andrée', '9193077345', 'sbrogan5@adobe.com', 'cbrogan5@google.ru');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (7, 'Brou', 'Börje', '1005483095', 'bbrou6@meetup.com', 'mbrou6@slate.com');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (8, 'Pittaway', 'Miléna', '5853684776', 'apittaway7@spotify.com', 'dpittaway7@altervista.org');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (9, 'Ramsby', 'Ruì', '7942277007', 'wramsby8@hhs.gov', 'wramsby8@sfgate.com');
insert into contact (id, con_nom, con_prenom, con_tel, con_mail, con_statut) values (10, 'Churchlow', 'Pélagie', '5258955530', 'mchurchlow9@sfgate.com', 'schurchlow9@goo.ne.jp');
