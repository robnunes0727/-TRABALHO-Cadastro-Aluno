-- Adiciona cursos
INSERT INTO Curso (id, nome, campus, periodo) VALUES 
(1, 'Análise e Desenvolvimento de Sistemas', 'Tatuapé', 'M'),
(2, 'Análise e Desenvolvimento de Sistemas', 'Tatuapé', 'N'),
(3, 'Ciência da Computação', 'Tatuapé', 'V'),
(4, 'Ciência da Computação', 'Tatuapé', 'M'),
(5, 'Medicina', 'Pinheiros', 'M'),
(6, 'Medicina', 'Pinheiros', 'V'),
(7, 'Medicina', 'Pinheiros', 'N');

-- Adiciona disciplinas
INSERT INTO Disciplina (id, nome, semestre) VALUES 
(1, 'Java', '2020-1'),
(2, 'PHP', '2020-1'),
(3, 'Farmacologia', '2020-1'),
(4, 'Segurança de Dados', '2020-1'),
(5, 'Virologia', '2020-1'),
(6, 'Banco de Dados', '2019-2');

-- Adiciona turmas
INSERT INTO Turma (id, disciplina_id, curso_id) VALUES 
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 2),
(5, 1, 3),
(6, 1, 4),
(7, 2, 3),
(8, 2, 4),
(9, 4, 3),
(10, 6, 4),
(11, 3, 5),
(12, 5, 5),
(13, 3, 6),
(14, 5, 6),
(15, 3, 7),
(16, 5, 7);