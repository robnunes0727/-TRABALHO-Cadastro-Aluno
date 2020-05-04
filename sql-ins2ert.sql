USE roberto_unicid;

-- Adiciona cursos
INSERT INTO Curso (id, nome, campus) VALUES 
(1, 'Análise e Desenvolvimento de Sistemas', 'Tatuapé'),
(2, 'Ciência da Computação', 'Tatuapé'),
(3, 'Medicina', 'Pinheiros');

-- Adiciona disciplinas
INSERT INTO Disciplina (id, nome) VALUES 
(1, 'Java'),
(2, 'PHP'),
(3, 'Farmacologia'),
(4, 'Segurança de Dados'),
(5, 'Virologia');

-- Adiciona turmas
INSERT INTO Turma (id, curso_id, periodo, semestre) VALUES 
(1, 3, 'M', '2019-02'),
(2, 3, 'V', '2019-02'),
(3, 1, 'M', '2020-01'),
(4, 2, 'M', '2020-01'),
(5, 3, 'M', '2020-01'),
(6, 1, 'V', '2020-01'),
(7, 2, 'V', '2020-01'),
(8, 3, 'V', '2020-01'),
(9, 1, 'N', '2020-01'),
(10, 2, 'N', '2020-01');
