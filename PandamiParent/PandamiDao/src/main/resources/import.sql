INSERT INTO `pandami_db`.`city` (`id`, `name`, `zipCode`) VALUES ('1', 'Saint-Maur-des-Fossés', '94100');
INSERT INTO `pandami_db`.`city` (`id`, `name`, `zipCode`) VALUES ('2', 'Ivry-sur-Seine', '94200');
INSERT INTO `pandami_db`.`city` (`id`, `name`, `zipCode`) VALUES ('3', 'Vincennes', '94300');
INSERT INTO `pandami_db`.`city` (`id`, `name`, `zipCode`) VALUES ('4', 'Vitry-sur-Seine', '94400');
INSERT INTO `pandami_db`.`city` (`id`, `name`, `zipCode`) VALUES ('5', 'Villejuif', '94800');
INSERT INTO `pandami_db`.`desist_reason` (`id`, `label`) VALUES ('1', 'Problème de santé');
INSERT INTO `pandami_db`.`desist_reason` (`id`, `label`) VALUES ('2', 'Motif familial impérieux');
INSERT INTO `pandami_db`.`desist_reason` (`id`, `label`) VALUES ('3', 'Le service n\'est plus nécessaire');
INSERT INTO `pandami_db`.`equipment_type` (`id`, `label`) VALUES ('1', 'Aucun');
INSERT INTO `pandami_db`.`equipment_type` (`id`, `label`) VALUES ('2', 'Outils de bricolage');
INSERT INTO `pandami_db`.`equipment_type` (`id`, `label`) VALUES ('3', 'Outils de jardinage');
INSERT INTO `pandami_db`.`equipment_type` (`id`, `label`) VALUES ('4', 'Produits ménagers');
INSERT INTO `pandami_db`.`equipment_type` (`id`, `label`) VALUES ('5', 'Voiture');
INSERT INTO `pandami_db`.`equipment_type` (`id`, `label`) VALUES ('6', 'Ordinateur');
INSERT INTO `pandami_db`.`user_type` (`id`, `type`) VALUES ('1', 'Administrateur');
INSERT INTO `pandami_db`.`user_type` (`id`, `type`) VALUES ('2', 'Utilisateur');
INSERT INTO `pandami_db`.`ended_type` (`id`, `label`) VALUES ('1', 'Finalisation automatique');
INSERT INTO `pandami_db`.`ended_type` (`id`, `label`) VALUES ('2', 'Action finalisée');
INSERT INTO `pandami_db`.`ended_type` (`id`, `label`) VALUES ('3', 'Action non finalisée');
INSERT INTO `pandami_db`.`report_issue` (`id`, `label`) VALUES ('1', 'Service mal réalisé');
INSERT INTO `pandami_db`.`report_issue` (`id`, `label`) VALUES ('2', 'Retard du bénévole');
INSERT INTO `pandami_db`.`report_issue` (`id`, `label`) VALUES ('3', 'Bénévole agressif');
INSERT INTO `pandami_db`.`cancel_reason` (`id`, `label`) VALUES ('1', 'Le service n\'est plus nécessaire');
INSERT INTO `pandami_db`.`cancel_reason` (`id`, `label`) VALUES ('2', 'Matériel défectueux');
INSERT INTO `pandami_db`.`cancel_reason` (`id`, `label`) VALUES ('3', 'Bénéficiaire indisponible');
INSERT INTO `pandami_db`.`gender` (`id`, `name`) VALUES ('1', 'Homme');
INSERT INTO `pandami_db`.`gender` (`id`, `name`) VALUES ('2', 'Femme');
INSERT INTO `pandami_db`.`gender` (`id`, `name`) VALUES ('3', 'Autre');
INSERT INTO `pandami_db`.`activity_category` (`id`, `label`) VALUES ('1', 'Service à Domicile');
INSERT INTO `pandami_db`.`activity_category` (`id`, `label`) VALUES ('2', 'Livraison de biens');
INSERT INTO `pandami_db`.`activity_category` (`id`, `label`) VALUES ('3', 'Travaux ménagers');
INSERT INTO `pandami_db`.`activity_category` (`id`, `label`) VALUES ('4', 'Divertissement');
INSERT INTO `pandami_db`.`activity_category` (`id`, `label`) VALUES ('5 ', 'Transport de personnes');
INSERT INTO `pandami_db`.`activity_category` (`id`, `label`) VALUES ('6', 'Animaux');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('1', 'Garde d\'enfant', '1', '1');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('2', 'Accompagnement scolaire', '1', '1');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('3', 'Aide administrative', '1', '6');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('4', 'Courses essentielles', '2', '1');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('5', 'Livraison médicaments', '2', '1');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('6', 'Jardinage', '3', '3');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('7', 'Bricolage', '3', '2');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('8', 'Ménage', '3', '4');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('9', 'Compagnie', '4', '1');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('10', 'Promenade', '4', '1');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('11', 'Rendez-vous médical', '5', '5');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('12', 'Rendez-vous administratif', '5', '5');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('13', 'Lieux de culte', '5', '5');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('14', 'Garde animaux', '6', '1');
INSERT INTO `pandami_db`.`activity` (`id`, `label`, `activityCategory_id`, `equipmentType_id`) VALUES ('15', 'Promenade animal', '6', '1');
INSERT INTO `pandami_db`.`user` (`id`, `birthDate`, `email`, `emergencyContactName`, `emergencyContactPhoneNumber`, `emergencyContactSurname`, `inscriptionDate`, `login`, `name`, `password`, `phoneNumber`, `street`, `surname`, `city_id`, `gender_id`, `userType_id`) VALUES ('1', '1985-02-20', 'kolepm@hotmail.com', 'titi', '0145866523', 'de Tutu', '2018-05-05 00:00:00', 'titi', 'titi', 'titi', '0654785623', '4 Boulevard de Créteil', 'tyty', '1', '1', '2');
INSERT INTO `pandami_db`.`user` (`id`, `birthDate`, `email`, `emergencyContactName`, `emergencyContactPhoneNumber`, `emergencyContactSurname`, `inscriptionDate`, `login`, `name`, `password`, `phoneNumber`, `street`, `surname`, `city_id`, `gender_id`, `userType_id`) VALUES ('2', '1984-02-20', 'ompoema@hotmail.com', 'otot', '0145522983', 'ed Atat', '2020-05-05 00:00:00', 'tutu', 'tutu', 'tutu', '0758562263', '50 Boulevard Maxime Gorki', 'tutu', '2', '2', '2');
INSERT INTO `pandami_db`.`user` (`id`, `birthDate`, `email`, `emergencyContactName`, `emergencyContactPhoneNumber`, `emergencyContactSurname`, `inscriptionDate`, `login`, `name`, `password`, `phoneNumber`, `street`, `surname`, `city_id`, `gender_id`, `userType_id`) VALUES ('3', '1986-02-20', 'kolmp@outlook.fr', 'titu', '0145865956', 'el Toto', '2017-05-05 00:00:00', 'tata', 'tata', 'tata', '0698974510', '73 Avenue Maurice Thorez', 'tata', '3', '1', '2');
INSERT INTO `pandami_db`.`user` (`id`, `birthDate`, `email`, `emergencyContactName`, `emergencyContactPhoneNumber`, `emergencyContactSurname`, `inscriptionDate`, `login`, `name`, `password`, `phoneNumber`, `street`, `surname`, `city_id`, `gender_id`, `userType_id`) VALUES ('4', '1987-02-20', 'tutyto@hotmail.fr', 'tyto', '0184956293', 'tyto', '2015-05-05 00:00:00', 'tyto', 'tyto', 'tyto', '0689294618', '4 Rue Diderot', 'tyto', '4', '2', '2');
INSERT INTO `pandami_db`.`user` (`id`, `birthDate`, `email`, `emergencyContactName`, `emergencyContactPhoneNumber`, `emergencyContactSurname`, `inscriptionDate`, `login`, `name`, `password`, `phoneNumber`, `street`, `surname`, `city_id`, `gender_id`) VALUES ('5', '1988-02-20 00:00:00', 'ytzdizjaid@hotmail.fr', 'taty', '0145959562', 'taty', '2016-05-05 00:00:00', 'taty', 'taty', 'taty', '0688989289', '21 Rue Gabriel Péri', 'taty', '5', '1', '1');
INSERT INTO `pandami_db`.`activity_preference` (`id`, `preferenceEnd`, `preferenceStart`, `activity_id`, `user_id`) VALUES ('1', '2018-01-01', '2017-01-01', '1', '2');
INSERT INTO `pandami_db`.`activity_preference` (`id`, `preferenceEnd`, `preferenceStart`, `activity_id`, `user_id`) VALUES ('2', '2019-06-03', '2019-02-01', '2', '2');
INSERT INTO `pandami_db`.`activity_preference` (`id`, `preferenceEnd`, `preferenceStart`, `activity_id`, `user_id`) VALUES ('3', '2017-11-11', '2017-10-01', '3', '2');
INSERT INTO `pandami_db`.`activity_preference` (`id`, `preferenceEnd`, `preferenceStart`, `activity_id`, `user_id`) VALUES ('4', '2018-03-12', '2018-02-11', '4', '2');
INSERT INTO `pandami_db`.`activity_preference` (`id`, `preferenceEnd`, `preferenceStart`, `activity_id`, `user_id`) VALUES ('5', '2020-05-12', '2020-04-11', '5', '2');
INSERT INTO pandami_db.availability (id, choiceEnd, choiceStart, day, endHour, startHour, user_id) VALUES ('1', '2021-03-20', '2021-01-18', 'Lundi', '10:00:00', '09:00:00', '2');
INSERT INTO pandami_db.availability (id, choiceEnd, choiceStart, day, endHour, startHour, user_id) VALUES ('2', '2021-07-20', '2021-05-23', 'Mercredi', '11:00:00', '10:30:00', '2');
INSERT INTO pandami_db.availability (id, choiceEnd, choiceStart, day, endHour, startHour, user_id) VALUES ('3', '2021-01-20', '2021-01-16', 'Vendredi', '12:00:00', '10:45:00', '2');
INSERT INTO pandami_db.availability (id, choiceEnd, choiceStart, day, endHour, startHour, user_id) VALUES ('4', '2021-02-20', '2021-03-20', 'Mardi', '13:00:00', '11:50:00', '2');
INSERT INTO pandami_db.availability (id, choiceEnd, choiceStart, day, endHour, startHour, user_id) VALUES ('5', '2021-05-20', '2021-03-20', 'Dimanche', '14:00:00', '12:00:00', '2');
INSERT INTO pandami_db.availability (id, choiceEnd, choiceStart, day, endHour, startHour, user_id) VALUES ('6', '2021-09-20', '2021-03-20', 'Jeudi', '15:00:00', '12:25:00', '2');
INSERT INTO pandami_db.availability (id, choiceEnd, choiceStart, day, endHour, startHour, user_id) VALUES ('7', '2021-04-20', '2021-03-20', 'Samedi', '16:00:00', '11:38:00', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `closeDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `endedType_id`, `user_id`) VALUES ('1', '2021-02-10', '2021-02-10', '11:00:00', '2021-02-03', '10:00:00', '4 Boulevard de Créteil', '1', '1', '2', '1');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `closeDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `endedType_id`, `user_id`) VALUES ('2', '2021-02-13', '2021-02-13', '11:00:00', '2021-02-06', '09:00:00', '50 Boulevard Maxime Gorki', '4', '2', '1', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `cancelDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('3', '2021-02-17', '2021-02-14', '13:30:00', '2021-02-10', '12:00:00', '73 Avenue Maurice Thorez', '6', '3', '3');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `closeDate`, `endHour`, `publishDate`, `reportDate`, `startHour`, `street`, `activity_id`, `city_id`, `endedType_id`, `reportIssue_id`, `user_id`) VALUES ('4', '2021-02-16', '2021-02-18', '16:30:00', '2021-02-10', '2021-02-18', '14:30:00', '4 Rue Diderot', '11', '4', '2', '2', '4');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `closeDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `endedType_id`, `user_id`) VALUES ('5', '2021-02-20', '2021-02-20', '13:00:00', '2021-02-12', '11:30:00', '21 Rue Gabriel Péri', '8', '5', '1', '5');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `closeDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `endedType_id`, `user_id`) VALUES ('6', '2021-03-08', '2021-03-08', '10:30:00', '2021-03-02', '09:30:00', '50 Boulevard Maxime Gorki', '15', '2', '1', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `closeDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `endedType_id`, `user_id`) VALUES ('7', '2021-03-14', '2021-03-14', '14:00:00', '2021-03-04', '12:00:00', '50 Boulevard Maxime Gorki', '11', '2', '1', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `closeDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `endedType_id`, `user_id`) VALUES ('8', '2021-03-15', '2021-03-15', '12:00:00', '2021-03-06', '11:00:00', '4 Boulevard de Créteil', '3', '1', '1', '1');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('9', '2021-03-18', '16:30:00', '2021-03-08', '15:00:00', '73 Avenue Maurice Thorez', '6', '3', '3');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `closeDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `endedType_id`, `user_id`) VALUES ('10', '2021-03-16', '2021-03-16', '16:30:00', '2021-03-08', '14:30:00', '73 Avenue Maurice Thorez', '7', '3', '1', '3');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('11', '2021-03-17', '17:00:00', '2021-03-09', '16:00:00', '4 Boulevard de Créteil', '15', '1', '1');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('12', '2021-03-19', '13:30:00', '2021-03-09', '12:00:00', '50 Boulevard Maxime Gorki', '7', '2', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('13', '2021-03-20', '17:00:00', '2021-03-10', '15:30:00', '4 Rue Diderot', '8', '4', '4');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('14', '2021-03-20', '14:00:00', '2021-03-10', '13:30:00', '4 Rue Diderot', '10', '4', '4');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('15', '2021-03-25', '12:00:00', '2021-03-22 14:20:00', '11:00:00', '4 Boulevard de Créteil', '5', '1', '1');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('16', '2021-04-01', '14:00:00', '2021-03-21 11:52:00', '12:00:00', '4 Rue Diderot', '6', '4', '1');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('17', '2021-04-03', '18:00:00', '2021-03-21 18:00:00', '17:00:00', '73 Avenue Maurice Thorez', '7', '3', '1');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('18', '2021-04-03', '17:00:00', '2021-03-19 15:00:00', '16:00:00', '21 Rue Gabriel Péri', '11', '5', '1');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('19', '2021-04-05', '11:00:00', '2021-03-20 18:00:00', '10:00:00', '50 Boulevard Maxime Gorki', '1', '2', '1');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('20', '2021-03-26', '11:30:00', '2021-03-22 17:00:00', '11:00:00', '4 Boulevard de Créteil', '2', '1', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('21', '2021-03-28', '15:30:00', '2021-03-23 14:00:00', '14:30:00', '73 Avenue Maurice Thorez', '8', '3', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('22', '2021-04-01', '10:30:00', '2021-03-18 17:00:00', '09:30:00', '50 Boulevard Maxime Gorki', '5', '2', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('23', '2021-04-02', '18:00:00', '2021-03-17 20:00:00', '16:30:00', '4 Rue Diderot', '9', '4', '2');
INSERT INTO `pandami_db`.`demand` (`id`, `actionDate`, `endHour`, `publishDate`, `startHour`, `street`, `activity_id`, `city_id`, `user_id`) VALUES ('24', '2021-03-25', '14:00:00', '2021-03-11 22:00:00', '12:00:00', '4 Rue Diderot', '10', '5', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('1', '2021-02-05', '2021-02-03', '1', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `selectionDate`, `demand_id`, `volunteer_id`) VALUES ('2', '2021-02-03', '2021-02-05', '1', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('3', '2021-02-05', '2021-02-04', '1', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('4', '2021-02-05', '2021-02-05', '1', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('5', '2021-02-08', '2021-02-07', '2', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `desistDate`, `rejectDate`, `replyDate`, `selectionDate`, `demand_id`, `desistReason_id`, `volunteer_id`) VALUES ('6', '2021-02-08', '2021-02-08', '2021-02-07', '2021-02-07', '2', '1', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `selectionDate`, `demand_id`, `volunteer_id`) VALUES ('7', '2021-02-08', '2021-02-08', '2', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('8', '2021-02-14', '2021-02-11', '3', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('9', '2021-02-14', '2021-02-11', '3', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('10', '2021-02-14', '2021-02-11', '3', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `selectionDate`, `demand_id`, `volunteer_id`) VALUES ('11', '2021-02-11', '2021-02-12', '4', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('12', '2021-02-12', '2021-02-11', '4', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('13', '2021-02-12', '2021-02-11', '4', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('14', '2021-02-14', '2021-02-12', '5', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `desistDate`, `rejectDate`, `replyDate`, `selectionDate`, `demand_id`, `desistReason_id`, `volunteer_id`) VALUES ('15', '2021-02-14', '2021-02-14', '2021-02-13', '2021-02-13', '5', '1', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `selectionDate`, `demand_id`, `volunteer_id`) VALUES ('16', '2021-02-13', '2021-02-14', '5', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('17', '2021-02-14', '2021-02-13', '5', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('18', '2021-03-03', '2021-03-02', '6', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `selectionDate`, `demand_id`, `volunteer_id`) VALUES ('19', '2021-03-02', '2021-03-03', '6', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('20', '2021-03-03', '2021-03-03', '6', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('21', '2021-03-08', '2021-03-04', '7', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `desistDate`, `rejectDate`, `replyDate`, `selectionDate`, `demand_id`, `desistReason_id`, `volunteer_id`) VALUES ('22', '2021-03-05', '2021-03-08', '2021-03-04', '2021-03-04', '7', '2', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('23', '2021-03-08', '2021-03-06', '7', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `selectionDate`, `demand_id`, `volunteer_id`) VALUES ('24', '2021-03-07', '2021-03-08', '7', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('25', '2021-03-09', '9', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('26', '2021-03-09', '9', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('27', '2021-03-09', '9', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('28', '2021-03-10', '2021-03-10', '10', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('29', '2021-03-10', '2021-03-10', '10', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `selectionDate`, `demand_id`, `volunteer_id`) VALUES ('30', '2021-03-10', '2021-03-10', '10', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `rejectDate`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('31', '2021-03-10', '2021-03-10', '10', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('32', '2021-03-10', '11', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('33', '2021-03-10', '11', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('34', '2021-03-10', '12', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('35', '2021-03-10', '12', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('36', '2021-03-10', '12', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('37', '2021-03-11', '13', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('38', '2021-03-11', '14', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('39', '2021-03-11', '14', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('40', '2021-03-13', '15', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('41', '2021-03-23 15:00:00', '16', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('42', '2021-03-22 12:00:00', '16', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('43', '2021-03-23 14:00:00', '16', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('44', '2021-03-23 15:28:45', '16', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('45', '2021-03-20 17:54:32', '18', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('46', '2021-03-21 09:04:39', '18', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('47', '2021-03-21 17:24:42', '18', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('48', '2021-03-21 19:20:22', '18', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('49', '2021-03-18 08:42:59', '23', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('50', '2021-03-21 18:47:20', '17', '2');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('51', '2021-03-22 08:54:23', '17', '3');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('52', '2021-03-23 14:57:30', '17', '4');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `selectionDate`, `demand_id`, `volunteer_id`) VALUES ('53', '2021-03-23 16:00:00', '2021-03-24 11:52:42', '15', '5');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('54', '2021-03-19 10:32:41', '23', '1');
INSERT INTO `pandami_db`.`reply` (`id`, `replyDate`, `demand_id`, `volunteer_id`) VALUES ('55', '2021-03-23 14:57:19', '23', '4');


