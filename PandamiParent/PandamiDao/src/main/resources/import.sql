INSERT INTO `user_type` (id, type) VALUES (1, 'utilisateur');
INSERT INTO `city` (id, name, zipCode) VALUES (1, 'Paris', '75000');
INSERT INTO `gender`(id, name) VALUES (1, 'masculin');
INSERT INTO `user` (id, birthDate, email, emergencyContactName, emergencyContactPhoneNumber, emergencyContactSurname, inscriptionDate, login, name, password, phoneNumber, street, surname, city_id, gender_id, userType_id) VALUES (1, '1995-01-01', 'toto@gmail.com', 'tata', '0102030405', 'de Tata', '2019-02-02', 'toto', 'toto', 'toto', '0605040302', '2 rue de chez toto', 'de Toto', 1, 1, 1);
