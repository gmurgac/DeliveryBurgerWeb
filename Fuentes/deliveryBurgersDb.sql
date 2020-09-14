-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema DeliveryBurger_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DeliveryBurger_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DeliveryBurger_DB` DEFAULT CHARACTER SET utf8mb4 ;
USE `DeliveryBurger_DB` ;

-- -----------------------------------------------------
-- Table `DeliveryBurger_DB`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DeliveryBurger_DB`.`clientes` (
  `id_cliente` VARCHAR(11) NOT NULL,
  `nombre` VARCHAR(20) NULL DEFAULT NULL,
  `apellido` VARCHAR(20) NULL DEFAULT NULL,
  `edad` TINYINT(3) NULL DEFAULT NULL,
  `direccion` VARCHAR(100) NULL DEFAULT NULL,
  `numero_contacto` INT(11) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `DeliveryBurger_DB`.`hamburgesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DeliveryBurger_DB`.`hamburgesas` (
  `id_burger` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NULL DEFAULT NULL,
  `precio` INT(11) NULL DEFAULT NULL,
  `descripcion` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id_burger`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `DeliveryBurger_DB`.`repartidores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DeliveryBurger_DB`.`repartidores` (
  `id_repartidor` INT(4) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NULL DEFAULT NULL,
  `apellido` VARCHAR(20) NULL DEFAULT NULL,
  `vehiculo` VARCHAR(50) NULL DEFAULT NULL,
  `disponibilidad` INT(2) NULL DEFAULT NULL,
  `numero_telefonico` INT(11) NOT NULL,
  PRIMARY KEY (`id_repartidor`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
