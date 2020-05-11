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
CREATE SCHEMA IF NOT EXISTS `roberto_unicid` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `roberto_unicid` ;

-- -----------------------------------------------------
-- Table `roberto_unicid`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`aluno` (
  `rgm` CHAR(8) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nascimento` DATE NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL DEFAULT 'NENHUM',
  `endereco` VARCHAR(45) NOT NULL,
  `municipio` VARCHAR(45) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `celular` VARCHAR(45) NOT NULL DEFAULT '000000000000',
  PRIMARY KEY (`rgm`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `cpf_UNIQUE` ON `roberto_unicid`.`aluno` (`cpf` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`curso` (
  `id` INT NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `campus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`turma` (
  `id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  `periodo` CHAR(1) NOT NULL,
  `semestre` CHAR(7) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Turma_Curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `roberto_unicid`.`curso` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_Turma_Curso1_idx` ON `roberto_unicid`.`turma` (`curso_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`alunoemturma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`alunoemturma` (
  `Aluno_rgm` CHAR(8) NOT NULL,
  `Turma_id` INT NOT NULL,
  PRIMARY KEY (`Aluno_rgm`),
  CONSTRAINT `fk_Aluno_has_Turma_Aluno1`
    FOREIGN KEY (`Aluno_rgm`)
    REFERENCES `roberto_unicid`.`aluno` (`rgm`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_Aluno_has_Turma_Turma1`
    FOREIGN KEY (`Turma_id`)
    REFERENCES `roberto_unicid`.`turma` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `Aluno_rgm_UNIQUE` ON `roberto_unicid`.`alunoemturma` (`Aluno_rgm` ASC) VISIBLE;

CREATE INDEX `fk_Aluno_has_Turma_Turma1_idx` ON `roberto_unicid`.`alunoemturma` (`Turma_id` ASC) VISIBLE;

CREATE INDEX `fk_Aluno_has_Turma_Aluno1_idx` ON `roberto_unicid`.`alunoemturma` (`Aluno_rgm` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`disciplina` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`disciplinaemcurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`disciplinaemcurso` (
  `Disciplina_id` INT NOT NULL,
  `Curso_id` INT NOT NULL,
  PRIMARY KEY (`Disciplina_id`, `Curso_id`),
  CONSTRAINT `fk_Disciplina_has_Curso_Curso1`
    FOREIGN KEY (`Curso_id`)
    REFERENCES `roberto_unicid`.`curso` (`id`),
  CONSTRAINT `fk_Disciplina_has_Curso_Disciplina1`
    FOREIGN KEY (`Disciplina_id`)
    REFERENCES `roberto_unicid`.`disciplina` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_Disciplina_has_Curso_Curso1_idx` ON `roberto_unicid`.`disciplinaemcurso` (`Curso_id` ASC) VISIBLE;

CREATE INDEX `fk_Disciplina_has_Curso_Disciplina1_idx` ON `roberto_unicid`.`disciplinaemcurso` (`Disciplina_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roberto_unicid`.`notasfaltas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roberto_unicid`.`notasfaltas` (
  `Aluno_rgm` CHAR(8) NOT NULL,
  `Faltas` INT NOT NULL DEFAULT '0',
  `Nota` FLOAT(3,1) NOT NULL DEFAULT '0.0',
  `Disciplina_id` INT NOT NULL,
  `Curso_id` INT NOT NULL,
  PRIMARY KEY (`Aluno_rgm`, `Disciplina_id`, `Curso_id`),
  CONSTRAINT `fk_NotasFaltas_AlunoEmTurma1`
    FOREIGN KEY (`Aluno_rgm`)
    REFERENCES `roberto_unicid`.`alunoemturma` (`Aluno_rgm`),
  CONSTRAINT `fk_NotasFaltas_DisciplinaEmCurso1`
    FOREIGN KEY (`Disciplina_id` , `Curso_id`)
    REFERENCES `roberto_unicid`.`disciplinaemcurso` (`Disciplina_id` , `Curso_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_NotasFaltas_AlunoEmTurma1_idx` ON `roberto_unicid`.`notasfaltas` (`Aluno_rgm` ASC) VISIBLE;

CREATE INDEX `fk_NotasFaltas_DisciplinaEmCurso1_idx` ON `roberto_unicid`.`notasfaltas` (`Disciplina_id` ASC, `Curso_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
