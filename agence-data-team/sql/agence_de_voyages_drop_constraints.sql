--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  DROP FOREIGN KEY `client_ibfk_1` ,
  DROP FOREIGN KEY `client_ibfk_2` ;

--
-- Contraintes pour la table `compagnie_aerienne_vol`
--
ALTER TABLE `compagnie_aerienne_vol`
  DROP FOREIGN KEY `compagnie_aerienne_vol_ibfk_1` ,
  DROP FOREIGN KEY `compagnie_aerienne_vol_ibfk_2` ;

--
-- Contraintes pour la table `escale`
--
ALTER TABLE `escale`
  DROP FOREIGN KEY `escale_ibfk_1`,
  DROP FOREIGN KEY `escale_ibfk_2` ;

--
-- Contraintes pour la table `passager`
--
ALTER TABLE `passager`
  DROP FOREIGN KEY `passager_ibfk_1` ;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  DROP FOREIGN KEY `reservation_ibfk_1` ,
  DROP FOREIGN KEY `reservation_ibfk_2` ,
  DROP FOREIGN KEY `reservation_ibfk_3` ;

--
-- Contraintes pour la table `ville_aeroport`
--
ALTER TABLE `ville_aeroport`
  DROP FOREIGN KEY `ville_aeroport_ibfk_1` ,
  DROP FOREIGN KEY `ville_aeroport_ibfk_2` ;

--
-- Contraintes pour la table `vol`
--
ALTER TABLE `vol`
  DROP FOREIGN KEY `vol_ibfk_1` ,
  DROP FOREIGN KEY `vol_ibfk_2` ;