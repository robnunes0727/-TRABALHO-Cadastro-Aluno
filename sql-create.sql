-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema roberto_unicid
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `roberto_unicid` ;

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
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Disciplina` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`Turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`Turma` (
  `id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  `periodo` CHAR(1) NOT NULL,
  `semestre` CHAR(7) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Turma_Curso1_idx` (`curso_id` ASC) VISIBLE,
  CONSTRAINT `fk_Turma_Curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `roberto_unicid`.`Curso` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`AlunoEmTurma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`AlunoEmTurma` (
  `Aluno_rgm` CHAR(8) NOT NULL,
  `Turma_id` INT NOT NULL,
  INDEX `fk_Aluno_has_Turma_Turma1_idx` (`Turma_id` ASC) VISIBLE,
  INDEX `fk_Aluno_has_Turma_Aluno1_idx` (`Aluno_rgm` ASC) VISIBLE,
  UNIQUE INDEX `Aluno_rgm_UNIQUE` (`Aluno_rgm` ASC) VISIBLE,
  PRIMARY KEY (`Aluno_rgm`),
  CONSTRAINT `fk_Aluno_has_Turma_Aluno1`
    FOREIGN KEY (`Aluno_rgm`)
    REFERENCES `roberto_unicid`.`Aluno` (`rgm`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Aluno_has_Turma_Turma1`
    FOREIGN KEY (`Turma_id`)
    REFERENCES `roberto_unicid`.`Turma` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`DisciplinaEmCurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`DisciplinaEmCurso` (
  `Disciplina_id` INT NOT NULL,
  `Curso_id` INT NOT NULL,
  INDEX `fk_Disciplina_has_Curso_Curso1_idx` (`Curso_id` ASC) VISIBLE,
  INDEX `fk_Disciplina_has_Curso_Disciplina1_idx` (`Disciplina_id` ASC) VISIBLE,
  PRIMARY KEY (`Disciplina_id`, `Curso_id`),
  CONSTRAINT `fk_Disciplina_has_Curso_Disciplina1`
    FOREIGN KEY (`Disciplina_id`)
    REFERENCES `roberto_unicid`.`Disciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Disciplina_has_Curso_Curso1`
    FOREIGN KEY (`Curso_id`)
    REFERENCES `roberto_unicid`.`Curso` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`NotasFaltas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`NotasFaltas` (
  `Aluno_rgm` CHAR(8) NOT NULL,
  `Faltas` INT NOT NULL DEFAULT 0,
  `Nota` FLOAT(3,1) NOT NULL DEFAULT 0,
  `Disciplina_id` INT NOT NULL,
  `Curso_id` INT NOT NULL,
  PRIMARY KEY (`Aluno_rgm`, `Disciplina_id`, `Curso_id`),
  INDEX `fk_NotasFaltas_AlunoEmTurma1_idx` (`Aluno_rgm` ASC) VISIBLE,
  INDEX `fk_NotasFaltas_DisciplinaEmCurso1_idx` (`Disciplina_id` ASC, `Curso_id` ASC) VISIBLE,
  CONSTRAINT `fk_NotasFaltas_AlunoEmTurma1`
    FOREIGN KEY (`Aluno_rgm`)
    REFERENCES `roberto_unicid`.`AlunoEmTurma` (`Aluno_rgm`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_NotasFaltas_DisciplinaEmCurso1`
    FOREIGN KEY (`Disciplina_id` , `Curso_id`)
    REFERENCES `roberto_unicid`.`DisciplinaEmCurso` (`Disciplina_id` , `Curso_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
