-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema theCat
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema theCat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `theCat` DEFAULT CHARACTER SET utf8 ;
USE `theCat` ;

-- -----------------------------------------------------
-- Table `theCat`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theCat`.`image` (
  `id` VARCHAR(30) NOT NULL,
  `height` INT NULL,
  `width` INT NULL,
  `url` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theCat`.`weight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theCat`.`weight` (
  `imperial` VARCHAR(15) NULL,
  `metric` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`metric`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theCat`.`breed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theCat`.`breed` (
  `id` VARCHAR(15) NOT NULL,
  `adaptability` INT NULL,
  `affection_level` INT NULL,
  `alt_names` VARCHAR(25) NULL,
  `cfa_url` VARCHAR(60) NULL,
  `child_friendly` INT NULL,
  `country_code` VARCHAR(4) NULL,
  `country_codes` VARCHAR(45) NULL,
  `description` VARCHAR(500) NULL,
  `dog_friendly` INT NULL,
  `energy_level` INT NULL,
  `experimental` TINYINT NULL,
  `grooming` INT NULL,
  `hairless` TINYINT NULL,
  `health_issues` INT NULL,
  `hypoallergenic` TINYINT NULL,
  `indoor` TINYINT NULL,
  `intelligence` INT NULL,
  `lap` INT NULL,
  `life_span` VARCHAR(10) NULL,
  `name` VARCHAR(45) NULL,
  `natural` TINYINT NULL,
  `origin` VARCHAR(45) NULL,
  `rare` TINYINT NULL,
  `rex` TINYINT NULL,
  `shedding_level` INT NULL,
  `short_legs` TINYINT NULL,
  `social_needs` INT NULL,
  `stranger_friendly` INT NULL,
  `suppressed_tail` TINYINT NULL,
  `temperament` VARCHAR(150) NULL,
  `vetstreet_url` VARCHAR(60) NULL,
  `vocalisation` INT NULL,
  `weight_imperial` VARCHAR(15) NULL,
  `wikipedia_url` VARCHAR(60) NULL,
  `reference_image_id` VARCHAR(30) NULL,
  `weight_metric` VARCHAR(15) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_breed_image_idx` (`reference_image_id` ASC),
  INDEX `fk_breed_weight1_idx` (`weight_metric` ASC),
  CONSTRAINT `fk_breed_image`
    FOREIGN KEY (`reference_image_id`)
    REFERENCES `theCat`.`image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_breed_weight1`
    FOREIGN KEY (`weight_metric`)
    REFERENCES `theCat`.`weight` (`metric`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
