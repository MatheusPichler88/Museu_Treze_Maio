USE MuseuTrezeDeMaio;
GO

-- Tabela de autores
INSERT INTO autores (nome, nacionalidade, data_nascimento) VALUES
('Carolina Maria de Jesus', 'Brasileira', '1914-03-14'),
('Milton Santos', 'Brasileira', '1926-05-03'),
('Conceição Evaristo', 'Brasileira', '1946-11-29'),
('Abdias Nascimento', 'Brasileira', '1914-03-14'),
('Sueli Carneiro', 'Brasileira', '1950-06-24'),
('Nei Lopes', 'Brasileira', '1942-05-09'),
('Djamila Ribeiro', 'Brasileira', '1980-08-01'),
('Lázaro Ramos', 'Brasileira', '1978-11-01'),
('Muniz Sodré', 'Brasileira', '1942-10-15'),
('Joel Rufino dos Santos', 'Brasileira', '1941-09-09'),
('Flávio dos Santos Gomes', 'Brasileira', '1960-05-20'),
('Ana Maria Gonçalves', 'Brasileira', '1970-12-23');
GO

-- Tabela de categorias
INSERT INTO categorias (nome, descricao) VALUES
('Literatura Afro-Brasileira', 'Obras literárias de autores afro-brasileiros'),
('História do Negro no Brasil', 'Estudos históricos sobre a população negra'),
('Cultura Africana', 'Tradições e manifestações culturais africanas'),
('Movimento Negro', 'Lutas e organizações do movimento negro brasileiro'),
('Ensaios Sociais', 'Reflexões sobre racismo e sociedade'),
('Biografias', 'Histórias de vida de personalidades negras'),
('Quilombos e Resistência', 'Estudos sobre comunidades quilombolas'),
('Literatura Contemporânea', 'Obras literárias recentes de autores negros');
GO

-- Tabela de usuarios
INSERT INTO usuarios (nome, tipo, telefone, email, endereco, data_cadastro) VALUES
('Ana Julia', 'Comunidade', '(55) 99988-7766', 'ana.julia@gmail.com', 'Rua Floriano Peixoto, 123 - Centro, Santa Maria/RS', '20250115 10:00:00'),
('Carlos Oliveira', 'Pesquisador', '(55) 98877-6655', 'carlos.oliveira@ufsm.com', 'Av. Rio Branco, 456 - Centro, Santa Maria/RS', '20250120 14:30:00'),
('Mariana Costa', 'Comunidade', '(55) 97766-5544', 'mariana.costa@email.com', 'Osvaldo Cruz, 789 - Km Três, Santa Maria/RS', '20250210 09:15:00'),
('Maria Luiza', 'Estudante', '(55) 96655-4433', 'maria.luiza@ufsm.com', 'Rua Professor Araújo, 321 - Centro, Santa Maria/RS', '20250228 16:45:00');
GO

-- Tabela de materiais da biblioteca
INSERT INTO materiais_biblioteca (tipo, titulo, id_autor, ano_publicacao, id_categoria, descricao, isbn, editora, quantidade_exemplares, disponivel) VALUES
('Livro', 'Quarto de Despejo: Diário de uma Favelada', 1, 1960, 1, 'Diário que relata o cotidiano de uma mulher negra e favelada em São Paulo nos anos 1950', '8571640011', 'Ática', 3, 1),
('Livro', 'Um Defeito de Cor', 12, 2006, 1, 'Romance histórico que reconta a história do Brasil através da perspectiva de uma africana idosa', '8571642871', 'Record', 2, 1),
('Livro', 'Pequeno Manual Antirracista', 7, 2019, 5, '11 lições breves para entender as origens do racismo e como combatê-lo', '8535931879', 'Companhia das Letras', 4, 1),
('Livro', 'O Genocídio do Negro Brasileiro', 4, 1978, 4, 'Obra fundamental que denuncia o racismo estrutural na sociedade brasileira', '8571643010', 'Perspectiva', 1, 1),
('Livro', 'Ponciá Vicêncio', 3, 2003, 1, 'Romance sobre memória, identidade e as marcas da escravidão na população negra', '8571641506', 'Mazza', 2, 1),
('Livro', 'Na Minha Pele', 8, 2017, 6, 'Reflexões sobre racismo, branquitude e representatividade', '854310718X', 'Objetiva', 2, 1),
('Livro', 'A Mão Afro-Brasileira', 9, 2010, 3, 'Significado da contribuição africana na arte brasileira', '8571643517', 'SENAC', 1, 1),
('Livro', 'Dicionário da Escravidão Negra no Brasil', 6, 2011, 2, 'Compêndio sobre a história da escravidão africana no Brasil', '8531413321', 'EdUSP', 1, 1),
('Livro', 'Zumbi: O Último Herói dos Palmares', 10, 2009, 7, 'Biografia do líder do Quilombo dos Palmares', '8571642456', 'Pallas', 2, 1),
('Revista', 'Revista Raça Brasil - Edição Especial 25 anos', NULL, 2021, 5, 'Edição comemorativa com entrevistas e artigos sobre avanços do movimento negro', '9771417325001', 'Editora Escala', 1, 1),
('Jornal', 'O Menelick - 2º Ato - Edição 15', NULL, 2018, 4, 'Jornal de arte e cultura negra com foco em produção contemporânea', NULL, 'Instituto O Menelick', 1, 1),
('Livro', 'Quilombos: Resistência à Escravidão', 11, 2015, 7, 'Estudo sobre a formação e organização dos quilombos brasileiros', '8571644017', 'Contexto', 1, 1);
GO

-- Tabela do acervo
INSERT INTO acervo_historico (tipo, titulo, descricao, data_item, palavra_chave, local_origem, doador, caminho_digitalizacao) VALUES
('Foto', 'Marcha Zumbi dos Palmares - 1995', 'Registro histórico da marcha que reuniu 30 mil negros em Brasília contra o racismo', '1995-11-20', 'marcha, movimento negro, Brasília, protesto', 'Brasília-DF', 'Arquivo Nacional', 'C:\Users\matheus\Documents\MuseuTrezeDeMaio\Fotos\marcha_zumbi_1995.jpg'),
('Jornal', 'O Clarim da Alvorada - Edição Fundadora', 'Primeira edição do jornal da Frente Negra Brasileira, importante organização dos anos 1930', '1933-05-15', 'frente negra, imprensa negra, história, São Paulo', 'São Paulo-SP', 'Museu Afro Brasil', 'C:\Users\gabriel\Documentos\AcervoMuseu\Jornais\clarim_alvorada_1933.pdf'),
('Carta', 'Carta de Abdias Nascimento ao Ministro da Educação', 'Documento histórico onde Abdias reivindica inclusão da história africana no currículo escolar', '1978-03-10', 'abdias nascimento, educação, movimento negro, carta', 'Rio de Janeiro-RJ', 'Família Nascimento', 'C:\Users\matheus\Documentos\MuseuTrezeDeMaio\Documentos\Cartas\abdias_educacao_1978.pdf'),
('Documento', 'Ata de Fundação do Museu Treze de Maio', 'Documento original da reunião que fundou o museu, assinado por líderes comunitários', '1982-05-13', 'fundação, museu, comunidade negra, Santa Maria', 'Santa Maria-RS', 'Comunidade Local', 'C:\Users\gabriel\Documentos\AcervoMuseu\Documentos\Atas\ata_fundacao_1982.pdf'),
('Foto', 'Roda de Capoeira no Parque Itaimbé', 'Registro de tradicional roda de capoeira que acontecia aos domingos no parque', '1990-08-15', 'capoeira, cultura, tradição, Santa Maria', 'Santa Maria-RS', 'Mestre João Angolinha', 'C:\Users\matheus\Documentos\MuseuTrezeDeMaio\Fotos\capoeira_itaimbe_1990.jpg'),
('Jornal', 'Diário de Santa Maria - Centenário da Abolição', 'Edição especial do jornal local sobre os 100 anos da abolição da escravatura', '1988-05-14', 'abolição, escravidão, Santa Maria, centenário', 'Santa Maria-RS', 'Acervo Jornal Diário', 'C:\Users\gabriel\Documentos\AcervoMuseu\Jornais\diario_abolicao_1988.pdf'),
('Documento', 'Estatuto da Sociedade Cultural Treze de Maio', 'Documento de fundação da primeira associação negra de Santa Maria', '1945-11-20', 'associação negra, cultura, Santa Maria, estatuto', 'Santa Maria-RS', 'Família Silva', 'C:\Users\matheus\Documentos\MuseuTrezeDeMaio\Documentos\Associacoes\estatuto_treze_maio_1945.pdf');
GO

-- Tabela de emprestimos
INSERT INTO emprestimos (id_material, id_usuario, data_emprestimo, data_devolucao_prevista, data_devolucao_real, status_emprestimo) VALUES
(1, 1, '20250301 10:00:00', '2025-03-15', NULL, 'Ativo'),
(3, 2, '20250225 14:30:00', '2025-03-10', '2025-03-08', 'Devolvido'),
(8, 2, '20250228 09:15:00', '2025-03-13', NULL, 'Atrasado'),
(5, 3, '20250305 11:20:00', '2025-03-19', NULL, 'Ativo'),
(6, 4, '20250302 16:45:00', '2025-03-16', NULL, 'Ativo');
GO

-- Tabela de Logs 
INSERT INTO log_sistema (tabela, id_item, acao) VALUES
('usuarios', 1, 'INSERT'),
('usuarios', 2, 'INSERT'),
('materiais_biblioteca', 1, 'INSERT'),
('materiais_biblioteca', 3, 'INSERT'),
('emprestimos', 1, 'INSERT'),
('emprestimos', 2, 'INSERT'),
('materiais_biblioteca', 1, 'UPDATE'),
('emprestimos', 2, 'UPDATE');
GO

