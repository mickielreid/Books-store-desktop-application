-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema AwesomeMike_BookStore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AwesomeMike_BookStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AwesomeMike_BookStore` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `AwesomeMike_BookStore` ;

-- -----------------------------------------------------
-- Table `AwesomeMike_BookStore`.`books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AwesomeMike_BookStore`.`books` (
  `BOOKCODE` INT(11) NOT NULL AUTO_INCREMENT,
  `TITLE` VARCHAR(50) NOT NULL,
  `AUTHOR` VARCHAR(25) NOT NULL,
  `PRICE` DECIMAL(7,2) NULL DEFAULT NULL,
  `TYPE` VARCHAR(25) NULL DEFAULT NULL,
  `SUBJECT` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`BOOKCODE`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `AwesomeMike_BookStore`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AwesomeMike_BookStore`.`sales` (
  `BOOKCODE` INT(11) NOT NULL,
  `SALESDATE` DATE NOT NULL,
  `QUANTITY` INT(11) NOT NULL,
  `PRICE` DECIMAL(7,2) NULL DEFAULT NULL,
  `sales_id` INT(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sales_id`),
  INDEX `fk_name` (`BOOKCODE` ASC) VISIBLE,
  CONSTRAINT `fk_name`
    FOREIGN KEY (`BOOKCODE`)
    REFERENCES `AwesomeMike_BookStore`.`books` (`BOOKCODE`)
    ON DELETE CASCADE,
  CONSTRAINT `sales_ibfk_1`
    FOREIGN KEY (`BOOKCODE`)
    REFERENCES `AwesomeMike_BookStore`.`books` (`BOOKCODE`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
