ALTER TABLE `client` CHANGE `idAdd` `idAdd` INT(15) NULL;

ALTER TABLE `compagnie_aerienne_vol` 
    CHANGE `idCompagnie` `idCompagnie` BIGINT(20) NULL,
    CHANGE `idVol` `idVol` BIGINT(20) NULL;
    
ALTER TABLE `escale`
    CHANGE `idAeroport` `idAeroport` BIGINT(20) NULL, 
    CHANGE `idVol` `idVol` BIGINT(20) NULL;
    
ALTER TABLE `passager` CHANGE `idAdd` `idAdd` INT(15) NULL;

ALTER TABLE `reservation` 
    CHANGE `idVol` `idVol` BIGINT(20) NULL, 
    CHANGE `idPassager` `idPassager` BIGINT(20) NULL, 
    CHANGE `idClient` `idClient` BIGINT(20) NULL;
    
ALTER TABLE `ville_aeroport` 
    CHANGE `idVille` `idVille` BIGINT(20) NULL, 
    CHANGE `idAeroport` `idAeroport` BIGINT(20) NULL;
    
ALTER TABLE `vol` 
CHANGE `idAeroportDepart` `idAeroportDepart` BIGINT(20) NULL, 
CHANGE `idAeroportArrivee` `idAeroportArrivee` BIGINT(20) NULL;