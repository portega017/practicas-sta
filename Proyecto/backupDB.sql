-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ExamenSta
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ExamenSta` ;

-- -----------------------------------------------------
-- Schema ExamenSta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ExamenSta` ;
USE `ExamenSta` ;

-- -----------------------------------------------------
-- Table `ExamenSta`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Clientes` (
  `DNI` VARCHAR(9) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Direccion de casa` VARCHAR(45) NOT NULL,
  `Contraseña` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`DNI`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ExamenSta`.`Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Productos` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Productos` (
  `idProducto` INT NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  `Precio` DECIMAL(5,2) NOT NULL,
  `Cantidad` INT NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ExamenSta`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Categoria` (
  `idCategoria` INT NOT NULL,
  `Categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ExamenSta`.`Pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Pedidos` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Pedidos` (
  `idPedido` INT NOT NULL,
  `Fecha y Hora` DATETIME NOT NULL,
  `Enviado` TINYINT NOT NULL,
  `Clientes_DNI` VARCHAR(9) NOT NULL,
  `Productos_idProducto` INT NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idPedido`, `Clientes_DNI`, `Productos_idProducto`),
  INDEX `fk_Pedidos_Clientes_idx` (`Clientes_DNI` ASC) VISIBLE,
  INDEX `fk_Pedidos_Productos1_idx` (`Productos_idProducto` ASC) VISIBLE,
  INDEX `fk_Pedidos_Categoria1_idx` (`Categoria_idCategoria` ASC) VISIBLE,
  CONSTRAINT `fk_Pedidos_Clientes`
    FOREIGN KEY (`Clientes_DNI`)
    REFERENCES `ExamenSta`.`Clientes` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedidos_Productos1`
    FOREIGN KEY (`Productos_idProducto`)
    REFERENCES `ExamenSta`.`Productos` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedidos_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `ExamenSta`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
