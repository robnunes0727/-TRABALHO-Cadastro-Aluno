-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema roberto_unicid
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `roberto_unicid` ;
USE `roberto_unicid` ;

-- -----------------------------------------------------
-- Table `roberto_unicid`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Aluno` (
  `rgm` CHAR(8) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nascimento` DATE NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL DEFAULT 'NENHUM',
  `endereco` VARCHAR(45) NOT NULL,
  `municipio` VARCHAR(45) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `celular` VARCHAR(45) NOT NULL DEFAULT '000000000000',
  PRIMARY KEY (`rgm`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Curso` (
  `id` INT NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `campus` VARCHAR(45) NOT NULL,
  `periodo` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Disciplina` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `semestre` CHAR(6) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`Turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Turma` (
  `id` INT NOT NULL,
  `disciplina_id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Turma_Disciplina_idx` (`disciplina_id` ASC) VISIBLE,
  INDEX `fk_Turma_Curso1_idx` (`curso_id` ASC) VISIBLE,
  CONSTRAINT `fk_Turma_Disciplina`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `roberto_unicid`.`Disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_Curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `roberto_unicid`.`Curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`AlunoEmTurma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`AlunoEmTurma` (
  `Aluno_rgm` CHAR(8) NOT NULL,
  `Turma_id` INT NOT NULL,
  `notas` FLOAT(3,1) NOT NULL DEFAULT 0,
  `faltas` INT NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`Aluno_rgm`, `Turma_id`),
  INDEX `fk_Aluno_has_Turma_Turma1_idx` (`Turma_id` ASC) VISIBLE,
  INDEX `fk_Aluno_has_Turma_Aluno1_idx` (`Aluno_rgm` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_has_Turma_Aluno1`
    FOREIGN KEY (`Aluno_rgm`)
    REFERENCES `roberto_unicid`.`Aluno` (`rgm`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_Turma_Turma1`
    FOREIGN KEY (`Turma_id`)
    REFERENCES `roberto_unicid`.`Turma` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
