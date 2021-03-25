-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema skoon2_aurele
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `skoon2_aurele` DEFAULT CHARACTER SET utf8 ;
USE `skoon2_aurele` ;

-- -----------------------------------------------------
-- Table `skoon2_aurele`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `administrateur` VARCHAR(45) NULL,
  `nettoyeur` VARCHAR(45) NULL,
  `preteur` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skoon2_aurele`.`agenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`agenda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date_horaire_debut` DATETIME NOT NULL,
  `date_horaire_fin` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `skoon2_aurele`.`media`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`media` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `skoon2_aurele`.`adresse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`adresse` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ville` VARCHAR(45) NOT NULL,
  `rue` VARCHAR(45) NOT NULL,
  `code_postal` INT(11) NOT NULL,
  `geolocalisation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `skoon2_aurele`.`equipement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`equipement` (
  `id` INT(11) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `proprietaire` VARCHAR(45) NOT NULL,
  `type_evenement` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `skoon2_aurele`.`evenement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`evenement` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `nombre_participant` VARCHAR(45) NOT NULL,
  `agenda_id` INT(11) NOT NULL,
  `media_id` INT(11) NOT NULL,
  `adresse_id` INT(11) NOT NULL,
  `equipement_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_evenement_agenda1_idx` (`agenda_id` ASC) VISIBLE,
  INDEX `fk_evenement_media1_idx` (`media_id` ASC) VISIBLE,
  INDEX `fk_evenement_adresse1_idx` (`adresse_id` ASC) VISIBLE,
  INDEX `fk_evenement_equipement1_idx` (`equipement_id` ASC) VISIBLE,
  CONSTRAINT `fk_evenement_agenda1`
    FOREIGN KEY (`agenda_id`)
    REFERENCES `skoon2_aurele`.`agenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_media1`
    FOREIGN KEY (`media_id`)
    REFERENCES `skoon2_aurele`.`media` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_adresse1`
    FOREIGN KEY (`adresse_id`)
    REFERENCES `skoon2_aurele`.`adresse` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_equipement1`
    FOREIGN KEY (`equipement_id`)
    REFERENCES `skoon2_aurele`.`equipement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `skoon2_aurele`.`participant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`participant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pseudo` VARCHAR(45) NOT NULL,
  `activites` VARCHAR(255) NOT NULL,
  `role_id` INT NOT NULL,
  `evenement_id` INT(11) NOT NULL,
  `equipement_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_participant_role_idx` (`role_id` ASC) VISIBLE,
  INDEX `fk_participant_evenement1_idx` (`evenement_id` ASC) VISIBLE,
  INDEX `fk_participant_equipement1_idx` (`equipement_id` ASC) VISIBLE,
  CONSTRAINT `fk_participant_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `skoon2_aurele`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participant_evenement1`
    FOREIGN KEY (`evenement_id`)
    REFERENCES `skoon2_aurele`.`evenement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participant_equipement1`
    FOREIGN KEY (`equipement_id`)
    REFERENCES `skoon2_aurele`.`equipement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `skoon2_aurele` ;

-- -----------------------------------------------------
-- Table `skoon2_aurele`.`messagerie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`messagerie` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(45) NULL DEFAULT NULL,
  `date_heure_emission` DATETIME NULL DEFAULT NULL,
  `media_id` INT(11) NOT NULL,
  `evenement_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_messagerie_media1_idx` (`media_id` ASC) VISIBLE,
  INDEX `fk_messagerie_evenement1_idx` (`evenement_id` ASC) VISIBLE,
  CONSTRAINT `fk_messagerie_media1`
    FOREIGN KEY (`media_id`)
    REFERENCES `skoon2_aurele`.`media` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_messagerie_evenement1`
    FOREIGN KEY (`evenement_id`)
    REFERENCES `skoon2_aurele`.`evenement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `skoon2_aurele`.`skooner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skoon2_aurele`.`skooner` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `participant_id` INT NOT NULL,
  `agenda_id` INT(11) NOT NULL,
  `messagerie_id` INT(11) NOT NULL,
  `adresse_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_skooner_participant_idx` (`participant_id` ASC) VISIBLE,
  INDEX `fk_skooner_agenda1_idx` (`agenda_id` ASC) VISIBLE,
  INDEX `fk_skooner_messagerie1_idx` (`messagerie_id` ASC) VISIBLE,
  INDEX `fk_skooner_adresse1_idx` (`adresse_id` ASC) VISIBLE,
  CONSTRAINT `fk_skooner_participant`
    FOREIGN KEY (`participant_id`)
    REFERENCES `skoon2_aurele`.`participant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_skooner_agenda1`
    FOREIGN KEY (`agenda_id`)
    REFERENCES `skoon2_aurele`.`agenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_skooner_messagerie1`
    FOREIGN KEY (`messagerie_id`)
    REFERENCES `skoon2_aurele`.`messagerie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_skooner_adresse1`
    FOREIGN KEY (`adresse_id`)
    REFERENCES `skoon2_aurele`.`adresse` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
